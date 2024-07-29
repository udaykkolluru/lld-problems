package state;

import model.Coin;
import model.Note;
import model.Product;
import vending_machine.VendingMachine;

public class ReturnChangeState implements VendingMachineState {

	private VendingMachine vendingMachine;

	public ReturnChangeState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void selectProduct(Product product) {
		System.err.println("ReturnChangeState Please collect the change");

	}

	public void insertCoins(Coin coin) {
		System.err.println("ReturnChangeState Please collect the change");

	}

	public void insertNotes(Note note) {
		System.err.println("ReturnChangeState Please collect the change");

	}

	public void dispenseProduct() {
		System.err.println(" ReturnChangeState Please collect the change");

	}

	public void returnChange() {
		double paid = vendingMachine.getTotalPayment();
		double price = vendingMachine.getSelectedProduct().getPrice();
		if (paid > price) {
			System.out.println("ReturnChangeState money returned " + (paid - price));
		} else {
			System.out.println("ReturnChangeState no change to return");
		}
		vendingMachine.resetProductAndPaymentSelection();
		vendingMachine.setCurrentState(vendingMachine.getIdleState());
	}

}
