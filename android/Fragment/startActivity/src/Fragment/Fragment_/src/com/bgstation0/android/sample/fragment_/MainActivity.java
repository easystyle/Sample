package com.bgstation0.android.sample.fragment_;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        if (savedInstanceState == null){
        	
            // �t���O�����g�̒ǉ�.
            FragmentManager fragmentManager = getFragmentManager();	// fragmentManager�̎擾.
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();	// fragmentTransaction�̎擾.
            Fragment1 fragment1 = new Fragment1();	// fragment1�̐���.
            fragmentTransaction.add(R.id.framelayout1, fragment1);	// fragment1��ǉ�.
            fragmentTransaction.commit();	// �m��.
            
        }
        
    }
    
}
