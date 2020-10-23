package com.bgstation0.android.sample.fragment_;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

//フラグメント1
public class Fragment1 extends Fragment implements OnClickListener{

	// メンバフィールド
	static final String TAG = "Fragment1";	// TAGを"Fragment1"で初期化.
	public int mNumber = 0;	// mNumberを0で初期化.
	public MainActivity mContext = null;	// mContextをnullで初期化.
	
	// コンストラクタ
	public Fragment1(){
		
	}
	
	// アタッチ時
	@Override
	public void onAttach(Activity activity){
			
		// 既定の処理.
		super.onAttach(activity);
		Log.d(TAG, "Fragment1.onAttach");	// "Fragment1.onAttach"とログに残す.
		mContext = (MainActivity)activity;	// activityをmContextに渡す.
		mContext.func();	// funcを呼ぶ.
		
	}
		
	// フラグメント生成時
	@Override
	public void onCreate(Bundle savedInstanceState){
		
		// 既定の処理.
		super.onCreate(savedInstanceState);	// 親クラスのonCreateを呼ぶ.
		
		// Fragmentの再生成を抑止.
		setRetainInstance(true);	// setRetainInstanceをtrueに.
				
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
	
	// デタッチ時
    @Override
    public void onDetach(){
    	
    	// ログを残す.
    	Log.d(TAG, "Fragment1.onDetach");	// "Fragment1.onDetach"とログに残す.
    
    	// mContextをnull.
    	mContext = null;
    	
    	// 既定の処理.
    	super.onDetach();	// 親クラスのonDetachを呼ぶ.
	
    }
    	
}