import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { Login } from '../../interfaces/login';
import { UsersService } from '../../services/users/users.service';
import { DialogTemplateComponent } from '../dialog-template/dialog-template.component';
import { MatDialogRef, MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Router, NavigationEnd } from '@angular/router';
import { AuthService } from '../../services/auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  formData: Object;
  error: any;
  data: any;
  token: any;

  dialogTemplate: MatDialogRef<DialogTemplateComponent>


  loginForm = this.fb.group({
    email: ['', Validators.required],
    password: ['', Validators.required]
  })

  constructor(private fb: FormBuilder, private userHttp: UsersService, private dialog: MatDialog, private router: Router, private auth: AuthService){ }

  onLogin() {
    this.formData = this.loginForm.value
    
    const login: Login = {
      email: this.formData['email'],
      password: this.formData['password']
    }
    
    this.userHttp.getUser(login).subscribe(
      data => {
        this.data = data
        this.token =  this.data.token
        this.data = JSON.parse(this.data.body);        
        localStorage.setItem("token", this.token)
        this.navigate("dashboard")
        window.location.reload();
      },
      error => {
        this.error = error
        console.log(this.error);
              
        this.dialogTemplate = this.dialog.open(DialogTemplateComponent, {
          width: "250px",
          data: {message: this.error, title: "Whoops", showButton: false}
        });
      }
    )  
  }

  navigate(url: string): void {
    this.router.navigate([url])
  }

  ngOnInit() {
    if (this.auth.isAuthenticated()) {
      this.navigate("dashboard")
    }
  }

}
