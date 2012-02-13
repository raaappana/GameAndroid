package pe.pe.pe.Content.Packs;

import CSharp.*;

import java.lang.Exception;





public class PackContent
{
    public int _userCount;
    public Object _engineSampleObject;
    public PackContent ReadedContentObject; 


    public boolean objectReaded;
    public int number;
    public int offset;
    public int size;
    public int headersize;
    public int loadedformat;
    public String name;
    public MeshContentadditionalheader mh = null;

    public PackContent()
    {
        _userCount = 0;
    }

    public PackContent(BinaryReader br, int _number)//16+имЯ
    {
        this.number = _number;
        int length = br.ReadInt32();
        name = new String(br.ReadChars(length + 1));
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

	public void Retain(Object __newObject) throws Exception
	{
		if (__newObject == null && _engineSampleObject == null)
			throw new Exception();

		_userCount++;
		if (__newObject == null)
			return;
		if (_engineSampleObject == null)
			_engineSampleObject = __newObject;
	}

    public void Release()
    {
        _userCount--;
        if (_userCount == 0)
        {
            IDisposable obj = (IDisposable) _engineSampleObject;
            if (obj != null)
                obj.Dispose();

            _engineSampleObject = null;
            objectReaded = false;
            ReadedContentObject = null;
        }
    }

    public void loadbody(byte[] array)
    {}

    public void Unload()
    {
        objectReaded = false;
        ReadedContentObject = null;
    }
}