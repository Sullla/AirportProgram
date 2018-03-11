package airportprogram;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PassengerQueue {

    public Scanner input = new Scanner(System.in);
    //public static final ArrayList<String> myList = new ArrayList<String>();
    int MAX_QUEUE_SIZE = 20;
    Passenger[] qnames = new Passenger[MAX_QUEUE_SIZE];

    //Passenger pass = new Passenger();
    //int maxValue = 0;
    //int minValue = 0;
    int front = 0;
    int end = 0;
    int sizeQueue = 0;
    int changeFront = 0;
    int maxStay = 0;
    int minStay = 0;

    public void addqueue(Passenger passenger) {
        if (end == 20) {

            end = 0;

        }

        //Scanner input = new Scanner(System.in);
        qnames[end] = passenger;
        end++;
        if (sizeQueue < MAX_QUEUE_SIZE) {
            sizeQueue++;
        }

    }

    public void takequeue() {
        System.out.println("Fullname taken :" + qnames[front].fullName());
        front++;

        sizeQueue--;

    }

    public void displayqueue() {

        System.out.println("Queue display: ");
        changeFront = front;
        for (int counter = 0; counter < sizeQueue; counter++) {

            System.out.println(changeFront + " " + qnames[changeFront].fullName() + " " + qnames[changeFront].getSecondsInQueue());
            changeFront++;

            if (changeFront == MAX_QUEUE_SIZE) {

                changeFront = 0;

            }

        }
        System.out.println("  ");

    }

    public int getMaxStay() {
        for (int w = 0; w < 30; w++) {
            if (qnames[changeFront].getSecondsInQueue() > maxStay) {

                maxStay = qnames[changeFront].getSecondsInQueue();
            }

        }
        return maxStay;
    }

    public int average() {
        int total = 0;
        return total = 0;
    }

    public int getMinStay() {
        for (int q = 0; q < 30; q++) {
            if (qnames[changeFront].getSecondsInQueue() < minStay) {

                minStay = qnames[changeFront].getSecondsInQueue();
            }

        }
        return minStay;
    }

    public boolean isEmpty() {

        if (this.end == this.changeFront) {
            return true;

        } else {
            return false;
        }

    }

    public boolean isFull() {
        int diff = this.end - this.changeFront;
        if (diff == -1 || diff == (this.MAX_QUEUE_SIZE - 1)) {
            return true;
        } else {
            return false;
        }
    }
}
