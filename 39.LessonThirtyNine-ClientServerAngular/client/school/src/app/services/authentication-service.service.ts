import { Injectable } from "@angular/core";
import { Observable } from "rxjs/Rx";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { JwtUtilsService } from "./jwt-utils.service";
import { apiUrl } from "../constants";

@Injectable()
export class AuthenticationServiceService {

  constructor(private http: HttpClient, private jwtUtilsService: JwtUtilsService) { }

  login(username: string, password: string): Observable<boolean> {
    const headers: HttpHeaders = new HttpHeaders({ "Content-Type": "application/json" });
    return this.http.post(`{ApiUrl/login`, JSON.stringify({ username, password }), { headers })
      .map((res: any) => {
        const token = res && res["token"];
        if (token) {
          localStorage.setItem("currentUser", JSON.stringify({
            username: username,
            roles: this.jwtUtilsService.getRoles(token),
            token: token
          }));
          return true;
        } else {
          return false;
        }
      })
      .catch((error: any) => {
        if (error.status === 400) {
          return Observable.throw("Illegal login");
        } else {
          return Observable.throw(error.json().error || "Server error");
        }
      });
  }

  register(username: string, password: string) :Observable<boolean> {
    const headers: HttpHeaders = new HttpHeaders({ "Content-Type": "application/json" });
    return this.http.post(`{ApiUrl/register`, JSON.stringify({ username, password }), { headers })
      .map((res: any) => {
        const token = res && res["token"];
        if (token) {
          localStorage.setItem("currentUser", JSON.stringify({
            username: username,
            roles: this.jwtUtilsService.getRoles(token),
            token: token
          }));
          return true;
        } else {
          return false;
        }
      })
      .catch((error: any) => {
        if (error.status === 400) {
          return Observable.throw("Couldn't complete the registration");
        } else {
          return Observable.throw(error.json().error || "Server error");
        }
      });
  }

  getToken(): String {
    const currentUser = JSON.parse(localStorage.getItem("currentUser"));
    const token = currentUser && currentUser.token;
    return token ? token : "";
  }

  logout(): void {
    localStorage.removeItem("currentUser");
  }

  isLoggedIn(): boolean {
    if (this.getToken() !== "") {
      return true;
    } else {
      return false;
    }
  }

  getCurrentUser() {
    if (localStorage.currentUser) {
      return JSON.parse(localStorage.currentUser);
    } else {
      return undefined;
    }
  }

}
