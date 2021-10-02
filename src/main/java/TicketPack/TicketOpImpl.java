package TicketPack;

import PessengerPack.Passenger;
import TrainPack.Train;
import TrainPack.TrainOpImpl;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class TicketOpImpl implements TicketOp{
    TreeMap<Passenger,Double> passengers=new TreeMap<Passenger, Double>();
    TrainOpImpl TOI=new TrainOpImpl();
    //private int train_no;
    /*public int getTrainNo(int no)
    {
        train_no+=no;
        return train_no;
    }*/
    //Train train=TOI.getTrainDetails(train_no);
    @Override
    public String generatePNR(int train_no,String str) {
        Train train=TOI.getTrainDetails(train_no);
        //String source=train.getSource().charAt(0);
        //char dest=train.getDest().charAt(0);
        String[] word=str.split("/");
        String fstr="";
        for (String s:word)
        {
            fstr+=s;
        }

        Random rand=new Random();
        int count=(rand.nextInt(100)+100);
        String s3=Integer.toString(count);
        char ch=train.getSource().charAt(0);
        String s1=Character.toString(ch);
        char ch1=train.getDest().charAt(0);
        String s2=Character.toString(ch1);
        String s=s1+s2+"_"+fstr+"_"+s3;
        return (s);
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
