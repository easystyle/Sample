package com.bgstation0.android.sample.fragment_;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// �t���O�����g1
public class Fragment2 extends Fragment {

	// �����o�t�B�[���h
	static final String TAG = "Fragment2";	// TAG��"Fragment2"�ŏ�����.
	
	// �R���X�g���N�^
	public Fragment2(){
		
	}
	
	// �t���O�����g������
	@Override
	public void onCreate(Bundle savedInstanceState){
		
		// ����̏���.
		super.onCreate(savedInstanceState);	// �e�N���X��onCreate���Ă�.
		
		// ���O���c��.
		Log.d(TAG, "Fragment2.onCreate");	// "Fragment2.onCreate"�ƃ��O�Ɏc��.
		
	}
	
	// �t���O�����g�j����
	@Override
	public void onDestroy(){
			
		// ���O���c��.
		Log.d(TAG, "Fragment2.onDestroy");	// "Fragment2.onDestroy"�ƃ��O�Ɏc��.
		
		// ����̏���.
		super.onDestroy();	// �e�N���X��onDestroy���Ă�.
				
	}
	
	// �r���[������
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		
		// ���O���c��.
		Log.d(TAG, "Fragment2.onCreateView");	// "Fragment2.onCreateView"�ƃ��O�Ɏc��.
				
		// ����̏���.
		return inflater.inflate(R.layout.fragment2_main, null);	// inflater.inflate��R.layout.fragment2_main����r���[���쐬��, ���̂܂ܕԂ�.
		
	}
	
}