package com.example.isabelmangan.blueprinttravel;

import com.google.android.gms.maps.model.LatLng;

public class Attraction {
    String placeID;
    LatLng placeLatLng;
    Boolean isReq;
    int duration;
    String placeName;

    public Attraction() {

    }
    public Attraction(LatLng placeLatLng, String placeID, int duration, String placeName) {
        setLatLng(placeLatLng);
        setPlaceID(placeID);
        setDuration(duration);
        setPlaceName(placeName);
    }
    public void setLatLng(LatLng latLng) {
        this.placeLatLng = latLng;
    }
    public void setPlaceID(String placeID) {
        this.placeID = placeID;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
    public LatLng getLatLng() {
        return placeLatLng;
    }
    public String getPlaceID() {
        return placeID;
    }
    public String getPlaceName() {
        return placeName;
    }
    public int getDuration() {
        return duration;
    }
}