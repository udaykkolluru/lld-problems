package vending_machine;

import model.Coin;
import model.Inventory;
import model.Note;
import model.Product;

public class Client {

	public static void main(String[] args) {
		VendingMachine vendingMachine = VendingMachine.getInstance();

		Product laysProduct = new Product("lays", 2.49);
		Product doritosProduct = new Product("doritos", 2.74);

		Inventory inventory = vendingMachine.getInventory();
		inventory.addProduct(laysProduct, 1);
		inventory.addProduct(doritosProduct, 3);

		// 1
		vendingMachine.selectProduct(laysProduct);

		vendingMachine.insertCoins(Coin.QUARTER);
		vendingMachine.insertNotes(Note.FIVE);

		vendingMachine.dispenseProduct();
		vendingMachine.returnChange();

		// 2
		vendingMachine.selectProduct(laysProduct);
	}

}
