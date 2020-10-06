package com.bgstation0.android.sample.fragment_;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragment1 extends Fragment implements View.OnClickListener{

    // メンバフィールド
    static final String TAG = "Fragment1";	// TAGを"Fragment1"で初期化.
	
    // ビュー生成時
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
			
        // ログを残す.
        Log.d(TAG, "Fragment1.onCreateView");	// "Fragment1.onCreateView"とログに残す.
			
        // 既定の処理.
        super.onCreateView(inflater, container, savedInstanceState);
		
        // Fragment1のButtonを取得.
        View view = inflater.inflate(R.layout.fragment1_main, null);	// inflater.inflateでR.layout.fragment1_mainからビューを作成.
        Button button1 = (Button)view.findViewById(R.id.fragment1_button);	// button1を取得.
        button1.setOnClickListener(this);	// thisをセット.
        return view;	// viewを返す.
        
    }
    
    // クリックされた時.
    @Override
    public void onClick(View v) {
    	// TODO Auto-generated method stub
    	// SubActivityを起動.
    	Intent intent = new Intent(getActivity(), SubActivity.class);	// intentを生成.
    	//getActivity().startActivityForResult(intent, 1);	// Activity.startActivityForResultでintentと1を指定して起動.
    	startActivityForResult(intent, 1);	// Fragment.startActivityForResultでintentと1を指定して起動.
    }
    
    // アクティビティの結果が返ってきた時.
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
    	
    	// 既定の処理
    	super.onActivityResult(requestCode, resultCode, data);	// 親クラスのonActivityResultを呼ぶ.
    	
    	// resultCodeの出力.
    	Toast.makeText(getActivity(), "resultCode = " + String.valueOf(resultCode), Toast.LENGTH_LONG).show();	// resultCodeをToast表示.(RESULT_OKは-1.)
    	
    	// requestCodeの出力.
    	Toast.makeText(getActivity(), "Fragment1.requestCode = " + String.valueOf(requestCode), Toast.LENGTH_LONG).show();	// requestCodeをToast表示.
    	
    	// requestCodeが1.
    	if (requestCode == 1){
    		String message = data.getStringExtra("message");	// message取得.
    		Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();	// messageをToast表示.
    	}
    	
    }
    
}