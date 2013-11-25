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
	
		//�{�^���̓���
		  Button registButton=(Button)findViewById(R.id.checkFriends_button);
		  
		  //�o�^���j���[�փ{�^���������ꂽ�ꍇ�̏���
		  registButton.setOnClickListener(new View.OnClickListener() {
			  @Override
			  public void onClick(View v) {
					// �C���e���g�̃C���X�^���X����
					Intent intentRegistMenu = new Intent(MainActivity.this, CheckFriendsActivity.class);
					// �o�^���j���[�̃A�N�e�B�r�e�B�N��
					startActivity(intentRegistMenu);
			  }
		  });
		  
	}	
}
