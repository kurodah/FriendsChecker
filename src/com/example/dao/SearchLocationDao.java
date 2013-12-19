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
    	
    	//DBからのlat、longitを格納する変数
    	int lat;
    	int longit;
    	
        // Testデータ
        List<LocationDataEntity> locList = null;
   
        try {
        		
        	//DB使用の準備
        	db = helper.getWritableDatabase();
        		
        	//SQL文の準備と実行
        	String locationSQL = "Select * from  mapList";
        	c = db.rawQuery(locationSQL, null);
        		
        	while (c.moveToNext()) {				
        	    
                if (locList == null) {
                    locList = new ArrayList<LocationDataEntity>();
                }
        	    
                
                LocationDataEntity locDataEntity = null;
                locDataEntity = new LocationDataEntity();
                
        		//各項目の取得
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
