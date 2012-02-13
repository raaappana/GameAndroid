package pe.pe.pe.Content.Packs;






public class PackContent
{
    public int _userCount;
    public object _engineSampleObject;
    public PackContent ReadedContentObject; 


    public bool objectReaded;
    public int number;
    public int offset;
    public int size;
    public int headersize;
    public int loadedformat;
    public string name;
    public MeshContentadditionalheader mh = null;

    public PackContent()
    {
        _userCount = 0;
    }

    public PackContent(System.IO.BinaryReader br, int _number)//16+имЯ
    {
        this.number = _number;
        int length = br.ReadInt32();
        name = new string(br.ReadChars(length + 1));
        offset = br.ReadInt32();
        loadedformat = br.ReadInt32();
        headersize = br.ReadInt32();
        
        //когдато Я был молодой и глупый и теперь пишу этот кастыль
        if (loadedformat == ElementType.MeshOptimazedForStore || loadedformat == ElementType.MeshOptimazedForLoading)
        {
            mh = new MeshContentadditionalheader();
            mh.load(br, loadedformat);
        }
        else
        {
            size = br.ReadInt32();
        }
    }

    public void Retain(object __newObject = null)
    {
        //TODO - check logic
        if (__newObject == null && _engineSampleObject == null)
            throw new Exception();
        _userCount++;
        if (__newObject == null)
            return;
        if (_engineSampleObject == null)
            _engineSampleObject = __newObject;
    }

    public virtual void Release()
    {
        _userCount--;
        if (_userCount == 0)
        {
            IDisposable obj = _engineSampleObject as IDisposable;
            if (obj != null)
                obj.Dispose();

            _engineSampleObject = null;
            objectReaded = false;
            ReadedContentObject = null;
        }
    }

    public virtual void loadbody(byte[] array)
    {}

    public virtual void Unload()
    {
        objectReaded = false;
        ReadedContentObject = null;
    }
}


}