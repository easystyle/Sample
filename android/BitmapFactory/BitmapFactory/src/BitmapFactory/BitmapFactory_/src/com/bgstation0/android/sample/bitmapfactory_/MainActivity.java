package com.bgstation0.android.sample.bitmapfactory_;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // ImageViewにdrawableのtest.pngを表示.
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);	// BitmapFactory.decodeResourceでR.drawable.testをBitmapに変換し読み込み, bitmapに格納.
        ImageView imageView1 = (ImageView)findViewById(R.id.imageview1);	// findViewByIdでimageView1を取得.
        imageView1.setImageBitmap(bitmap);	// setImageBitmapでbitmapをセット.
        
    }
}
