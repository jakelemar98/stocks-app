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
  res: any
  labelArr: string[] = new Array()
  dataArr: number[] = new Array()
  monthChartVisible: string = "none"
  weekChartVisible: string = "none"
  dayChartVisible: string = "none"

  constructor(private stocksHttp: StocksService) {

  }

  ngOnInit() {
    this.stocksHttp.getTimeSeries("monthly", "msft").subscribe(
      data => this.organizeData(data, 11, "monthChart"),
      error => console.log(error)
    )

    this.stocksHttp.getTimeSeries("weekly", "aapl").subscribe(
      data => this.organizeData(data, 14, "weekChart"),
      error => console.log(error)
    )

    this.stocksHttp.getTimeSeries("daily", "googl").subscribe(
      data => this.organizeData(data, 29, "dayChart"),
      error => console.log(error)
    )
  }

  organizeData(data, length, chart) {
    this.res = data
    this.res = JSON.parse(this.res.response)
    var labelArr = new Array()
    var dataArr = new Array()
    for (let index = 0; index < Object.keys(this.res).length; index++) {          
      const date = this.res[index].Date
      const price = this.res[index]["4. close"]
      const intPrice = parseInt(price)
      labelArr[length - index] = date
      dataArr[length - index] = intPrice  
    }
    console.log(dataArr, labelArr);
    
    this.createChart(chart, labelArr, dataArr)        
    this.dayChartVisible = "block"
  }


  createChart(chartId, labels, data) {    
    this.canvas = document.getElementById(chartId);
    this.ctx = this.canvas.getContext('2d');
    let myChart = new Chart(this.ctx, {
      type: 'line',
      data: {
          labels: labels,
          datasets: [{
              label: 'Stock Price $',
              data: data,
              borderWidth: 1
          }]
      },
      options: {
        responsive: true,
      }
    });
  }
}

