package com.example.friendschecker;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR); 
		setContentView(R.layout.main_menu);
		setTheme(android.R.style.Theme_Black_NoTitleBar); 
		Button registButton=(Button)findViewById(R.id.regist_button);
		Button searchButton=(Button)findViewById(R.id.search_button);
		
	    //�o�^�{�^���������ꂽ�ꍇ�̏���
        registButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  // �C���e���g�̃C���X�^���X����
                  Intent intentRegistMenu = new Intent(MainActivity.this, RegistLocationActivity.class);
                  // ���C�����j���[�̃A�N�e�B�r�e�B�N��
                  startActivity(intentRegistMenu);
            }
        });
        
        //�����{�^���������ꂽ�ꍇ�̏���
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  // �C���e���g�̃C���X�^���X����
                  Intent intentRegistMenu = new Intent(MainActivity.this, SearchLocationActivity.class);
                  // ���C�����j���[�̃A�N�e�B�r�e�B�N��
                  startActivity(intentRegistMenu);
            }
        });
		
	}	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {     
		// ���j���[�̗v�f��ǉ�    
		menu.add("�Q�[��������");   
		menu.add("�n�}���g��");   
		menu.add("���W�̊m�F");   
		menu.add("���W�̓o�^"); 
		menu.add("�e�X�g");   
		// ���j���[�̗v�f��ǉ����Ď擾     
		MenuItem actionItem = menu.add("Action Button");      
		// SHOW_AS_ACTION_IF_ROOM:�]�T������Ε\��     
		actionItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		// �A�C�R����ݒ�    
		actionItem.setIcon(android.R.drawable.ic_menu_share);  
		return true; 
	}
		
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {     
	
		if(item.getTitle()=="�e�X�g"){
        	InputBox("���͂��Ă��������B", "�e�L�X�g����");
        	return true; 
		}
		
		if(item.getTitle()=="�Q�[��������"){
			Intent intentGameMenu = new Intent(MainActivity.this, CheckFriendsActivity.class);
			// �o�^���j���[�̃A�N�e�B�r�e�B�N��
			startActivity(intentGameMenu);
			return true; 	
		}
		
		if(item.getTitle()=="�n�}���g��"){
			// �C���e���g�̃C���X�^���X����
			Intent intentMapMenu = new Intent(MainActivity.this, UseMapActivity.class);
			// Map���j���[�̃A�N�e�B�r�e�B�N��
			startActivity(intentMapMenu);
			return true; 	
		}
		
		if(item.getTitle()=="���W�̊m�F"){
			Intent intentSearchLocation = new Intent(MainActivity.this, SearchLocationActivity.class);
			// �o�^���j���[�̃A�N�e�B�r�e�B�N��
			startActivity(intentSearchLocation);
			return true; 	
		}
		
		if(item.getTitle()=="���W�̓o�^"){
			// �C���e���g�̃C���X�^���X����
			Intent intentRegistLocation = new Intent(MainActivity.this, RegistLocationActivity.class);
			// �o�^���j���[�̃A�N�e�B�r�e�B�N��
			startActivity(intentRegistLocation);
			return true; 	
		}
		return true; 
	} 
	
	//���̓_�C�A���O�̍쐬
	void InputBox(String message, String title) {
		final EditText editText = new EditText(MainActivity.this);
		AlertDialog.Builder alertDialog=new AlertDialog.Builder(MainActivity.this);
	    alertDialog.setTitle(title);
	    alertDialog.setMessage(message);
	    alertDialog.setView(editText);
	    alertDialog.setIcon(android.R.drawable.ic_dialog_info);
	    alertDialog.setPositiveButton("OK",new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog,int whichButton) {
	        	String input = editText.getText().toString();
	        	Toast.makeText(MainActivity.this, input, Toast.LENGTH_LONG).show();
	        }
	    });
	    alertDialog.create();
	    alertDialog.show();
	}
}
