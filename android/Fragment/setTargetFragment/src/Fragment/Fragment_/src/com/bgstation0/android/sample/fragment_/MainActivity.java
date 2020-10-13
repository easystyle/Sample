package com.bgstation0.android.sample.fragment_;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

//メインアクティビティ
public class MainActivity extends Activity {

    // メンバフィールド
    static final String TAG = "MainActivity";	// TAGを"MainActivity"で初期化.
    
    // 生成時.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
    	// 既定の処理
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // nullならFragment追加.
        if (savedInstanceState == null){
        
        	// Fragmentの追加.
        	FragmentManager fragmentManager = getFragmentManager();	// fragmentManagerの取得.
        	FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();	// fragmentTransactionの開始.
        	Fragment1 fragment1 = Fragment1.newInstance();	// fragment1を生成.
        	fragmentTransaction.add(R.id.framelayout1, fragment1);	// fragment1を追加.
        	fragmentTransaction.commit();	// 確定.
            
        }
        
    }
    
}