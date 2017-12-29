import { Component, OnInit } from "@angular/core";

import { AuthenticationService } from "../../services/authentication-service.service";
import { Observable } from "rxjs/Observable";

import { Router } from "@angular/router";

@Component({
  selector: "app-register",
  templateUrl: "./register.component.html",
  styleUrls: ["./register.component.css"]
})
export class RegisterComponent {
  public user;
  public error: boolean;
  public message: string;

  constructor(private authenticationService: AuthenticationService,
    private router: Router) {
    this.user = {};
  }


  register(): void {
    this.authenticationService.register(this.user.username, this.user.password).subscribe(
      (registered: boolean) => {
        if (registered) {
          this.authenticationService.login(this.user.username, this.user.password);
          this.router.navigate(["/list"]);
        } else {
          this.error = true;
          this.message = "Unexpected error, please try again.";
        }
      }
      ,
      (err: Error) => {
        this.message = err.message;
        this.error = true;
      });
  }

}

