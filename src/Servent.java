
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Servent {

	/**
	 * @param args
	 */
	
	
	
	public static void main(String[] args) {
	try{
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date(); 
		DatagramSocket datagramSocket= new DatagramSocket(10000);
		
		// TO public connect
		ConnectionPing ct=new ConnectionPing();
		Thread t1=new Thread(ct); 
		ct.setDatagramSocket(datagramSocket);
		t1.start();
		
		// Private Socket at Private Port
	
		while(true)
		{
		byte[] buffer = new byte[5000];
		System.out.println("listening code");		
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);		
		datagramSocket.receive(packet);
		System.out.println(packet.getLength());
		Object Obj=Utilities.bytetoObject(packet.getData());
		Beacon b1=(Beacon)Obj;
		System.out.println(b1.getMessage());
		if(b1.getMessage().equals("PING"))
		{
			System.out.println("IN iff loop");
			
			InetAddress ip = InetAddress.getByName(b1.getIp());
			Beacon b=new Beacon(1,dateFormat.format(date), ip.toString(), 10000, "PONG");
			byte[] buffer1=Utilities.convertObjecttoByte(b);
			DatagramPacket dp = new DatagramPacket(buffer1,buffer1.length, ip, b1.getPort());
			System.out.println("send packet to PONG");
			System.out.println("Packet length"+dp.getLength());
			datagramSocket.send(dp);  
			
		}
		System.out.println("call");
		Thread.sleep(1000);
		}

		}   
		catch(Exception e)
		{
			System.out.println("Error in Servent Class :---"+e.getMessage());
		}
	}
	
	
	

}

