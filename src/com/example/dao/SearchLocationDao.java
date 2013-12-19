package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.entity.LocationDataEntity;
import com.example.friendschecker.CreateProductHelper;

public class SearchLocationDao extends Activity{
    

    public List<LocationDataEntity> searchDB(Context con){
        CreateProductHelper helper = null;
        SQLiteDatabase db = null;
        
    	helper = new CreateProductHelper(con);    
    	db = helper.getWritableDatabase();
    	Cursor c = null;
    	String mapID = null;
    	
    	//DB�����lat�Alongit���i�[����ϐ�
    	int lat;
    	int longit;
    	
        // Test�f�[�^
        List<LocationDataEntity> locList = null;
   
        try {
        		
        	//DB�g�p�̏���
        	db = helper.getWritableDatabase();
        		
        	//SQL���̏����Ǝ��s
        	String locationSQL = "Select * from  mapList";
        	c = db.rawQuery(locationSQL, null);
        		
        	while (c.moveToNext()) {				
        	    
                if (locList == null) {
                    locList = new ArrayList<LocationDataEntity>();
                }
        	    
                
                LocationDataEntity locDataEntity = null;
                locDataEntity = new LocationDataEntity();
                
        		//�e���ڂ̎擾
        		mapID = c.getString(c.getColumnIndex("_id"));
        		lat = c.getInt(c.getColumnIndex("lat"));
        		longit = c.getInt(c.getColumnIndex("longit"));
        		
        		locDataEntity.setMapID(mapID);
        		locDataEntity.setLat(lat);
        		locDataEntity.setLongit(longit);
        		locList.add(locDataEntity);

        	}
        
        } catch (Exception e) {
        
        } finally {
        	if (c != null) {
        		c.close();
        	}
        }
        return locList;
    }
}
