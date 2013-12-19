package com.example.friendschecker;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR); 
		setContentView(R.layout.main_menu);
		setTheme(android.R.style.Theme_Black_NoTitleBar); 
		Button registButton=(Button)findViewById(R.id.regist_button);
		Button searchButton=(Button)findViewById(R.id.search_button);
		
	    //登録ボタンが押された場合の処理
        registButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  // インテントのインスタンス生成
                  Intent intentRegistMenu = new Intent(MainActivity.this, RegistLocationActivity.class);
                  // メインメニューのアクティビティ起動
                  startActivity(intentRegistMenu);
            }
        });
        
        //検索ボタンが押された場合の処理
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  // インテントのインスタンス生成
                  Intent intentRegistMenu = new Intent(MainActivity.this, SearchLocationActivity.class);
                  // メインメニューのアクティビティ起動
                  startActivity(intentRegistMenu);
            }
        });
		
	}	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {     
		// メニューの要素を追加    
		menu.add("ゲームをする");   
		menu.add("地図を使う");   
		menu.add("座標の確認");   
		menu.add("座標の登録"); 
		menu.add("テスト");   
		// メニューの要素を追加して取得     
		MenuItem actionItem = menu.add("Action Button");      
		// SHOW_AS_ACTION_IF_ROOM:余裕があれば表示     
		actionItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		// アイコンを設定    
		actionItem.setIcon(android.R.drawable.ic_menu_share);  
		return true; 
	}
		
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {     
	
		if(item.getTitle()=="テスト"){
        	InputBox("入力してください。", "テキスト入力");
        	return true; 
		}
		
		if(item.getTitle()=="ゲームをする"){
			Intent intentGameMenu = new Intent(MainActivity.this, CheckFriendsActivity.class);
			// 登録メニューのアクティビティ起動
			startActivity(intentGameMenu);
			return true; 	
		}
		
		if(item.getTitle()=="地図を使う"){
			// インテントのインスタンス生成
			Intent intentMapMenu = new Intent(MainActivity.this, UseMapActivity.class);
			// Mapメニューのアクティビティ起動
			startActivity(intentMapMenu);
			return true; 	
		}
		
		if(item.getTitle()=="座標の確認"){
			Intent intentSearchLocation = new Intent(MainActivity.this, SearchLocationActivity.class);
			// 登録メニューのアクティビティ起動
			startActivity(intentSearchLocation);
			return true; 	
		}
		
		if(item.getTitle()=="座標の登録"){
			// インテントのインスタンス生成
			Intent intentRegistLocation = new Intent(MainActivity.this, RegistLocationActivity.class);
			// 登録メニューのアクティビティ起動
			startActivity(intentRegistLocation);
			return true; 	
		}
		return true; 
	} 
	
	//入力ダイアログの作成
	void InputBox(String message, String title) {
		final EditText editText = new EditText(MainActivity.this);
		AlertDialog.Builder alertDialog=new AlertDialog.Builder(MainActivity.this);
	    alertDialog.setTitle(title);
	    alertDialog.setMessage(message);
	    alertDialog.setView(editText);
	    alertDialog.setIcon(android.R.drawable.ic_dialog_info);
	    alertDialog.setPositiveButton("OK",new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog,int whichButton) {
	        	String input = editText.getText().toString();
	        	Toast.makeText(MainActivity.this, input, Toast.LENGTH_LONG).show();
	        }
	    });
	    alertDialog.create();
	    alertDialog.show();
	}
}
