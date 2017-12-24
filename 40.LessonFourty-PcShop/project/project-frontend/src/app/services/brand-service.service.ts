import { Injectable } from "@angular/core";
import { Observable } from "rxjs/Rx";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { JwtUtilsService } from "./jwt-utils.service";
import { Page } from "../models/Page";
import { Brand } from "../models/Brand";
import { HttpParams } from "@angular/common/http/src/params";

@Injectable()
export class BrandService {
    private readonly path = "api/brands";
    constructor(private http: HttpClient) { }

    getAll(): Observable<Brand[]> {
        return this.http.get(this.path) as Observable<Brand[]>;
    }

}
