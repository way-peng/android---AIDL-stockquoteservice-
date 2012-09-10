package com.androidbook.stockquoteservice;
interface IStockQuoteService
{          
//输入字符串格式的股票代号，输出双精度类型的股票价格
	double getQuote(String ticker);
}
