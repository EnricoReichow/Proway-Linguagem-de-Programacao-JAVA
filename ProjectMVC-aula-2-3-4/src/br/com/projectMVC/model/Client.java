package br.com.projectMVC.model;

public class Client {

	private int id;
	private String name;
	private String adress;
	private boolean status;
	private String address;
	
	public Client() {
		super();
	}

	public Client(int id, String name, String adress, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.status = status;
	}

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

	public String getAddress() {
		return adress;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
