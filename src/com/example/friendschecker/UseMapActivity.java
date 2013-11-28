package com.example.friendschecker;


import java.util.ArrayList;
import java.util.List;

import jp.co.yahoo.android.maps.GeoPoint;
import jp.co.yahoo.android.maps.MapActivity;
import jp.co.yahoo.android.maps.MapController;
import jp.co.yahoo.android.maps.MapView;
import jp.co.yahoo.android.maps.MyLocationOverlay;
import jp.co.yahoo.android.maps.OverlayItem;
import jp.co.yahoo.android.maps.PinOverlay;
import jp.co.yahoo.android.maps.PopupOverlay;
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
    private MyLocationOverlay myLocation;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 5. MapView を（アプリケーションID渡しで）生成し、
        // getMapController() で取得した MapController で、表示位置などの設定をする
        final MapView mapView = new MapView(this, APP_ID);
        
        //ピンを立てる処理
        GeoPoint mid = new GeoPoint(35665721, 139731006);
        setContentView(mapView);
        PinOverlay pinOverlay = new PinOverlay(PinOverlay.PIN_VIOLET);
        mapView.getOverlays().add(pinOverlay);
        pinOverlay.addPoint(mid,null);
        //MapController c = mapView.getMapController();
        //c.setCenter(mid);
        //c.setCenter(new GeoPoint(35632385, 139881695)); // 初期表示の地図を指定
        //c.setZoom(3); // 初期表示の縮尺を指定
        //自分の位置の取得
        //myLocation = new MyLocationOverlay(getApplicationContext(), mapView);
        
        //myLocation.enableMyLocation();
        
        //myLocation.runOnFirstFix(new Runnable(){
            //public void run() {
                //if (mapView.getMapController() != null) {
                    //現在位置を取得
                    //GeoPoint p = myLocation.getMyLocation();
                    //地図移動
                    //mapView.getMapController().animateTo(p);
                //}
            //}
        //});
        
        
        //地図の種類変更
        List<String> style=new ArrayList<String>();
        style.add("off:landmark");
        style.add("on:store");
        style.add("off:line_name");
        mapView .setMapType(mapView.MapTypeStyle,"base:standard",style);
        
        //ズームコントロール
        mapView.setBuiltInZoomControls(true);
        
        //ピンをつける 
        mapView.setLongPress(true);
        
        //ポップアップの処理
        PopupOverlay popupOverlay = new PopupOverlay(){
            @Override
            public void onTap(OverlayItem item){
              //ポップアップをタッチした際の処理
            }
          };
          mapView.getOverlays().add(popupOverlay);
          pinOverlay.setOnFocusChangeListener(popupOverlay);
          pinOverlay.addPoint(mid,"石志水産","行きつけの居酒屋");
        
    }
        
        
    // 4. MapActivity.isRouteDisplayed をオーバーライドする
    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
}