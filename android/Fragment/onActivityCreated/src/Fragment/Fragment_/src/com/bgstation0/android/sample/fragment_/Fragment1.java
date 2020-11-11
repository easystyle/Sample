package com.bgstation0.android.sample.fragment_;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

//�t���O�����g1
public class Fragment1 extends Fragment {

	// �����o�t�B�[���h
	static final String TAG = "Fragment1";	// TAG��"Fragment1"�ŏ�����.
	
	// �R���X�g���N�^
	public Fragment1(){
		
	}
	
	// �t���O�����g������
	@Override
	public void onCreate(Bundle savedInstanceState){
		
		// ����̏���.
		super.onCreate(savedInstanceState);	// �e�N���X��onCreate���Ă�.
		
		// ���O���c��.
		Log.d(TAG, "Fragment1.onCreate");	// "Fragment1.onCreate"�ƃ��O�Ɏc��.
		
	}
	
	// �t���O�����g�j����
	@Override
	public void onDestroy(){
		
		// ���O���c��.
		Log.d(TAG, "Fragment1.onDestroy");	// "Fragment1.onDestroy"�ƃ��O�Ɏc��.
		
		// ����̏���.
		super.onDestroy();	// �e�N���X��onDestroy���Ă�.
		
	}
	
	// �r���[������
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		
		// ���O���c��.
		Log.d(TAG, "Fragment1.onCreateView");	// "Fragment1.onCreateView"�ƃ��O�Ɏc��.
		
		// ����̏���.
		super.onCreateView(inflater, container, savedInstanceState);
		
		// MainActivity��EditText�̓��e���擾.
		MainActivity mainActivity = (MainActivity)getActivity();	// mainActivity���擾.
		EditText activityEdittext1 = (EditText)mainActivity.findViewById(R.id.activityedittext1);	// activityEdittext1���擾.
		if (activityEdittext1 == null){
			Log.d(TAG, "activityEdittext1 == null");
		}
		else{
			Log.d(TAG, "activityEdittext1 = " + activityEdittext1.getText().toString());	// activityEdittext1�����O�o��.
		}
		Log.d(TAG, "mainActivity.mStr = " + mainActivity.mStr);	// mainActivity.mStr���o��.
		
		// Fragment1��EditText���擾.
		View view = inflater.inflate(R.layout.fragment1_main, null);	// inflater.inflate��R.layout.fragment1_main����r���[���쐬.
		EditText fragmentEdittext1 = (EditText)view.findViewById(R.id.fragmentedittext1);	// fragmentEdittext1���擾.
		if (fragmentEdittext1 == null){
			Log.d(TAG, "fragmentEdittext1 == null");
		}
		else{
			Log.d(TAG, "fragmentEdittext1 = " + fragmentEdittext1.getText().toString());	// fragmentEdittext1�����O�o��.
		}
		return view;	// view��Ԃ�.
		
	}
	
	// �A�N�e�B�r�e�B����������
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		
		// ���O���c��.
		Log.d(TAG, "Fragment1.onActivityCreated");	// "Fragment1.onActivityCreated"�ƃ��O�Ɏc��.
				
		// ����̏���.
		super.onActivityCreated(savedInstanceState);
		
		// MainActivity��EditText�̓��e���擾.
		MainActivity mainActivity = (MainActivity)getActivity();	// mainActivity���擾.
		EditText activityEdittext1 = (EditText)mainActivity.findViewById(R.id.activityedittext1);	// activityEdittext1���擾.
		if (activityEdittext1 == null){
			Log.d(TAG, "activityEdittext1 == null");
		}
		else{
			Log.d(TAG, "onActivityCreated#activityEdittext1 = " + activityEdittext1.getText().toString());	// activityEdittext1�����O�o��.
		}
		Log.d(TAG, "mainActivity.mStr = " + mainActivity.mStr);	// mainActivity.mStr���o��.
		
	}
	
}