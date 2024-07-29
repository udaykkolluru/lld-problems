package parkinglot;

import vehicle.Bike;
import vehicle.Car;
import vehicle.Truck;
import vehicle.Type;
import vehicle.Vehicle;

public class Client {

	public static void main(String[] args) {
		ParkingLot parkingLot = ParkingLot.createParkingLot();
		parkingLot.addLevel(11, 2);
		parkingLot.addLevel(22, 3);
		Vehicle bikeVehicle = new Bike("abcs");
		Vehicle carVehicle = new Car("uhfewih");
		Vehicle vehicle = new Truck("f43");

		parkingLot.displayAvailability();
		parkingLot.parkVehicle(bikeVehicle);
		parkingLot.displayAvailability();
		parkingLot.parkVehicle(carVehicle);
		parkingLot.displayAvailability();
		parkingLot.unparkVehicle(bikeVehicle);
		parkingLot.displayAvailability();
	}

}
