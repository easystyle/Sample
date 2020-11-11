package com.bgstation0.android.sample.fragment_;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

// �t���O�����g2
public class Fragment2 extends Fragment {

	// �����o�t�B�[���h
	static final String TAG = "Fragment2";	// TAG��"Fragment2"�ŏ�����.
	private CustomListener mCustomListener = null;	// mCustomListener��null�ŏ�����.
	
	// �R���X�g���N�^
	public Fragment2(){
		
	}
	
	// �t�@�N�g�����\�b�h
	public static Fragment2 newInstance(){
		
		// Fragment2�I�u�W�F�N�g�̐���.
		Fragment2 fragment2 = new Fragment2();	// fragment2�𐶐�.
		return fragment2;	// fragment2��Ԃ�.
		
	}
	
	// �A�^�b�`��
	@Override
	public void onAttach(Activity activity){
		
		// ����̏���.
		super.onAttach(activity);
		mCustomListener = (CustomListener)activity;	// activity��mCustomListener�ɓn��.
		
	}
	
	// �r���[������
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
	
		// ����̏���.
		super.onCreateView(inflater, container, savedInstanceState);
		
		// view��Ԃ�.
		View view = inflater.inflate(R.layout.fragment2_main, null);	// view���쐬.
		Button button = (Button)view.findViewById(R.id.fragment2_button);	// button���擾.
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// ���X�i�[�����s.
				mCustomListener.onButtonClicked(2);	// 2��n��.
			}
			
		});
		
		return view;	// view��Ԃ�.
		
	}
	
}