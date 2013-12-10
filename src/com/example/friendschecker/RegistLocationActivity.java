package com.example.friendschecker;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistLocationActivity extends Activity{
	
    //SQLiteDatabase�̒�`        
	CreateProductHelper helper = null;    
	SQLiteDatabase db = null;       
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.regist_location);	
		
		// �{�^���̎w��                
		Button registButton = (Button) findViewById(R.id.register);
		
		registLocationClickListener regLocationClickListerner = new registLocationClickListener();                
        registButton.setOnClickListener(regLocationClickListerner);
        
        // DB�쐬   
        helper = new CreateProductHelper(RegistLocationActivity.this);    
	}
	
    class registLocationClickListener implements OnClickListener {                
    	public void onClick(View v) {
    		 db = helper.getWritableDatabase();
    		 
    		 //�l�̎擾
    		 try{
	    		 EditText latText = (EditText) findViewById(R.id.lat_text);
	    		 EditText longitText = (EditText) findViewById(R.id.longit_text);
	    		 
	             String lat = latText.getText().toString();
	             String longit = longitText.getText().toString();
	             String insertSQL = "insert into mapList(lat,longit)values('" + 
	             lat + "','"+ longit + "')";
	             
	             //SQL�̎��s
	             db.execSQL(insertSQL);
	             
	             //�m�F
                 String registLatMessage = "�ܓx"+lat;  
                 Toast.makeText(RegistLocationActivity.this,
                 		registLatMessage, Toast.LENGTH_SHORT).show();
                 String registLongitMessage = "�o�x"+longit;  
                 Toast.makeText(RegistLocationActivity.this,
                 		registLongitMessage, Toast.LENGTH_SHORT).show();
    		 }catch(Exception e){
    			  String failMessage = "���s�p�^�[��";
                  Toast.makeText(RegistLocationActivity.this,
                		  failMessage, Toast.LENGTH_SHORT).show();
    		 }finally{
    			 db.close();
    		 }
    	}
    }
}
