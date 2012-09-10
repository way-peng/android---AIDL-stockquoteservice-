package com.androidbook.stockquoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class StockQuoteService extends Service {
	private static final String TAG = "StockQuoteService";
   //��IStockQuoteService.Stub������ʵ�֣�����onBind���з��أ��Ӷ��ڷ������ɶ�AIDL��ʵ�֡�
	//���ҽ�������ͻ��˹�������Ҫ��AndroidManifest.xml�ļ�����ӷ���������
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
	//����IStockQuoteService.Stub������ʵ��
	public IBinder onBind(Intent intent) {
		Log.v(TAG, "onBind() called");
		return new StockQuoteServiceImpl();
	}

}
