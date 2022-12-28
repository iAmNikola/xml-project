import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PInputFormPageComponent } from './pages/p/p-input-form-page/p-input-form-page.component';
import { HttpClientModule } from '@angular/common/http';
import { PSearchComponent } from './pages/p/p-search-page/p-search.component';

@NgModule({
  declarations: [
    AppComponent,
    PInputFormPageComponent,
    PSearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
