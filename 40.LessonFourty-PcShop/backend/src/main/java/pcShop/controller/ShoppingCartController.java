package pcShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pcShop.dto.ShoppingCartDTO;
import pcShop.model.Component;
import pcShop.service.ShoppingCartService;

@RestController
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService scServ;
	
    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "api/shoppingCart")
    public ResponseEntity<ShoppingCartDTO> get() {
    	return new ResponseEntity<>(new ShoppingCartDTO(scServ.find()),HttpStatus.OK);
    }
    
    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "api/shoppingCart")
    public ResponseEntity<ShoppingCartDTO> createExam(@RequestBody Component comp) {
    	return new ResponseEntity<>(new ShoppingCartDTO(scServ.addItem(comp)),HttpStatus.OK);
    }
    
    @PreAuthorize("isAuthenticated()")
	@DeleteMapping(value = "api/shoppingCart/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
    	scServ.removeItem(id);
     	return new ResponseEntity<>(HttpStatus.OK);
    }
}
