import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { Login } from '../login' 
import { UsersService } from '../users.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  formData: Object;

  loginForm = this.fb.group({
    email: ['', Validators.required],
    password: ['', Validators.required]
  })

  constructor(private fb: FormBuilder, private userHttp: UsersService){ }

  onLogin() {
    this.formData = this.loginForm.value
    
    const login: Login = {
      email: this.formData['email'],
      password: this.formData['password']
    }
    
    this.userHttp.getUser(login).subscribe(data => {
      console.log(data);
    })

  }

}
