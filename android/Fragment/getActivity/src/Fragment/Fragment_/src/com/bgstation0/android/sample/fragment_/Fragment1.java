package com.bgstation0.android.sample.fragment_;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

//フラグメント1
public class Fragment1 extends Fragment {

	// メンバフィールド
	static final String TAG = "Fragment1";	// TAGを"Fragment1"で初期化.
	
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
		
		// MainActivityのEditTextの内容を取得.
		Activity mainActivity = getActivity();	// mainActivityを取得.
		EditText mainEdittext1 = (EditText)mainActivity.findViewById(R.id.edittext1);	// mainEdittext1を取得.
		Log.d(TAG, "mainEdittext1 = " + mainEdittext1.getText().toString());	// mainEdittext1をログ出力.
		
		// 既定の処理.
		return inflater.inflate(R.layout.fragment1_main, null);	// inflater.inflateでR.layout.fragment1_mainからビューを作成し, そのまま返す.
		
	}
	
}
