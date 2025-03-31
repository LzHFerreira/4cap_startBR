import { bootstrapApplication } from '@angular/platform-browser';
import { ApplicationConfig } from '@angular/core';
import { AppComponent } from './app/app.component';
import { provideRouter } from '@angular/router';
import { routes } from './app/app.routes';
import { provideHttpClient } from '@angular/common/http';
import { UserService } from './app/user.service';

const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes), // Provides routing functionality
    UserService, // Your custom service
    provideHttpClient(), // Properly providing HttpClient
  ],
};

bootstrapApplication(AppComponent, appConfig).catch((err) =>
  console.error(err)
);
