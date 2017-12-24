import { Component, OnInit, ViewEncapsulation } from "@angular/core";
import { Input } from "@angular/core";
import { ShoppingCart } from "../../models/ShoppingCart"
import { ShoppingCartService } from "../../services/shoppingCart-service.service";
import { ShoppingCartItem } from "../../models/ShoppingCartItem";

@Component({
  selector: "app-shopping-cart",
  templateUrl: "./shoppingCart.component.html",
  styleUrls: ["./shoppingCart.component.css"],
  encapsulation: ViewEncapsulation.None
})
export class ShoppingCartComponent implements OnInit {
  @Input()
  shoppingCart: ShoppingCart;

  constructor(private shoppingCartService: ShoppingCartService) {
  }

  ngOnInit() {
  }

  delete(item: ShoppingCartItem) {
    this.shoppingCartService.delete(item.component.id).subscribe(
      () => {
        this.shoppingCartService.get().subscribe((data) => this.shoppingCart = data);
      },
      () => {
        this.shoppingCartService.get().subscribe((data) => this.shoppingCart = data);
      }
    );
  }
}
