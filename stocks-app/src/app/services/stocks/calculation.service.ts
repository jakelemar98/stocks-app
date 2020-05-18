import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CalculationService {

  constructor() { }

  calcMonthlyChanges(months: number[], data: Object): Object {
    const comparison: number = data[0]['4. close']
    const arr: Array<Object> = [];
    const newObj: Object = []
    for (let index = 0; index < months.length; index++) {
      const newNum: number = data[months[index]]['4. close']
      const change: number = comparison - newNum
      const percent: number = (change / comparison) * 100
      newObj[index] = percent.toFixed(2)
    }
    return newObj
  }
}
