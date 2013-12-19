package com.example.dao;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.friendschecker.CreateProductHelper;

/**
 *���W��o�^���邽�߂ɕK�v��DAO�N���X
 */

public class RegistLocationDao extends Activity{
    
    public void registDB(int lat,int longit,Context con){
        
        CreateProductHelper helper = null;
        SQLiteDatabase db = null;
        helper = new CreateProductHelper(con);
        db = helper.getWritableDatabase();
                
        //�l�̎擾
        try{        
            String insertSQL = "insert into mapList(lat,longit)values('" + 
            lat + "','"+ longit + "')";
            
            //SQL�̎��s
            db.execSQL(insertSQL);
            
            //�m�F         
            String registLatMessage = "�ܓx"+lat;  
            Toast.makeText(con,
                   registLatMessage, Toast.LENGTH_SHORT).show();
            String registLongitMessage = "�o�x"+longit;  
            Toast.makeText(con,
                   registLongitMessage, Toast.LENGTH_SHORT).show();
        }catch(Exception e){
             String failMessage = "���s�p�^�[��";
             Toast.makeText(getApplicationContext(),
                     failMessage, Toast.LENGTH_SHORT).show();
        }finally{
            db.close();
        }
    }

}
