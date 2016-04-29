import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class Monitor implements Runnable {

	public static  HashMap<Integer,Beacon> hs=new HashMap<Integer,Beacon>();
	
		@SuppressWarnings("deprecation")
		public void run(){
		  
			while(true){
				try {
					Thread.sleep(2000);
					Date tm=new Date();
						
					List<Beacon> list = new ArrayList<Beacon>(hs.values());
					if(!list.isEmpty())
					{
						for(Beacon b: list)
						{
						Integer hour=tm.getHours();		
						Integer min=tm.getMinutes();
						Integer sec= tm.getSeconds();
						b.time= b.time.replaceAll("\\s+","");
						String s1[]=b.time.split(":");
						Integer bHour=Integer.parseInt(s1[0]);
						Integer bMin=Integer.parseInt(s1[1]);
						Integer bSec=Integer.parseInt(s1[2]);
						System.out.println("System timings"+hour+":"+min+":"+sec);
						System.out.println("Bacon timing"+bHour+":"+bMin+":"+bSec);
						Integer dhour=hour-bHour;
						Integer dmin=min-bMin;
						
						System.out.println("difference in time : --"+dmin);
						
						
						
						if(dhour==0)
						{
							if(dmin==1)
							{
								if(sec>bSec)
								{
									System.out.println("Port Dead, no response from client :"+b.port);
									hs.remove(b.getPort());
								
								}
							}
						}
							
						}
						
					}
					
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		 }
		
		public static void setList(Integer port,Beacon newB) {
			
				hs.put(port, newB);
			
		}

	}
		



