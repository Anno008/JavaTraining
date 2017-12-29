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
        this.componentTypeService.getAll().subscribe(
          (data1) => {
            this.componentTypes = data1;
            this.route.params.subscribe((params) => {
              this.componentService.get(+params["id"]).subscribe(
                (data2) => {
                  this.comp = data2;
                  this.dataLoaded = true;
                },
                (error) => {
                  console.log(error);
                });
            });
          },
          (error) => {
            console.log(error);
          }
        );
      },
      (error) => {
        console.log(error);
      }
    );

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

