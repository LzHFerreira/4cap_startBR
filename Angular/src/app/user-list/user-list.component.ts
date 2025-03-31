import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-user-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss'],
})
export class UserListComponent implements OnInit {
  users: any[] = [];

  constructor(private readonly userService: UserService) {}

  ngOnInit() {
    this.userService.getUsers().subscribe((data) => {
      this.users = data;
    });
  }
}
