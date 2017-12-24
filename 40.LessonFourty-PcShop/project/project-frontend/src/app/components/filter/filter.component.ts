import { Component, OnInit, ViewEncapsulation } from "@angular/core";
import { Input } from "@angular/core";
import { BrandService } from "../../services/brand-service.service";
import { ComponentTypeService } from "../../services/componentType-service.service";
import { Filter } from "../../models/Filter";
import { Brand } from "../../models/Brand";
import { ComponentType } from "../../models/ComponentType";

@Component({
  selector: "app-filter",
  templateUrl: "./filter.component.html",
  styleUrls: ["./filter.component.css"],
  encapsulation: ViewEncapsulation.None
})
export class FilterComponent implements OnInit {
  filter: Filter;
  types: ComponentType[];
  brands: Brand[];
  constructor(
    private brandService: BrandService,
    private componentTypeService: ComponentTypeService) {
  }

  ngOnInit() {
    this.loadData();
  }

  loadData() {
    this.brandService.getAll().subscribe((data) => this.brands = data);
    this.componentTypeService.getAll().subscribe((data) => this.types = data);
    this.filter = {
      brand: null,
      componentType: null,
      name: ""
    };
  }

  selectionChanged() {
    console.log(this.filter);
  }

  test() {
    console.log("Doubt");
  }
}
