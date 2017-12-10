package pcShop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import pcShop.model.ShoppingCart;
import pcShop.model.ShoppingCartItem;
import pcShop.model.security.SecurityUser;
import pcShop.repository.ShoppingCartRepository;
import pcShop.repository.UserRepository;

@Component
public class ShoppingCartService {
	@Autowired
	private ShoppingCartRepository shoppingCatRepository;

	@Autowired
	private UserRepository userRepo;

	public ShoppingCart find() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		ShoppingCart sc = shoppingCatRepository.findByUserUsername(username);
		if (sc != null) {
			return shoppingCatRepository.findByUserUsername(username);
		} else {
			sc = new ShoppingCart();
			Optional<SecurityUser> oUser = userRepo.findByUsername(username);
			sc.setUser(oUser.get());
			return shoppingCatRepository.save(sc);
		}
	}

	public ShoppingCart save(ShoppingCart sc) {
		return shoppingCatRepository.save(sc);
	}

	public ShoppingCart addItem(pcShop.model.Component comp) {
		ShoppingCart sc = find();
		sc.getItems().add(new ShoppingCartItem(comp));
		sc.setAmount(sc.getItems().stream().mapToDouble(x -> x.getComponent().getPrice()).sum());
		return shoppingCatRepository.save(sc);
	}

	public ShoppingCart removeItem(Long id) {
		ShoppingCart sc = find();
//		sc.getItems().removeIf(x -> x.getId().equals(id));
		
		for (ShoppingCartItem item : sc.getItems()) {
			if(item.getComponent().getId() == id) {
				sc.getItems().remove(item);
			}
		}
		sc.setAmount(sc.getItems().stream().mapToDouble(x -> x.getComponent().getPrice()).sum());
		return shoppingCatRepository.save(sc);
	}

}
