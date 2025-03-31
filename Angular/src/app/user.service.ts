import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor() {}

  // Mock user list
  private users = [
    { id: 1, name: 'John Doe', email: 'john@example.com' },
    { id: 2, name: 'Jane Smith', email: 'jane@example.com' },
  ];

  // Get all users (mocked)
  getUsers(): Observable<any[]> {
    return of(this.users); // Returns the mock users as an observable
  }

  // Add a new user (mocked)
  addUser(user: any): Observable<any> {
    this.users.push(user);
    return of(user);
  }

  // Get a user by ID (mocked)
  getUserById(userId: number): Observable<any> {
    const user = this.users.find((u) => u.id === userId);
    return of(user || { error: 'User not found' });
  }

  // Delete a user by ID (mocked)
  deleteUser(userId: number): Observable<any> {
    this.users = this.users.filter((user) => user.id !== userId);
    return of({ message: 'User deleted' });
  }
}
