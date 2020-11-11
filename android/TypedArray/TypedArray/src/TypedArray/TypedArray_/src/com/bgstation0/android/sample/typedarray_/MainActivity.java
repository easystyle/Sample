package com.bgstation0.android.sample.typedarray_;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

//���C���A�N�e�B�r�e�B�N���XMainActivity�̒�`.
public class MainActivity extends Activity {

    // �����o�t�B�[���h�̒�`
    static final String TAG = "MainActivity";	// TAG��"MainActivity"�ŏ�����.

    // �A�N�e�B�r�e�B������
    @Override
    protected void onCreate(Bundle savedInstanceState) {
	
        // ����̏���
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      
        // �^�t���z��̎擾.
        Resources res = getResources();	// res���擾.
        TypedArray mixedarray = res.obtainTypedArray(R.array.mixedarray);	// mixedarray�̎擾.
        Log.d(TAG, mixedarray.toString());	// mixedarray���o��.
      
    }
  
}
