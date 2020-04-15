import { Component, OnInit } from '@angular/core';
import { Chart } from 'chart.js';
import { StocksService } from '../../services/stocks/stocks.service'
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  title = 'Stock Chart';
  canvas: any;
  ctx: any;
  res: any
  obj: Object = {
    0: { labels: [], data: [] },
    1: { labels: [], data: [] },
    2: { labels: [], data: [] }
  }
  chartBuilt: Object = {
    0: { built: true },
    1: { built: false },
    2: { built: false }
  }

  constructor(private stocksHttp: StocksService) {

  }

  ngOnInit() {
    this.stocksHttp.getTimeSeries("monthly", "msft").subscribe(
      data => this.organizeData(data, 11, "monthChart", 2),
      error => console.log(error)
    )

    this.stocksHttp.getTimeSeries("weekly", "aapl").subscribe(
      data => this.organizeData(data, 14, "weekChart", 1),
      error => console.log(error)
    )

    this.stocksHttp.getTimeSeries("daily", "googl").subscribe(
      data => this.organizeData(data, 29, "dayChart", 0),
      error => console.log(error)
    )
  }

  organizeData(data, length, chart, tabIndex) {
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

    this.obj[tabIndex].labels = labelArr
    this.obj[tabIndex].data = dataArr

    if(tabIndex == 0){
      this.createChart(chart, labelArr, dataArr)        
    }
  }


  createChart(chartId, labels, data) {
    this.canvas = document.getElementById(chartId);
    this.ctx = this.canvas.getContext('2d');
    let myChart = new Chart(this.ctx, {
      type: 'line',
      data: {
          labels: labels,
          datasets: [{
              fill: false,
              label: 'Stock Price $',
              data: data,
              borderWidth: 3,
              backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
              ],
              borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
          }]
      },
      options: {
        responsive: true,
      },
    });
  }

  changeEvent($event){
    var id = $event.index
    var chartId = (id == 1 ? "weekChart" : "monthChart")
    if (id >= 1 && !this.chartBuilt[id].built) {
      this.createChart(chartId, this.obj[id].labels, this.obj[id].data)
      this.chartBuilt[id].built = true
    }
  }
}

