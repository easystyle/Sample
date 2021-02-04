package com.bgstation0.android.sample.bluetoothsocket_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.UUID;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

//���C���A�N�e�B�r�e�B
public class MainActivity extends Activity implements OnClickListener, OnItemClickListener{

 // �����o�t�B�[���h�̒�`
 Context mContext = null;	// mContext��null�ŏ�����.
 ListView mListView1 = null;	// mListView1��null�ŏ�����.
 ArrayList<BluetoothDevice> mBluetoothDeviceList = null;	// mBluetoothDeviceList��null�ŏ�����.
 CustomAdapter mCustomAdapter = null;	// mCustomAdapter��null�ŏ�����.
 BroadcastReceiver mCustomReceiver = null;	// �u���[�h�L���X�g���V�[�o��null�ŏ�����.
 BluetoothAdapter mBluetoothAdapter = null;	// null�ŏ�����.
 public static final int REQUEST_CODE_BLUETOOTH_ENABLE = 1;	// REQUEST_CODE_BLUETOOTH_ENABLE��1�ŏ�����.
 
 // �A�N�e�B�r�e�B������
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 	
 	// ����̏���
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);
     
     // mContext�Ɏ��g���Z�b�g.
     mContext = this;	// mContext��this���i�[.
     
     // ���X�g�r���[�̎擾�ƃA�C�e���I���n���h���̃Z�b�g.
     mListView1 = (ListView)findViewById(R.id.listview1);	// mListView1���擾.
     mListView1.setOnItemClickListener(this);	// this���Z�b�g.
     
     // �J�X�^���A�_�v�^�̐����ƃZ�b�g..
     mBluetoothDeviceList = new ArrayList<BluetoothDevice>();	// mBluetoothDeviceList�𐶐�.
     mCustomAdapter = new CustomAdapter(this, R.layout.list_item, mBluetoothDeviceList);	// CustomAdapter�̐���.
     mListView1.setAdapter(mCustomAdapter);	// mListView1.setAdapter��mCustomAdapter���Z�b�g.
     
     // �J�X�^�����V�[�o����.
     mCustomReceiver = new CustomReceiver(this);	// CustomReceiver�𐶐�.(this��n��.)
     
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
     	
     	// ���p�\�łȂ�������, Bluetooth�ݒ��ʂɑJ�ڂ�, ���p�\�Ȃ�T��.
			if (!mBluetoothAdapter.isEnabled()){	// ���p�\�łȂ�.
				Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);	// ���p�\���N�G�X�g.
				startActivityForResult(intent, REQUEST_CODE_BLUETOOTH_ENABLE);	// startActivityForResult��intent���s, REQUEST_CODE_BLUETOOTH_ENABLE��n��.
			}
			else{	// ���p�\.
				
				// �C���e���g�t�B���^�[���J�X�^�����V�[�o�ɓo�^.
				IntentFilter filter = new IntentFilter();	// filter�̐���.
				filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);	// �J�n
				filter.addAction(BluetoothDevice.ACTION_FOUND);	// ����
				filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);	// �I��
				registerReceiver(mCustomReceiver, filter);	// mCustomReceiver��filter��o�^.
				
				// �T��.
				mBluetoothAdapter.startDiscovery();	// mBluetoothAdapter.startDiscovery�ŒT���J�n.
				
			}
			
		}
		
 }

	// Bluetooth���_�C�A���O����Ԃ��Ă�����.
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent){
		
		// ���N�G�X�g��Bluetooth���̏ꍇ.
		if (requestCode == REQUEST_CODE_BLUETOOTH_ENABLE){
			if (resultCode == Activity.RESULT_OK){	// ���[�U��������������.
				
				// �C���e���g�t�B���^�[���J�X�^�����V�[�o�ɓo�^.
				IntentFilter filter = new IntentFilter();	// filter�̐���.
				filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);	// �J�n
				filter.addAction(BluetoothDevice.ACTION_FOUND);	// ����
				filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);	// �I��
				registerReceiver(mCustomReceiver, filter);	// mCustomReceiver��filter��o�^.
				
				// �T��.
				mBluetoothAdapter.startDiscovery();	// mBluetoothAdapter.startDiscovery�ŒT���J�n.
				
			}
		}
		
	}
	
	// �A�C�e�����I�����ꂽ��.
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
		// �f�o�C�X�̎擾.
		BluetoothDevice bluetoothDevice = mBluetoothDeviceList.get(position);	// mBluetoothDeviceList.get��bluetoothDevice���擾.
		
		// SPP��UUID����.
		UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");	// SPP��UUID�͂���.
		
		// Bluetooth�\�P�b�g�Őڑ�.
		BluetoothSocket soc = null;	// Bluetooth�\�P�b�gsoc��null�ŏ�����.
		try {
			
			// �\�P�b�g�쐬.
            soc = bluetoothDevice.createRfcommSocketToServiceRecord(uuid);
            Toast.makeText(mContext, "soc = " + soc.toString(), Toast.LENGTH_LONG).show();	// soc.toString()��\��.
            
            // �\�P�b�g�ڑ�.
            soc.connect();	// soc.connect�Őڑ�.
            Toast.makeText(mContext, "soc.connect", Toast.LENGTH_LONG).show();	// "soc.connect"�ƕ\��.
            
            // ��������.
            OutputStream outputStream = soc.getOutputStream();	//�@soc.getOutputStream�ŏo�̓X�g���[���擾.
            String str = "ABCDE";	// str��"ABCDE"���Z�b�g.
            outputStream.write(str.getBytes(Charset.forName("UTF-8")));	// str����������.
            
            // �ǂݍ���.
            //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(soc.getInputStream(), Charset.forName("UTF-8")));	// bufferedReader�𐶐�.
            //String res = bufferedReader.readLine();	// bufferedReader.readLine�œǂݍ���, res�Ɋi�[.
            //Toast.makeText(mContext, "res = " + res, Toast.LENGTH_LONG).show();	// res��\��.
            InputStream inputStream = soc.getInputStream();	// soc.getInputStream�œ��̓X�g���[���擾.
            byte[] bytes = new byte[1024];	// byte�z���p��.
            int len;
            len = inputStream.read(bytes);	// inputStream.read�œǂݍ���.
            String res = new String(bytes, 0, len);
            Toast.makeText(mContext, "res = " + res, Toast.LENGTH_LONG).show();	// res��\��.
            
            // �\�P�b�g�����.
            soc.close();	// soc.close�ŕ���.
            soc = null;	// ������soc��null�ɂ���.
            Toast.makeText(mContext, "soc.close", Toast.LENGTH_LONG).show();	// "soc.close"�ƕ\��.
            
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Toast.makeText(mContext, "e1 = " + e1.getMessage(), Toast.LENGTH_LONG).show();	// ��O���b�Z�[�W�\��.
			if (soc != null){	// soc���c���Ă�����Ă���.
				try {
					// �\�P�b�g�����.
		            soc.close();	// soc.close�ŕ���.
		            soc = null;	// ������soc��null�ɂ���.
		            Toast.makeText(mContext, "soc.close", Toast.LENGTH_LONG).show();	// "soc.close"�ƕ\��.
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
					Toast.makeText(mContext, "e2 = " + e2.getMessage(), Toast.LENGTH_LONG).show();	// ��O���b�Z�[�W�\��.
				}
			}
		}
		
	}
	
}