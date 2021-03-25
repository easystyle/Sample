package com.bgstation0.android.sample.view_;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

// カスタムアダプタ
public class CustomAdapter extends ArrayAdapter<String> {

	// メンバフィールドの定義.
	private final LayoutInflater mInflater;	// インフレータmInflater.
	
	// コンストラクタ.
	public CustomAdapter(Context context, int textViewResourceId, List<String> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);	// mInflaterを生成.
	}

	// アイテム表示のカスタマイズ
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		// TextViewを用意.
		TextView liTextView = null;	// liTextViewをnullで初期化.
		
		// convertViewがnullの時.
		if (convertView == null){
			convertView = mInflater.inflate(R.layout.list_item, null);	// convertViewがnullならinflater.inflateで取得.(ここは難しいのでひとまずこういうものだと捉えておく.)
            liTextView = (TextView)convertView.findViewById(R.id.list_item_textview);	// convertView.findViewByIdでR.id.list_item_textviewをliTextViewに格納.
            convertView.setTag(liTextView);	// convertView.setTagでliTextViewをセット.
		}
		else{	// nullでない時.
			liTextView = (TextView)convertView.getTag();	// convertView.getTagでliTextViewを返す.
		}
		
		// アイテムのセット.
		liTextView.setText(getItem(position));	// position番目のアイテムをliTextView.setTextでセット.
		return convertView;	// convertViewを返す.
	
	}
	
}