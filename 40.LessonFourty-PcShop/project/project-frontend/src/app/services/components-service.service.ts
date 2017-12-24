import { Injectable } from "@angular/core";
import { Observable } from "rxjs/Rx";
import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { JwtUtilsService } from "./jwt-utils.service";
import { Page } from "../models/Page";
import { Component } from "../models/Component";

@Injectable()
export class ComponentsService {
  private readonly path = "api/components";
  constructor(private http: HttpClient) { }

  getAll(page: number, itemsPerPage: number): Observable<Page<Component>> {
    let params = new HttpParams();
    params = params.append("page", page.toString());
    params = params.append("size", itemsPerPage.toString());

    return this.http.get(this.path, { params: params }) as Observable<Page<Component>>;
  }

  get(id: number): Observable<Component> {
    return this.http.get(`${this.path}/${id}`) as Observable<Component>;
  }

  save(comp: Component): Observable<Component> {
    let params = new HttpParams();
    params = params.append("Content-Type", "application/json");
    return comp.id === undefined ?
      this.http.post(this.path, comp, { params }) as Observable<Component>
      : this.http.put(`${this.path}/${comp.id}`, comp, { params }) as Observable<Component>;

  }

  delete(comp: Component): any {
    return this.http.delete(`${this.path}/${comp.id}`);
  }
}
