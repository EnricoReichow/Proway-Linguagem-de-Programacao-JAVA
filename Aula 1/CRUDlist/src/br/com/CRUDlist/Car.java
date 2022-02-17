package br.com.CRUDlist;

public class Car {

	private Integer id;
	private String model;
	private String color;
	private String year;

	public Car(String model, String color, String year) {
		super();
		this.model = model;
		this.color = color;
		this.year = year;
	}

	public Car() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", color=" + color + ", year=" + year + "]";
	}

}
