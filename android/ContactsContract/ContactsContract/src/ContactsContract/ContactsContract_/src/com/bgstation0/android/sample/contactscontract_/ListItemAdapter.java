package com.bgstation0.android.sample.contactscontract_;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

//ListItem�p�A�_�v�^�[ListItemAdapter
public class ListItemAdapter extends ArrayAdapter<ListItem> {	// ArrayAdapter<ListItem>���p������ListItemAdapter�̒�`.
	
	// �C���t���[�^�[�̒�`.
	LayoutInflater inflater;	// �C���t���[�^�[inflater.
	
	// �R���X�g���N�^
	public ListItemAdapter(Context context, int resource, List<ListItem> objects){
		super(context, resource, objects);
		inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);	// inflater�̎擾.
	}
	
	// �A�C�e���\���̃J�X�^�}�C�Y
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		// convertView��null�̎�.
		if (convertView == null){
			convertView = inflater.inflate(R.layout.list_item, null);	// convertView��null�Ȃ�inflater.inflate�Ŏ擾.
		}
		TextView tvname = (TextView)convertView.findViewById(R.id.list_item_name);	// convertView.findViewById��R.id.list_item_name��tvname�Ɋi�[.
		tvname.setText(getItem(position).name);	// position�Ԗڂ̃A�C�e����name��tvname.setText�ŃZ�b�g.
		TextView tvphonenumber = (TextView)convertView.findViewById(R.id.list_item_phonenumber);	// convertView.findViewById��R.id.list_item_phonenumber��tvphonenumber�Ɋi�[.
		tvphonenumber.setText(getItem(position).phoneNumber);	// position�Ԗڂ̃A�C�e����phoneNumber��tvphonenumber.setText�ŃZ�b�g.
		TextView tvemailaddress = (TextView)convertView.findViewById(R.id.list_item_emailaddress);	// convertView.findViewById��R.id.list_item_emailaddress��tvemailaddress�Ɋi�[.
		tvemailaddress.setText(getItem(position).emailAddress);	// position�Ԗڂ̃A�C�e����emailAddress��tvemailaddress.setText�ŃZ�b�g.
		return convertView;	// convertView��Ԃ�.
	}

}