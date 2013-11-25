package com.example.friendschecker;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
	
		//ボタンの特定
		  Button registButton=(Button)findViewById(R.id.checkFriends_button);
		  
		  //登録メニューへボタンが押された場合の処理
		  registButton.setOnClickListener(new View.OnClickListener() {
			  @Override
			  public void onClick(View v) {
					// インテントのインスタンス生成
					Intent intentRegistMenu = new Intent(MainActivity.this, CheckFriendsActivity.class);
					// 登録メニューのアクティビティ起動
					startActivity(intentRegistMenu);
			  }
		  });
		  
	}	
}
