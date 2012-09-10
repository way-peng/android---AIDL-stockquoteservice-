package com.androidbook.stockquoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class StockQuoteService extends Service {
	private static final String TAG = "StockQuoteService";
   //对IStockQuoteService.Stub存根类的实现，并在onBind类中返回，从而在服务端完成对AIDL的实现。
	//而且将服务向客户端公开，需要在AndroidManifest.xml文件中添加服务声明。
	public class StockQuoteServiceImpl extends IStockQuoteService.Stub {

		@Override
		public double getQuote(String ticker) throws RemoteException {
			Log.v(TAG, "getQuote() called for " + ticker);
			return 20.0;
		}
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.v(TAG, "onCreate called");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.v(TAG, "onDestory() called");
	}

	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		Log.v(TAG, "onStart() called");
	}

	@Override
	//返回IStockQuoteService.Stub存根类的实现
	public IBinder onBind(Intent intent) {
		Log.v(TAG, "onBind() called");
		return new StockQuoteServiceImpl();
	}

}
