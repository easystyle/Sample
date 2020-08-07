package com.bgstation0.android.sample.view.basesavedstate_;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

//メインアクティビティ
public class MainActivity extends Activity implements OnClickListener{

	// アクティビティ生成時
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
    	// 既定の処理.
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // button1の初期化
        Button button1 = (Button)findViewById(R.id.button1);	// button1を取得.
        button1.setOnClickListener(this);	// thisをセット.
        
    }
    
    // クリックされた時.
 	@Override
 	public void onClick(View v) {
 		
 		// TODO Auto-generated method stub
 		// CustomViewに文字列をセット.
 		CustomView customView1 = (CustomView)findViewById(R.id.customview1);	// customView1を取得.
 		customView1.mStr1 = "ABCDE";	// mStr1に"ABCDE"をセット.
 		customView1.mStr2 = "FGHIJ";	// mStr2に"FGHIJ"をセット.
 		customView1.mStr3 = "KLMNO";	// mStr3に"KLMNO"をセット.
 		customView1.invalidate();	// customView1.invalidateで再描画.
 		
 	}
    
}