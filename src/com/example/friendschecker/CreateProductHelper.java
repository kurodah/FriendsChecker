package com.example.friendschecker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateProductHelper  extends SQLiteOpenHelper{ 
	// �R���X�g���N�^��`    
	public CreateProductHelper(Context con){  
		// SQLiteOpenHelper�̃R���X�g���N�^�Ăяo��  
		super(con,"friendsDB",null,1);    
	}            
	// onCreate���\�b�h  
	@Override    
	public void onCreate(SQLiteDatabase db) {
		String createTableSql  = "create table mapList(_id integer primary key autoincrement," + "lat int," + "longit int)";                                                                
		// SQL���s              
		db.execSQL(createTableSql); 
	}        
	// onUpgrade���\�b�h   
	@Override    
	public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
		
	}
}
