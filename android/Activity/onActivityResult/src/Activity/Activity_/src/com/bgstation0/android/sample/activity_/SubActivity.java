package com.bgstation0.android.sample.activity_;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

//MainActivityによって起動されるSubActivity.
public class SubActivity extends Activity implements OnClickListener{	// SubActivityの定義.

	// Activityが生成されたとき.
	@Override
	protected void onCreate(Bundle savedInstanceState) {	// onCreateの定義
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);
		
		// button2を取得し, OnClickListenerとして自身をセット.
        Button button2 = (Button)findViewById(R.id.button2);	// findViewByIdでR.id.button2を取得.
        button2.setOnClickListener(this);	// button1.setOnClickListenerでthis(自身)をセット.
	}
	
	// View.OnClickListenerインタフェースのオーバーライドメソッドを実装.
    public void onClick(View v){	// onClickをオーバーライド.
    	
    	// ボタンのIDごとに振り分ける.
    	switch (v.getId()){	// v.getIdごとに振り分ける.
    	
    		// button2の時.
    		case R.id.button2:
    			
    			// R.id.button2ブロック
    			{
    				
    				// データを付加して元のアクティビティに戻る.
    				//Intent data = new Intent();	// dataというIntentを作成.
    				//data.putExtra("message", "ABCDE");	// data.putExtraで, キーを"message", 値を"ABCDE"として書き込み.
    				//setResult(RESULT_OK, data);	// リザルトコードをRESULT_OK, 返すデータインテントをdataとしてsetResultでセット.
    				setResult(RESULT_CANCELED, null);	// RESULT_CANCELED.
    				finish();	// finishでこのアクティビティは終了し, 前のアクティビティに戻る.
    				
    			}
    			
    	}
    	
    }
    
}
