package com.bgstation0.android.sample.listview_;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // �z��̏���.
        final String[] names = {
        	"Taro",
        	"Jiro",
        	"Saburo",
        	"Shiro"
        };
        final String[] addresses = {
        	"Tokyo",
        	"Osaka",
        	"Nagoya",
        	"Sapporo"
        };
        
        // ListView�擾.
        ListView listView1 = (ListView)findViewById(R.id.listview1);
        
        // customAdapter����.
        BaseAdapter customAdapter = new CustomAdapter(this, names, addresses);
        
        // �Z�b�g.
        listView1.setAdapter(customAdapter);	// customAdapter���Z�b�g.
        
    }
    
}