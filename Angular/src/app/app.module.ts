import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { UserService } from './user.service';
import { provideHttpClient } from '@angular/common/http';
import { AppRoutingModule } from './app.routes';

@NgModule({
  declarations: [],
  imports: [BrowserModule, AppRoutingModule],
  providers: [UserService, provideHttpClient()],
})
export class AppModule {}
