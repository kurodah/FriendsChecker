package com.example.entity;

import java.io.Serializable;

public class LocationDataEntity implements Serializable{
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    
    private String mapID;
    
    private int lat;
    
    private int longit;

	public String getMapID() {
		return mapID;
	}

	public void setMapID(String mapID) {
		this.mapID = mapID;
	}

	public int getLat() {
		return lat;
	}

	public void setLat(int lat) {
		this.lat = lat;
	}

	public int getLongit() {
		return longit;
	}

	public void setLongit(int longit) {
		this.longit = longit;
	}
    
}
