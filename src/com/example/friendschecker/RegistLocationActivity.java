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

public class RegistLocationActivity extends Activity {

	// SQLiteDatabaseの定義
	CreateProductHelper helper = null;
	SQLiteDatabase db = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.regist_location);

		// ボタンの指定
		Button registButton = (Button) findViewById(R.id.register);

		registLocationClickListener regLocationClickListerner = new registLocationClickListener();
		registButton.setOnClickListener(regLocationClickListerner);

		// DB作成
		helper = new CreateProductHelper(RegistLocationActivity.this);
	}

	class registLocationClickListener implements OnClickListener {
		public void onClick(View v) {
			/**
			 * テキストボックスから経度、緯度を取得
			 */
			EditText latText = (EditText) findViewById(R.id.lat_text);
			EditText longitText = (EditText) findViewById(R.id.longit_text);

			/**
			 * DBに接続し、経度・緯度の登録を行う。
			 */
			RegistLocationDao regLocationDao = new RegistLocationDao();

			// 緯度・経度の値をテキスト→String→Intに変換
			int lat = Integer.parseInt(latText.getText().toString());
			int longit = Integer.parseInt(longitText.getText().toString());
			Context context = RegistLocationActivity.this;
			regLocationDao.registDB(lat, longit, context);

		}
	}
}