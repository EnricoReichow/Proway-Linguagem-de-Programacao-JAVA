package br.com.projectHeritageMVC.model;

public class Customer extends Person {

	private String cpf;
	private String rg;
	
	public Customer() {
		
	}
	public Customer(String cpf, String rg) {
		super();
		this.cpf = cpf;
		this.rg = rg;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	@Override
	public String toString() {
		return "Customer [cpf=" + cpf + ", rg=" + rg + ", id=" + getId() + ", name=" + getName()
				+ ", address=" + getAddress() + ", status=" + getStatus() + "]";
	}
	
	public void consultarCPF() {
		if (getStatus() == true) {
			System.out.println("");
		}else {
			System.out.println("");
		}
	}
}
