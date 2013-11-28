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
        // 5. MapView を（アプリケーションID渡しで）生成し、
        // getMapController() で取得した MapController で、表示位置などの設定をする
        MapView mapView = new MapView(this, APP_ID);
        MapController c = mapView.getMapController();
        c.setCenter(new GeoPoint(35632385, 139881695)); // 初期表示の地図を指定
        c.setZoom(3); // 初期表示の縮尺を指定
        mapView.setMapType(mapView.MapTypeSatellite); // 航空写真表示（オプショナル）
        // 6. MapActivity に MapView を設定し、表示させる
        setContentView(mapView);
    }
    // 4. MapActivity.isRouteDisplayed をオーバーライドする
    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
}