import { Component, OnInit } from '@angular/core';
import { Chart } from 'chart.js';
import { StocksService } from '../stocks.service'
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  title = 'Sample Stock Chart';
  canvas: any;
  ctx: any;
  monthlyRes: any
  monthArr: string[] = new Array(12)
  monthPrice: number[] = new Array(12)

  constructor(private stocksHttp: StocksService) {

  }

  ngOnInit() {
    this.stocksHttp.getTimeSeriesMonthly("msft").subscribe(
      data => {        
        this.monthlyRes = data
        this.monthlyRes = JSON.parse(this.monthlyRes.response)
        console.log(this.monthlyRes);
        for (let index = 0; index < Object.keys(this.monthlyRes).length; index++) {          
          const date = this.monthlyRes[index].Date
          const price = this.monthlyRes[index]["4. close"]
          const intPrice = parseInt(price)
          this.monthArr[11 - index] = date
          this.monthPrice[11 - index] = intPrice          
        }
        this.createMonthChart()        
      },
      error => {
        console.log(error);
      }
    )
  }

  createMonthChart() {
    this.canvas = document.getElementById('myChart');
    this.ctx = this.canvas.getContext('2d');
    let myChart = new Chart(this.ctx, {
      type: 'line',
      data: {
          labels: this.monthArr,
          datasets: [{
              label: 'Stock Price $',
              data: this.monthPrice,
              borderWidth: 1
          }]
      },
      options: {
        responsive: true,
      }
    });
  }
}

