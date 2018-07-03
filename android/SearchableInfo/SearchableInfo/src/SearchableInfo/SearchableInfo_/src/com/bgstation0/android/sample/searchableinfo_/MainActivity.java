package com.bgstation0.android.sample.searchableinfo_;

import java.util.Set;

import android.app.Activity;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // SearchManager�̎擾.
        SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);	// searchManager���擾.
        // searchableInfo�̎擾.
        SearchableInfo searchableInfo = searchManager.getSearchableInfo(getComponentName());	// searchManager.getSearchableInfo��searchableInfo���擾.
        
        // SearchView�̎擾.
        SearchView searchView = (SearchView)findViewById(R.id.searchview);	// searchview���擾.
        // searchableInfo�̃Z�b�g.
        searchView.setSearchableInfo(searchableInfo);	// searchView.setSearchableInfo��searchView��searchableInfo���Z�b�g.
        
    }
    
    @Override
    protected void onNewIntent(Intent intent){
    	
    	super.onNewIntent(intent);
    	
    	// �����N�G���̎擾.
        if (intent != null){	// intent��null�łȂ���.
        	String action = intent.getAction();	// action���擾.
        	if (action != null){	// action��null�łȂ���.
        		if (action.equals(Intent.ACTION_SEARCH)){	// action��Intent.ACTION_SEARCH�̎�.
        			//String query = intent.getStringExtra(SearchManager.QUERY);	// query���擾.
        			//Toast.makeText(this, "query = " + query, Toast.LENGTH_LONG).show();	// query��\��.
        			Bundle bundle = intent.getExtras();
        			Set<String> keySet = bundle.keySet();
        		    for (String key : keySet) {
        		    	Toast.makeText(this, key + ":" + bundle.get(key), Toast.LENGTH_LONG).show();	// query��\��.
        		    }
        		}
        	}
        }
        
    }
    
}