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
        // 5. MapView ���i�A�v���P�[�V����ID�n���Łj�������A
        // getMapController() �Ŏ擾���� MapController �ŁA�\���ʒu�Ȃǂ̐ݒ������
        final MapView mapView = new MapView(this, APP_ID);
        
        //�s���𗧂Ă鏈��
        GeoPoint mid = new GeoPoint(35665721, 139731006);
        setContentView(mapView);
        PinOverlay pinOverlay = new PinOverlay(PinOverlay.PIN_VIOLET);
        mapView.getOverlays().add(pinOverlay);
        pinOverlay.addPoint(mid,null);
        //MapController c = mapView.getMapController();
        //c.setCenter(mid);
        //c.setCenter(new GeoPoint(35632385, 139881695)); // �����\���̒n�}���w��
        //c.setZoom(3); // �����\���̏k�ڂ��w��
        //�����̈ʒu�̎擾
        //myLocation = new MyLocationOverlay(getApplicationContext(), mapView);
        
        //myLocation.enableMyLocation();
        
        //myLocation.runOnFirstFix(new Runnable(){
            //public void run() {
                //if (mapView.getMapController() != null) {
                    //���݈ʒu���擾
                    //GeoPoint p = myLocation.getMyLocation();
                    //�n�}�ړ�
                    //mapView.getMapController().animateTo(p);
                //}
            //}
        //});
        
        
        //�n�}�̎�ޕύX
        List<String> style=new ArrayList<String>();
        style.add("off:landmark");
        style.add("on:store");
        style.add("off:line_name");
        mapView .setMapType(mapView.MapTypeStyle,"base:standard",style);
        
        //�Y�[���R���g���[��
        mapView.setBuiltInZoomControls(true);
        
        //�s�������� 
        mapView.setLongPress(true);
        
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
        
        
    // 4. MapActivity.isRouteDisplayed ���I�[�o�[���C�h����
    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
}