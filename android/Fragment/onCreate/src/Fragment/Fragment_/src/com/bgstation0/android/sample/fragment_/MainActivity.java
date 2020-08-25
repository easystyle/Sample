package com.bgstation0.android.sample.fragment_;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

// ���C���A�N�e�B�r�e�B
public class MainActivity extends Activity implements OnClickListener{

	// ������
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	// ����̏���.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Button1�̏���.
        Button button1 = (Button)findViewById(R.id.button1);	// button1���擾.
        button1.setOnClickListener(this);	// ���X�i�[�Ƃ���this���Z�b�g.
        
        // Button2�̏���.
        Button button2 = (Button)findViewById(R.id.button2);	// button2���擾.
        button2.setOnClickListener(this);	// ���X�i�[�Ƃ���this���Z�b�g.
        
    }
    
    // �N���b�N��
    public void onClick(View v){
    	
    	// FragmentManager, fragmentTransaction�̎擾.
    	FragmentManager fragmentManager = getFragmentManager();	// fragmentManager�̎擾.
    	FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();	// fragmentTransaction�̎擾.
    	
    	// Button���Ƃɕ�����.
    	int id = v.getId();	// v.getId��id���擾.
    	if (id == R.id.button1){	// button1�Ȃ�.
    		Fragment1 fragment1 = new Fragment1();	// fragment1�𐶐�.
    		fragmentTransaction.add(R.id.framelayout1, fragment1);	// fragment1��ǉ�.
    		fragmentTransaction.commit();	// �R�~�b�g.
    	}
    	else if (id == R.id.button2){	// button2�Ȃ�.
    		Fragment2 fragment2 = new Fragment2();	// fragment2�𐶐�.
    		fragmentTransaction.add(R.id.framelayout1, fragment2);	// fragment2��ǉ�.
    		fragmentTransaction.commit();	// �R�~�b�g.
    	}
    	
    }
    
}