package com.example.testingqbee;

public class CustomerReservation {

    private String customerName;
    private String hotelName;
    private String rID;
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

    public String getrID() {
        return rID;
    }

    public void setrID(String rID) {
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
