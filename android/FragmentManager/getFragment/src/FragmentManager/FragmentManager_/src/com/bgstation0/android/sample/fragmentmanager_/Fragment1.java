package com.bgstation0.android.sample.fragmentmanager_;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

//フラグメント1
public class Fragment1 extends Fragment implements OnClickListener{

	// メンバフィールド
	static final String TAG = "Fragment1";	// TAGを"Fragment1"で初期化.
	public int mNumber = 0;	// mNumberを0で初期化.
	
	// コンストラクタ
	public Fragment1(){
		
	}
	
	// フラグメント生成時
	@Override
	public void onCreate(Bundle savedInstanceState){
		
		// 既定の処理.
		super.onCreate(savedInstanceState);	// 親クラスのonCreateを呼ぶ.
		
		// ログを残す.
		Log.d(TAG, "Fragment1.onCreate");	// "Fragment1.onCreate"とログに残す.
		
	}
	
	// フラグメント破棄時
	@Override
	public void onDestroy(){
		
		// ログを残す.
		Log.d(TAG, "Fragment1.onDestroy");	// "Fragment1.onDestroy"とログに残す.
		
		// 既定の処理.
		super.onDestroy();	// 親クラスのonDestroyを呼ぶ.
		
	}
	
	// ビュー生成時
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		
		// ログを残す.
		Log.d(TAG, "Fragment1.onCreateView");	// "Fragment1.onCreateView"とログに残す.
				
		// 既定の処理.
		View view = inflater.inflate(R.layout.fragment1_main, null);	// inflater.inflateでR.layout.fragment1_mainからビューを作成.
        Button button1 = (Button)view.findViewById(R.id.fragment1_button1);	// Fragment1のbutton1を取得.
        button1.setOnClickListener(this);	// リスナーとしてthisをセット.
        TextView tv = (TextView)view.findViewById(R.id.fragment1_textview);
        tv.setText(Integer.toString(mNumber));
		return view;
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		mNumber++;	// mNumberを増やす.
		View view = getView();
		TextView tv = (TextView)view.findViewById(R.id.fragment1_textview);
        tv.setText(Integer.toString(mNumber));
	}
	
}
