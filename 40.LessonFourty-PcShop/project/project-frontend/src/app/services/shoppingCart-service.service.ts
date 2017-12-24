import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/Observable";
import { ShoppingCart } from "../models/ShoppingCart";
import { Component } from "../models/Component";

@Injectable()
export class ShoppingCartService {

    private path = "/api/shoppingCart";

    constructor(private httpClient: HttpClient) { }

    get(): Observable<ShoppingCart> {
        return this.httpClient.get(this.path) as Observable<ShoppingCart>;
    }

    addItem(item: Component): Observable<ShoppingCart> {
        return this.httpClient.post(this.path, item) as Observable<ShoppingCart>;
    }

    delete(id: number): Observable<any> {
        return this.httpClient.delete(`${this.path}/${id}`);
    }
}
