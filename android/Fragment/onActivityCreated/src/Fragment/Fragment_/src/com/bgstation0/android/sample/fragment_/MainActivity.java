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

//���C���A�N�e�B�r�e�B
public class MainActivity extends Activity implements OnClickListener{

	// �����o�t�B�[���h�̒�`.
	public String mStr = "";	// mStr��""�ŏ�����.
	
	// ������
	@Override
	protected void onCreate(Bundle savedInstanceState) {
 	
		// �����̍ŏ��̏��.
		mStr = "AAA";	// mStr��"AAA"���Z�b�g.
		
		// ����̏���.
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
     
		// Button1�̏���.
		Button button1 = (Button)findViewById(R.id.button1);	// button1���擾.
		button1.setOnClickListener(this);	// ���X�i�[�Ƃ���this���Z�b�g.
     
		// �����̍Ō�̏��.
		mStr = "BBB";	// mStr��"BBB"���Z�b�g.
				
	}
 
	// �N���b�N��
	public void onClick(View v){

	}
 
}