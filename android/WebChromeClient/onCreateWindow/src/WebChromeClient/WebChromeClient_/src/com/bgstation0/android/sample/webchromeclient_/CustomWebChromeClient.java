package com.bgstation0.android.sample.webchromeclient_;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class CustomWebChromeClient extends WebChromeClient {

	// �����o�t�B�[���h�̒�`
	private Context context;	// Context�^context
	private TextView progressTextView;	// TextView�^progressTextView
	private ProgressBar progressBar;	// ProgressBar�^progressBar.
	
	// �R���X�g���N�^
	public CustomWebChromeClient(Context context){
		
		// �����o�̏�����
		this.context = context;	// ������context�������o��context�ɃZ�b�g.
		Activity activity = (Activity)context;	// context��Activity�^��activity�ɃL���X�g.
		progressTextView = (TextView)activity.findViewById(R.id.progresstextview);	// progressTextView���擾.
		progressBar = (ProgressBar)activity.findViewById(R.id.progressbar);	// findViewById��R.id.progressbar���擾��, progressBar�Ɋi�[.
		
	}
	
	// ���[�h�̐i�����ω�������.
	@Override
	public void onProgressChanged(WebView view, int newProgress){
		
		// �i���̍X�V.
		progressTextView.setText(newProgress + "%");	// progressTextView.setText��newProgress��"%"��t���ĕ\��.
		progressBar.setProgress(newProgress);	// progressBar.setProgress�Ői����newProgress���Z�b�g.
		
	}
	
	// �E�B���h�E�쐬��.
	@Override
	public boolean onCreateWindow(WebView view, boolean dialog, boolean userGesture, Message resultMsg){
		
		// "onCreateWindow"��\��.
		Activity activity = (Activity)context;	// context��Activity�^��activity�ɃL���X�g.
		String url = view.getUrl();	// ����WebView�����[�h���Ă���(�\�����Ă���)URL.(�����N��ł͂Ȃ��̂Œ���!)
		Toast.makeText(activity, "onCreateWindow, url = " + url, Toast.LENGTH_LONG).show();	// "onCreateWindow"��url��\��.
		WebView.HitTestResult hr = view.getHitTestResult();	// �����N���HitTestResult��.
		Toast.makeText(activity, "new url = " + hr.getExtra(), Toast.LENGTH_LONG).show();	// hr.getExtra��\��.
		
		// �J������ɐ��䂪�s���Ă�, ���������������悤��false�ɂ���.
		return false;	// false��Ԃ�.
		
	}
	
}