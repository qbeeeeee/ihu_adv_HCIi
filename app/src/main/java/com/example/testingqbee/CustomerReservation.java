package com.example.testingqbee;

public class CustomerReservation {

    private String customerName;
    private String hotelName;
    private int rID;
    private int travelPackageID;

    public CustomerReservation(){};

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getrID() {
        return rID;
    }

    public void setrID(int rID) {
        this.rID = rID;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getTravelPackageID() {
        return travelPackageID;
    }

    public void setTravelPackageID(int travelPackageID) {
        this.travelPackageID = travelPackageID;
    }
}
