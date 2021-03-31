package com.bgstation0.android.sample.view_;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

// �J�X�^���A�_�v�^
public class CustomAdapter extends ArrayAdapter<String> {

	// �����o�t�B�[���h�̒�`.
	private final LayoutInflater mInflater;	// �C���t���[�^mInflater.
	
	// �R���X�g���N�^.
	public CustomAdapter(Context context, int textViewResourceId, List<String> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);	// mInflater�𐶐�.
	}

	// �A�C�e���\���̃J�X�^�}�C�Y
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		// TextView��p��.
		TextView liTextView = null;	// liTextView��null�ŏ�����.
		
		// convertView��null�̎�.
		if (convertView == null){
			convertView = mInflater.inflate(R.layout.list_item, null);	// convertView��null�Ȃ�inflater.inflate�Ŏ擾.(�����͓���̂łЂƂ܂������������̂��Ƒ����Ă���.)
            liTextView = (TextView)convertView.findViewById(R.id.list_item_textview);	// convertView.findViewById��R.id.list_item_textview��liTextView�Ɋi�[.
            convertView.setTag(liTextView);	// convertView.setTag��liTextView���Z�b�g.
		}
		else{	// null�łȂ���.
			liTextView = (TextView)convertView.getTag();	// convertView.getTag��liTextView��Ԃ�.
		}
		
		// �A�C�e���̃Z�b�g.
		liTextView.setText(getItem(position));	// position�Ԗڂ̃A�C�e����liTextView.setText�ŃZ�b�g.
		return convertView;	// convertView��Ԃ�.
	
	}
	
}