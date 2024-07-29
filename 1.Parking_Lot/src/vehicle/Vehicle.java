package vehicle;

public abstract class Vehicle {
	private String licencePlate;
	private Type type;

	public Vehicle(String licencePlate, Type type) {
		super();
		this.licencePlate = licencePlate;
		this.type = type;
	}

	public String getLicencePlate() {
		return licencePlate;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Vehicle [licencePlate=" + licencePlate + ", type=" + type + "]";
	}

}
