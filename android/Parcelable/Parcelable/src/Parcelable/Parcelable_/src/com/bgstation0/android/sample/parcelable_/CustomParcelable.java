package com.bgstation0.android.sample.parcelable_;

import android.os.Parcel;
import android.os.Parcelable;

// �J�X�^���p�[�Z���u���N���XCustomParcelable�̒�`
public class CustomParcelable implements Parcelable {

	// �����o�t�B�[���h�̒�`
	private String mStr1;
	private String mStr2;
	private String mStr3;
	
	// �ʏ�0�ŕԂ�.
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	// ��������.
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		// CustomParcelable(Parcel in)�Ɠ������Ԃŏ�������.
		dest.writeString(mStr1);	// dest��mStr1����������.
		dest.writeString(mStr2);	// dest��mStr2����������.
		dest.writeString(mStr3);	// dest��mStr3����������.
	}
	
	// CREATOR
	public static final Parcelable.Creator<CustomParcelable> CREATOR = new Parcelable.Creator<CustomParcelable>() {
		public CustomParcelable createFromParcel(Parcel in){
			return new CustomParcelable(in);
		}
		public CustomParcelable[] newArray(int size){
			return new CustomParcelable[size];
		}
	};
	
	// ����J�R���X�g���N�^
	private CustomParcelable(Parcel in){
		// writeToParcel(Parcel dest, int flags)�Ɠ������Ԃœǂݍ���.
		mStr1 = in.readString();	// in����ǂݍ���mStr1�Ɋi�[.
		mStr2 = in.readString();	// in����ǂݍ���mStr2�Ɋi�[.
		mStr3 = in.readString();	// in����ǂݍ���mStr3�Ɋi�[.
	}
	
	// ���J�R���X�g���N�^
	public CustomParcelable(String str1, String str2, String str3){
		// ���������Ԃ����킹��.
		mStr1 = str1;
		mStr2 = str2;
		mStr3 = str3;
	}
	
	// mStr1�̎擾.
	public String getStr1(){
		return mStr1;	// mStr1��Ԃ�.
	}
	
	// mStr2�̎擾.
	public String getStr2(){
		return mStr2;	// mStr2��Ԃ�.
	}
	
	// mStr3�̎擾.
	public String getStr3(){
		return mStr3;	// mStr3��Ԃ�.
	}
		
}