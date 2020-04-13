import { Component, OnInit } from '@angular/core';
import { Router, RoutesRecognized } from '@angular/router';
import { AuthService } from '../auth/auth.service'

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  tokenInfo: Object;

  constructor(public auth: AuthService) { }

  ngOnInit(): void {
    this.tokenInfo = this.auth.decodeToken()
    console.log(this.tokenInfo);
  }
}
