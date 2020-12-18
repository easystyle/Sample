package com.bgstation0.android.sample.bluetoothadapter_;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

// ���C���A�N�e�B�r�e�B�N���XMainActivity(View.OnClickListener������.)
public class MainActivity extends Activity implements OnClickListener{

	// �����o�t�B�[���h�̒�`
	Context mContext = null;	// mContext��null�ŏ�����.
	
	// �A�N�e�B�r�e�B������
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	// ����̏���
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // mContext�Ɏ��g���Z�b�g.
        mContext = this;	// mContext��this���i�[.
        
        // button1�̏�����.
        Button button1 = (Button)findViewById(R.id.button1);	// button1���擾.
        button1.setOnClickListener(this);	// this���Z�b�g.
        
    }

    // �N���b�N��
	@Override
	public void onClick(View v) {
		
		// TODO Auto-generated method stub
		// BluetoothAdapter�̎擾.
		BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();	// bluetoothAdapter�̎擾.
		if (bluetoothAdapter != null){	// null�łȂ�.
			
			// ���p�\�łȂ�������, Bluetooth�ݒ��ʂɑJ��.
			if (!bluetoothAdapter.isEnabled()){	// ���p�\�łȂ�.
				Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);	// ���p�\���N�G�X�g.
				startActivity(intent);	// �N��.
			}
			
		}
		
	}
	
}