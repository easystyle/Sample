package com.bgstation0.android.sample.bluetoothdevice_;

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

//���C���A�N�e�B�r�e�B�N���XMainActivity(View.OnClickListener������.)
public class MainActivity extends Activity implements OnClickListener{

	// �����o�t�B�[���h�̒�`
	Context mContext = null;	// mContext��null�ŏ�����.
	public static final int REQUEST_CODE_BLUETOOTH_ENABLE = 1;	// REQUEST_CODE_BLUETOOTH_ENABLE��1�ŏ�����.
	BluetoothAdapter mBluetoothAdapter = null;	// null�ŏ�����.
	
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
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();	// mBluetoothAdapter�̎擾.
		if (mBluetoothAdapter != null){	// null�łȂ�.
			
			// ���p�\�łȂ�������, Bluetooth�ݒ��ʂɑJ��.
			if (!mBluetoothAdapter.isEnabled()){	// ���p�\�łȂ�.
				Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);	// ���p�\���N�G�X�g.
				//startActivity(intent);	// �N��.
				startActivityForResult(intent, REQUEST_CODE_BLUETOOTH_ENABLE);	// startActivityForResult��intent���s, REQUEST_CODE_BLUETOOTH_ENABLE��n��.
			}
			
		}
		
	}
	
	// Bluetooth���_�C�A���O����Ԃ��Ă�����.
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent){
		
		// ���N�G�X�g��Bluetooth���̏ꍇ.
		if (requestCode == REQUEST_CODE_BLUETOOTH_ENABLE){
			if (resultCode == Activity.RESULT_OK){	// ���[�U��������������.
				mBluetoothAdapter.startDiscovery();	// mBluetoothAdapter.startDiscovery�ŒT���J�n.
			}
		}
		
	}
	
}