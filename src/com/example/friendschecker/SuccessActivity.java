package com.example.friendschecker;


import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.Fields;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.analytics.tracking.android.Tracker;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SuccessActivity extends Activity {
	
	public void onStart() {
		super.onStart();
		EasyTracker.getInstance(getApplicationContext()).activityStart(this);

		//サイト名の記述
		Tracker easyTracker = EasyTracker.getInstance(this);
		easyTracker.set(Fields.SCREEN_NAME, "成功ページ");
		easyTracker.send(MapBuilder
			    .createAppView()
			    .build());
	}	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.success_page);
	}	
}
