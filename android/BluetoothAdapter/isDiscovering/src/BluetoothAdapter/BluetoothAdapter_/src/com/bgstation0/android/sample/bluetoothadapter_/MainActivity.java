package com.bgstation0.android.sample.bluetoothadapter_;

import java.util.ArrayList;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

// メインアクティビティクラスMainActivity(View.OnClickListenerを実装.)
public class MainActivity extends Activity implements OnClickListener{

	// メンバフィールドの定義
	Context mContext = null;	// mContextをnullで初期化.
	public static final int REQUEST_CODE_BLUETOOTH_ENABLE = 1;	// REQUEST_CODE_BLUETOOTH_ENABLEを1で初期化.
	BluetoothAdapter mBluetoothAdapter = null;	// nullで初期化.
	private BroadcastReceiver mCustomReceiver = null;	// ブロードキャストレシーバはnullで初期化.
	ListView mListView1 = null;	// mListView1をnullで初期化.
	CustomAdapter mCustomAdapter = null;	// mCustomAdapterをnullで初期化.
	ArrayList<ListItem> mListItem = null;	// mListItemをnullで初期化.
	
	// アクティビティ生成時
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	// 既定の処理
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // mContextに自身をセット.
        mContext = this;	// mContextにthisを格納.
        
        // リストビューの取得.
        mListView1 = (ListView)findViewById(R.id.listview1);	// mListView1を取得.
        
        // カスタムアダプタの生成.
        mListItem = new ArrayList<ListItem>();	// mListItemは生成.
        mCustomAdapter = new CustomAdapter(this, R.layout.list_item, mListItem);	// CustomAdapterの生成.
        
        // カスタムレシーバ生成.
        mCustomReceiver = new CustomReceiver(this);	// CustomReceiverを生成.(thisを渡す.)
        
        // button1の初期化.
        Button button1 = (Button)findViewById(R.id.button1);	// button1を取得.
        button1.setOnClickListener(this);	// thisをセット.
        
        // button2の初期化.
        Button button2 = (Button)findViewById(R.id.button2);	// button2を取得.
        button2.setOnClickListener(this);	// thisをセット.
        
    }

    // クリック時
	@Override
	public void onClick(View v) {
		
		// TODO Auto-generated method stub
		// 押されたButton毎に処理を分岐.
		if (v.getId() == R.id.button1){	// button1の時.

			// BluetoothAdapterの取得.
			mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();	// mBluetoothAdapterの取得.
			if (mBluetoothAdapter != null){	// nullでない.
			
				// 利用可能でなかったら, Bluetooth設定画面に遷移し, 利用可能なら探索.
				if (!mBluetoothAdapter.isEnabled()){	// 利用可能でない.
					Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);	// 利用可能リクエスト.
					//startActivity(intent);	// 起動.
					startActivityForResult(intent, REQUEST_CODE_BLUETOOTH_ENABLE);	// startActivityForResultでintent発行, REQUEST_CODE_BLUETOOTH_ENABLEを渡す.
				}
				else{	// 利用可能.
				
					// インテントフィルターをカスタムレシーバに登録.
					IntentFilter filter = new IntentFilter();	// filterの生成.
					filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);	// 開始
					filter.addAction(BluetoothDevice.ACTION_FOUND);	// 発見
					filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);	// 終了
					registerReceiver(mCustomReceiver, filter);	// mCustomReceiverにfilterを登録.
				
					// 探索.
					mBluetoothAdapter.startDiscovery();	// mBluetoothAdapter.startDiscoveryで探索開始.
				
				}
			
			}
			
		}
		else if (v.getId() == R.id.button2){	// button2の時.
			
			// BluetoothAdapterの取得.
			mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();	// mBluetoothAdapterの取得.
			if (mBluetoothAdapter != null){	// nullでない.

				// 探索中かチェック.
				if (mBluetoothAdapter.isDiscovering()){	// 探索中.
					Toast.makeText(mContext, "Discovering!", Toast.LENGTH_LONG).show();	// "Discovering!"と表示.
				}
				else{
					Toast.makeText(mContext, "Not discovering.", Toast.LENGTH_LONG).show();	// "Not discovering."と表示.
				}
			
			}
			
		}
				
	}
	
	// Bluetooth許可ダイアログから返ってきた時.
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent){
		
		// リクエストがBluetooth許可の場合.
		if (requestCode == REQUEST_CODE_BLUETOOTH_ENABLE){
			if (resultCode == Activity.RESULT_OK){	// ユーザが許可を押した時.
				
				// インテントフィルターをカスタムレシーバに登録.
				IntentFilter filter = new IntentFilter();	// filterの生成.
				filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);	// 開始
				filter.addAction(BluetoothDevice.ACTION_FOUND);	// 発見
				filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);	// 終了
				registerReceiver(mCustomReceiver, filter);	// mCustomReceiverにfilterを登録.
				
				// 探索.
				mBluetoothAdapter.startDiscovery();	// mBluetoothAdapter.startDiscoveryで探索開始.
				
			}
		}
		
	}
	
}