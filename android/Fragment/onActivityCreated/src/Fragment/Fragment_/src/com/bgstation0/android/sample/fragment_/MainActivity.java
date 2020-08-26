package com.bgstation0.android.sample.fragment_;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

//メインアクティビティ
public class MainActivity extends Activity implements OnClickListener{

	// メンバフィールドの定義.
	public String mStr = "";	// mStrを""で初期化.
	
	// 生成時
	@Override
	protected void onCreate(Bundle savedInstanceState) {
 	
		// 生成の最初の状態.
		mStr = "AAA";	// mStrに"AAA"をセット.
		
		// 既定の処理.
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
     
		// Button1の処理.
		Button button1 = (Button)findViewById(R.id.button1);	// button1を取得.
		button1.setOnClickListener(this);	// リスナーとしてthisをセット.
     
		// 生成の最後の状態.
		mStr = "BBB";	// mStrに"BBB"をセット.
				
	}
 
	// クリック時
	public void onClick(View v){

	}
 
}