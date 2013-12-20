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
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_location);
		
	    TableLayout tableLayout = (TableLayout) findViewById(R.id.list);
	    tableLayout.removeAllViews();
	    
	    /**
	     * これより画面（Activity）で表示する緯度・経度の表示用テーブルを作成する。
	     */
	    
	    
	    //ヘッダーに追加する行の宣言
        TableRow headerRow = new TableRow(SearchLocationActivity.this);

        // ID（ヘッダー）
        TextView headerID = new TextView(SearchLocationActivity.this);
        headerID.setText("ID");
        headerID.setBackgroundColor(Color.rgb(51, 153, 102));
        headerID.setTextSize(12.0f);
        headerID.setWidth(40);

        // 緯度（ヘッダー）
        TextView headerLat = new TextView(SearchLocationActivity.this);
        headerLat.setText("緯度");
        headerLat.setBackgroundColor(Color.rgb(51, 153, 102));
        headerLat.setTextSize(12.0f);
        headerLat.setWidth(200);

        // 経度（ヘッダー）
        TextView headerLongit = new TextView(SearchLocationActivity.this);
        headerLongit.setText("経度");
        headerLongit.setBackgroundColor(Color.rgb(51, 153, 102));
        headerLongit.setTextSize(12.0f);
        headerLongit.setWidth(200);

        // ヘッダーに各行を追加
        headerRow.addView(headerID);
        headerRow.addView(headerLat);
        headerRow.addView(headerLongit);
        tableLayout.addView(headerRow);        
        
        
        /**
         * 以下、DBに格納されているデータを出力する。
         */
        
        Context con = SearchLocationActivity.this;
        SearchLocationDao searchLocationDao = new SearchLocationDao(); 
        List<LocationDataEntity> locList =  searchLocationDao.searchDB(con);
        
        //行を縞々にするための変数
        int rowColor = 0;
                
        if(locList != null){
            
          //拡張For文でDBから取得したデータを取り出す
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
                
                //MapIDのデータをセット
                lineMapID.setText(lineMapIDText);
                lineMapID.setBackgroundColor(Color.rgb(51, 153, 102));
                lineMapID.setTextSize(12.0f);
                lineMapID.setWidth(200);
                
                //緯度のデータをセット
                lineLat.setText(lineLatText);
                lineLat.setBackgroundColor(Color.rgb(51, 153, 102));
                lineLat.setTextSize(12.0f);
                lineLat.setWidth(200);
                
                //経度のデータをセット
                lineLongit.setText(lineLongitText);
                lineLongit.setBackgroundColor(Color.rgb(51, 153, 102));
                lineLongit.setTextSize(12.0f);
                lineLongit.setWidth(200);       
                
                
                if(rowColor%2 == 0){
                	lineRow.setBackgroundColor(Color.rgb(204,255,204));
                }
                //次の行の色を変えるためプラス1する。
                rowColor = rowColor + 1;
                
                // MapID、緯度、経度を一行として追加
                lineRow.addView(lineMapID);
                lineRow.addView(lineLat);
                lineRow.addView(lineLongit);
                tableLayout.addView(lineRow);    
            }
        } 
	}
}
