package com.bgstation0.android.sample.activity_;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // findViewById��R.id.hello_world��TextView���擾��, setText��"Activity.findViewById"�ɑւ���.
        TextView tv = (TextView)findViewById(R.id.hello_world);	// R.id.hello_world�Ȃ�TextView���擾��, tv�Ɋi�[.
        tv.setText("Activity.findViewById");	// tv.setText��"Activity.findViewById"���Z�b�g.
    }
}