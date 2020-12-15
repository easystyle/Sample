package com.bgstation0.android.sample.bluetoothdevice_;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

//メインアクティビティクラスMainActivity(View.OnClickListenerを実装.)
public class MainActivity extends Activity implements OnClickListener{

	// メンバフィールドの定義
	Context mContext = null;	// mContextをnullで初期化.
	public static final int REQUEST_CODE_BLUETOOTH_ENABLE = 1;	// REQUEST_CODE_BLUETOOTH_ENABLEを1で初期化.
	BluetoothAdapter mBluetoothAdapter = null;	// nullで初期化.
	
	// アクティビティ生成時
	@Override
	protected void onCreate(Bundle savedInstanceState) {
 	
		// 既定の処理
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
     
		// mContextに自身をセット.
		mContext = this;	// mContextにthisを格納.
     
		// button1の初期化.
		Button button1 = (Button)findViewById(R.id.button1);	// button1を取得.
		button1.setOnClickListener(this);	// thisをセット.
     
	}

	// クリック時
	@Override
	public void onClick(View v) {
		
		// TODO Auto-generated method stub
		// BluetoothAdapterの取得.
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();	// mBluetoothAdapterの取得.
		if (mBluetoothAdapter != null){	// nullでない.
			
			// 利用可能でなかったら, Bluetooth設定画面に遷移.
			if (!mBluetoothAdapter.isEnabled()){	// 利用可能でない.
				Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);	// 利用可能リクエスト.
				//startActivity(intent);	// 起動.
				startActivityForResult(intent, REQUEST_CODE_BLUETOOTH_ENABLE);	// startActivityForResultでintent発行, REQUEST_CODE_BLUETOOTH_ENABLEを渡す.
			}
			
		}
		
	}
	
	// Bluetooth許可ダイアログから返ってきた時.
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent){
		
		// リクエストがBluetooth許可の場合.
		if (requestCode == REQUEST_CODE_BLUETOOTH_ENABLE){
			if (resultCode == Activity.RESULT_OK){	// ユーザが許可を押した時.
				mBluetoothAdapter.startDiscovery();	// mBluetoothAdapter.startDiscoveryで探索開始.
			}
		}
		
	}
	
}