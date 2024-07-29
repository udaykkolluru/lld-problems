package model;

public class Product {
	private String name;
	private double price;

	public Product(String name, double d) {
		super();
		this.name = name;
		this.price = d;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + "]";
	}

	
}
