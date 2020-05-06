export interface stockInfo {
    exists: boolean;
    data: stockData[];
}

interface stockData {
    symbol: string;
    price:  number;
    open: number;
    close: number;
}
  