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
  selector: "app-edit-component",
  templateUrl: "./editComponent.component.html",
  styleUrls: ["./editComponent.component.css"]
})
export class EditComponentComponent {
  comp: Component;
  dataLoaded = false;
  brands: Brand[];
  componentTypes: ComponentType[];

  constructor(
    private brandService: BrandService,
    private componentTypeService: ComponentTypeService,
    private componentService: ComponentsService,
    private router: Router,
    private route: ActivatedRoute) {

  }

  ngOnInit() {
    this.loadData();
  }

  loadData() {
    this.brandService.getAll().subscribe(
      (data) => {
        this.brands = data;
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
    this.route.params.subscribe((params) => {
      this.componentService.get(+params["id"]).subscribe(
        (yes) => {
          this.comp = yes;
        },
        (error) => {
          console.log(error);
        });
    });

    this.dataLoaded = true;

  }
  save() {
    this.componentService.save(this.comp).subscribe(
      (yes) => {
        alert("Success");
      },
      (no) => {
        alert("Error");
      }
    );
    this.router.navigate(["/components"]);
  }

  byId(brand1: Brand, brand2: Brand) {
    if (brand1 && brand2) {
      return brand1.id === brand2.id;
    }
  }

}

