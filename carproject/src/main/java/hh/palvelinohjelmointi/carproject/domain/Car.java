package hh.palvelinohjelmointi.carproject.domain;

public class Car {
	private String model;
	private int year;
	
	public Car() {
		super();
		this.model = null;
		this.year = 0;
	}
	public Car(String model, int year) {
		super();
		this.model = model;
		this.year = year;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getModel() {
		return model;
	}
	public int getYear() {
		return year;
	}
	@Override
	public String toString() {
		return "Car [model=" + model + ", year=" + year + "]";
	}
	
	

}
