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

public class FailActivity extends Activity {
	
	public void onStart() {
		super.onStart();
		EasyTracker.getInstance(getApplicationContext()).activityStart(this);
		
		//サイト名の記述
		Tracker easyTracker = EasyTracker.getInstance(this);
		easyTracker.set(Fields.SCREEN_NAME, "失敗ページ");
		easyTracker.send(MapBuilder
			    .createAppView()
			    .build());

		easyTracker.send(MapBuilder.
					createTransaction("0_123456","In-app Store",
							2.16d,0.17d,0.0d,"USD").build()
		);
	
		easyTracker.send(MapBuilder.
				createItem("0_123456",
						"Level Pack: Space",
						"L_789",
						"Game expansions", 
						1.99d,
						1L,
						 "USD")
				.build()
			);
	}		
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fail_page);
	}	
}
