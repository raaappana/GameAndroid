package CSharp;
import java.io.*;
public class BinaryReader {
	
	DataInputStream mStream;
	
	public BinaryReader(String _file)
	{
		try 
		{
			mStream = new DataInputStream(new BufferedInputStream(
					new FileInputStream(_file)));
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
		int a =	mStream.read(buffer);
		return buffer;
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
