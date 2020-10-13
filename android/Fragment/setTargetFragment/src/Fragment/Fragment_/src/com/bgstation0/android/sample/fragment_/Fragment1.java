package com.bgstation0.android.sample.fragment_;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragment1 extends Fragment implements View.OnClickListener{

    // メンバフィールド
    static final String TAG = "Fragment1";	// TAGを"Fragment1"で初期化.
	
	// ファクトリメソッド
	public static Fragment1 newInstance(){
		
		// Fragment1オブジェクトの生成.
		Fragment1 fragment1 = new Fragment1();	// fragment1を生成.
		return fragment1;	// fragment1を返す.
		
	}
	
    // ビュー生成時
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
			
        // ログを残す.
        Log.d(TAG, "Fragment1.onCreateView");	// "Fragment1.onCreateView"とログに残す.
			
        // 既定の処理.
        super.onCreateView(inflater, container, savedInstanceState);
		
        // Fragment1のButtonを取得.
        View view = inflater.inflate(R.layout.fragment1_main, null);	// inflater.inflateでR.layout.fragment1_mainからビューを作成.
        Button button1 = (Button)view.findViewById(R.id.fragment1_button);	// button1を取得.
        button1.setOnClickListener(this);	// thisをセット.
        return view;	// viewを返す.
        
    }
    
    // クリックされた時.
    @Override
    public void onClick(View v) {
    	// TODO Auto-generated method stub
    	// 親のアクティビティを取得.
    	Activity activity = getActivity();	// getActivityでactivityを取得.
    	if (activity !=null){	// nullでない.
    		FragmentManager fragmentManager = activity.getFragmentManager();	// fragmentManagerを取得.
    		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();	// fragmentTransactionを取得.
    		Fragment2 fragment2 = Fragment2.newInstance(this);	// fragment2を生成.(ターゲットに呼び出し元thisをセット.)
        	fragmentTransaction.add(R.id.framelayout1, fragment2);	// fragment2を追加.
        	fragmentTransaction.commit();	// 確定.
    	}
    }
    
    // 独自メソッドcustomMethod.
    public void customMethod(){
    	// 親のアクティビティを取得.
    	Activity activity = getActivity();	// getActivityでactivityを取得.
        if (activity !=null){	// nullでない.
            // トースト表示.
            Toast.makeText(activity, "customMethod!", Toast.LENGTH_LONG).show();	// "customMethod!"と表示.
    	}
    }
    
}