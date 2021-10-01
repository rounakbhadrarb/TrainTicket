package TicketPack;

import PessengerPack.Passenger;
import TrainPack.Train;
import TrainPack.TrainOpImpl;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TicketOpImpl implements TicketOp{
    TreeMap<Passenger,Double> passengers=new TreeMap<Passenger, Double>();
    TrainOpImpl TOI=new TrainOpImpl();
    @Override
    public String generatePNR() {
        return null;
    }

    @Override
    public Double calcPassengerFare(int train_no,int age,char gender) {
        Train train=TOI.getTrainDetails(train_no);
        double price=train.getTicketPrice();
        if(age<=12)
        {
            price=price*0.5;
            return price;
        }
        else
        {
            if (age>=60)
            {
                price=price*0.6;
                return price;
            }
            else
            {
                if(gender=='F')
                {
                    price=price*0.75;
                    return price;
                }
                else
                {
                    return price;
                }
            }
        }
    }


    @Override
    public void addPassenger(String name, int age, char gender) {

    }

    @Override
    public double calculateTotalTicketPrice(Passenger p,double price) {
        //TreeMap<Passenger,Double> passengers=new TreeMap<Passenger, Double>();
        passengers.put(p,price);
        double value=0;
        for(Map.Entry<Passenger,Double> entry:passengers.entrySet())
        {
            value+=entry.getValue();
            //Passenger key=entry.getKey();

        }
        return value;
    }

    @Override
    public StringBuilder generateTicket() {
        return null;
    }

    @Override
    public void writeTicket() {

    }
}
