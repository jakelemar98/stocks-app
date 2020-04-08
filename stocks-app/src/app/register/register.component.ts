import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { EmailValidator } from './email.validator';
import { PasswordValidator } from './password.validator';
import { UsersService } from '../users.service';
import { NewUser } from '../new-user'
import { User } from '../user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  
  formData: Object;
  user: User;
  registerForm = this.fb.group({
    firstname: ['', Validators.required],
    lastname: ['', Validators.required],
    email: ['', Validators.required],
    confirmEmail: ['', Validators.required],
    password: ['', [Validators.required, Validators.minLength(8)]],
    confirmPass: ['', Validators.required]
  }, { validator: [EmailValidator.mustBeEqual, PasswordValidator.mustBeEqual] } )

  constructor(private fb: FormBuilder, private userHttp: UsersService) { }

  ngOnInit(): void {
  }

  onRegister() {
    this.formData = this.registerForm.value;
    const user: NewUser = {
      firstname: this.formData['firstname'],
      lastname: this.formData['lastname'],
      email: this.formData['email'],
      password: this.formData['password']
    }

    this.userHttp.createUser(user).subscribe(data => {
      console.log(data);
    })

  }

}
