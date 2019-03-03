package com.example.vibhu.vms;

public class fireobj {
    String Name;
    String Address;
    String image;
    Double Lat;
    Double Lon;
    Long phone;

    public fireobj(String name, String address, String image, Double lat, Double lon, Long phone) {
        Name = name;
        Address = address;
        this.image = image;
        Lat = lat;
        Lon = lon;
        this.phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getLat() {
        return Lat;
    }

    public void setLat(Double lat) {
        Lat = lat;
    }

    public Double getLon() {
        return Lon;
    }

    public void setLon(Double lon) {
        Lon = lon;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
