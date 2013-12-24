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

	private static Tracker mTracker;
	private static final String GA_PROPERTY_ID = "UA-42723657-1";

	public void onStart() {
		super.onStart();
		EasyTracker.getInstance(getApplicationContext()).activityStart(this);

		// サイト名の記述
		Tracker easyTracker = EasyTracker.getInstance(this);
		easyTracker.set(Fields.SCREEN_NAME, "監視してるぞ");
		easyTracker.send(MapBuilder.createAppView().build());
	}

	@Override
	public void onStop() {
		super.onStop();
		EasyTracker.getInstance(getApplicationContext()).activityStop(this);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		mTracker = GoogleAnalytics.getInstance(this).getTracker(GA_PROPERTY_ID);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friends_check);

		// ボタンの特定
		Button backMenuButton = (Button) findViewById(R.id.backMenu_button);
		Button successRouteButton = (Button) findViewById(R.id.success_button);
		Button failRouteButton = (Button) findViewById(R.id.fail_button);

		// メインメニューへボタンが押された場合の処理
		backMenuButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// インテントのインスタンス生成
				Intent intentMainMenu = new Intent(CheckFriendsActivity.this,
						MainActivity.class);
				// メインメニューのアクティビティ起動
				startActivity(intentMainMenu);
			}
		});

		// ルート1ボタンが押された場合の処理
		successRouteButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mTracker.send(MapBuilder
						.createEvent("ボタンの選択", "ルート1の実行", "ボタン", null)
						.set(Fields.SESSION_CONTROL, "start").build());

				// インテントのインスタンス生成
				Intent intentSuccessMenu = new Intent(
						CheckFriendsActivity.this, SuccessActivity.class);
				// 登録メニューのアクティビティ起動
				startActivity(intentSuccessMenu);
			}
		});

		// ルート2ボタンが押された場合の処理
		failRouteButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// インテントのインスタンス生成
				Intent intentFailMenu = new Intent(CheckFriendsActivity.this,
						FailActivity.class);
				// 登録メニューのアクティビティ起動
				startActivity(intentFailMenu);
			}
		});
	}
}
