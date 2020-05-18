export interface stockInfo {
    exists: boolean;
    data: stockData[];
    historical: any[]
    length: number;
}

interface stockData {
    symbol: string;
    price:  number;
    open: number;
    close: number;
}