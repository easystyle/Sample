package com.bgstation0.android.sample.fragment_;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CustomFragment extends Fragment {

	// publicな引数なしコンストラクタ.
	public CustomFragment(){
		Log.d("testtag", "test1234");
	}
	
	// フラグメントのビュー生成時.
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
	
		// ビューの生成.
		return inflater.inflate(R.layout.customfragment_main, null);	// inflateで生成したViewを返す.
		
	}
	
}
