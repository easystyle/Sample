package com.bgstation0.android.sample.fragmentmanager_;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // FragmentManager���擾.
        FragmentManager fragmentManager = getFragmentManager();	// getFragmentManager��fragmentManager���擾.
        // id��"fragment1"�ƂȂ�Fragment���擾.
        Fragment fragment1 = fragmentManager.findFragmentById(R.id.fragment1);	// fragmentManager.findFragmentById��"fragment1"�Ȃ�id��Fragment��T���Ď擾.
        if (fragment1 == null){	// null�Ȃ�.
        	Toast.makeText(this, "fragment1 is not exist!", Toast.LENGTH_LONG).show();	// "fragment1 is not exist!"�ƕ\��.
        }
        else{
        	Toast.makeText(this, "fragment1 is exist!", Toast.LENGTH_LONG).show();	// "fragment1 is exist!"�ƕ\��.
        }
        // id��"fragment2"�ƂȂ�Fragment���擾.
        Fragment fragment2 = fragmentManager.findFragmentById(R.id.fragment2);	// fragmentManager.findFragmentById��"fragment2"�Ȃ�id��Fragment��T���Ď擾.
        if (fragment2 == null){	// null�Ȃ�.
        	Toast.makeText(this, "fragment2 is not exist!", Toast.LENGTH_LONG).show();	// "fragment2 is not exist!"�ƕ\��.
        }
        else{
        	Toast.makeText(this, "fragment2 is exist!", Toast.LENGTH_LONG).show();	// "fragment2 is exist!"�ƕ\��.
        }
        // Fragment�Ƃ��Ă͑��݂��Ȃ�id��findFragmentById���Ă݂�.
        Fragment fragment3 = fragmentManager.findFragmentById(R.id.fragment1_textview);	// fragmentManager.findFragmentById��"fragment1_textview"�Ƃ���Fragment�Ƃ��Ă͑��݂��Ȃ�id���w�肵�Ă݂�.
        if (fragment3 == null){	// null�Ȃ�.
        	Toast.makeText(this, "fragment3 is not exist!", Toast.LENGTH_LONG).show();	// "fragment3 is not exist!"�ƕ\��.
        }
        else{
        	Toast.makeText(this, "fragment3 is exist!", Toast.LENGTH_LONG).show();	// "fragment3 is exist!"�ƕ\��.
        }
    }
}