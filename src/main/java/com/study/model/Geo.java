package com.study.model;

public class Geo {
    
    private String name;
    private String address;
    private Double lat;
    private Double lng;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Geo{" + "name=" + name + ", address=" + address + ", lat=" + lat + ", lng=" + lng + '}';
    }

}
