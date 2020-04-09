import { Component, OnInit, Inject } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { EmailValidator } from './email.validator';
import { PasswordValidator } from './password.validator';
import { UsersService } from '../users.service';
import { NewUser } from '../new-user'
import { User } from '../user';
import { DialogTemplateComponent } from '../dialog-template/dialog-template.component'
import { MatDialogRef, MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  
  formData: Object;
  user: User;
  response: Object;
  error: any;

  dialogTemplate: MatDialogRef<DialogTemplateComponent>

  registerForm = this.fb.group({
    firstname: ['', Validators.required],
    lastname: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    confirmEmail: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(8)]],
    confirmPass: ['', Validators.required]
  }, { validator: [EmailValidator.mustBeEqual, PasswordValidator.mustBeEqual] } )

  

  constructor(private fb: FormBuilder, private userHttp: UsersService, private dialog: MatDialog) { }

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

    this.userHttp.createUser(user).subscribe(
      data => {
        this.response = data
        this.dialogTemplate = this.dialog.open(DialogTemplateComponent, {
          width: "250px",
          data: {message: "Your account has been created! lets get started!", title: "Nice!", showButton: true}
        });
      },
      error =>  {
        this.error = error

        if(this.error['status'] !== 201) {          
          this.dialogTemplate = this.dialog.open(DialogTemplateComponent, {
            width: "250px",
            data: {message: this.error, title: "Whoops"}
          });
        }
      }

      
    )    
  }

  private success(data){
    this.response = data
      console.log(this.response);
  }

}

