package com.bgstation0.android.sample.bitmap_;

import java.io.File;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // ImageViewにtest.pngを表示.
        Bitmap bitmap = BitmapFactory.decodeFile(getFilesDir().getPath() + "/" + "test.png");	// BitmapFactory.decodeFileでファイル"test.png"をBitmapに変換し読み込み, bitmapに格納.(パスの取り方に注意!)
        ImageView imageView1 = (ImageView)findViewById(R.id.imageview1);	// findViewByIdでimageView1を取得.
        imageView1.setImageBitmap(bitmap);	// setImageBitmapでbitmapをセット.
        
    }
}