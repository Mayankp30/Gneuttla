import java.io.Serializable;


public class Beacon implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	
	Integer countoffile;
	String time;
	String ip;
	Integer port;
	String message;
	
	public Beacon(String message)
	{
		this.message=message;
	}
	
	public Beacon(Integer countoffile, String time, String ip, Integer port,
			String message) {
		super();
		this.time = time;
		this.ip = ip;
		this.port = port;
		this.message = message;
	}

	public Integer getCountoffile() {
		return countoffile;
	}

	public String getTime() {
		return time;
	}

	public String getIp() {
		return ip;
	}

	public Integer getPort() {
		return port;
	}

	public String getMessage() {
		return message;
	}

	
	
	@Override
	public String toString() {
		return "Beacon [countoffile=" + countoffile + ", time=" + time
				+ ", ip=" + ip + ", port=" + port + ", message=" + message
				+ "]";
	}
	

	
}

