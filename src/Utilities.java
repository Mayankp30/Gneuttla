import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Utilities {

	public static byte[] convertObjecttoByte(Beacon b)throws Exception
	{
		ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(new BufferedOutputStream(bytestream));
        o.writeObject(b);
        o.flush();
        o.close();  
        return bytestream.toByteArray();  
        
	}
	
	public static Object bytetoObject(byte[] bytes) throws IOException, ClassNotFoundException {
		ByteArrayInputStream b = new ByteArrayInputStream(bytes);
        ObjectInputStream o = new ObjectInputStream(b);
        return o.readObject();
	}
	
}
