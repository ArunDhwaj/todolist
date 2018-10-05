import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import {AppService} from './service/app-service.service';
import {HttpClientModule} from '@angular/common/http';
import {TaskServService} from './service/task-serv.service';


@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [AppService, TaskServService],
  bootstrap: [AppComponent]
})
export class AppModule { }
