import { Component as c, OnInit } from "@angular/core";

import { AuthenticationService } from "../../services/authentication-service.service";
import { Observable } from "rxjs/Observable";

import { Router } from "@angular/router";
import { Brand } from "../../models/Brand";
import { Page } from "../../models/Page";
import { Component } from "../../models/Component";
import { ComponentsService } from "../../services/components-service.service";
import { BrandService } from "../../services/brand-service.service";

@c({
  selector: "app-components",
  templateUrl: "./componentsList.component.html",
  styleUrls: ["./componentsList.component.css"]
})
export class ComponentsListComponent {
  brands: Brand[];

  page: Page<Component>;

  currentPageNumber: number;

  forEdit: Component;


  constructor(private componentsService: ComponentsService,
    private authenticationService: AuthenticationService,
    private brandsService: BrandService) { }

  ngOnInit() {
    this.currentPageNumber = 0;
    this.loadData();

    this.brandsService.getAll().subscribe(
      (brands) => {
        this.brands = brands;
      }
    );
  }

  loadData() {
    this.componentsService.getAll(this.currentPageNumber).subscribe(data => {
      this.page = data;
    });
  }

  changePage(i: number) {
    this.currentPageNumber += i;
    this.loadData();
  }

  isAdmin(): boolean {
    return this.authenticationService.isAdmin();
  }
}

