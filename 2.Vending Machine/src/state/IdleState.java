package state;

import model.Coin;
import model.Note;
import model.Product;
import vending_machine.VendingMachine;

public class IdleState implements VendingMachineState {

	private VendingMachine vendingMachine;

	public IdleState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void selectProduct(Product product) {
		if (vendingMachine.getInventory().isAvailable(product)) {
			vendingMachine.setSelectedProduct(product);
			vendingMachine.setCurrentState(vendingMachine.getpaymentState());
			System.out.println("selected idle state " + product);
		} else {
			System.err.println("selected product unavailable " + product);
		}
	}

	public void insertCoins(Coin coin) {
		System.err.println("Please select a product first.");

	}

	public void insertNotes(Note note) {
		System.err.println("Please select a product first.");

	}

	public void dispenseProduct() {
		System.err.println("Please select a product first.");

	}

	public void returnChange() {
		System.err.println("Please select a product first.");

	}

}
