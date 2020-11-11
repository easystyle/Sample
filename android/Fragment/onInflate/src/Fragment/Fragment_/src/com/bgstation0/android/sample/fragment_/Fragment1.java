package com.bgstation0.android.sample.fragment_;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//�t���O�����g1
public class Fragment1 extends Fragment {

	// �����o�t�B�[���h
	static final String TAG = "Fragment1";	// TAG��"Fragment1"�ŏ�����.
	String mCustomData = "";	// mCustomData��""�ŏ�����.
	
	// �R���X�g���N�^
	public Fragment1(){
		
	}
	
	// ���C�A�E�gXML���擾��
	@Override
	public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState){
		
		// ����̏���.
		super.onInflate(activity, attrs, savedInstanceState);	// �e�N���X��onInflate���Ă�.
		
		// ���O���c��.
		Log.d(TAG, "Fragment1.onInflate");	// "Fragment1.onInflate"�ƃ��O�Ɏc��.
		
		// �����̎擾.
		Resources res = activity.getResources();	// res�̎擾.
		TypedArray a = res.obtainAttributes(attrs, R.styleable.Fragment1);	// a�̎擾.
		mCustomData = a.getString(R.styleable.Fragment1_custom_data);	// mCustomData�̎擾.
		
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
		
		// view�𐶐���, �Ԃ�..
		View view = inflater.inflate(R.layout.fragment1_main, null);	// inflater.inflate��R.layout.fragment1_main����r���[���쐬.
		return view;	// view��Ԃ�.
		
	}
	
	// �r���[����������.
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState){
	
		// ���O���c��.
		Log.d(TAG, "Fragment1.onViewCreated");	// "Fragment1.onViewCreated"�ƃ��O�Ɏc��.
				
		// ����̏���.
		super.onViewCreated(view, savedInstanceState);
	
		// mCustomData�̃Z�b�g.
		TextView textview1 = (TextView)view.findViewById(R.id.fragment1_textview);	// textview1�̎擾.
		textview1.setText(mCustomData);	// textview1.setText��mCustomData���Z�b�g.
		
	}
	
	// �A�N�e�B�r�e�B����������
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		
		// ���O���c��.
		Log.d(TAG, "Fragment1.onActivityCreated");	// "Fragment1.onActivityCreated"�ƃ��O�Ɏc��.
				
		// ����̏���.
		super.onActivityCreated(savedInstanceState);
		
	}
	
}