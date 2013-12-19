package com.example.dao;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.friendschecker.CreateProductHelper;

/**
 *座標を登録するために必要なDAOクラス
 */

public class RegistLocationDao extends Activity{
    
    public void registDB(int lat,int longit,Context con){
        
        CreateProductHelper helper = null;
        SQLiteDatabase db = null;
        helper = new CreateProductHelper(con);
        db = helper.getWritableDatabase();
                
        //値の取得
        try{        
            String insertSQL = "insert into mapList(lat,longit)values('" + 
            lat + "','"+ longit + "')";
            
            //SQLの実行
            db.execSQL(insertSQL);
            
            //確認         
            String registLatMessage = "緯度"+lat;  
            Toast.makeText(con,
                   registLatMessage, Toast.LENGTH_SHORT).show();
            String registLongitMessage = "経度"+longit;  
            Toast.makeText(con,
                   registLongitMessage, Toast.LENGTH_SHORT).show();
        }catch(Exception e){
             String failMessage = "失敗パターン";
             Toast.makeText(getApplicationContext(),
                     failMessage, Toast.LENGTH_SHORT).show();
        }finally{
            db.close();
        }
    }

}
