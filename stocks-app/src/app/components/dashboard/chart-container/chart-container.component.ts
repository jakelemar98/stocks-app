import { Component, OnInit, Input } from '@angular/core';
import { stockInfo } from 'src/app/interfaces/stocks';
import { Chart } from 'chart.js';
import { StocksService } from 'src/app/services/stocks/stocks.service';

interface ChartData {
  labels: any[],
  data: any[],
  built: Boolean;
}

@Component({
  selector: 'app-chart-container',
  templateUrl: './chart-container.component.html',
  styleUrls: ['./chart-container.component.scss']
})
export class ChartContainerComponent {

  @Input() stocks: stockInfo;
  
  chartData: any;
  canvas: any;
  ctx: any;
  chartRes: any;

  chartObj: ChartData = {
    labels: [],
    data: [],
    built: false
  };

  constructor(private stockService: StocksService) { }    

  ngAfterViewInit(): void {
    this.getChartData()
  }

  changeEvent($event){
    var id = $event.index
    if (id != 0) {
      if (!this.chartObj[id].built) {
        console.log("chart not built");
        this.createChart(this.stocks.data[id].symbol, this.chartObj[id].labels, this.chartObj[id].data, id)
      }
    }
  }

  getChartData(): void {    
    for (let index = 0; index < Object.keys(this.stocks.data).length; index++) {      
      this.stockService.getTimeSeries("daily", this.stocks.data[index]["symbol"]).subscribe(
        data => this.organizeData(data, 29, index),
        error => console.log(error)
      )
    }
  }

  createChart(chartId, labels, data, index) {
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
    this.chartObj[index].built = true
  }

  organizeData(data, length, tabIndex) {    
    this.chartRes = data
    this.chartRes = JSON.parse(this.chartRes.response)    
    var labelArr = new Array()
    var dataArr = new Array()
    for (let index = 0; index < Object.keys(this.chartRes).length; index++) {          
      const date = this.chartRes[index].Date
      const price = this.chartRes[index]["4. close"]      
      const intPrice = parseFloat(price)      
      labelArr[length - index] = date
      dataArr[length - index] = intPrice  
    }
    this.chartObj[tabIndex] = {labels: labelArr, data: dataArr, built: false }
    if (tabIndex == 0) {
      this.createChart(this.stocks.data[tabIndex]["symbol"], labelArr, dataArr, tabIndex)
    }
  }
}
