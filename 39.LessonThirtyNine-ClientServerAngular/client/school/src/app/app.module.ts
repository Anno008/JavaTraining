import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { HttpModule } from "@angular/http";
import { RouterModule, Routes } from "@angular/router";
import { FormsModule} from "@angular/forms";

import { AppComponent } from "./app.component";

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
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
