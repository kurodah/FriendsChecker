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
		  Button playGameButton=(Button)findViewById(R.id.playGame_button);
		  Button mapButton=(Button)findViewById(R.id.map_button);
		  
		  //登録メニューへボタンが押された場合の処理
		  playGameButton.setOnClickListener(new View.OnClickListener() {
			  @Override
			  public void onClick(View v) {
					// インテントのインスタンス生成
					Intent intentGameMenu = new Intent(MainActivity.this, CheckFriendsActivity.class);
					// 登録メニューのアクティビティ起動
					startActivity(intentGameMenu);
			  }
		  });
		  
		  //登録メニューへボタンが押された場合の処理
		  mapButton.setOnClickListener(new View.OnClickListener() {
			  @Override
			  public void onClick(View v) {
					// インテントのインスタンス生成
					Intent intentMapMenu = new Intent(MainActivity.this, UseMapActivity.class);
					// 登録メニューのアクティビティ起動
					startActivity(intentMapMenu);
			  }
		  });		  
		  
		  
	}	
}
