import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { HttpModule } from "@angular/http";
import { RouterModule, Routes } from "@angular/router";
import { FormsModule } from "@angular/forms";
import { HTTP_INTERCEPTORS, HttpClientModule } from "@angular/common/http";

import { AppComponent } from "./app.component";

import { AuthenticationService } from "./services/authentication-service.service";
import { JwtUtilsService } from "./services/jwt-utils.service";
import { TokenInterceptorService } from "./services/token-interceptor.service";
import { CanActivateAuthGuard } from "./services/can-activate-auth.guard";

const appRoutes: Routes = [
  // { path: 'students', component: StudentsComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    // StudentsComponent,
  ],
  imports: [
    BrowserModule,
    HttpModule,
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
    JwtUtilsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
