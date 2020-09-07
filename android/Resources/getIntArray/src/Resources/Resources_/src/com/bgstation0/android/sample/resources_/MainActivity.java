package com.bgstation0.android.sample.resources_;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

//メインアクティビティクラスMainActivityの定義.
public class MainActivity extends Activity {

    // メンバフィールドの定義
    static final String TAG = "MainActivity";	// TAGを"MainActivity"で初期化.

    // アクティビティ生成時
    @Override
    protected void onCreate(Bundle savedInstanceState) {
 	
        // 既定の処理
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // リソースから整数配列の取得.
        Resources res = getResources();	// resを取得.
        int[] onetwothree = res.getIntArray(R.array.onetwothree);	// onetwothreeを取得.
        for (int i = 0; i < onetwothree.length; i++){	// 長さ分繰り返す.
        	 Log.d(TAG, "onetwothree[" + i + "] = " + onetwothree[i]);	// onetwothree[i]を出力.        	
        }
        
    }
    
}
