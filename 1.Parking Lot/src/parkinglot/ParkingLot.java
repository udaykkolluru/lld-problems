package parkinglot;

import java.util.ArrayList;
import java.util.List;

import vehicle.Vehicle;

public class ParkingLot {
	private static ParkingLot instance;
	private List<Level> levels;

	private ParkingLot() {
		levels = new ArrayList<>();
	}

	public static ParkingLot createParkingLot() {
		if (instance == null) {
			instance = new ParkingLot();
		}
		return instance;
	}

	public void addLevel(int floor, int spots) {
		Level level = new Level(floor, spots);
		levels.add(level);
	}

	public void parkVehicle(Vehicle bikeVehicle) throws ParkingUnavailableException {
		boolean parked = false;
		for (Level level : levels) {
			if (level.parkVehicle(bikeVehicle)) {
				System.out.println("Parked Vehicle" + bikeVehicle);
				parked = true;
				break;
			}
		}
		if (parked == false) {
			throw new ParkingUnavailableException("Parking Unavailable At the moment");
		}
	}

	public void unparkVehicle(Vehicle bikeVehicle) {
		for (Level level : levels) {
			if (level.unparkVehicle(bikeVehicle)) {
				System.out.println("UnParked Vehicle" + bikeVehicle);
				break;
			}
		}

	}

	public void displayAvailability() {
		for (Level level : levels) {
			level.displayAvailability();
		}

	}

}
