package com.bgstation0.android.sample.viewgroup_;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class SubActivity extends Activity {

	// Activityが作成された時.
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        
        // "onCreate"とtagの表示.
        Intent intent = getIntent();	// intentを取得.
        String tag = intent.getStringExtra("tag");	// "tag"の値を取得.
        TextView tv = (TextView)findViewById(R.id.textview1);	// tvを取得.
        tv.setText(tag);	// tagをセット.
        //Toast.makeText(this, "onCreate(" + tag + ")", Toast.LENGTH_LONG).show();	// Toastで"onCreate"とtagを表示.
        
        // WebViewのロード.
        WebView webView = (WebView)findViewById(R.id.webview);	// webViewを取得.
        webView.setWebViewClient(new WebViewClient(){
        	// ロードするURLが変わった時.
        	@Override
        	public boolean shouldOverrideUrlLoading(WebView view, String url){
        		
        		// falseを返すと, 必ずこのWebViewで処理するようになる.
        		return false;	// falseを返す.
        		
        	}
        });
        if (tag.equals("test1")){	// "test1"なら.
        	webView.loadUrl("https://m.yahoo.co.jp/");	// webView.loadUrlで"https://m.yahoo.co.jp/"ロード.
        }
        else{	// "test2"なら.
        	webView.loadUrl("https://www.google.co.jp/");	// webView.loadUrlで"https://www.google.co.jp/"ロード.
        }
        
	}
	
	// Activityが開始されたとき.
	@Override
    protected void onStart(){
    	super.onStart();
    	
    	// "onStart"とtagの表示.
        Intent intent = getIntent();	// intentを取得.
        String tag = intent.getStringExtra("tag");	// "tag"の値を取得.
        //Toast.makeText(this, "onStart(" + tag + ")", Toast.LENGTH_LONG).show();	// Toastで"onStart"とtagを表示.
        
    }
	
	// Activityが破棄されたとき.
	@Override
    protected void onDestroy() {	// onDestroyの定義
    	
    	// 親クラスの処理
    	super.onDestroy();	// super.onDestroyで親クラスの既定処理.
    	
    	// "onDestroy"の表示.
        //Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show();	// Toastで"onDestroy"を表示.
        
    }
    
    @Override
    protected void onNewIntent(Intent intent){
    	super.onNewIntent(intent);
    	
    	// "onNewIntent"とtagの表示.
        String tag = intent.getStringExtra("tag");	// "tag"の値を取得.
        //Toast.makeText(this, "onNewIntent(" + tag + ")", Toast.LENGTH_LONG).show();	// Toastで"onNewIntent"とtagを表示.
        
    }
	
}