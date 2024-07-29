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

	public synchronized boolean parkVehicle(Vehicle bikeVehicle) {
		if (vehicle == null) {
			vehicle = bikeVehicle;
			type = bikeVehicle.getType();
			return true;
		} else {
			return false;
		}
	}

	public synchronized boolean unparkVehicle(Vehicle bikeVehicle) {
		if (vehicle == bikeVehicle && type == bikeVehicle.getType()) {
			vehicle = null;
			return true;
		}
		return false;
	}

	public synchronized boolean isAvailable() {
		return vehicle == null;
	}

}
