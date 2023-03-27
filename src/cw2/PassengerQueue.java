package cw2;


import java.util.ArrayList;

import java.util.Scanner;


public class PassengerQueue {

    static int  size;
    static int sides = 6;

    static Passenger[] arr = new Passenger[42];
    static ArrayList<Passenger> trainQueue = new ArrayList<>();



    public static void addCustomer() {
        if (!isFull()) {
            size = size + 1;
        }else
            System.out.println("Queue is Full");
    }


    public static boolean isEmpty(){

       return size == 0;
    }


    public static boolean isFull(){

       return size == 42;
    }


    public static void remove() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter customer's first name, last name and seat no : ");
        String entered;
        entered = in.nextLine();

        if(!isEmpty()) {
        for (int i = 0; i < trainQueue.size(); i++) {
            if (entered.equals(trainQueue.get(i).toString())) {
                trainQueue.remove(i);
            }
        }
        }else
            System.out.println("Queue is Empty");
        //checks if the name entered is equal to any element in the array, if it's there it removes
        //if the queue is empty it doesn't allow to delete a name when entered


        System.out.println(" ");
    }




    public static void display(){
        int rolls = (int) (Math.random()*sides)+1;
        System.out.println(rolls);


        for (int i = 0 ; i < rolls; i++){
            if(TrainStation.waitingRoom!=null) {
                arr[i] = TrainStation.waitingRoom.get(i);
                TrainStation.waitingRoom.remove(i);
                trainQueue.add(arr[i]);

            }
        }//adding the names from the waiting room to an array and then adding those names to the train queue
        System.out.println(trainQueue);
        TrainStation.waitingQueueGui();

    }

    public static int getLength(){
        return  size;
    }




}
