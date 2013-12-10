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
		  Button searchButton=(Button)findViewById(R.id.searchLocation_button);
		  Button registButton=(Button)findViewById(R.id.registLocation_button);
		  //登録メニューへボタンが押された場合の処理
		  playGameButton.setOnClickListener(new View.OnClickListener() {
			  @Override
			  public void onClick(View v) {
					// インテントのインスタンス生成
					Intent intentGameMenu = new Intent(MainActivity.this, CheckFriendsActivity.class);
					// 登録メニューのアクテsビティ起動
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
		  
		  //位置確認ボタンが押された場合の処理
		  searchButton.setOnClickListener(new View.OnClickListener() {
			  @Override
			  public void onClick(View v) {
					// インテントのインスタンス生成
					Intent intentSearchLocation = new Intent(MainActivity.this, SearchLocationActivity.class);
					// 登録メニューのアクティビティ起動
					startActivity(intentSearchLocation);
			  }
		  });
		  
		  //位置登録ボタンが押された場合の処理
		  registButton.setOnClickListener(new View.OnClickListener() {
			  @Override
			  public void onClick(View v) {
					// インテントのインスタンス生成
					Intent intentRegistLocation = new Intent(MainActivity.this, RegistLocationActivity.class);
					// 登録メニューのアクティビティ起動
					startActivity(intentRegistLocation);
			  }
		  });		
		  
	}	
}
