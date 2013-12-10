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
        // YahooID�̎󂯓n��
        final MapView mapView = new MapView(this, APP_ID);
        
        //�s���𗧂Ă鏈��
        GeoPoint mid = new GeoPoint(35665721, 139731006);
        setContentView(mapView);
        PinOverlay pinOverlay = new PinOverlay(PinOverlay.PIN_VIOLET);
        mapView.getOverlays().add(pinOverlay);
        pinOverlay.addPoint(mid,null);
        
        //�Y�[���R���g���[��
        mapView.setBuiltInZoomControls(true);
        
        //�s�������� 
        mapView.setLongPress(true);

        //MapController c = mapView.getMapController();
        //c.setCenter(mid);
        //c.setCenter(new GeoPoint(35632385, 139881695)); // �����\���̒n�}���w��
        //c.setZoom(3); // �����\���̏k�ڂ��w��
        //�����̈ʒu�̎擾
        myLocation = new MyLocationOverlay(getApplicationContext(), mapView);
        
        myLocation.enableMyLocation();
        
        myLocation.runOnFirstFix(new Runnable(){
            public void run() {
                if (mapView.getMapController() != null) {
                    //���݈ʒu���擾
                    GeoPoint p = myLocation.getMyLocation();
                    //�n�}�ړ�
                    mapView.getMapController().animateTo(p);
                    
                    lat = p.getLatitudeE6();
                    longit = p.getLongitudeE6();
                    
                    //�g�[�X�g����
                    String mapMessage = "�ܓx" +lat + "�o�x" + longit;  
                    Toast.makeText(UseMapActivity.this,
                    		mapMessage, Toast.LENGTH_SHORT).show();
                    
                    try{
                    	helper = new CreateProductHelper(UseMapActivity.this);	
                    	db = helper.getWritableDatabase();
                    	String insertSQL = "insert into mapList(lat,longit)"+
            			"values('" + lat + "','" + longit + "')";
                    	db.execSQL(insertSQL);
                        String registMessage = "����";  
                        Toast.makeText(UseMapActivity.this,
                        		registMessage, Toast.LENGTH_SHORT).show();
                    }catch(Exception e){
                        String errorMessage = "DB�o�^�G���[";  
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
                        String errorMessage = "DB�����G���[";  
                        Toast.makeText(UseMapActivity.this,
                        		errorMessage, Toast.LENGTH_SHORT).show();
                    }  
              }
            }
        });
                
        mapView.getOverlays().add(myLocation);

        //�n�}�̎�ޕύX
        List<String> style=new ArrayList<String>();
        style.add("off:landmark");
        style.add("on:store");
        style.add("off:line_name");
        mapView .setMapType(mapView.MapTypeStyle,"base:standard",style);
        
        
        //�|�b�v�A�b�v�̏���
        PopupOverlay popupOverlay = new PopupOverlay(){
            @Override
            public void onTap(OverlayItem item){
              //�|�b�v�A�b�v���^�b�`�����ۂ̏���
            }
          };
        mapView.getOverlays().add(popupOverlay);
        pinOverlay.setOnFocusChangeListener(popupOverlay);
        pinOverlay.addPoint(mid,"�Ύu���Y","�s�����̋�����");
    }
        
    // MapActivity.isRouteDisplayed ���I�[�o�[���C�h����
    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
}