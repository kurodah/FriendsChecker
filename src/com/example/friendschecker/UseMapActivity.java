package com.example.friendschecker;


import jp.co.yahoo.android.maps.GeoPoint;
import jp.co.yahoo.android.maps.MapActivity;
import jp.co.yahoo.android.maps.MapController;
import jp.co.yahoo.android.maps.MapView;
import jp.co.yahoo.android.maps.PinOverlay;
import jp.co.yahoo.android.maps.routing.RouteOverlay;
import jp.co.yahoo.android.maps.routing.RouteOverlay.RouteOverlayListener;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.location.*;
import android.os.Bundle;
import android.view.*;
import android.view.ViewGroup.*;
import android.widget.*;

public class UseMapActivity extends MapActivity  {
    private static final String APP_ID = "dj0zaiZpPTF6aDVrN2FzMHFQWCZzPWNvbnN1bWVyc2VjcmV0Jng9MTk-";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 5. MapView ���i�A�v���P�[�V����ID�n���Łj�������A
        // getMapController() �Ŏ擾���� MapController �ŁA�\���ʒu�Ȃǂ̐ݒ������
        MapView mapView = new MapView(this, APP_ID);
        MapController c = mapView.getMapController();
        c.setCenter(new GeoPoint(35632385, 139881695)); // �����\���̒n�}���w��
        c.setZoom(3); // �����\���̏k�ڂ��w��
        mapView.setMapType(mapView.MapTypeSatellite); // �q��ʐ^�\���i�I�v�V���i���j
        // 6. MapActivity �� MapView ��ݒ肵�A�\��������
        setContentView(mapView);
    }
    // 4. MapActivity.isRouteDisplayed ���I�[�o�[���C�h����
    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
}