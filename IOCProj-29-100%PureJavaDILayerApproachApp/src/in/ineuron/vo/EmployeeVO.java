package in.ineuron.vo;

public class EmployeeVO {

	private String ename;
	private String eaddress;
	private String eage;
	private String eid;

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}

	public String getEage() {
		return eage;
	}

	public void setEage(String eage) {
		this.eage = eage;
	}

	@Override
	public String toString() {
		return "EmployeeVO [ename=" + ename + ", eaddress=" + eaddress + ", eage=" + eage + ", eid=" + eid + "]";
	}

}
