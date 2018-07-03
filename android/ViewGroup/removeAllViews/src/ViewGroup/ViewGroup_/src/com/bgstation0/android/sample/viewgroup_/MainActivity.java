package com.bgstation0.android.sample.viewgroup_;

import android.app.Activity;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends ActivityGroup {

	// メンバフィールドの定義.
	LocalActivityManager lam = null;
	FrameLayout mFrameMain = null;
	ViewGroup mVGFrameMain = null;
	LinearLayout mLinearSub1 = null;
	LinearLayout mLinearSub2 = null;
	View mDecorView1 = null;
	View mDecorView2 = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // LocalActivityManagerの取得.
        lam = getLocalActivityManager();	// lamの取得.
        
        // MainActivityの挿入するビューを取得.
        View mainDecorView = getWindow().getDecorView();	// MainActivityのDecorView取得.
        ViewGroup vgDecorView = (ViewGroup)mainDecorView;	// vgDecorViewにキャスト.
        View linear = vgDecorView.getChildAt(0);	// 0番目をlinearに.
        ViewGroup vgLinear = (ViewGroup)linear;	// vgLinearにキャスト.
        if (vgLinear == null){
        	Log.d("ViewGroup", "0");
        	Toast.makeText(this, "0", Toast.LENGTH_LONG).show();
        	return;
        }
        // 必ずしも1番目がFrameLayoutとは限らない.
        String s = vgLinear.getChildAt(0).getClass().getName();
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        View mainContentView;
        if (s.equals("android.widget.FrameLayout")){
        	Toast.makeText(this, "A", Toast.LENGTH_LONG).show();
        	mainContentView = vgLinear.getChildAt(0);	// 0番目はmainContentView.
        }
        else{
        	Toast.makeText(this, "B", Toast.LENGTH_LONG).show();
        	mainContentView = vgLinear.getChildAt(1);	// 1番目はmainContentView.
        }
        if (mainContentView == null){
        	Log.d("ViewGroup", "1");
        	Toast.makeText(this, "1", Toast.LENGTH_LONG).show();
        	return;
        }
        ViewGroup vgMainContentView = (ViewGroup)mainContentView;	// vgMainContentViewにキャスト.
        if (vgMainContentView == null){
        	Log.d("ViewGroup", "2");
        	Toast.makeText(this, "2", Toast.LENGTH_LONG).show();
        	return;
        }
        
        int c = vgMainContentView.getChildCount();
        
        Toast.makeText(this, "c = " + c, Toast.LENGTH_LONG).show();
        for (int i = 0; i < vgMainContentView.getChildCount(); i++){
        	Toast.makeText(this, vgMainContentView.getChildAt(i).toString(), Toast.LENGTH_LONG).show();
        }
        //return;
        mFrameMain = (FrameLayout)vgMainContentView.getChildAt(0);	// 0番目はframe_main.
        if (mFrameMain == null){
        	Log.d("ViewGroup", "3");
        	Toast.makeText(this, "3", Toast.LENGTH_LONG).show();
        	return;
        }
        mVGFrameMain = mFrameMain;	// mVGFrameMainにキャスト.
        if (mVGFrameMain == null){
        	Log.d("ViewGroup", "4");
        	Toast.makeText(this, "4", Toast.LENGTH_LONG).show();
        	return;
        }
        Log.d("ViewGroup", "5");
        Toast.makeText(this, "5", Toast.LENGTH_LONG).show();
        
        // SubActivityのIntent作成.
        Intent intent1 = new Intent(this, SubActivity.class);	// intent1作成.
        intent1.putExtra("tag", "test1");	// キーに"tag", 値に"test1".
        // Windowの取得.
        Window window1 = lam.startActivity("test1", intent1);	// intent1を渡して, window1の取得.
        mDecorView1 = window1.getDecorView();	// window1.getDecorViewでmDecorView1を取得.
        //Toast.makeText(this, "decorView1 = " + decorView1.toString(), Toast.LENGTH_LONG).show();	// decorView1を出力.
        ViewGroup vg1 = (ViewGroup)mDecorView1;	// ViewGroupのvg1にキャスト.
        //Toast.makeText(this, "vg1.getChildCount() = " + vg1.getChildCount(), Toast.LENGTH_LONG).show();	// vg1.getChildCountを出力.
        View childView1 = vg1.getChildAt(0);	// vg1.getChildAt(0)で子ビューを取得.
        //Toast.makeText(this, "childView1.toString() = " + childView1.toString(), Toast.LENGTH_LONG).show();	// childView1.toString()を出力.
        ViewGroup vgChild1 = (ViewGroup)childView1;	// ViewGroupのvgChild1にキャスト.
        //Toast.makeText(this, "vgChild1.getChildCount() = " + vgChild1.getChildCount(), Toast.LENGTH_LONG).show();	// vgChild1.getChildCount()を出力.
        View contentView1 = null;	// contentView1をnullで初期化.    
        ViewGroup vgContentView1 = null;	// vgContentView1をnullで初期化.
        for (int i = 0; i < vgChild1.getChildCount(); i++){	// vgChild1.getChildCount分繰り返す.
        	Toast.makeText(this, vgChild1.getChildAt(i).toString(), Toast.LENGTH_LONG).show();	// vgChild1.getChildAt(i)を出力.
        	if (vgChild1.getChildAt(i).getId() == android.R.id.content){
        		Toast.makeText(this, "android.R.id.content", Toast.LENGTH_LONG).show();	// "android.R.id.content"と出力.
        		contentView1 = vgChild1.getChildAt(i);	// contentView1に格納.
        		vgContentView1 = (ViewGroup)contentView1;	// vgOntentView1にキャスト.
        		if (vgContentView1.getChildAt(0).getId() == R.id.linear_sub){
        			Toast.makeText(this, "R.id.linear_sub", Toast.LENGTH_LONG).show();	// "R.id.linear_sub"と出力.
        			mLinearSub1 = (LinearLayout)vgContentView1.getChildAt(0);	// mLinearSubに格納.
        		}
        	}
        }
        
        // SubActivityのIntent作成.
        Intent intent2 = new Intent(this, SubActivity.class);	// intent2作成.
        intent2.putExtra("tag", "test2");	// キーに"tag", 値に"test2".
        // Windowの取得.
        Window window2 = lam.startActivity("test2", intent2);	// intent2を渡して, window2の取得.
        mDecorView2 = window2.getDecorView();	// window2.getDecorViewでmDecorView2を取得.
        //Toast.makeText(this, "decorView2 = " + decorView2.toString(), Toast.LENGTH_LONG).show();	// decorView2を出力.
        ViewGroup vg2 = (ViewGroup)mDecorView2;	// ViewGroupのvg2にキャスト.
        //Toast.makeText(this, "vg2.getChildCount() = " + vg2.getChildCount(), Toast.LENGTH_LONG).show();	// vg2.getChildCountを出力.
        View childView2 = vg2.getChildAt(0);	// vg2.getChildAt(0)で子ビューを取得.
        //Toast.makeText(this, "childView2.toString() = " + childView2.toString(), Toast.LENGTH_LONG).show();	// childView2.toString()を出力.
        ViewGroup vgChild2 = (ViewGroup)childView2;	// ViewGroupのvgChild2にキャスト.
        //Toast.makeText(this, "vgChild2.getChildCount() = " + vgChild2.getChildCount(), Toast.LENGTH_LONG).show();	// vgChild2.getChildCount()を出力.
        View contentView2 = null;	// contentView2をnullで初期化.    
        ViewGroup vgContentView2 = null;	// vgContentView2をnullで初期化.
        for (int i = 0; i < vgChild2.getChildCount(); i++){	// vgChild2.getChildCount分繰り返す.
        	Toast.makeText(this, vgChild2.getChildAt(i).toString(), Toast.LENGTH_LONG).show();	// vgChild2.getChildAt(i)を出力.
        	if (vgChild2.getChildAt(i).getId() == android.R.id.content){
        		Toast.makeText(this, "android.R.id.content", Toast.LENGTH_LONG).show();	// "android.R.id.content"と出力.
        		contentView2 = vgChild2.getChildAt(i);	// contentView2に格納.
        		vgContentView2 = (ViewGroup)contentView2;	// vgOntentView2にキャスト.
        		if (vgContentView2.getChildAt(0).getId() == R.id.linear_sub){
        			Toast.makeText(this, "R.id.linear_sub", Toast.LENGTH_LONG).show();	// "R.id.linear_sub"と出力.
        			mLinearSub2 = (LinearLayout)vgContentView2.getChildAt(0);	// mLinearSubに格納.
        		}
        	}
        }
        
        // 1を初期表示.
        mVGFrameMain.removeAllViews();	// mVGFrameMain.removeAllViewsでいったんクリア.
        mFrameMain.addView(mDecorView1);	// 追加するときは, mDecorView1を追加.
        //mVGFrameMain.addView(mLinearSub1);	// mVGFrameMain.addViewでmLinearSub1を追加.
        
    }
    
    // メニューが作成された時.
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	
    	// メニューの作成
    	getMenuInflater().inflate(R.menu.main, menu);	// getMenuInflaterでMenuItemを取得し, そのままinflateで指定されたR.menu.mainを元にmenuを作成.
    	return true;	// trueを返す.
    	
    }
    
    // メニューが選択された時.
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    
    	// どのメニューが選択されたか.
    	switch (item.getItemId()){	// アイテムIDごとに振り分け.
    	
    		// TextView1
    		case R.id.menu_textview1:
    			
    			// TextView1ブロック
				{
					
					// 1を表示.
			        mVGFrameMain.removeAllViews();	// mVGFrameMain.removeAllViewsでいったんクリア.
			        mFrameMain.addView(mDecorView1);	// 追加するときは, mDecorView1を追加.
			        
				}
				
				break;
			
			// TextView1
    		case R.id.menu_textview2:
    			
    			// TextView2ブロック
				{
	
					// 2を表示.
			        mVGFrameMain.removeAllViews();	// mVGFrameMain.removeAllViewsでいったんクリア.
			        mFrameMain.addView(mDecorView2);	// 追加するときは, mDecorView2を追加.
			        
				}
				
				break;
				
    	}
    	return super.onOptionsItemSelected(item);	// 親クラス既定処理
    	
    }
    
}