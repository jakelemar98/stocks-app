import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ChartContainerComponent } from './chart-container/chart-container.component'
import { MaterialModule } from '../../material/material.module';
import { CardContainerComponent } from './card-container/card-container.component';
import { DeleteDialogComponent } from './delete-dialog/delete-dialog.component';

@NgModule({
  declarations: [
      ChartContainerComponent,
      CardContainerComponent,
      DeleteDialogComponent
  ],
  imports: [
    CommonModule,
    MaterialModule
  ],
  exports: [
    ChartContainerComponent,
    CardContainerComponent
  ]
})
export class DashboardModule { }
