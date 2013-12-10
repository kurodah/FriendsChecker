package com.example.friendschecker;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class SearchLocationActivity extends Activity {

	CreateProductHelper helper = null;
	SQLiteDatabase db = null;
	public TextView txtInfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_location);
		// Button searchButton = (Button)findViewById(R.id.location_button);
		TableLayout tableLayout = (TableLayout) findViewById(R.id.list);
		tableLayout.removeAllViews();
		helper = new CreateProductHelper(SearchLocationActivity.this);

		db = helper.getWritableDatabase();
		Cursor c = null;
		String mapID = null;
		int lat;
		int longit;
		String latText;
		String longitText;


		try {
			
			//DB使用の準備
			db = helper.getWritableDatabase();
			
			//SQL文の準備と実行
			String locationSQL = "Select * from  mapList";
			c = db.rawQuery(locationSQL, null);
			
			
			//ヘッダーに追加する行の宣言
			TableRow headerRow = new TableRow(SearchLocationActivity.this);

			// ID（ヘッダー）
			TextView headerCheck = new TextView(SearchLocationActivity.this);
			headerCheck.setText("ID");
			headerCheck.setBackgroundColor(Color.rgb(51, 153, 102));
			headerCheck.setTextSize(12.0f);
			headerCheck.setWidth(40);

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
			headerRow.addView(headerCheck);
			headerRow.addView(headerLat);
			headerRow.addView(headerLongit);
			tableLayout.addView(headerRow);			
			
			while (c.moveToNext()) {				
				
				//各項目の取得
				mapID = c.getString(c.getColumnIndex("_id"));
				lat = c.getInt(c.getColumnIndex("lat"));
				longit = c.getInt(c.getColumnIndex("longit"));
				latText = String.valueOf(lat);
				longitText = String.valueOf(longit);
				
				
				String getMAPMessage = "MAPID:"+mapID+latText+longitText;
				Toast.makeText(SearchLocationActivity.this, getMAPMessage,
						Toast.LENGTH_SHORT).show();
				
				
				TableRow itemRow = new TableRow(SearchLocationActivity.this);				
				
				//idの列の追加
				TextView idRow = new TextView(SearchLocationActivity.this);
				idRow.setGravity(Gravity.LEFT);
				idRow.setTextSize(12.0f);
				idRow.setText(mapID);

				//緯度の列の追加
				TextView latRow = new TextView(SearchLocationActivity.this);
				latRow.setGravity(Gravity.LEFT);
				latRow.setTextSize(12.0f);
				latRow.setText(latText);
				
				//経度
				TextView longitRow = new TextView(SearchLocationActivity.this);
				longitRow.setGravity(Gravity.LEFT);
				longitRow.setTextSize(12.0f);
				longitRow.setText(longitText);

				//経度の列の追加
				itemRow.addView(idRow);
				itemRow.addView(latRow);
				itemRow.addView(longitRow);
				tableLayout.addView(itemRow);
				
			}

		} catch (Exception e) {

		} finally {
			if (c != null) {
				c.close();
			}
		}
	}
}
