package com.example.friendschecker;

import java.util.ArrayList;
import java.util.List;

import jp.co.yahoo.android.maps.GeoPoint;
import jp.co.yahoo.android.maps.MapActivity;
import jp.co.yahoo.android.maps.MapView;
import jp.co.yahoo.android.maps.MyLocationOverlay;
import jp.co.yahoo.android.maps.OverlayItem;
import jp.co.yahoo.android.maps.PinOverlay;
import jp.co.yahoo.android.maps.PopupOverlay;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;


public class UseMapActivity extends MapActivity  {
    private static final String APP_ID = "dj0zaiZpPTF6aDVrN2FzMHFQWCZzPWNvbnN1bWVyc2VjcmV0Jng9MTk-";
    private MyLocationOverlay myLocation;
    SQLiteDatabase db = null;	
    CreateProductHelper helper = null;
    int lat;
    int longit;
    int searchLat;
    int searchLongit;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // YahooIDの受け渡し
        final MapView mapView = new MapView(this, APP_ID);
        
        //ピンを立てる処理
        GeoPoint mid = new GeoPoint(35665721, 139731006);
        setContentView(mapView);
        PinOverlay pinOverlay = new PinOverlay(PinOverlay.PIN_VIOLET);
        mapView.getOverlays().add(pinOverlay);
        pinOverlay.addPoint(mid,null);
        
        //ズームコントロール
        mapView.setBuiltInZoomControls(true);
        
        //ピンをつける 
        mapView.setLongPress(true);

        //MapController c = mapView.getMapController();
        //c.setCenter(mid);
        //c.setCenter(new GeoPoint(35632385, 139881695)); // 初期表示の地図を指定
        //c.setZoom(3); // 初期表示の縮尺を指定
        //自分の位置の取得
        myLocation = new MyLocationOverlay(getApplicationContext(), mapView);
        
        myLocation.enableMyLocation();
        
        myLocation.runOnFirstFix(new Runnable(){
            public void run() {
                if (mapView.getMapController() != null) {
                    //現在位置を取得
                    GeoPoint p = myLocation.getMyLocation();
                    //地図移動
                    mapView.getMapController().animateTo(p);
                    
                    lat = p.getLatitudeE6();
                    longit = p.getLongitudeE6();
                    
                    //トーストする
                    String mapMessage = "緯度" +lat + "経度" + longit;  
                    Toast.makeText(UseMapActivity.this,
                    		mapMessage, Toast.LENGTH_SHORT).show();
                    
                    try{
                    	helper = new CreateProductHelper(UseMapActivity.this);	
                    	db = helper.getWritableDatabase();
                    	String insertSQL = "insert into mapList(lat,longit)"+
            			"values('" + lat + "','" + longit + "')";
                    	db.execSQL(insertSQL);
                        String registMessage = "成功";  
                        Toast.makeText(UseMapActivity.this,
                        		registMessage, Toast.LENGTH_SHORT).show();
                    }catch(Exception e){
                        String errorMessage = "DB登録エラー";  
                        Toast.makeText(UseMapActivity.this,
                        		errorMessage, Toast.LENGTH_SHORT).show();
                    }
                    
                    try{
                    	helper = new CreateProductHelper(UseMapActivity.this);	
                    	db = helper.getWritableDatabase();
                    	Cursor c = null;
            			String searchResultSQL = "select * from mapList";
            			c = db.rawQuery(searchResultSQL, null);
            			
            			
            			String searchMessage = "";
                        Toast.makeText(UseMapActivity.this,
                        		searchMessage, Toast.LENGTH_SHORT).show();
                        searchLat =  c.getInt(c.getColumnIndex("lat"));
                        searchLongit = c.getInt(c.getColumnIndex("longit"));
              
                    }catch(Exception e){
                        String errorMessage = "DB検索エラー";  
                        Toast.makeText(UseMapActivity.this,
                        		errorMessage, Toast.LENGTH_SHORT).show();
                    }  
              }
            }
        });
                
        mapView.getOverlays().add(myLocation);

        //地図の種類変更
        List<String> style=new ArrayList<String>();
        style.add("off:landmark");
        style.add("on:store");
        style.add("off:line_name");
        mapView .setMapType(mapView.MapTypeStyle,"base:standard",style);
        
        
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
        
    // MapActivity.isRouteDisplayed をオーバーライドする
    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
}