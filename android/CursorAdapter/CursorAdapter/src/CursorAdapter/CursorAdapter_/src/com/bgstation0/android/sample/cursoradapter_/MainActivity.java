package com.bgstation0.android.sample.cursoradapter_;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends Activity {

	// メンバフィールドの定義.
	public CustomDBHelper mHlpr = null;	// CustomDBHelperオブジェクトmHlprをnullにしておく.
	public SQLiteDatabase mSqlite = null;	// SQLiteDatabaseオブジェクトmSqliteをnullにしておく.
	public CustomCursorAdapter mAdapter = null;	// CustomCursorAdapterオブジェクトmAdapterをnullにしておく.
	public Cursor mCursor = null;	// CursorオブジェクトmCursorをnullにしておく.
	
	// Activityが生成されたとき.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // ListViewの取得.
        ListView listView1 = (ListView)findViewById(R.id.listview1);	// listView1を取得.
        
        // DBへの行の挿入.
        mCursor = null;	// mCursorにnullをセット.
        try{
        	if (mHlpr == null){	// mHlprがnullなら.
        		mHlpr = new CustomDBHelper(getApplicationContext());	// mHlpr作成.
        		if (mSqlite == null){	// mSqliteがnullなら.
        			mSqlite = mHlpr.getWritableDatabase();	// mSqlite取得.
        			if (mSqlite != null){	// mSqliteが取得できれば.
        				// 挿入.
        				ContentValues values1 = new ContentValues();	// values1の生成.
        				values1.put("name", "Taro");	// キーが"name", 値が"Taro".
        				values1.put("age", 20);	// キーが"age", 値が20.
        				long i = mSqlite.insert("custom", null, values1);	// 挿入.
        				ContentValues values2 = new ContentValues();	// values2の生成.
        				values2.put("name", "Jiro");	// キーが"name", 値が"Jiro".
        				values2.put("age", 18);	// キーが"age", 値が18.
        				long i2 = mSqlite.insert("custom", null, values2);	// 挿入.
        				ContentValues values3 = new ContentValues();	// values3の生成.
        				values3.put("name", "Saburo");	// キーが"name", 値が"Saburo".
        				values3.put("age", 16);	// キーが"age", 値が16.
        				long i3 = mSqlite.insert("custom", null, values3);	// 挿入.
        				// 選択.
        				String[] projection = new String[]{
        						"_id", // ID.
        						"name",	// 名前.
        						"age" // 年齢.
        				};
        				mCursor = mSqlite.query("custom", projection, null, null, null, null, "age desc");	// クエリ結果をmCursorに格納.
        				mAdapter = new CustomCursorAdapter(this, mCursor, true);	// mAdapterを生成.
        				listView1.setAdapter(mAdapter);	// listView1にmAdapterをセット.
        			}
        		}
        	}
        }
        catch (Exception ex){	// 例外.
        	Log.e("CursorAdapter", ex.toString());	// ex.toStringをLogに出力.
        }
        finally{	// 必須処理
        	if (mSqlite != null){	// mSqliteがあれば.
        		mSqlite.close();	// 閉じる.
        		mSqlite = null;	// nullをセット.
        	}
        	if (mHlpr != null){	// mHlprがあれば.
        		mHlpr.close();	// 閉じる.
        		mHlpr = null;	// nullをセット.
        	}
        }
        
    }
    
    // Activityが破棄されたとき.
    protected void onDestroy() {	// onDestroyの定義
    	
    	// 親クラスの処理
    	super.onDestroy();	// super.onDestroyで親クラスの既定処理.
    	
    	// カーソルを閉じる.
    	if (mCursor != null){	// mCursorがあれば.
    		mCursor.close();	// 閉じる.
    		mCursor = null;	// nullをセット.
    	}
    	
    }
    
}