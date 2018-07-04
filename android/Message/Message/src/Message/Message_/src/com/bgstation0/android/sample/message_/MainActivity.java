package com.bgstation0.android.sample.message_;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{	// View.OnClickListener������.

	// �����o�t�B�[���h�̒�`.
	private final String TAG = "Message_";	// TAG"Message_"�̒�`.
	private Handler mHandler;	// Handler�I�u�W�F�N�gmHandler.
	private Context mContext = null;	// Context�^mContext��null�ŏ�����.
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // �R���e�L�X�g������.
        mContext = this;	// mContext��this���Z�b�g.
        
        // button1���擾��, OnClickListener�Ƃ��Ď��g���Z�b�g.
        Button button1 = (Button)findViewById(R.id.button1);	// findViewById��R.id.button1���擾.
        button1.setOnClickListener(this);	// button1.setOnClickListener��this(���g)���Z�b�g.
        
    }
    
    // View.OnClickListener�C���^�t�F�[�X�̃I�[�o�[���C�h���\�b�h������.
    public void onClick(View v){	// onClick���I�[�o�[���C�h.
    
    	// �n���h���[�̏���.
    	mHandler = new Handler(){	// Handler�I�u�W�F�N�ghandler�̐���.
    		
    		// ���b�Z�[�W���������̏���.
    		@Override
    		public void handleMessage(Message msg){
    
    			// ���b�Z�[�W���m�F.
    			if (msg != null){	// msg��null�łȂ�.
    				Toast.makeText(mContext, "msg.obj = " + (String)msg.obj, Toast.LENGTH_LONG).show();	// msg.obj��\��.
    			}
    			
    			// ���b�Z�[�W��������, "Pushed!".
    			Button button1 = (Button)findViewById(R.id.button1);	// findViewById��R.id.button1���擾.
	    		button1.setText("Pushed!");	// button1.setText��"Pushed!"�ɕύX.
	    		
    		}
    		
    	};
    	
    	// �X���b�h�̍쐬�Ǝ��s.
    	CustomThread customThread = new CustomThread(mHandler);	// �R���X�g���N�^��mHandler��n����, customThread���쐬.
    	customThread.start();	// customThread.start()�Ŏ��s.
    		
    }
    
}