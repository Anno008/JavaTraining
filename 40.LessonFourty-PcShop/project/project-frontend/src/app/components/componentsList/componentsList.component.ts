import { Component as c, OnInit } from "@angular/core";

import { AuthenticationService } from "../../services/authentication-service.service";
import { Observable } from "rxjs/Observable";

import { Router } from "@angular/router";
import { Brand } from "../../models/Brand";
import { Page } from "../../models/Page";
import { Component } from "../../models/Component";
import { ComponentsService } from "../../services/components-service.service";
import { BrandService } from "../../services/brand-service.service";
import { ShoppingCart } from "../../models/ShoppingCart";
import { ShoppingCartService } from "../../services/shoppingCart-service.service";

@c({
  selector: "app-components",
  templateUrl: "./componentsList.component.html",
  styleUrls: ["./componentsList.component.css"]
})
export class ComponentsListComponent {
  brands: Brand[];
  page: Page<Component>;
  currentPageNumber: number;
  totalPages: number;
  itemsPerPage = 10;
  shoppingCart: ShoppingCart;

  forEdit: Component;


  constructor(private componentsService: ComponentsService,
    private authenticationService: AuthenticationService,
    private brandsService: BrandService,
    private router: Router,
    private shoppingCartService: ShoppingCartService) { }

  ngOnInit() {
    this.currentPageNumber = 0;
    // this.loadData();
  }

  loadShoppingCart() {
    this.shoppingCartService.get().subscribe(
      (data) => {
        this.shoppingCart = data;
      },
      (error) => {
        console.log(error);
      }
    );
  }
  loadData() {
    if (this.authenticationService.getCurrentUser()) {
      this.loadShoppingCart();
    }

    this.componentsService.getAll(this.currentPageNumber, this.itemsPerPage).subscribe(data => {
      this.page = data;
      this.totalPages = data.totalPages;
    });

    this.brandsService.getAll().subscribe(
      (brands) => {
        this.brands = brands;
      }
    );
  }

  delete(comp: Component) {
    this.componentsService.delete(comp).subscribe(
      (res) => {
        this.loadData();
      },
      (err) => {
        this.loadData();
      }
    );
  }

  buy(item: Component): void {
    this.shoppingCartService.addItem(item).subscribe(
      (shoppingCart) => {
        this.shoppingCart = shoppingCart;
        this.loadShoppingCart();
      }
    );
  }


  itemsPerPageChanged(value: number): void {
    this.itemsPerPage = value;
    this.loadData();
  }

  changePage(i: number) {
    this.currentPageNumber += i;
    this.loadData();
  }

  isLoggedIn(): boolean {
    return this.authenticationService.isLoggedIn();
  }

  isAdmin(): boolean {
    return this.authenticationService.isAdmin();
  }

  edit(comp: Component) {
    this.router.navigate(["edit", comp.id]);
  }
}

