package com.bgstation0.android.sample.arrayadapter_;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // ArrayAdapterの生成.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);	// 既定のandroid.R.layout.simple_spinner_itemでアダプタ作成.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);	// ドロップダウンリスト表示時のビューは既定のandroid.R.layout.simple_spinner_dropdown_itemをセット.
        // アイテムの追加.
        adapter.add("Item1");	// Item1を追加.
        adapter.add("Item2");	// Item2を追加.
        adapter.add("Item3"); 	// Item3を追加.
        // スピナーにアダプタをセット.
        Spinner spinner = (Spinner)findViewById(R.id.spinner);	// spinnerを取得.
        spinner.setAdapter(adapter);	// adapterをセット.
        
    }
    
}
