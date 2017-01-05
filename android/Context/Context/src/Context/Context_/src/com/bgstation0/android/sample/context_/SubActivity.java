package com.bgstation0.android.sample.context_;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends Activity {

	// Activityが生成されたとき.
	@Override
	protected void onCreate(Bundle savedInstanceState) {	// onCreateの定義
		super.onCreate(savedInstanceState);
			
		// "SubActivity!"の表示.
		TextView tv = new TextView(this);	// TextViewオブジェクトtvの生成.
		tv.setText("SubActivity!");	// tv.setTextで"SubActivity!"のセット.
		setContentView(tv);	// setContentViewでtvを表示.
		
		// Toastでthisの内容を文字列にしたものを表示.
		Toast.makeText(this, this.toString(), Toast.LENGTH_LONG).show();
		
	}
		
}