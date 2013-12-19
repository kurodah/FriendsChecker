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

		// �o�[���o��
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		setTheme(android.R.style.Theme_Black_NoTitleBar);

		// YahooID�̎󂯓n��
		final MapView mapView = new MapView(this, APP_ID);

		// �s���𗧂Ă鏈��
		GeoPoint mid = new GeoPoint(35665721, 139731006);
		setContentView(mapView);
		PinOverlay pinOverlay = new PinOverlay(PinOverlay.PIN_VIOLET);
		mapView.getOverlays().add(pinOverlay);
		pinOverlay.addPoint(mid, null);

		// �Y�[���R���g���[��
		mapView.setBuiltInZoomControls(true);

		// �s��������
		mapView.setLongPress(true);

		// MapController c = mapView.getMapController();
		// c.setCenter(mid);
		// c.setCenter(new GeoPoint(35632385, 139881695)); // �����\���̒n�}���w��
		// c.setZoom(3); // �����\���̏k�ڂ��w��
		// �����̈ʒu�̎擾
		myLocation = new MyLocationOverlay(getApplicationContext(), mapView);

		myLocation.enableMyLocation();

		myLocation.runOnFirstFix(new Runnable() {
			public void run() {
				if (mapView.getMapController() != null) {
					// ���݈ʒu���擾
					GeoPoint p = myLocation.getMyLocation();
					// �n�}�ړ�
					mapView.getMapController().animateTo(p);

					lat = p.getLatitudeE6();
					longit = p.getLongitudeE6();
					RegistLocationDao regLocationDao = new RegistLocationDao();
					regLocationDao.registDB(lat,longit,con);
				}
			}
		});

		mapView.getOverlays().add(myLocation);

		// �n�}�̎�ޕύX
		List<String> style = new ArrayList<String>();
		style.add("off:landmark");
		style.add("on:store");
		style.add("off:line_name");
		mapView.setMapType(mapView.MapTypeStyle, "base:standard", style);

		// �|�b�v�A�b�v�̏���
		PopupOverlay popupOverlay = new PopupOverlay() {
			@Override
			public void onTap(OverlayItem item) {
				// �|�b�v�A�b�v���^�b�`�����ۂ̏���
			}
		};
		mapView.getOverlays().add(popupOverlay);
		pinOverlay.setOnFocusChangeListener(popupOverlay);
		pinOverlay.addPoint(mid, "�Ύu���Y", "�s�����̋�����");
	}

	// MapActivity.isRouteDisplayed ���I�[�o�[���C�h����
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

	// ���j���[���ڂ̍쐬
	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// ���j���[�̗v�f��ǉ�
	// menu.add("�ʒu���L�^����");
	// ���j���[�̗v�f��ǉ����Ď擾
	// MenuItem actionItem = menu.add("Action Button");
	// SHOW_AS_ACTION_IF_ROOM:�]�T������Ε\��
	// actionItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
	// �A�C�R����ݒ�
	// actionItem.setIcon(android.R.drawable.ic_menu_share);
	// return true;
	// }

	// @Override
	// public boolean onOptionsItemSelected(MenuItem item) {
	// final EditText editView = new EditText(UseMapActivity.this);
	// new AlertDialog.Builder(UseMapActivity.this).setTitle("�e�L�X�g���̓_�C�A���O")
	// .setView(editView);
	// return true;
	// }
}