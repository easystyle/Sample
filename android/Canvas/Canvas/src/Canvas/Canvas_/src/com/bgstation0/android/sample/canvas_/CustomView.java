package com.bgstation0.android.sample.canvas_;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

// カスタムビュークラスCustomViewの定義
public class CustomView extends View {

	// メンバフィールドの定義
	Paint mPaint = null;	// PaintオブジェクトmPaintをnullで初期化.
	
	// コンストラクタの定義
	public CustomView(Context context){
		
		// 既定の初期化.
		super(context);	// 親クラスのコンストラクタにcontextを渡す.
		mPaint = new Paint();	// Paintオブジェクトを生成し, mPaintに格納.
		
	}
	
	// 描画時
	@Override
	protected void onDraw(Canvas canvas){

		// テキスト"ABCDE"を描画.
		canvas.drawText("ABCDE", 50, 50, mPaint);	// canvas.drawTextで(50, 50)の位置に"ABCDE"を描画.
		
		// 矩形を描画.
		canvas.drawRect(100,  100,  150,  150, mPaint);	// canvas.drawRectで(100, 100)の位置に矩形を描画.
		
		// 円を描画.
		canvas.drawCircle(200, 200, 30, mPaint);	// canvas.drawCircleで(200, 200)の位置に円を描画.
		
	}
	
}