package Employee.bo;

public class Driver_bo {
	
	private int id;
	private String name;
	private String phone;
	private String vehical;
	private String license;
	private String city;
	private String aadhar;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getVehical() {
		return vehical;
	}
	public void setVehical(String vehical) {
		this.vehical = vehical;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	@Override
	public String toString() {
		return "Driver_bo [id=" + id + ", name=" + name + ", phone=" + phone + ", vehical=" + vehical + ", license="
				+ license + ", city=" + city + ", aadhar=" + aadhar + "]";
	}
	public Driver_bo(String name, String phone, String vehical, String license, String city, String aadhar) {
		super();
		
		this.name = name;
		this.phone = phone;
		this.vehical = vehical;
		this.license = license;
		this.city = city;
		this.aadhar = aadhar;
	}
	
	
	public Driver_bo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}

