import { provideRouter } from '@angular/router';
import { routes } from './app.routes';
import { provideHttpClient, withFetch } from '@angular/common/http';
import { UserService } from './user.service';

export const appConfig = {
  providers: [
    provideRouter(routes), // Add routing providers
    UserService, // Your custom service
    provideHttpClient(withFetch()), // Add HttpClient provider
  ],
};
