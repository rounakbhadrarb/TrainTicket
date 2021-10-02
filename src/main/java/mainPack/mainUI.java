package mainPack;

import PessengerPack.Passenger;
import TicketPack.TicketOpImpl;
import TrainPack.Train;
import TrainPack.TrainOpImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class mainUI {
    
    public static void main(String[] args)
    {
        TrainOpImpl TOI=new TrainOpImpl();
        TicketOpImpl gPrice=new TicketOpImpl();
        DateComparison dc=new DateComparison();

        Scanner sc=new Scanner(System.in);
        System.out.println("enter the train no");
        int train_no=sc.nextInt();
        //date
        Date date=null;
        System.out.println("enter date in yyyy/MM/dd format: ");
        String d=sc.next();
        try {
            /*SimpleDateFormat formatter=new SimpleDateFormat("yyyy/MM/dd");
            Date date=formatter.parse(d);
            System.out.println(formatter.format(date));*/
            date=new SimpleDateFormat("yyyy/MM/dd").parse(d);

        }
        catch(ParseException e)
        {
            e.printStackTrace();
        }

        if(dc.dateCom(date)) {
            System.out.println("proceed further");
            System.out.println("enter the number the passenger");
            int pNo = sc.nextInt();
            double price = 0;
            Passenger ps =null;
            while (pNo != 0) {
                System.out.println("enter the passenger name");
                String pName = sc.next();
                System.out.println("enter passenger age:");
                int age = sc.nextInt();
                System.out.println("enter gender M/F");
                char gen = sc.next().charAt(0);

                ps = new Passenger(pName, age, gen);

                price = gPrice.calcPassengerFare(train_no, age, gen);
                //fprice = gPrice.calculateTotalTicketPrice(ps, price);
                gPrice.calculateTotalTicketPrice(ps,price);


                pNo--;

            }
            System.out.println(gPrice.generateTicket(train_no,d,price,ps));
            //System.out.println("total fare is : " + fprice);
            String st=gPrice.generatePNR(train_no,d);
            System.out.println("Your ticket has been booked successfully with pnr no.:"+st);
            gPrice.writeTicket();

        }
        else
        {
            System.out.println("Date must me after your journey date. Your journey ends here");

        }

    }
}
