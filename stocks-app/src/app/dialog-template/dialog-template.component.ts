import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';


export interface DialogData {
  message: string;
  title: string;
  showButton: boolean;
  _id: string;
}


@Component({
  selector: 'dialog-template',
  templateUrl: 'dialog-template.component.html',
})
export class DialogTemplateComponent {

  constructor(
    public dialogRef: MatDialogRef<DialogTemplateComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

}