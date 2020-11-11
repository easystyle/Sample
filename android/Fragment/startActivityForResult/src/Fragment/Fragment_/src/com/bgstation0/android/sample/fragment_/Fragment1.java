package com.bgstation0.android.sample.fragment_;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment1 extends Fragment implements View.OnClickListener{

    // �����o�t�B�[���h
    static final String TAG = "Fragment1";	// TAG��"Fragment1"�ŏ�����.
	
    // �r���[������
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
			
        // ���O���c��.
        Log.d(TAG, "Fragment1.onCreateView");	// "Fragment1.onCreateView"�ƃ��O�Ɏc��.
			
        // ����̏���.
        super.onCreateView(inflater, container, savedInstanceState);
		
        // Fragment1��Button���擾.
        View view = inflater.inflate(R.layout.fragment1_main, null);	// inflater.inflate��R.layout.fragment1_main����r���[���쐬.
        Button button1 = (Button)view.findViewById(R.id.fragment1_button);	// button1���擾.
        button1.setOnClickListener(this);	// this���Z�b�g.
        return view;	// view��Ԃ�.
        
    }
    
    // �N���b�N���ꂽ��.
    @Override
    public void onClick(View v) {
    	// TODO Auto-generated method stub
    	// SubActivity���N��.
    	Intent intent = new Intent(getActivity(), SubActivity.class);	// intent�𐶐�.
    	//getActivity().startActivityForResult(intent, 1);	// Activity.startActivityForResult��intent��1���w�肵�ċN��.
    	startActivityForResult(intent, 1);	// Fragment.startActivityForResult��intent��1���w�肵�ċN��.
    }
    
}