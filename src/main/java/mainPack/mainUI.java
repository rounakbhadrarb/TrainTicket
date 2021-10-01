package mainPack;

import PessengerPack.Passenger;
import TicketPack.TicketOpImpl;
import TrainPack.Train;
import TrainPack.TrainOpImpl;

import java.util.Scanner;

public class mainUI {
    
    public static void main(String[] args)
    {
        TrainOpImpl TOI=new TrainOpImpl();
        TicketOpImpl gPrice=new TicketOpImpl();

        Scanner sc=new Scanner(System.in);
        System.out.println("enter the train no");
        int train_no=sc.nextInt();
        //date
        System.out.println("enter the number the passenger");
        int pNo=sc.nextInt();
        double fprice=0;
        while(pNo!=0)
        {
            System.out.println("enter the passenger name");
            String pName=sc.next();
            System.out.println("enter passenger age:");
            int age=sc.nextInt();
            System.out.println("enter gender M/F");
            char gen=sc.next().charAt(0);

            Passenger ps=new Passenger(pName,age,gen);

            double price=gPrice.calcPassengerFare(train_no,age,gen);
            fprice=gPrice.calculateTotalTicketPrice(ps,price);

             pNo--;

        }
        System.out.println("total fare is : "+fprice);


    }
}
