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
		  mTracker = GoogleAnalytics.getInstance(this).getTracker(GA_PROPERTY_ID); 	
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.friends_check);
		  
		  
		//�{�^���̓���
		  Button backMenuButton=(Button)findViewById(R.id.backMenu_button);
		  Button successRouteButton=(Button)findViewById(R.id.success_button);
		  Button failRouteButton=(Button)findViewById(R.id.fail_button);
		  
		  
		  
		  //���C�����j���[�փ{�^���������ꂽ�ꍇ�̏���
		  backMenuButton.setOnClickListener(new View.OnClickListener() {
			  @Override
			  public void onClick(View v) {
					// �C���e���g�̃C���X�^���X����
					Intent intentMainMenu = new Intent(CheckFriendsActivity.this, MainActivity.class);
					// ���C�����j���[�̃A�N�e�B�r�e�B�N��
					startActivity(intentMainMenu);
			  }
		  });
		    
		  
		  //���[�g1�{�^���������ꂽ�ꍇ�̏���
		  successRouteButton.setOnClickListener(new View.OnClickListener() {
			  @Override
			  public void onClick(View v) {			    
				    mTracker.send(MapBuilder
				    		.createEvent("�{�^���̑I��", "���[�g1�̎��s", "�{�^��", null) 
				    		.set(Fields.SESSION_CONTROL, "start") 
				    		.build()
				    ); 
				  
					// �C���e���g�̃C���X�^���X����
					Intent intentSuccessMenu = new Intent(CheckFriendsActivity.this, SuccessActivity.class);
					// �o�^���j���[�̃A�N�e�B�r�e�B�N��
					startActivity(intentSuccessMenu); 
			  }
		  });

				   		  
		  //���[�g2�{�^���������ꂽ�ꍇ�̏���
		  failRouteButton.setOnClickListener(new View.OnClickListener() {
			  @Override
			  public void onClick(View v) {
					// �C���e���g�̃C���X�^���X����
					Intent intentFailMenu = new Intent(CheckFriendsActivity.this, FailActivity.class);
					// �o�^���j���[�̃A�N�e�B�r�e�B�N��
					startActivity(intentFailMenu);
			  }
		  });		
	}		
}
	