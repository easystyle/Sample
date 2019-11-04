package com.bgstation0.android.sample.activity_;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{	// View.OnClickListener������.

	// �^�O�̒�`
	private final String TAG = "MainActivity";	// TAG��"MainActivity"
	private final int DIALOG_ID_1 = 1;	// DIALOG_ID_1��1�ɂ���.
	private final int DIALOG_ID_2 = 2;	// DIALOG_ID_2��2�ɂ���.
    private int count1 = 0;	// button1�������ꂽ��count1��0�ŏ�����.
    private int count2 = 0;	// button2�������ꂽ��count2��0�ŏ�����.
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // button1���擾��, OnClickListener�Ƃ��Ď��g���Z�b�g.
        Button button1 = (Button)findViewById(R.id.button1);	// findViewById��R.id.button1���擾.
        button1.setOnClickListener(this);	// button1.setOnClickListener��this(���g)���Z�b�g.
        
        // button2�𗘗p��, OnClickListener�Ƃ��Ď��g���Z�b�g.
        Button button2 = (Button)findViewById(R.id.button2);	// findViewById��R.id.button2���擾.
        button2.setOnClickListener(this);	// button2.setOnClickListener��this(���g)���Z�b�g.
        
    }
	
	// View.OnClickListener�C���^�t�F�[�X�̃I�[�o�[���C�h���\�b�h������.
    public void onClick(View v){	// onClick���I�[�o�[���C�h.
    
    	// �{�^����ID���Ƃɕ�����.
    	if (v.getId() == R.id.button1){ // button1

    		// DIALOG_ID_1�̕\��.
    		Bundle args = new Bundle();	// args�̐���.
    		//args.putString("title", "dialog1");	// "title"��"dialog1"�ɃZ�b�g.
    		//args.putString("message", "button1 clicked!");	// "message"��"button1 clicked!"�ɃZ�b�g.
    		args.putInt("count1", count1);	// count1��o�^.
    		count1++;	// count1���C���N�������g.
    		showDialog(DIALOG_ID_1, args);	// showDialog��DIALOG_ID_1�̃_�C�A���O�\��.(args��n��.)
    		//showDialog(DIALOG_ID_1);	// showDialog��DIALOG_ID_1�̂ݓn��.
    		
    	}
    	else if (v.getId() == R.id.button2){ // button2
    		
    		// DIALOG_ID_2�̕\��.
    		Bundle args = new Bundle();	// args�̐���.
    		//args.putString("title", "dialog2");	// "title"��"dialog2"�ɃZ�b�g.
    		//args.putString("message", "button2 clicked!");	// "message"��"button2 clicked!"�ɃZ�b�g.
    		args.putInt("count2", count2);	// count2��o�^.
    		count2++;	// count2���C���N�������g.
    		showDialog(DIALOG_ID_2, args);	// showDialog��DIALOG_ID_2�̃_�C�A���O�\��.(args��n��.)
    		//showDialog(DIALOG_ID_2);	// showDialog��DIALOG_ID_2�̂ݓn��.
    		
    	}
    	
    }

    // onCreateDialog(int id)�Ń_�C�A���O�쐬.
    /*
    @Override
    protected Dialog onCreateDialog(int id){
    	
    	// �A���[�g�_�C�A���O�r���_�[�̐���
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);	// AlertDialog.Builer�̃C���X�^���Xbuilder�̐���.
    	
    	// "onCreateDialog(id)"���Ă΂ꂽ���Ƃ�\��.
    	Toast.makeText(this, "onCreateDialog(id)", Toast.LENGTH_LONG).show();	// "onCreateDialog(id)"��\��.
    	
    	// ID���Ƃɕς���.
    	if (id == DIALOG_ID_1){	// DIALOG_ID_1
    		
    		// �A���[�g�_�C�A���O�̐ݒ�
	    	builder.setTitle("create title 1");	// setTitle��"create title 1"���Z�b�g.	    	
	    	builder.setMessage("create message 1");	// setMessage��"create message 1"�Z�b�g.
	
	    	// �|�W�e�B�u�{�^���̐ݒ�
	    	builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {	// builder.setPositiveButton�Ń|�W�e�B�u�{�^��"OK"��DialogInterface.OnClickListener���Z�b�g. 
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.v(TAG, "Activity.showDialog(1) OK onClick!");	// Log.v��"Activity.showDialog(1) OK onClick!"��\��.
				}
				
			});
	    	
    	}
    	else if (id == DIALOG_ID_2){ // DIALOG_ID_2
    	
    		// �A���[�g�_�C�A���O�̐ݒ�
	    	builder.setTitle("create title 2");	// setTitle��"create title 2"���Z�b�g.	    	
	    	builder.setMessage("create message 2");	// setMessage��"create message 1"�Z�b�g.
	
	    	// �|�W�e�B�u�{�^���̐ݒ�
	    	builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {	// builder.setPositiveButton�Ń|�W�e�B�u�{�^��"OK"��DialogInterface.OnClickListener���Z�b�g. 
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.v(TAG, "Activity.showDialog(2) OK onClick!");	// Log.v��"Activity.showDialog(2) OK onClick!"��\��.
				}
				
			});
	    	
    	}
    	
    	// �A���[�g�_�C�A���O�̍쐬
    	return builder.create();	// builder.create�ō쐬����Dialog�I�u�W�F�N�g��Ԃ�.
    	
    }
    */
    
    // onPrepareDialog(int id, Dialog dialog)�Ń_�C�A���O����.
    /*
    @Override
    protected void onPrepareDialog(int id, Dialog dialog){
    	
    	// "onPrepareDialog(id, dialog)"���Ă΂ꂽ���Ƃ�\��.
    	Toast.makeText(this, "onPrepareDialog(id = " + id + ", dialog)", Toast.LENGTH_LONG).show();	// "onPrepareDialog(id, dialog)"��\��.(id�̒l��.)
    	super.onPrepareDialog(id, dialog);	// �e�N���X�̃��\�b�h���Ă�.
    	
    }
    */
    
    // onPrepareDialog(int id, Dialog dialog, Bundle args)�Ń_�C�A���O����.
    @Override
    protected void onPrepareDialog(int id, Dialog dialog, Bundle args){
    	
    	// "onPrepareDialog(id, dialog, args)"���Ă΂ꂽ���Ƃ�\��.
    	Toast.makeText(this, "onPrepareDialog(id = " + id + ", dialog, args)", Toast.LENGTH_LONG).show();	// "onPrepareDialog(id, dialog, args)"��\��.(id�̒l��.)
    	if (id == DIALOG_ID_1){	// DIALOG_ID_1
    		Toast.makeText(this, "c1 = " + args.getInt("count1"), Toast.LENGTH_LONG).show();	// c1��\��.
    	}
    	else if (id == DIALOG_ID_2){	// DIALOG_ID_2
    		Toast.makeText(this, "c2 = " + args.getInt("count2"), Toast.LENGTH_LONG).show();	// c2��\��.
    	}
    	super.onPrepareDialog(id, dialog, args);	// �e�N���X�̃��\�b�h���Ă�.
    	
    }
    
    // onCreateDialog�Ń_�C�A���O�쐬.
    @Override
    protected Dialog onCreateDialog(int id, Bundle args){
    	
    	// �A���[�g�_�C�A���O�r���_�[�̐���
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);	// AlertDialog.Builer�̃C���X�^���Xbuilder�̐���.
    	
    	// "onCreateDialog(id, args)"���Ă΂ꂽ���Ƃ�\��.
    	Toast.makeText(this, "onCreateDialog(id, args)", Toast.LENGTH_LONG).show();	// "onCreateDialog(id, args)"��\��.
    	
    	// args�œn���ꂽ"title"��"message"�����o��.
    	/*
    	String title = args.getString("title");	// title���擾.
    	Toast.makeText(this, "title = " + title, Toast.LENGTH_LONG).show();	// title��\��.
    	String message = args.getString("message");	// message���擾.
    	Toast.makeText(this, "message = " + message, Toast.LENGTH_LONG).show();	// message��\��.
    	*/
    	
    	// ID���Ƃɕς���.
    	if (id == DIALOG_ID_1){	// DIALOG_ID_1
    		
	    	// �A���[�g�_�C�A���O�̐ݒ�
    		/*
	    	builder.setTitle(title);	// setTitle��title���Z�b�g.
	    	builder.setMessage(message);	// setMessage��message���Z�b�g.
			*/
    		builder.setTitle("dialog1");	// �^�C�g����"dialog1".
    		int c1 = args.getInt("count1");	// "count1"�̒l��c1�Ɋi�[.
    		builder.setMessage("c1 = " + c1);	// c1�̒l��\��.
    		LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);	// inflater����.
    		View layout = inflater.inflate(R.layout.dialog_main, (ViewGroup)findViewById(R.id.layout_root));	// layout����.
    		EditText editText1 = (EditText)layout.findViewById(R.id.dialog_edittext1);	// editText1���擾.
    		String strCount1 = String.valueOf(c1);	// c1��strCount1�ɕϊ�.
    		editText1.setText(strCount1);	// strCount1���Z�b�g.
    		Button button1 = (Button)layout.findViewById(R.id.dialog_button1);	// button1���擾.
    		button1.setOnClickListener(new View.OnClickListener() {	// �N���b�N���X�i�[���Z�b�g.
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					removeDialog(DIALOG_ID_1);	// DIALOG_ID_1���폜.
				}
				
			});
    		builder.setView(layout);	// layout���Z�b�g.
    		
	    	// �|�W�e�B�u�{�^���̐ݒ�
	    	builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {	// builder.setPositiveButton�Ń|�W�e�B�u�{�^��"OK"��DialogInterface.OnClickListener���Z�b�g. 
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.v(TAG, "Activity.showDialog(1) OK onClick!");	// Log.v��"Activity.showDialog(1) OK onClick!"��\��.
				}
				
			});
    	
    	}
    	else if (id == DIALOG_ID_2){ // DIALOG_ID_2
    		
    		// �A���[�g�_�C�A���O�̐ݒ�
    		/*
    		builder.setTitle(title);	// setTitle��title���Z�b�g.
	    	builder.setMessage(message);	// setMessage��message���Z�b�g.
			*/
    		builder.setTitle("dialog2");	// �^�C�g����"dialog2".
    		int c2 = args.getInt("count2");	// "count2"�̒l��c2�Ɋi�[.
    		builder.setMessage("c2 = " + c2);	// c2�̒l��\��.
    		LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);	// inflater����.
    		View layout = inflater.inflate(R.layout.dialog_main, (ViewGroup)findViewById(R.id.layout_root));	// layout����.
    		EditText editText1 = (EditText)layout.findViewById(R.id.dialog_edittext1);	// editText1���擾.
    		String strCount2 = String.valueOf(c2);	// c2��strCount2�ɕϊ�.
    		editText1.setText(strCount2);	// strCount2���Z�b�g.
    		Button button1 = (Button)layout.findViewById(R.id.dialog_button1);	// button1���擾.
    		button1.setOnClickListener(new View.OnClickListener() {	// �N���b�N���X�i�[���Z�b�g.
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					removeDialog(DIALOG_ID_2);	// DIALOG_ID_2���폜.
				}
				
			});
    		builder.setView(layout);	// layout���Z�b�g.
    		
	    	// �|�W�e�B�u�{�^���̐ݒ�
	    	builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {	// builder.setPositiveButton�Ń|�W�e�B�u�{�^��"OK"��DialogInterface.OnClickListener���Z�b�g. 
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Log.v(TAG, "Activity.showDialog(2) OK onClick!");	// Log.v��"Activity.showDialog(2) OK onClick!"��\��.
				}
				
			});
    		
    	}

    	// �A���[�g�_�C�A���O�̍쐬
    	return builder.create();	// builder.create�ō쐬����Dialog�I�u�W�F�N�g��Ԃ�.
    	
    }
	
}