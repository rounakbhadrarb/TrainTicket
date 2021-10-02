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
    
    public static void main(String[] args) {
        TrainOpImpl TOI = new TrainOpImpl();
        TicketOpImpl gPrice = new TicketOpImpl();
        DateComparison dc = new DateComparison();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Book Ticket ");
            System.out.println("2. Exit");
            System.out.println("Enter your choice : ");
            int choice=sc.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("enter the train no between 1001 to 1006 ");
                    int train_no = sc.nextInt();
                    if(train_no>=1001 && train_no<=1006) {
                        Date date = null;
                        System.out.println("enter date in yyyy/MM/dd format: ");
                        String d = sc.next();
                        try {
                            date = new SimpleDateFormat("yyyy/MM/dd").parse(d);

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        if (dc.dateCom(date)) {
                            System.out.println("enter the number of passengers");
                            int pNo = sc.nextInt();
                            double price = 0;
                            Passenger ps = null;
                            while (pNo != 0) {
                                System.out.println("enter the passenger name");
                                String pName = sc.next();
                                System.out.println("enter passenger age:");
                                int age = sc.nextInt();
                                System.out.println("enter gender M/F");
                                char gen = sc.next().charAt(0);
                                ps = new Passenger(pName, age, gen);
                                price = gPrice.calcPassengerFare(train_no, age, gen);
                                gPrice.calculateTotalTicketPrice(ps, price);
                                pNo--;

                            }
                            gPrice.generateTicket(train_no, d, price, ps);
                            gPrice.writeTicket();
                        } else {
                            System.out.println("Date must me after your journey date. Your journey ends here");

                        }
                    }
                    else
                    {
                        System.out.println("Train with given no doesn't exist\n");
                    }
                    System.out.println(" \n\nIf you want to book another ticket press 1 or press 2 for exit\n");
                    break;
                }
                case 2:
                {
                    sc.close();
                    System.out.println("Thank you for visiting......");
                    System.exit(0);
                }
            }

        }
    }
}
