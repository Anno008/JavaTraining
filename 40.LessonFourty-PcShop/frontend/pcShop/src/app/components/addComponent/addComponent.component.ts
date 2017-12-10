import { Component as c, OnInit } from "@angular/core";

import { AuthenticationService } from "../../services/authentication-service.service";
import { Observable } from "rxjs/Observable";
import { Input } from "@angular/core";
import { Output } from "@angular/core";
import { EventEmitter } from "@angular/core";

import { Router } from "@angular/router";
import { Brand } from "../../models/Brand";
import { Page } from "../../models/Page";
import { Component } from "../../models/Component";
import { ComponentsService } from "../../services/components-service.service";
import { BrandService } from "../../services/brand-service.service";
import { ComponentType } from "../../models/ComponentType";
import { ComponentTypeService } from "../../services/componentType-service.service";

@c({
  selector: "app-add-component",
  templateUrl: "./addComponent.component.html",
  styleUrls: ["./addComponent.component.css"]
})
export class AddComponentComponent {
  comp: Component;

  dataLoaded = false;
  brands: Brand[];

  componentTypes: ComponentType[];

  constructor(
    private brandService: BrandService,
    private componentTypeService: ComponentTypeService,
    private compnoentService: ComponentsService,
    private router: Router) { }

  ngOnInit() {
    this.loadData();
  }

  loadData() {
    this.brandService.getAll().subscribe(
      (data) => {
        this.brands = data;
        console.log(data);
      },
      (error) => {
        console.log(error);
      }
    );

    this.componentTypeService.getAll().subscribe(
      (data) => {
        this.componentTypes = data;
      },
      (error) => {
        console.log(error);
      }
    );
    this.dataLoaded = true;
    this.comp = {
      brand: null,
      componentType: null,
      name: "",
      price: 0
    };
  }
  add() {
    this.compnoentService.save(this.comp).subscribe(
      (yes) => {
        alert("Success");
      },
      (no) => {
        alert("Error");
      }
    );
    this.comp = {
      brand: null,
      componentType: null,
      name: "",
      price: 0
    };
    const res = confirm("Do you want to add more items or go back to the list?");
    console.log(res);
    if (!res) {
      this.router.navigate(["/components"]);
    }
  }

  byId(brand1: Brand, brand2: Brand) {
    if (brand1 && brand2) {
      return brand1.id === brand2.id;
    }
  }

}

