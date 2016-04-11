package com.bgstation0.android.sample.activity_;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{	// View.OnClickListener������.

	// �^�O�̒�`
	private final String TAG = "MainActivity";	// TAG��"MainActivity"
	
	// Activity���������ꂽ�Ƃ�.
    @Override
    protected void onCreate(Bundle savedInstanceState) {	// onCreate�̒�`
        
    	// �e�N���X�̏�����, activity_main�̕\��.
    	super.onCreate(savedInstanceState);	// super.onCreate�Őe�N���X�̊��菈��.
        setContentView(R.layout.activity_main);	// setContentView��R.layout.activity_main��\��.

        // button1���擾��, OnClickListener�Ƃ��Ď��g���Z�b�g.
        Button button1 = (Button)findViewById(R.id.button1);	// findViewById��R.id.button1���擾.
        button1.setOnClickListener(this);	// button1.setOnClickListener��this(���g)���Z�b�g.
        
        // onCreate�̃��O��\��.
        Log.v(TAG, "onCreate()");	// Log.v��"onCreate()"�Əo��.       
    }
    
    // View.OnClickListener�C���^�t�F�[�X�̃I�[�o�[���C�h���\�b�h������.
    public void onClick(View v){	// onClick���I�[�o�[���C�h.
    	// �{�^���������ꂽ��DialogActivity���N��.
    	Intent intent = new Intent(this, DialogActivity.class);	// DialogActivity��ΏۂƂ���Intent�I�u�W�F�N�gintent�𐶐�.
    	startActivity(intent);	// startActivity��intent���w�肵��Activity���N��.    	
    }
    
    // Activity���J�n���ꂽ�Ƃ�.
    protected void onStart() {	// onStart�̒�`
    	
    	// �e�N���X�̏���
    	super.onStart();	// super.onStart�Őe�N���X�̊��菈��.
    	
    	// onStart�̃��O��\��.
    	Log.v(TAG, "onStart()");	// Log.v��"onStart()"�Əo��.
    }
    
    // Activity���ĊJ�����Ƃ�.
    protected void onRestart() {	// onRestart�̒�`
    	
    	// �e�N���X�̏���
    	super.onRestart();	// super.onRestart�Őe�N���X�̊��菈��.
    	
    	// onRestart�̃��O��\��.
    	Log.v(TAG, "onRestart()");	// Log.v��"onRestart()"�Əo��.
    }
    
    // Activity���\�������Ƃ�.
    protected void onResume() {	// onResume�̒�`
    	
    	// �e�N���X�̏���
    	super.onResume();	// super.onResume�Őe�N���X�̊��菈��.
    	
    	// onResume�̃��O��\��.
    	Log.v(TAG, "onResume()");	// Log.v��"onResume()"�Əo��.
    }
    
    // Activity���ꎞ��~���ꂽ�Ƃ�.
    protected void onPause() {	// onPause�̒�`
    	
    	// �e�N���X�̏���
    	super.onPause();	// super.onPause�Őe�N���X�̊��菈��.
    	
    	// onPause�̃��O��\��.
    	Log.v(TAG, "onPause()");	// Log.v��"onPause()"�Əo��.
    }
    
    // Activity����~���ꂽ�Ƃ�.
    protected void onStop() {	// onStop�̒�`
    	
    	// �e�N���X�̏���
    	super.onStop();	// super.onStop�Őe�N���X�̊��菈��.
    	
    	// onStop�̃��O��\��.
    	Log.v(TAG, "onStop()");	// Log.v��"onStop()"�Əo��.
    }
    
    // Activity���j�����ꂽ�Ƃ�.
    protected void onDestroy() {	// onDestroy�̒�`
    	
    	// �e�N���X�̏���
    	super.onDestroy();	// super.onDestroy�Őe�N���X�̊��菈��.
    	
    	// onDestroy�̃��O��\��.
    	Log.v(TAG, "onDesroy()");	// Log.v��"onDestroy()"�Əo��.
    }
}