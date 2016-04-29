import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ConnectionPing implements Runnable{

	// public socket to PING
	DatagramSocket dgscoket; 
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date(); 
	
    
	
	@Override
	public void run() {
		try{
		while(true)
		{
			System.out.println(dateFormat.format(date));
		    InetAddress ip = InetAddress.getByName("192.168.1.25");  
		    Beacon b=new Beacon(1,dateFormat.format(date), ip.toString(),10000, "PING");
		    byte[] buffer=Utilities.convertObjecttoByte(b);
		    DatagramPacket dp = new DatagramPacket(buffer,buffer.length, ip, 10000);
		    System.out.println("Send to Ping");
		    dgscoket.send(dp);  
		    Thread.sleep(2000);
		}
		}
		catch(Exception e)
		{
			System.out.println("Error in Connection Class---:"+e.getMessage());
		}
	}
	
	
	
	public  void setDatagramSocket(DatagramSocket ds)
	{
		dgscoket=ds;
	}
	
}
