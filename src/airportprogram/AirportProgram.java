package airportprogram;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class AirportProgram {

    private static int counter = 0;

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Passenger[] passenger = new Passenger[30];
        PassengerQueue mq = new PassengerQueue();

        String firstName;
        String lastName;
        Scanner input = new Scanner(System.in);

        String menu;
        int x = 0;
        do {

            System.out.println("Enter 'A' to add to queue, press r to run a simulation"
                    + " 'D' to take, 'v' to display, press 'L' to load,press 's' to save,'stop' to end :");
            menu = input.next();
            switch (menu) {

                case "a":

                    firstName = input.next();
                    lastName = input.next();

                    // Passenger[] passenger = new Passenger[30];
                    passenger[x] = new Passenger();
                    passenger[x].setfirstName(firstName);
                    passenger[x].setlastName(lastName);
                    // passenger[x].setSecondsInQueue(sum);

                    System.out.println(passenger[x].getSecondsInQueue());
                    mq.addqueue(passenger[x]);

                    x++;

                    break;
                case "d":
                    mq.takequeue();
                    break;
                case "v":
                    mq.displayqueue();
                    break;
                case "l":
                    loadPassengers(passenger, x, mq);
                    break;
                case "s":
                    storePassengers(passenger, x);
                    break;
                case "r":
                    runSimulator(passenger, mq);
                    break;

            }

        } while (menu != "stop");

    }

    public static void storePassengers(Passenger[] passenger, int x) throws FileNotFoundException {
        PrintWriter outtoFile = new PrintWriter("Airport.dat");

        //System.out.println(passenger[0].fullName());
        for (int y = 0; y < x; y++) {
            outtoFile.println(passenger[y].fullName() + " " + passenger[y].getSecondsInQueue());
        }
        outtoFile.close();

    }

    public static void loadPassengers(Passenger[] passenger, int x, PassengerQueue mq) throws FileNotFoundException {
        File airportQueue = new File("Airport.dat");
        int z = 0;
        Scanner longQueue = new Scanner(airportQueue);
        for (z = 0; z < 30; z++) {
            if (longQueue.hasNext()) {
                //passenger[z] = new Passenger();
                passenger[z].fullname(longQueue.next(), longQueue.next());
                passenger[z].setSecondsInQueue(longQueue.nextInt());
                mq.addqueue(passenger[z]);
            }
        }
    }

    public static void runSimulator(Passenger[] passenger, PassengerQueue mq) throws FileNotFoundException, InterruptedException {

        File airportQueue = new File("passengers.dat");
        Scanner longQueue = new Scanner(airportQueue);

        int x = 0;
        int counter1 = 0;
        int dice1 = 0;
        int dice2 = 0;
        int dice3 = 0;

        int sum = 0;

        while (longQueue.hasNext()) {
            for (int p = 0; p < passenger.length; p++) {

                passenger[p] = new Passenger();
                passenger[p].fullname(longQueue.next(), longQueue.next());

                passenger[p].setSecondsInQueue(sum);

            }

        }
        do {

            boolean checkIF = mq.isFull();
            dice1 = D6();
            if (checkIF == false) {

                for (int num = 0; num < dice1; num++) {

                    dice1 = D6();
                    dice2 = D62();
                    dice3 = D63();
                    sum = dice1 * dice2 * dice3;

                    passenger[counter1].setSecondsInQueue(sum);

                    System.out.println("|" + counter1 + "| " + " Passenger Name: "
                            + passenger[counter1].fullName()
                            + "| Time: " + passenger[counter1].getSecondsInQueue());
                    mq.addqueue(passenger[counter1]);

                    counter1++;
                }
                mq.takequeue();
            }

        } while (counter1 <= passenger.length);

        System.out.println(" max is: " + mq.getMaxStay() + " min is: " + mq.getMinStay());
        System.out.println("Queue size is: " + mq.sizeQueue);

    }

    public static int D6() {
        return (int) (1+Math.random() * 6);

    }

    public static int D62() {
        return (int) (1+Math.random() * 6);

    }

    public static int D63() {
        return (int) (1 + Math.random() * 6);

    }

}
