import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.scss'],
})
export class UserFormComponent implements OnInit {
  user = { name: '', email: '' };

  constructor(private readonly userService: UserService) {}

  ngOnInit(): void {
    console.log('UserFormComponent initialized');
  }

  onSubmit() {
    this.userService.addUser(this.user).subscribe();
  }
}
