package com.example.friendschecker;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.dao.RegistLocationDao;

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
    	    /**
    	     * �e�L�X�g�{�b�N�X����o�x�A�ܓx���擾
    	     */
    	    EditText latText = (EditText) findViewById(R.id.lat_text);
	    	EditText longitText = (EditText) findViewById(R.id.longit_text);
	    	
	    	/**
	    	 * DB�ɐڑ����A�o�x�E�ܓx�̓o�^���s���B
	    	 */
	    	RegistLocationDao regLocationDao = new RegistLocationDao();
	    	
	    	//�ܓx�E�o�x�̒l���e�L�X�g��String��Int�ɕϊ�
	    	int lat = Integer.parseInt(latText.getText().toString());
	    	int longit = Integer.parseInt(longitText.getText().toString());
	    	Context context = RegistLocationActivity.this;
	    	regLocationDao.registDB(lat, longit,context);
	    	
    	}
    }
}
