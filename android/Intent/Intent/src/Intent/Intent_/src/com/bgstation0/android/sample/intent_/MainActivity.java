package com.bgstation0.android.sample.intent_;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{	// View.OnClickListener������.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // button1���擾��, OnClickListener�Ƃ��Ď��g���Z�b�g.
        Button button1 = (Button)findViewById(R.id.button1);	// findViewById��R.id.button1���擾.
        button1.setOnClickListener(this);	// button1.setOnClickListener��this(���g)���Z�b�g.
    }
    
    // View.OnClickListener�C���^�t�F�[�X�̃I�[�o�[���C�h���\�b�h������.
    public void onClick(View v){	// onClick���I�[�o�[���C�h.
    	// �{�^���������ꂽ��C���e���g��"http://bg1hatenablog.com"���J�����Ƃ��ł���A�v���ɓn���ĕ\�����Ă��炤.
    	Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://bg1.hatenablog.com"));	// Intent.ACTION_VIEW(��ʕ\���A�N�V����)��"http://bg1.hatenablog.com"��\������Intent�I�u�W�F�N�gintent�𐶐�.
    	startActivity(intent);	// startActivity��intent���w�肵�ĕ\�����Ă����A�v�����N��.
    }
}