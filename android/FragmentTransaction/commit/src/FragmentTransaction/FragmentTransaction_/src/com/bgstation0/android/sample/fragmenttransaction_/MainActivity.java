package com.bgstation0.android.sample.fragmenttransaction_;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        if (savedInstanceState == null){

        	// Buttonの初期化.
            Button button1 = (Button)findViewById(R.id.button1);	// button1を取得.
            button1.setOnClickListener(new OnClickListener() {	// リスナーをセット.
    			
    			@Override
    			public void onClick(View v) {
    				// TODO Auto-generated method stub
    				FragmentManager fragmentManager = getFragmentManager();	// fragmentManagerの取得.
                    Fragment1 fragment1 = new Fragment1();	// fragment1を生成.
    		        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();	// fragmentTransactionの取得.
    		        fragmentTransaction.add(R.id.framelayout1, fragment1, "fragment1");	// fragment1をadd.
    		        // この時点ではcommitしない.
    		        Log.d("MainActivity", "Fragment1");
    			}
    			
    		});
            Button button2 = (Button)findViewById(R.id.button2);
            button2.setOnClickListener(new OnClickListener() {	// リスナーをセット.
    			
    			@Override
    			public void onClick(View v) {
    				// TODO Auto-generated method stub
    				FragmentManager fragmentManager = getFragmentManager();	// fragmentManagerの取得.
                    Fragment2 fragment2 = new Fragment2();	// fragment2を生成.
    		        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();	// fragmentTransactionの取得.
    		        fragmentTransaction.add(R.id.framelayout1, fragment2, "fragment2");	// fragment2をadd.
    		        fragmentTransaction.commit();	// この時点でcommitする.
    		        Log.d("MainActivity", "Fragment2");
    			}
    			
    		});
            
        }
        
    }
}