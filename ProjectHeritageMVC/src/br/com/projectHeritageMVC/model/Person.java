package br.com.projectHeritageMVC.model;

public class Person {

	private int Id;
	private String name;
	private String address;
	private Boolean status;
	
	public Person() {
	
	}

	public Person(int id, String name, String address, Boolean status) {
		super();
		Id = id;
		this.name = name;
		this.address = address;
		this.status = status;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Person [Id=" + Id + ", name=" + name + ", address=" + address + ", status=" + status + "]";
	}
	
}
