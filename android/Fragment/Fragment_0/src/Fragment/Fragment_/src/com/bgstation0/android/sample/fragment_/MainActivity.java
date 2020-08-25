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
        
        // savedInstanceState��null�Ȃ�.
        if (savedInstanceState == null){
        	
        	// �J�X�^���t���O�����g�̒ǉ�.
        	FragmentManager fragmentManager = getFragmentManager();	// fragmentManager�̎擾.
        	FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();	// fragmentTransaction�̎擾.
        	CustomFragment customFragment = new CustomFragment();	// custmFragment�𐶐�.
        	fragmentTransaction.replace(R.id.framelayout1, customFragment);	// ���v���[�X.
        	fragmentTransaction.commit();	// �R�~�b�g.
        
        }
        
    }
}