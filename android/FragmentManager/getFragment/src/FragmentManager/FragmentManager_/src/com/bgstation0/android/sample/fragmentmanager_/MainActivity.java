package com.bgstation0.android.sample.fragmentmanager_;

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
import android.widget.Toast;

//���C���A�N�e�B�r�e�B
public class MainActivity extends Activity implements OnClickListener{

	// �����o�t�B�[���h.
	Fragment mCurrentFragment = null;	// mCurrentFragment��null�ŏ�����.
	
	// ������
    @Override
    protected void onCreate(Bundle savedInstanceState) {
 	
 	    // ����̏���.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     
        // Button1�̏���.
        Button button1 = (Button)findViewById(R.id.button1);	// button1���擾.
        button1.setOnClickListener(this);	// ���X�i�[�Ƃ���this���Z�b�g.
        
        // savedInstanceState�̃`�F�b�N.
        if (savedInstanceState == null){	// null�̎�.
        	
        	// FragmentManager, fragmentTransaction�̎擾.
        	FragmentManager fragmentManager = getFragmentManager();	// fragmentManager�̎擾.
        	FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();	// fragmentTransaction�̎擾.
        	Fragment1 fragment1 = new Fragment1();	// fragment1�𐶐�.
        	fragmentTransaction.add(R.id.framelayout1, fragment1);	// fragment1��ǉ�.
        	fragmentTransaction.commit();	// �R�~�b�g.
        	mCurrentFragment = fragment1;	// mCurrentFragment��fragment1���Z�b�g.
        	
        }
        
        // mCurrentFragment�̃`�F�b�N.
        if (mCurrentFragment == null){
        	Log.d("MainActivity", "onCreate:mCurrentFragment == null");
        }
        else{
        	Log.d("MainActivity", "onCreate:mCurrentFragment = " + mCurrentFragment.toString());
        }
     
    }
    
    // �N���b�N��
    public void onClick(View v){
 	
        // FragmentManager, fragmentTransaction�̎擾.
    	//FragmentManager fragmentManager = getFragmentManager();	// fragmentManager�̎擾.
    	//FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();	// fragmentTransaction�̎擾.
    	//Fragment1 fragment1 = new Fragment1();	// fragment1�𐶐�.
    	//fragmentTransaction.add(R.id.framelayout1, fragment1);	// fragment1��ǉ�.
    	//fragmentTransaction.commit();	// �R�~�b�g.
    	//mCurrentFragment = fragment1;	// mCurrentFragment��fragment1���Z�b�g.
    	//Log.d("MainActivity", "onClick:mCurrentFragment = " + mCurrentFragment.toString());
    	
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState){
    	super.onSaveInstanceState(outState);
    	Log.d("MainActivity", "onSaveInstanceState:mCurrentFragment = " + mCurrentFragment.toString());
    	getFragmentManager().putFragment(outState, "savedFragment", mCurrentFragment);	// �ۑ�.
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
    	super.onRestoreInstanceState(savedInstanceState);
    	mCurrentFragment = getFragmentManager().getFragment(savedInstanceState, "savedFragment");	// ����.
    	Log.d("MainActivity", "onRestoreInstanceState:mCurrentFragment = " + mCurrentFragment.toString());
    }
    
}