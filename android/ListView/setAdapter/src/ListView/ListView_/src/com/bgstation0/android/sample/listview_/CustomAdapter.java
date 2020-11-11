package com.bgstation0.android.sample.listview_;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

	// �����o�t�B�[���h
	ArrayList<String> mNames = null;
	ArrayList<String> mAddresses = null;
	LayoutInflater mInflater = null;
	
	// �R���X�g���N�^
	CustomAdapter(Context context, String[] names, String[] addresses){
	
		// �C���t���[�^
		mInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		
		// ���X�g�R�s�[.
		mNames = new ArrayList<String>();
		for (String name : names){
			mNames.add(name);	// name��ǉ�.
		}
		mAddresses = new ArrayList<String>();
		for (String address : addresses){
			mAddresses.add(address);	// address��ǉ�.
		}
		
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mNames.size();	// �����ł�mNames�̐���Ԃ�.
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null){
			convertView = mInflater.inflate(R.layout.list_item, null);
		}
		TextView tvName = (TextView)convertView.findViewById(R.id.list_item_name);
		tvName.setText(mNames.get(position));
		TextView tvAddress = (TextView)convertView.findViewById(R.id.list_item_address);
		tvAddress.setText(mAddresses.get(position));
		return convertView;
	}

}