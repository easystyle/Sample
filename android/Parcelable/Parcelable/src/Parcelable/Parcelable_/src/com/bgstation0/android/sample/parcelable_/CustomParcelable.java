package com.bgstation0.android.sample.parcelable_;

import android.os.Parcel;
import android.os.Parcelable;

// カスタムパーセラブルクラスCustomParcelableの定義
public class CustomParcelable implements Parcelable {

	// メンバフィールドの定義
	private String mStr1;
	private String mStr2;
	private String mStr3;
	
	// 通常0で返す.
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	// 書き込み.
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		// CustomParcelable(Parcel in)と同じ順番で書き込む.
		dest.writeString(mStr1);	// destにmStr1を書き込み.
		dest.writeString(mStr2);	// destにmStr2を書き込み.
		dest.writeString(mStr3);	// destにmStr3を書き込み.
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
	
	// 非公開コンストラクタ
	private CustomParcelable(Parcel in){
		// writeToParcel(Parcel dest, int flags)と同じ順番で読み込む.
		mStr1 = in.readString();	// inから読み込みmStr1に格納.
		mStr2 = in.readString();	// inから読み込みmStr2に格納.
		mStr3 = in.readString();	// inから読み込みmStr3に格納.
	}
	
	// 公開コンストラクタ
	public CustomParcelable(String str1, String str2, String str3){
		// ここも順番を合わせる.
		mStr1 = str1;
		mStr2 = str2;
		mStr3 = str3;
	}
	
	// mStr1の取得.
	public String getStr1(){
		return mStr1;	// mStr1を返す.
	}
	
	// mStr2の取得.
	public String getStr2(){
		return mStr2;	// mStr2を返す.
	}
	
	// mStr3の取得.
	public String getStr3(){
		return mStr3;	// mStr3を返す.
	}
		
}