import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  imports: [CommonModule],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  successMessage: string | null = null;

  constructor(
    private readonly router: Router,
    private readonly route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    // Check for success message in query params
    this.route.queryParams.subscribe((params) => {
      if (params['success']) {
        this.successMessage = params['success'];
      }
    });
  }

  goToUsers() {
    this.router.navigate(['/users']);
  }

  goToAddUser() {
    this.router.navigate(['/add-user']);
  }
}
