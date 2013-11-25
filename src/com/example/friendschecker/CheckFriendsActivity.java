package com.example.friendschecker;



import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.Fields;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.analytics.tracking.android.Tracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class CheckFriendsActivity extends Activity {
	public void onStart() {
		super.onStart();
		EasyTracker.getInstance(getApplicationContext()).activityStart(this);
		
		//サイト名の記述
		Tracker easyTracker = EasyTracker.getInstance(this);
		easyTracker.set(Fields.SCREEN_NAME, "監視してるぞ");
		easyTracker.send(MapBuilder
			    .createAppView()
			    .build());
	}

	@Override
	public void onStop() {
	super.onStop();
	EasyTracker.getInstance(getApplicationContext()).activityStop(this);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friends_check);		

		//ボタンの特定
		  Button backMenuButton=(Button)findViewById(R.id.backMenu_button);
		  
		  //登録メニューへボタンが押された場合の処理
		  backMenuButton.setOnClickListener(new View.OnClickListener() {
			  @Override
			  public void onClick(View v) {
					// インテントのインスタンス生成
					Intent intentRegistMenu = new Intent(CheckFriendsActivity.this, MainActivity.class);
					// 登録メニューのアクティビティ起動
					startActivity(intentRegistMenu);
			  }
		  });		
		
	}		
}
	