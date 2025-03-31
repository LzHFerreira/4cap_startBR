import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { UserService } from './user.service';
import { provideHttpClient } from '@angular/common/http';

@NgModule({
  declarations: [],
  imports: [BrowserModule],
  providers: [UserService, provideHttpClient()],
})
export class AppModule {}
