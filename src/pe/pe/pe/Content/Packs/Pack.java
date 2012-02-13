package pe.pe.pe.Content.Packs;
import java.util.*;
import CSharp.*;
public class Pack
{
	
    public String errors = "";
   // public System.IO.FileInfo fi;
    public PackContent[] Objects;
    public int headersize;
    static int formayid = 43647457;
    public boolean fullsucces;
    public Pack(String filename)
    {
        AddObjectsToPack(filename);
    }
    public void AddObjectsToPack(String filename)
    {
    	
    	Vector<Integer> needcalcsize = new Vector<Integer>();
        fullsucces = false;
        BinaryReader br = new BinaryReader(filename);


        int foratID = br.ReadInt32();
        if (foratID != formayid)
        {
            errors += DateTime.Now.ToString() + ": not a pack;";
            br.Close();
            return;
        }
        int objectcount = br.ReadInt32();

        Objects = new PackContent[objectcount];
        for (int i = 0; i < objectcount; i++)
        {
            Objects[i] = new PackContent(br, i);
            if (Objects[i].size == 0)
                needcalcsize.add(i);
        }

        headersize = br.position();
        if (needcalcsize.size() != 0)
        {
            for (int i = 0; i < needcalcsize.size() - 1; i++)
            {
                Objects[needcalcsize.elementAt(i)].size = Objects[needcalcsize.elementAt(i) + 1].offset - Objects[needcalcsize.elementAt(i)].offset;
            }

            if (needcalcsize.elementAt(needcalcsize.size() - 1) + 1 == Objects.length)
            {
                Objects[needcalcsize.elementAt(needcalcsize.size() - 1)].size = Convert.ToInt32(this.fi.Length) -
                    (Objects[Objects.length - 1].offset + headersize);
            }
            else
            {
                int processingobject = needcalcsize.elementAt(needcalcsize.size() - 1);
                Objects[processingobject].size = Objects[processingobject + 1].offset - Objects[processingobject].offset;
            }
        }
        br.Close();
        fullsucces = true;
    }
}
