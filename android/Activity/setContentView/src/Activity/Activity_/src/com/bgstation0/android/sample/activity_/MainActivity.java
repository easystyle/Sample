package com.bgstation0.android.sample.activity_;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Button�I�u�W�F�N�g�̃C���X�^���X���쐬��, ������r���[�ɃZ�b�g.
        //setContentView(R.layout.activity_main);	// ���̕����̓R�����g�A�E�g.
        Button button = new Button(this);	// Button�I�u�W�F�N�g�̃C���X�^���X��button�Ɋi�[.
        setContentView(button);	// setContentView�Ńr���[��button���Z�b�g.
    }
}