package vending_machine;

import model.Coin;
import model.Inventory;
import model.Note;
import model.Product;
import state.DispenseState;
import state.IdleState;
import state.PaymentState;
import state.ReturnChangeState;
import state.VendingMachineState;

public class VendingMachine {

	private static VendingMachine vendingMachineInstance;

	private Inventory inventory;
	private VendingMachineState paymentState;
	private VendingMachineState idleState;
	private VendingMachineState dispenseState;
	private VendingMachineState returnChangeState;
	private VendingMachineState currentState;
	private double totalPayment = 0.0;
	private Product selectedProduct;

	private VendingMachine() {
		inventory = new Inventory();
		paymentState = new PaymentState(this);
		idleState = new IdleState(this);
		dispenseState = new DispenseState(this);
		returnChangeState = new ReturnChangeState(this);
		currentState = idleState;
		totalPayment = 0.0;
		selectedProduct = null;
	}

	public static synchronized VendingMachine getInstance() {
		if (vendingMachineInstance == null) {
			vendingMachineInstance = new VendingMachine();
		}
		return vendingMachineInstance;
	}

	public void selectProduct(Product product) {
		currentState.selectProduct(product);

	}

	public void insertCoins(Coin coin) {
		currentState.insertCoins(coin);

	}

	public void insertNotes(Note note) {
		currentState.insertNotes(note);
	}

	public void dispenseProduct() {
		currentState.dispenseProduct();
	}

	public void returnChange() {
		currentState.returnChange();
	}

	public void addCoins(Coin coin) {
		totalPayment += coin.getValue();
	}

	public void addNotes(Note note) {
		totalPayment += note.getValue();
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public VendingMachineState getpaymentState() {
		return paymentState;
	}

	public void setpaymentState(VendingMachineState paymentState) {
		this.paymentState = paymentState;
	}

	public VendingMachineState getIdleState() {
		return idleState;
	}

	public void setIdleState(VendingMachineState idleState) {
		this.idleState = idleState;
	}

	public VendingMachineState getDispenseState() {
		return dispenseState;
	}

	public void setDispenseState(VendingMachineState dispenseState) {
		this.dispenseState = dispenseState;
	}

	public VendingMachineState getReturnChangeState() {
		return returnChangeState;
	}

	public void setReturnChangeState(VendingMachineState returnChangeState) {
		this.returnChangeState = returnChangeState;
	}

	public VendingMachineState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(VendingMachineState currentState) {
		this.currentState = currentState;
	}

	public double getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(double totalPayment) {
		this.totalPayment = totalPayment;
	}

	public Product getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	public void resetProductAndPaymentSelection() {
		this.totalPayment = 0.0;
		this.selectedProduct = null;

	}

}
