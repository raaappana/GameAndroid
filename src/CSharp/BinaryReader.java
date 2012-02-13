package CSharp;
import java.io.*;
public class BinaryReader {
	
	DataInputStream mStream;
	PositionInputStream mInnerStream;
	
	public BinaryReader(String __file)
	{
		try 
		{
			FileInputStream sss = new FileInputStream(__file);
			mInnerStream = new PositionInputStream(sss);
			mStream = new DataInputStream(new BufferedInputStream(mInnerStream));
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
	public int ReadInt32() 
	{
		try {
			return mStream.readInt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public byte[] ReadChars(int __count)
	{
		byte[] buffer = new byte[__count];
		try 
		{
			int a =	mStream.read(buffer);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buffer;
	}
	
	public long Length()
	{
		return mInnerStream.getPosition();
	}
	
	public void Close()
	{
		try {
			mStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
