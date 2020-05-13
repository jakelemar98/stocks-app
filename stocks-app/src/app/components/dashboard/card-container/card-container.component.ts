import { Component, OnInit, Input } from '@angular/core';
import { stockInfo } from 'src/app/interfaces/stocks';

@Component({
  selector: 'app-card-container',
  templateUrl: './card-container.component.html',
  styleUrls: ['./card-container.component.scss']
})
export class CardContainerComponent implements OnInit {
  @Input() stocks: stockInfo
  constructor() { }

  ngOnInit(): void {
  }

}
