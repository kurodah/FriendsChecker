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
		  Button playGameButton=(Button)findViewById(R.id.playGame_button);
		  Button mapButton=(Button)findViewById(R.id.map_button);
		  
		  //�o�^���j���[�փ{�^���������ꂽ�ꍇ�̏���
		  playGameButton.setOnClickListener(new View.OnClickListener() {
			  @Override
			  public void onClick(View v) {
					// �C���e���g�̃C���X�^���X����
					Intent intentGameMenu = new Intent(MainActivity.this, CheckFriendsActivity.class);
					// �o�^���j���[�̃A�N�e�B�r�e�B�N��
					startActivity(intentGameMenu);
			  }
		  });
		  
		  //�o�^���j���[�փ{�^���������ꂽ�ꍇ�̏���
		  mapButton.setOnClickListener(new View.OnClickListener() {
			  @Override
			  public void onClick(View v) {
					// �C���e���g�̃C���X�^���X����
					Intent intentMapMenu = new Intent(MainActivity.this, UseMapActivity.class);
					// �o�^���j���[�̃A�N�e�B�r�e�B�N��
					startActivity(intentMapMenu);
			  }
		  });		  
		  
		  
	}	
}
