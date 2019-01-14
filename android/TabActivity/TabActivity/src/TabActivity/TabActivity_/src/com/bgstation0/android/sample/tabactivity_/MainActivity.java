package com.bgstation0.android.sample.tabactivity_;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // tabHost�̎擾.
        TabHost tabHost = getTabHost();	// getTabHost��tabHost���擾.
        
        // tabSpec�̍쐬.
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("MainTab");	// tabSpec�쐬.        
        // �e�L�X�g�̃Z�b�g.
        tabSpec.setIndicator("MainTab");	// �e�L�X�g��"MainTab".
        // �R���e���c�̃Z�b�g.
        tabSpec.setContent(R.id.main_content);	// R.id.main_content���Z�b�g.
        // �^�u�̒ǉ�.
        tabHost.addTab(tabSpec);	// tabSpec��ǉ�.
        
        // tabSpec2�̍쐬.(����Œǉ������, �ŏ��̃^�u�̃e�L�X�gMainContent���\������Ȃ�.)
        /*
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("MainTab2");	// tabSpec2�쐬.      
        // �e�L�X�g�̃Z�b�g.
        tabSpec2.setIndicator("MainTab2");	// �e�L�X�g��"MainTab2".
        // �R���e���c�̃Z�b�g.
        View v = (View)findViewById(R.id.main_content);	// v���擾.
        TextView tv = (TextView)v.findViewById(R.id.textview1);	// tv���擾.
        tv.setText("MainContent2");	// �e�L�X�g��ύX.
        tabSpec2.setContent(R.id.main_content);	// R.id.main_content���Z�b�g.
        // �^�u�̒ǉ�.
        tabHost.addTab(tabSpec2);	// tabSpec2��ǉ�.
        */
        
        // tabSpec2�̍쐬.(Intent��Activity��ǉ�.)
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("MainTab2");	// tabSpec2�쐬.
        // �e�L�X�g�̃Z�b�g.
        tabSpec2.setIndicator("MainTab2");	// �e�L�X�g��"MainTab2".
        // �R���e���c�̃Z�b�g.
        tabSpec2.setContent(new Intent(this, SubActivity.class));	// SubActivity���Z�b�g.
        // �^�u�̒ǉ�.
        tabHost.addTab(tabSpec2);	// tabSpec2��ǉ�.
        
        // tabSpec3�̍쐬.(Intent��Activity��ǉ�.)
        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("MainTab3");	// tabSpec3�쐬.
        // �e�L�X�g�̃Z�b�g.
        tabSpec3.setIndicator("MainTab3");	// �e�L�X�g��"MainTab3".
        // �R���e���c�̃Z�b�g.
        Intent intent = new Intent(this, SubActivity.class);	// intent�𐶐�.
        Bundle args = new Bundle();	// args�쐬.
        args.putString("tag", "Activity3");	// ("tag", "Activity3")�œo�^.
        intent.putExtras(args);	// args�o�^.
        tabSpec3.setContent(intent);	// intent���Z�b�g.
        // �^�u�̒ǉ�.
        tabHost.addTab(tabSpec3);	// tabSpec3��ǉ�.
        
    }
    
}