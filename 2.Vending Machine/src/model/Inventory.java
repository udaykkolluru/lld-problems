package model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {

	private Map<Product, Integer> inventoryMap;

	public Inventory() {
		inventoryMap = new ConcurrentHashMap<>();
	}

	public void addProduct(Product product, int qty) {
		inventoryMap.put(product, qty);
	}

	public void updateQuantity(Product product, int qty) {
		inventoryMap.put(product, qty);
	}

	public void removeProduct(Product product) {
		inventoryMap.remove(product);
	}

	public int getQuantity(Product product) {
		return inventoryMap.getOrDefault(product, 0);
	}

	public boolean isAvailable(Product product) {
		return inventoryMap.containsKey(product) && inventoryMap.getOrDefault(product, 0) > 0;
	}

}
