package com.bgstation0.android.sample.bluetoothdevice_;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// カスタムレシーバ
public class CustomReceiver extends BroadcastReceiver {

    // メンバフィールド.
    MainActivity mMainActivity = null;	// nullで初期化.
		

    // コンストラクタ.
    public CustomReceiver(MainActivity mainActivity){
    	
    	// 初期化.
    	mMainActivity = mainActivity;	// mMainActivityにmainActivityをセット.
			
    }
		
    // 受信時.
    @Override
    public void onReceive(Context context, Intent intent) {
			
        // TODO Auto-generated method stub
        // actionごとの処理.
        String action = intent.getAction();	// intent.getActionで得られたアクションをactionに格納.
        if (action == BluetoothAdapter.ACTION_DISCOVERY_STARTED){	// ACTION_DISCOVERY_STARTEDが来た時.
        	
        	// リストのクリア.
            mMainActivity.mCustomAdapter.clear();
            
        }
        else if (action == BluetoothDevice.ACTION_FOUND){	// ACTION_FOUNDが来た時.
				
            // Bluetoothデバイスの追加.
            BluetoothDevice bluetoothDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);	// bluetoothDeviceを取得.
            mMainActivity.mCustomAdapter.add(bluetoothDevice);	// bluetoothDeviceを追加.
	
        }
        
    }
    
}