package com.example.friendschecker;

import java.util.ArrayList;
import java.util.List;

import com.example.dao.RegistLocationDao;

import jp.co.yahoo.android.maps.GeoPoint;
import jp.co.yahoo.android.maps.MapActivity;
import jp.co.yahoo.android.maps.MapView;
import jp.co.yahoo.android.maps.MyLocationOverlay;
import jp.co.yahoo.android.maps.OverlayItem;
import jp.co.yahoo.android.maps.PinOverlay;
import jp.co.yahoo.android.maps.PopupOverlay;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class UseMapActivity extends MapActivity {
	private static final String APP_ID = "dj0zaiZpPTF6aDVrN2FzMHFQWCZzPWNvbnN1bWVyc2VjcmV0Jng9MTk-";
	private MyLocationOverlay myLocation;
	SQLiteDatabase db = null;
	CreateProductHelper helper = null;
	int lat;
	int longit;

	int searchLat;
	int searchLongit;
	Context con = UseMapActivity.this;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// バーを出す
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		setTheme(android.R.style.Theme_Black_NoTitleBar);

		// YahooIDの受け渡し
		final MapView mapView = new MapView(this, APP_ID);

		// ピンを立てる処理
		GeoPoint mid = new GeoPoint(35665721, 139731006);
		setContentView(mapView);
		PinOverlay pinOverlay = new PinOverlay(PinOverlay.PIN_VIOLET);
		mapView.getOverlays().add(pinOverlay);
		pinOverlay.addPoint(mid, null);

		// ズームコントロール
		mapView.setBuiltInZoomControls(true);

		// ピンをつける
		mapView.setLongPress(true);

		// MapController c = mapView.getMapController();
		// c.setCenter(mid);
		// c.setCenter(new GeoPoint(35632385, 139881695)); // 初期表示の地図を指定
		// c.setZoom(3); // 初期表示の縮尺を指定
		// 自分の位置の取得
		myLocation = new MyLocationOverlay(getApplicationContext(), mapView);

		myLocation.enableMyLocation();

		myLocation.runOnFirstFix(new Runnable() {
			public void run() {
				if (mapView.getMapController() != null) {
					// 現在位置を取得
					GeoPoint p = myLocation.getMyLocation();
					// 地図移動
					mapView.getMapController().animateTo(p);

					lat = p.getLatitudeE6();
					longit = p.getLongitudeE6();
					RegistLocationDao regLocationDao = new RegistLocationDao();
					regLocationDao.registDB(lat, longit, con);
				}
			}
		});

		mapView.getOverlays().add(myLocation);

		// 地図の種類変更
		List<String> style = new ArrayList<String>();
		style.add("off:landmark");
		style.add("on:store");
		style.add("off:line_name");
		mapView.setMapType(mapView.MapTypeStyle, "base:standard", style);

		// ポップアップの処理
		PopupOverlay popupOverlay = new PopupOverlay() {
			@Override
			public void onTap(OverlayItem item) {
				// ポップアップをタッチした際の処理
			}
		};
		mapView.getOverlays().add(popupOverlay);
		pinOverlay.setOnFocusChangeListener(popupOverlay);
		pinOverlay.addPoint(mid, "石志水産", "行きつけの居酒屋");
	}

	// MapActivity.isRouteDisplayed をオーバーライドする
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

	// メニュー項目の作成
	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// メニューの要素を追加
	// menu.add("位置を記録する");
	// メニューの要素を追加して取得
	// MenuItem actionItem = menu.add("Action Button");
	// SHOW_AS_ACTION_IF_ROOM:余裕があれば表示
	// actionItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
	// アイコンを設定
	// actionItem.setIcon(android.R.drawable.ic_menu_share);
	// return true;
	// }

	// @Override
	// public boolean onOptionsItemSelected(MenuItem item) {
	// final EditText editView = new EditText(UseMapActivity.this);
	// new AlertDialog.Builder(UseMapActivity.this).setTitle("テキスト入力ダイアログ")
	// .setView(editView);
	// return true;
	// }
}