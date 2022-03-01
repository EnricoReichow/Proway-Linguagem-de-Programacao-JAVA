package br.com.projectHeritageMVC.model;

public class Provider extends Person {

	private String cnpj;
	private Boolean openCapital;
	
	public Provider() {
		super();
	}
	
	public Provider(String cnpj, Boolean openCapital) {
		super();
		this.cnpj = cnpj;
		this.openCapital = openCapital;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Boolean getOpenCapital() {
		return openCapital;
	}
	public void setOpenCapital(Boolean openCapital) {
		this.openCapital = openCapital;
	}

	@Override
	public String toString() {
		return "Provider [cnpj=" + cnpj + ", openCapital=" + openCapital + ", id()=" + getId() + ", name()="
				+ getName() + ", address=" + getAddress() + ", status=" + getStatus() + "]";
	}
	
	
	
}
