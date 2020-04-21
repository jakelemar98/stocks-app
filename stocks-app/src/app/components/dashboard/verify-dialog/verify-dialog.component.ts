// import { Component, OnInit } from '@angular/core';


// export class VerifyDialogComponent implements OnInit {

//   constructor() { }

//   ngOnInit(): void {
//   }

// }

import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { FormControl, Validators } from '@angular/forms';
import { EmailService } from 'src/app/services/email/email.service';


export interface DialogData {
  code: number;
}


@Component({
  selector: 'app-verify-dialog',
  templateUrl: './verify-dialog.component.html',
  styleUrls: ['./verify-dialog.component.scss']
})
export class VerifyDialogComponent {

  codeFormControl = new FormControl("", [
    Validators.required
  ]);

  constructor(public dialogRef: MatDialogRef<VerifyDialogComponent>, @Inject(MAT_DIALOG_DATA) public data: DialogData, private emailService: EmailService) {}

  verifyCode(): void {
    var code = this.codeFormControl.value;
    this.emailService.checkCode(code).subscribe(
      data => this.closeDialog(data),
      error => console.log(error)
    );
  }

  closeDialog(data){
    localStorage.setItem("token", data.body)    
    this.dialogRef.close({event: data});
  }

}