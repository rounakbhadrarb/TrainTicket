package TicketPack;

import PessengerPack.Passenger;

public interface TicketOp {
    String generatePNR();
    Double calcPassengerFare(int train_no,int age,char gender);
    void addPassenger(String name,int age,char gender);
    double calculateTotalTicketPrice(Passenger p,double price);
    StringBuilder generateTicket();
    void writeTicket();

}
