package com.bgstation0.android.sample.view.basesavedstate_;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View.BaseSavedState;

// �J�X�^���Z�[�u�h�X�e�[�g.
public class CustomSavedState extends BaseSavedState {

	// �����o�t�B�[���h�̒�`
	public String mStr1 = "";	// mStr1��""�ŏ�����.
	public String mStr2 = "";	// mStr2��""�ŏ�����.
	public String mStr3 = "";	// mStr3��""�ŏ�����.
	
	// �R���X�g���N�^
	public CustomSavedState(Parcelable superState){
		super(superState);
	}
	
	// �v���C�x�[�g�R���X�g���N�^
	private CustomSavedState(Parcel in){
		super(in);
		mStr1 = in.readString();	// mStr1�Ɋi�[.
		mStr2 = in.readString();	// mStr2�Ɋi�[.
		mStr3 = in.readString();	// mStr3�Ɋi�[.
	}
	
	// ��������.
	@Override
	public void writeToParcel(Parcel out, int flags){
		super.writeToParcel(out,  flags);
		out.writeString(mStr1);	// mStr1����������.
		out.writeString(mStr2);	// mStr2����������.
		out.writeString(mStr3);	// mStr3����������.
	}
	
	public static final Parcelable.Creator<CustomSavedState> CREATOR = new Parcelable.Creator<CustomSavedState>(){
		public CustomSavedState createFromParcel(Parcel in){
			return new CustomSavedState(in);
		}
		public CustomSavedState[] newArray(int size){
			return new CustomSavedState[size];
		}
	};
	
}