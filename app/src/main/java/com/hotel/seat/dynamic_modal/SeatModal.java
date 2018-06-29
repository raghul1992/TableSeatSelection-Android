package com.hotel.seat.dynamic_modal;

/**
 * Created by Rahul on 1/11/2018.
 */

public class SeatModal {

    String strSeatNumber;
    boolean boolSeatStatus;

    public SeatModal(String strSeatNumber, boolean boolSeatStatus) {
        this.strSeatNumber = strSeatNumber;
        this.boolSeatStatus = boolSeatStatus;
    }

    public String getStrSeatNumber() {
        return strSeatNumber;
    }

    public void setStrSeatNumber(String strSeatNumber) {
        this.strSeatNumber = strSeatNumber;
    }

    public boolean isBoolSeatStatus() {
        return boolSeatStatus;
    }

    public void setBoolSeatStatus(boolean boolSeatStatus) {
        this.boolSeatStatus = boolSeatStatus;
    }
}
