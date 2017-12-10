import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
// import { HttpModule } from "@angular/http";
import { RouterModule, Routes } from "@angular/router";
import { FormsModule } from "@angular/forms";
import { HTTP_INTERCEPTORS, HttpClientModule } from "@angular/common/http";

import { AppComponent } from "./app.component";
import { LoginComponent } from "./components/login/login.component";
import { RegisterComponent } from "./components/register/register.component";
import { ComponentsListComponent } from "./components/componentsList/componentsList.component";

import { AuthenticationService } from "./services/authentication-service.service";
import { JwtUtilsService } from "./services/jwt-utils.service";
import { TokenInterceptorService } from "./services/token-interceptor.service";
import { CanActivateAuthGuard } from "./services/can-activate-auth.guard";
import { ComponentsService } from "./services/components-service.service";
import { BrandService } from "./services/brand-service.service";

const appRoutes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "register", component: RegisterComponent },
  { path: "components", component: ComponentsListComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    ComponentsListComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(
      appRoutes,
      {
        enableTracing: false
      }
    )
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorService,
      multi: true
    },
    AuthenticationService,
    CanActivateAuthGuard,
    JwtUtilsService,
    ComponentsService,
    BrandService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
