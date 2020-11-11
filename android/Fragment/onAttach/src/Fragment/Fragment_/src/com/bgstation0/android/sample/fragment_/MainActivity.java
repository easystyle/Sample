package com.bgstation0.android.sample.fragment_;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

// ���C���A�N�e�B�r�e�B
public class MainActivity extends Activity implements CustomListener{

	// �����o�t�B�[���h
	static final String TAG = "MainActivity";	// TAG��"MainActivity"�ŏ�����.
	Context mContext = null;	// mContext��null�ŏ�����.
	
	// ������.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	// ����̏���.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;	// mContext��this���Z�b�g.
        
        if (savedInstanceState == null){
        	
        	// Fragment�̒ǉ�.
        	FragmentManager fragmentManager = getFragmentManager();	// fragmentManager�̎擾.
        	FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();	// fragmentTransaction�̊J�n.
        	Fragment1 fragment1 = Fragment1.newInstance();	// fragment1�𐶐�.
        	fragmentTransaction.replace(R.id.framelayout1, fragment1);	// fragment1�ɒu��.
        	fragmentTransaction.commit();	// �m��.
        
        }
        
    }
    
    @Override
	public void onButtonClicked(int no){
		//Toast.makeText(mContext, TAG + " Callback", Toast.LENGTH_LONG).show();	// Toast�\��.
    	if (no == 1){	// 1�̎�.
    		// Fragment2�ɒu��.
    		FragmentManager fragmentManager = getFragmentManager();	// fragmentManager�̎擾.
        	FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();	// fragmentTransaction�̊J�n.
        	Fragment2 fragment2 = Fragment2.newInstance();	// fragment2�𐶐�.
        	fragmentTransaction.replace(R.id.framelayout1, fragment2);	// fragment2�ɒu��.
        	fragmentTransaction.commit();	// �m��.    		
    	}
    	else if (no == 2){	// 2�̎�.
    		// Fragment1�ɒu��.
    		FragmentManager fragmentManager = getFragmentManager();	// fragmentManager�̎擾.
        	FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();	// fragmentTransaction�̊J�n.
        	Fragment1 fragment1 = Fragment1.newInstance();	// fragment1�𐶐�.
        	fragmentTransaction.replace(R.id.framelayout1, fragment1);	// fragment1�ɒu��.
        	fragmentTransaction.commit();	// �m��.
    	}
	}
    
}