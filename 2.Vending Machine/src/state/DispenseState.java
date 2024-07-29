package state;

import model.Coin;
import model.Note;
import model.Product;
import vending_machine.VendingMachine;

public class DispenseState implements VendingMachineState {
	private VendingMachine vendingMachine;

	public DispenseState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void selectProduct(Product product) {
		System.err.println("Product dispension in progress");

	}

	public void insertCoins(Coin coin) {
		System.err.println("Product dispension in progress");
	}

	public void insertNotes(Note note) {
		System.err.println("Product dispension in progress");

	}

	public void dispenseProduct() {
		Product product = vendingMachine.getSelectedProduct();
		vendingMachine.getInventory().updateQuantity(product, (vendingMachine.getInventory().getQuantity(product) - 1));
		vendingMachine.setCurrentState(vendingMachine.getReturnChangeState());
	}

	public void returnChange() {
		System.err.println("Product dispension in progress");

	}

}
