package domen;

public enum Konstante {
	IP_ADRESA("127.0.0.1"), PORT(9000);
	private String ipAdresa;
	private int port;
	private Konstante(String ipAdresa) {
		this.ipAdresa = ipAdresa;
		
	}
	public String getIpAdresa() {
		return ipAdresa;
	}
	public int getPort() {
		return port;
	}
	private Konstante(int port) {
		this.port = port;
	}

}
