package com.bgstation0.android.sample.wv.wvt_;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class SubActivity extends Activity {

	// Activity���쐬���ꂽ��.
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
       
        // URL�Ȃǂ��擾.
        Intent intent = getIntent();	// intent���擾.
        Bundle bundle = intent.getExtras();	// bunfle���擾.
        String url = null;	// url��null�ŏ�����.
        if (bundle != null){	// bundle��null�łȂ�.
        	url = bundle.get("url").toString();	// url���擾.
        }
        // url���w�肳��Ă����WebView�Ń��[�h.
        WebView webView = (WebView)findViewById(R.id.webview);	// webView���擾.
        Activity mainActivity = getParent();	// LocalActivityManager�ɂ�閄�ߍ��݂̏ꍇ����������Ȃ���, getParent�ŌĂяo�����Ƃ��������ߍ��݌���mainActivity������.
        webView.setWebViewClient(new CustomWebViewClient(this, mainActivity));	// CustomWebViewClient���Z�b�g.
        webView.setWebChromeClient(new CustomWebChromeClient(this, mainActivity));	// CustomWebChromeClient���Z�b�g.
        webView.getSettings().setJavaScriptEnabled(true);	// JavaScript��L��.
        webView.getSettings().setSupportMultipleWindows(true);	// �����E�B���h�E��L��.
        if (url != null && !url.equals("")){	// url��null�łȂ�, ����, url��""�łȂ�.
        	webView.loadUrl(url);	// webView.loadUrl��url�����[�h.
        }
        
	}
	
}