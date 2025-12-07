package LLD.BookMyShowLLD.TheaterInfoClasses;

import LLD.BookMyShowLLD.enums.SeatType;

public class Seat {

    public Seat(int seatNo, SeatType sc){
        this.seatNo=seatNo;
        this.seatType=sc;
    }

    public int getSeatNo(){
        return seatNo;
    }
    public int seatNo;
    SeatType seatType;
}
