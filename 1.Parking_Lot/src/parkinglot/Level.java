package parkinglot;

import java.util.ArrayList;
import java.util.List;

import vehicle.Vehicle;

public class Level {
	private int floor;
	private List<ParkingSpot> parkingSpots;

	public Level(Integer floor, int spotsCount) {
		this.floor = floor;
		parkingSpots = new ArrayList<>(spotsCount);
		for (int i = 0; i < spotsCount; i++) {
			parkingSpots.add(new ParkingSpot(i+1));
		}
		// TODO Auto-generated constructor stub
	}

	public boolean parkVehicle(Vehicle bikeVehicle){
		for (ParkingSpot spot : parkingSpots) {
			if (spot.isAvailable() && spot.parkVehicle(bikeVehicle)) {
				return true;
			}
		}
		return false;
	}

	public boolean unparkVehicle(Vehicle bikeVehicle) {
		for (ParkingSpot spot : parkingSpots) {
			if (spot.unparkVehicle(bikeVehicle)) {
				return true;
			}
		}
		return false;
	}

	public void displayAvailability() {
		for (ParkingSpot spot : parkingSpots) {
			System.out.println("floor: " + floor + " spot No : " + spot.getId() + " status: "
					+ (spot.isAvailable() == true ? " available" : "occupied"));
		}

	}

}
