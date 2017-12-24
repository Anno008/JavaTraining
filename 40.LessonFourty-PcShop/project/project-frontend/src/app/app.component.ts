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
    const res = this.authenticationService.isLoggedIn();
    if (res) {
      this.getCurrentUsername();
    }
    return res;
  }

  getCurrentUsername(): void {
    const res = this.authenticationService.getCurrentUser();
    if (res) {
      this.user = res;
    }
  }
}
