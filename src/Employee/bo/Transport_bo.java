package Employee.bo;

public class Transport_bo {


	private String transport_type;
	private String number;
	private String dep;
	private String des;
	
	public String getTransport_type() {
		return transport_type;
	}
	public void setTransport_type(String transport_type) {
		this.transport_type = transport_type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	@Override
	public String toString() {
		return "Transport_bo [transport_type=" + transport_type + ", number=" + number + ", dep=" + dep + ", des=" + des
				+ "]";
	}
	public Transport_bo(String transport_type, String number, String dep, String des) {
		super();
		this.transport_type = transport_type;
		this.number = number;
		this.dep = dep;
		this.des = des;
	}
	public Transport_bo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
