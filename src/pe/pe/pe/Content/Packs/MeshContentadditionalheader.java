package pe.pe.pe.Content.Packs;
import CSharp.*;

public class MeshContentadditionalheader
{
    public int ismaxdetalized;
    public int isstatic;
    public int skinsize;
    public String[] lods;
    public void load(BinaryReader br, int loadedformat)
    {
        switch (loadedformat)
        {
            case ElementType.MeshOptimazedForStore:
                {
                    ismaxdetalized = br.ReadInt32();
                    skinsize = br.ReadInt32();
                    lods = new String[br.ReadInt32()];
                    int length;
                    for (int j = 0; j < lods.length; j++)
                    {
                        length = br.ReadInt32();
                        lods[j] = new String(br.ReadChars(length + 1));
                    }
                } break;
            case ElementType.MeshOptimazedForLoading:
                {
                    ismaxdetalized = br.ReadInt32();
                    isstatic = br.ReadInt32();
                    lods = new String[br.ReadInt32()];
                    int length;
                    for (int j = 0; j < lods.length; j++)
                    {
                        length = br.ReadInt32();
                        lods[j] = new String(br.ReadChars(length + 1));
                    }
                } break;
            default:
                { } break;
        }
    }
}