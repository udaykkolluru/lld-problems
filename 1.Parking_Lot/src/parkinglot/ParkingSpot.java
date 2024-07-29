package parkinglot;

import vehicle.Type;
import vehicle.Vehicle;

public class ParkingSpot {
	private int id;
	private Type type;
	private Vehicle vehicle;

	public ParkingSpot(int spotNum) {
		id = spotNum;
	}

	public int getId() {
		return id;
	}

	public Type getType() {
		return type;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public boolean parkVehicle(Vehicle bikeVehicle) {
		if (vehicle == null) {
			vehicle = bikeVehicle;
			type = bikeVehicle.getType();
			return true;
		}
		return false;
	}

	public boolean unparkVehicle(Vehicle bikeVehicle) {
		if (vehicle == bikeVehicle && type == bikeVehicle.getType()) {
			vehicle = null;
			return true;
		}
		return false;
	}

	public boolean isAvailable() {
		return vehicle == null;
	}

}
