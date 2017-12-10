import { Component } from "@angular/core";
import { AuthenticationService } from "./services/authentication-service.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent {
  title = "pcShop";
  user = "";

  constructor(private authenticationService: AuthenticationService, private router: Router) {
  }

  logout(): void {
    this.authenticationService.logout();
    this.router.navigate(["/login"]);
  }

  isLoggedIn(): boolean {
    this.getCurrentUsername();
    return this.authenticationService.isLoggedIn();
  }

  getCurrentUsername(): void {
    this.user = this.authenticationService.getCurrentUser();
  }
}
