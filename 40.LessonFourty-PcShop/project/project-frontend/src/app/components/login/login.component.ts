import { Component, OnInit } from "@angular/core";

import { AuthenticationService } from "../../services/authentication-service.service";
import { Observable } from "rxjs/Observable";

import { Router } from "@angular/router";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"]
})
export class LoginComponent {
  public user;
  public wrongUsernameOrPass: boolean;

  constructor(private authenticationService: AuthenticationService,
    private router: Router) {
    this.user = {};
    this.wrongUsernameOrPass = false;
  }


  login(): void {
    this.authenticationService.login(this.user.username, this.user.password).subscribe(
      (loggedIn: boolean) => {
        if (loggedIn) {
          this.router.navigate(["/components"]);
        }
      }
      ,
      (err: Error) => {
        if (err.toString() === "Illegal login") {
          this.wrongUsernameOrPass = true;
        } else {
          Observable.throw(err);
        }
      });
  }

}

