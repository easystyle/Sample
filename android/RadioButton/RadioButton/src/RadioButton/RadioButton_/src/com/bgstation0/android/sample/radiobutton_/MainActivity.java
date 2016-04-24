package com.bgstation0.android.sample.radiobutton_;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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
    	// radiogroup1���擾��, �ǂ̃��W�I�{�^�����`�F�b�N����Ă��邩���m�F.
    	RadioGroup radiogroup1 = (RadioGroup)findViewById(R.id.radiogroup1);	// findViewById��R.id.radiogroup1���擾.
    	int id = radiogroup1.getCheckedRadioButtonId();	// radiogroup1.getCheckedRadioButtonId�Ń`�F�b�N���ꂽRadioButton��ID���擾��, id�Ɋi�[.
    	RadioButton radiobutton = (RadioButton)findViewById(id);	// findViewById��id���w��RadioButton�I�u�W�F�N�g���擾.
    	Toast.makeText(this, radiobutton.getText(), Toast.LENGTH_SHORT).show();	// Toast��radiobutton��text��\��.
    }
}