import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.scss'],
})
export class UserFormComponent implements OnInit {
  user = { name: '', email: '' };

  constructor(
    private readonly userService: UserService,
    private readonly router: Router
  ) {}

  ngOnInit(): void {
    console.log('UserFormComponent initialized');
  }

  onSubmit() {
    console.log('Form submitted:', this.user);
    this.userService.addUser(this.user).subscribe(
      (response) => {
        console.log('User added successfully', response);
        // Navigate to home and show success message
        this.router.navigate(['/home'], {
          queryParams: { success: 'Usuário cadastrado com sucesso' },
        });
      },
      (error) => {
        console.error('Error adding user:', error);
      }
    );
  }
}
