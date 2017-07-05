package com.bgstation0.android.sample.webbackforwardlist_;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class CustomWebViewClient extends WebViewClient {

	// �����o�t�B�[���h�̒�`
	private Context context;	// Context�^context
	private EditText urlBar;	// EditText�^urlBar
	
	// �R���X�g���N�^
	public CustomWebViewClient(Context context){
		
		// �����o�̏�����
		this.context = context;	// ������context�������o��context�ɃZ�b�g.
		Activity activity = (Activity)context;	// context��Activity�^��activity�ɃL���X�g.
		urlBar = (EditText)activity.findViewById(R.id.urlbar);	// urlBar���擾.
		
	}
	
	// ���[�h����URL���ς������.
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url){
		
		// URL�̍X�V
		urlBar.setText(url);	// urlBar.setText��url���Z�b�g.
		
		// false��Ԃ���, �K������WebView�ŏ�������悤�ɂȂ�.
		return false;	// false��Ԃ�.
		
	}
	
	// �y�[�W�̃��[�h���I��������.
	@Override
	public void onPageFinished (WebView view, String url){
		
		// WebBackForwardList�̎擾.
		WebBackForwardList bfList = view.copyBackForwardList();	// view.copyBackForwardList�Ńo�b�N�t�H���[�h���X�g���擾��, bfList�Ɋi�[.
		WebHistoryItem hi = bfList.getCurrentItem();	// bfList.getCurrentItem�Ō��݂̃q�X�g���A�C�e�����擾��, hi�Ɋi�[.
		Toast.makeText(context, hi.getUrl(), Toast.LENGTH_LONG).show();	// hi.getUrl��URL���擾��, �����Toast�ŕ\��.
		// ListItem�z��Œǉ�����v�f���`.
		int c = bfList.getSize();	// bfList.getSize�ŃT�C�Y���擾��, c�Ɋi�[.
        ListItem[] listitems = new ListItem[c];	// ListItem�z��listitems(�v�f��3)
        for (int i = 0; i < c; i++){	// �I�u�W�F�N�g�z��̍쐬��, �C���X�^���X�𐶐��E�i�[�����Ƃ͕ʂȂ̂Œ���!
        	listitems[i] = new ListItem();	// ListItem�I�u�W�F�N�g�C���X�^���X�𐶐���, �e�v�f�Ɋi�[.
        	listitems[i].url = bfList.getItemAtIndex(i).getUrl();	// bfList.getItemAtIndex�ŗv�f���擾, getUrl��URL���擾��, listitems�Ɋi�[.
        }
        // ListView�I�u�W�F�N�g���擾.
        ListView listview = (ListView)((Activity)context).findViewById(R.id.listview);	// findViewById��listview���擾.
        // ListItemAdapter��adapter�𐶐�����, listview��adapter��listitems��R�t����.
        ListItemAdapter adapter = new ListItemAdapter(context, R.layout.list_item, listitems);	// ListItemAdapter�R���X�g���N�^��ListView�̃A�C�e���e���v���[�g��list_item�ƃ��X�g�f�[�^��listitems���Z�b�g.
        listview.setAdapter(adapter);	// listview1.setAdapter��adapter���Z�b�g����, ListView��Adapter��R�t����.
        adapter.notifyDataSetChanged();	// adapter.notifyDataSetChanged�Ńf�[�^���ω��������Ƃ�ʒm.
        
	}
	
}