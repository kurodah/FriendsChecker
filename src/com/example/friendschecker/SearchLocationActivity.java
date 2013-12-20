package com.example.friendschecker;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.dao.SearchLocationDao;
import com.example.entity.LocationDataEntity;

public class SearchLocationActivity extends Activity {
    
	public TextView txtInfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_location);
		
	    TableLayout tableLayout = (TableLayout) findViewById(R.id.list);
	    tableLayout.removeAllViews();
	    
	    /**
	     * �������ʁiActivity�j�ŕ\������ܓx�E�o�x�̕\���p�e�[�u�����쐬����B
	     */
	    
	    
	    //�w�b�_�[�ɒǉ�����s�̐錾
        TableRow headerRow = new TableRow(SearchLocationActivity.this);

        // ID�i�w�b�_�[�j
        TextView headerID = new TextView(SearchLocationActivity.this);
        headerID.setText("ID");
        headerID.setBackgroundColor(Color.rgb(51, 153, 102));
        headerID.setTextSize(12.0f);
        headerID.setWidth(40);

        // �ܓx�i�w�b�_�[�j
        TextView headerLat = new TextView(SearchLocationActivity.this);
        headerLat.setText("�ܓx");
        headerLat.setBackgroundColor(Color.rgb(51, 153, 102));
        headerLat.setTextSize(12.0f);
        headerLat.setWidth(200);

        // �o�x�i�w�b�_�[�j
        TextView headerLongit = new TextView(SearchLocationActivity.this);
        headerLongit.setText("�o�x");
        headerLongit.setBackgroundColor(Color.rgb(51, 153, 102));
        headerLongit.setTextSize(12.0f);
        headerLongit.setWidth(200);

        // �w�b�_�[�Ɋe�s��ǉ�
        headerRow.addView(headerID);
        headerRow.addView(headerLat);
        headerRow.addView(headerLongit);
        tableLayout.addView(headerRow);        
        
        
        /**
         * �ȉ��ADB�Ɋi�[����Ă���f�[�^���o�͂���B
         */
        
        Context con = SearchLocationActivity.this;
        SearchLocationDao searchLocationDao = new SearchLocationDao(); 
        List<LocationDataEntity> locList =  searchLocationDao.searchDB(con);
        
        //�s���ȁX�ɂ��邽�߂̕ϐ�
        int rowColor = 0;
                
        if(locList != null){
            
          //�g��For����DB����擾�����f�[�^�����o��
            for(LocationDataEntity locDataEntity  :locList){
                
                String lineMapIDText;
                String lineLatText;
                String lineLongitText;
                
                TableRow lineRow = new TableRow(SearchLocationActivity.this);
                TextView lineMapID = new TextView(SearchLocationActivity.this);
                TextView lineLat = new TextView(SearchLocationActivity.this);
                TextView lineLongit = new TextView(SearchLocationActivity.this);
                
     
                           
                
                lineMapIDText =locDataEntity.getMapID();
                lineLatText = String.valueOf(locDataEntity.getLat());
                lineLongitText = String.valueOf(locDataEntity.getLongit());
                
                //MapID�̃f�[�^���Z�b�g
                lineMapID.setText(lineMapIDText);
                lineMapID.setBackgroundColor(Color.rgb(51, 153, 102));
                lineMapID.setTextSize(12.0f);
                lineMapID.setWidth(200);
                
                //�ܓx�̃f�[�^���Z�b�g
                lineLat.setText(lineLatText);
                lineLat.setBackgroundColor(Color.rgb(51, 153, 102));
                lineLat.setTextSize(12.0f);
                lineLat.setWidth(200);
                
                //�o�x�̃f�[�^���Z�b�g
                lineLongit.setText(lineLongitText);
                lineLongit.setBackgroundColor(Color.rgb(51, 153, 102));
                lineLongit.setTextSize(12.0f);
                lineLongit.setWidth(200);       
                
                
                if(rowColor%2 == 0){
                	lineRow.setBackgroundColor(Color.rgb(204,255,204));
                }
                //���̍s�̐F��ς��邽�߃v���X1����B
                rowColor = rowColor + 1;
                
                // MapID�A�ܓx�A�o�x����s�Ƃ��Ēǉ�
                lineRow.addView(lineMapID);
                lineRow.addView(lineLat);
                lineRow.addView(lineLongit);
                tableLayout.addView(lineRow);    
            }
        } 
	}
}
