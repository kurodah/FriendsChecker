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
		
		//�T�C�g���̋L�q
		Tracker easyTracker = EasyTracker.getInstance(this);
		easyTracker.set(Fields.SCREEN_NAME, "�Ď����Ă邼");
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

		//�{�^���̓���
		  Button backMenuButton=(Button)findViewById(R.id.backMenu_button);
		  
		  //�o�^���j���[�փ{�^���������ꂽ�ꍇ�̏���
		  backMenuButton.setOnClickListener(new View.OnClickListener() {
			  @Override
			  public void onClick(View v) {
					// �C���e���g�̃C���X�^���X����
					Intent intentRegistMenu = new Intent(CheckFriendsActivity.this, MainActivity.class);
					// �o�^���j���[�̃A�N�e�B�r�e�B�N��
					startActivity(intentRegistMenu);
			  }
		  });		
		
	}		
}
	