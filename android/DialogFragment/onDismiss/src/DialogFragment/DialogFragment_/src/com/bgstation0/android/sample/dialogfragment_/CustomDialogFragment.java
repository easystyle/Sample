package com.bgstation0.android.sample.dialogfragment_;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class CustomDialogFragment extends DialogFragment implements View.OnClickListener{

	// メンバフィールドの定義
	CustomAsyncTask task = null;	// CustomAsyncTaskオブジェクトtaskをnullに.
	
	// ビュー生成時.
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		
		// レイアウトからビュー生成.
		View view = inflater.inflate(R.layout.fragment_custom_dialog, container);	// infalter.inflateでR.layout.fragment_custom_dialogを元にビューを作成し, viewに格納.
		Button button1 = (Button)view.findViewById(R.id.fragment1_button1);	// button1を取得.
		button1.setOnClickListener(this);	// thisをセット.
		return view;	// viewを返す.
		
	}
	
	// キャンセル時.
	@Override
	public void onCancel(DialogInterface dialog){
		super.onCancel(dialog);
		Toast.makeText(getActivity(), "onCancel", Toast.LENGTH_LONG).show();	// "onCancel"とToast表示.
	}
	
	// 非表示時.
	@Override
	public void onDismiss(DialogInterface dialog){
		super.onDismiss(dialog);
		Toast.makeText(getActivity(), "onDismiss", Toast.LENGTH_LONG).show();	// "onDismiss"とToast表示.
	}

	// ボタンクリック時.
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		// CustomAsyncTaskによる非同期処理を生成し, 実行.
    	task = new CustomAsyncTask(getActivity(), this);	// CustomAsyncTaskオブジェクトを作成し, taskに格納.(getActivityで親Activityを渡し, thisも渡す.)
    	task.execute(10);	// task.executeに10を渡して実行.
	}
	
}