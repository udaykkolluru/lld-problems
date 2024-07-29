package state;

import model.Coin;
import model.Note;
import model.Product;
import vending_machine.VendingMachine;

public class PaymentState implements VendingMachineState {

	private VendingMachine vendingMachine;

	public PaymentState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void selectProduct(Product product) {
		System.err.println("Product selected already");

	}

	public void insertCoins(Coin coin) {
		vendingMachine.addCoins(coin);
		System.out.println("coin inserted " + coin.getValue());
		checkPaymentStatus();

	}

	public void insertNotes(Note note) {
		vendingMachine.addNotes(note);
		System.out.println("note inserted " + note.getValue());
		checkPaymentStatus();

	}

	private void checkPaymentStatus() {
		if (vendingMachine.getTotalPayment() >= vendingMachine.getSelectedProduct().getPrice()) {
			vendingMachine.setCurrentState(vendingMachine.getDispenseState());
		}

		// TODO Auto-generated method stub

	}

	public void dispenseProduct() {
		System.err.println("Payment not completed ");

	}

	public void returnChange() {
		System.err.println("Payment not completed ");
	}

}
