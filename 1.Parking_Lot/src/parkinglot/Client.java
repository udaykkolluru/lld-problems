package parkinglot;

import vehicle.Bike;
import vehicle.Car;
import vehicle.Truck;
import vehicle.Vehicle;

public class Client {

	public static void main(String[] args) throws ParkingUnavailableException {
		ParkingLot parkingLot = ParkingLot.createParkingLot();
		parkingLot.addLevel(11, 2);
		parkingLot.addLevel(22, 3);
		Vehicle bikeVehicle = new Bike("abcs");
		Vehicle carVehicle = new Car("uhfewih");
		Vehicle vehicle = new Truck("f43");

		parkingLot.parkVehicle(bikeVehicle);
		parkingLot.parkVehicle(carVehicle);

		parkingLot.displayAvailability();

		parkingLot.unparkVehicle(bikeVehicle);

	}

}
