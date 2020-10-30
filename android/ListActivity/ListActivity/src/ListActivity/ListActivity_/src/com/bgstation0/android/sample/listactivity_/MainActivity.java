package com.bgstation0.android.sample.listactivity_;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

// ListActivtyを継承したMainActivity.
public class MainActivity extends ListActivity {

	// メンバフィールド.
	private String[] mNames = {"Taro", "Jiro", "Saburo", "Shiro", "Goro"};	// mNamesの初期化.
	
	// 生成時.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	// 既定の処理.
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);	// コンテンツビューのセットも不要.
    	
    	// ArrayAdapterの生成.
    	ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mNames);	// アイテムのレイアウトは既定のandroid.R.layout.simple_list_item_1を使う.
    	
    	// アダプタのセット.
    	setListAdapter(arrayAdapter);	// setListAdapterでarrayAdapterをセット.
    	
    }
    
}