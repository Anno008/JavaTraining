import { Component as c, OnInit } from "@angular/core";

import { AuthenticationService } from "../../services/authentication-service.service";
import { Observable } from "rxjs/Observable";
import { Input } from "@angular/core";
import { Output } from "@angular/core";
import { EventEmitter } from "@angular/core";

import { Router, ActivatedRoute } from "@angular/router";
import { Brand } from "../../models/Brand";
import { Page } from "../../models/Page";
import { Component } from "../../models/Component";
import { ComponentsService } from "../../services/components-service.service";
import { BrandService } from "../../services/brand-service.service";
import { ComponentType } from "../../models/ComponentType";
import { ComponentTypeService } from "../../services/componentType-service.service";

@c({
  selector: "app-edit",
  templateUrl: "./edit.component.html",
  styleUrls: ["./edit.component.css"]
})
export class EditComponent {

  @Output()
  componentToSave: EventEmitter<Component> = new EventEmitter();

  @Input()
  comp: Component;

  @Input()
  brands: Brand[];

  @Input()
  componentTypes: ComponentType[];


  constructor(
    private brandService: BrandService,
    private componentTypeService: ComponentTypeService) {
  }

  ngOnInit() {
    this.loadData();
  }

  loadData() {

  }
  reset() {
    this.comp = {
      name: "",
      price: 0,
      brand: undefined,
      componentType: undefined
    };
    this.comp = undefined;
  }
  save() {
    this.componentToSave.next(this.comp);
    this.comp = undefined;
  }

  byId(brand1: Brand, brand2: Brand) {
    if (brand1 && brand2) {
      return brand1.id === brand2.id;
    }
  }

}

