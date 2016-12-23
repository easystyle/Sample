package com.bgstation0.android.sample.mediastore_;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

// GridItem�p�A�_�v�^�[GridItemAdapter
public class GridItemAdapter extends ArrayAdapter<GridItem> {	// ArrayAdapter<GridItem>���p������GridItemAdapter�̒�`.

	// �C���t���[�^�[�̒�`.
	LayoutInflater inflater;	// �C���t���[�^�[inflater.
		
	// �R���X�g���N�^
	public GridItemAdapter(Context context, int resource, List<GridItem> objects){
		super(context, resource, objects);
		inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);	// inflater�̎擾.
	}
		
	// �A�C�e���\���̃J�X�^�}�C�Y
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		// convertView��null�̎�.
		if (convertView == null){
			convertView = inflater.inflate(R.layout.grid_item, null);	// convertView��null�Ȃ�inflater.inflate�Ŏ擾.
		}
		TextView tvname = (TextView)convertView.findViewById(R.id.grid_item_name);	// convertView.findViewById��R.id.grid_item_name��tvname�Ɋi�[.
		tvname.setText(getItem(position).name);	// position�Ԗڂ̃A�C�e����name��tvname.setText�ŃZ�b�g.
		ImageView ivbitmap = (ImageView)convertView.findViewById(R.id.grid_item_bitmap);	// convertView.findViewById��R.id.grid_item_bitmap��ivbitmap�Ɋi�[.
		ivbitmap.setImageBitmap(getItem(position).bitmap);	// position�Ԗڂ̃A�C�e����bitmap��ivbitmap.setImageBitmap�ŃZ�b�g.
		return convertView;	// convertView��Ԃ�.
	}
	
}