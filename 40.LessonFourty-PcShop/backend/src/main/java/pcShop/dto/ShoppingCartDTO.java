package pcShop.dto;

import java.util.HashSet;
import java.util.Set;

import pcShop.model.ShoppingCart;
import pcShop.model.ShoppingCartItem;

public class ShoppingCartDTO {

	private Set<ShoppingCartItem> items = new HashSet<>();
	private double amount;

	public ShoppingCartDTO() {
	}

	public ShoppingCartDTO(ShoppingCart sc) {
		this.items = sc.getItems();
		this.amount = sc.getAmount();
	}

	public Set<ShoppingCartItem> getItems() {
		return items;
	}

	public void setItems(Set<ShoppingCartItem> items) {
		this.items = items;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
