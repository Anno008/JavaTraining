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
}

// import { Component, OnInit, ViewEncapsulation } from "@angular/core";
// import { Input } from "@angular/core";
// import { MenuItemListComponent } from "../menu-item-list/menu-item-list.component";
// import { MenuItemService } from "../../services/menu-item-service.service";
// import { Output } from "@angular/core";
// import { EventEmitter } from "@angular/core";
// import { Filter } from "../../models/FIlter";
// import { CategoryService } from "../../services/category-service.service";
// import { Category } from "../../models/Category";


// @Component({
//   selector: "app-filter",
//   templateUrl: "./filter.component.html",
//   styleUrls: ["./filter.component.css"],
// })
// export class FilterComponent implements OnInit {

//    @Output() filterItems: EventEmitter<Filter> = new EventEmitter();

//   filter: Filter = {
//     name: "",
//     categoryId: 0
//   }
//   categories: Category[];
//   dataLoaded = false;
//   constructor(private menuItemService: MenuItemService,
//     private categoryService: CategoryService

//   ) {
//   }

//   ngOnInit() {
//     this.loadData();
//   }
//   loadData() {
//     this.categoryService.getAll().subscribe(data => {
//       this.categories = data;
//       this.dataLoaded = true;
//     }
//     );

//   }
//   selectionChanged() {
//     this.filterItems.next(this.filter);
//   }
// }
