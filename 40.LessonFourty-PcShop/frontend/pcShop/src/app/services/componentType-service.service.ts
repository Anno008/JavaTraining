import { Injectable } from "@angular/core";
import { Observable } from "rxjs/Rx";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { JwtUtilsService } from "./jwt-utils.service";
import { Page } from "../models/Page";
import { Brand } from "../models/Brand";
import { HttpParams } from "@angular/common/http/src/params";
import { ComponentType } from "../models/ComponentType";

@Injectable()
export class BrandService {
    private readonly path = "api/componentTypes";
    constructor(private http: HttpClient) { }

    getAll(): Observable<ComponentType[]> {
        return this.http.get(this.path) as Observable<ComponentType[]>;
    }

}
