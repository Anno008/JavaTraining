package pcShop.dto;

import java.util.HashSet;
import java.util.Set;

import pcShop.model.ShoppingCart;
import pcShop.model.ShoppingCartItem;

public class ShoppingCartDTO {

	public ShoppingCartDTO(ShoppingCart sc) {
		this.items = sc.getItems();
	}

	private Set<ShoppingCartItem> items = new HashSet<>();

	public Set<ShoppingCartItem> getItems() {
		return items;
	}

	public void setItems(Set<ShoppingCartItem> items) {
		this.items = items;
	}

}
