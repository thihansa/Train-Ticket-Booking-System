package cw2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static cw2.PassengerQueue.*;


public class TrainStation extends  Application{

    static Stage screen ;
    Scene scene , scene2, scene3;
    static ArrayList<Passenger> waitingRoom = new ArrayList<>();
    static Stage primaryStage = new Stage();
    static PassengerQueue arr= new PassengerQueue();
    static Passenger Time= new Passenger();
    static  private int secondsInQueue;




    @Override
    public  void start(Stage primaryStage) throws Exception {
        waitingQueueGui();

    }


    public static void main(String[] args) throws FileNotFoundException {
        cw1();
        launch(args);


    }

    public static void menu() {
        //Asking the user to input a,v,d,s,l or r to run the menu and gives invalid input if any other letter or number is entered
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Denuwara Menike train from Colombo to Badulla ");
        System.out.println("Enter \"A\" to add a customer");
        System.out.println("Enter \"V\" to view the train queue");
        System.out.println("Enter \"D\" to delete a passenger from the train queue");
        System.out.println("Enter \"S\" to Store trainQueue data ");
        System.out.println("Enter \"L\" to Load data back from the file into the trainQueue ");
        System.out.println("Enter \"R\" for the details. ");
        System.out.print("Enter input : ");


        String choice = sc.next().toLowerCase();
        switch (choice) {
            case "a":
                PassengerQueue.addCustomer();
                System.out.println("hello");
                break;

            case "v":
                View();
                break;

            case "d":
                PassengerQueue.remove();
                break;


            case "s":
                Save();
                break;

            case "l":
                Load();
                break;

            case "r":
                RunSimulation();
                break;

            default:
                System.out.println("Invalid Input");

        }
    }

    public static void cw1() throws FileNotFoundException {
        File file = new File("firstnames.txt");
        File file2 = new File("lastnames.txt");

        Scanner scfile = new Scanner(file);
        Scanner scfile2 = new Scanner(file2);
        int sides = 6;

        int counter = 1;
        int seatNumber = counter;
        while (scfile.hasNext()) {
            int rolls = (int) (Math.random()*sides)+1;
            int rolls2 = (int) (Math.random()*sides)+1;
            int rolls3 = (int) (Math.random()*sides)+1;
            int Seconds = rolls+rolls2+rolls3;
            secondsInQueue = secondsInQueue+Seconds;

            String info = scfile.nextLine();
            String info2 = scfile2.nextLine();

            int seatInfo = counter;
            int info4=Seconds;
            int info6 = secondsInQueue;
            if (!info.equals("null")) {
                if (!info2.equals("null")) {
                    waitingRoom.add(new Passenger(info, info2, seatInfo,info4,info6));
                }
            }
            counter++;
        }


    }


    public static void Save ()  {
        File f = new File("save trainqueue.txt");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);

            for (int i = 0; i < trainQueue.size(); i++) {
                if (trainQueue.get(i) !=null) {
                    oos.writeObject(String.valueOf(trainQueue.get(i))); //writes every element in the file in a new line everytime the for loop runs according to the size.
                }
            }
            oos.write('\n');
            oos.close();


        }  catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void Load() {
        File f = new File("save trainqueue.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            while (true){
                String save = (String) ois.readObject();
                System.out.println(save);

            }

        }  catch (EOFException e) {
            //e.printStackTrace();
        }	catch (IOException | ClassNotFoundException  e) {
            e.printStackTrace();
        }
        finally {
            try {
                fis.close();
                ois.close();
            } catch (IOException e) {

                e.printStackTrace();
            }

        }System.out.println(trainQueue);
    }

    public static void View() {
        screen = primaryStage;
        screen.setTitle("Booking Program for Denuwara Menike train to Badulla");


        Label b2 = new Label("Train Queue");
        b2.setFont(Font.font("Cambria", 32));
        b2.setTranslateY(-350);
        b2.setTranslateX(-400);
        HBox hbox = new HBox();
        VBox vbox1 = new VBox(20);


        for (int i = 0; i < 42; i++) {
            if (PassengerQueue.trainQueue.get(i) != null) {
                Button t = new Button(String.valueOf((PassengerQueue.trainQueue.get(i))));
                t.setStyle("-fx-background-color:GreenYellow;");
                vbox1.getChildren().add(t);
                vbox1.setPadding(new Insets(200, 0, 200, 50));
                if (i == PassengerQueue.trainQueue.size() - 1) {
                    break;
                }
            }
        }//A button is made for every element that is not null every time the for loop runs 42 times.

            StackPane layout = new StackPane();
            hbox.setSpacing(30.0);
            hbox.getChildren().addAll(vbox1);
            layout.getChildren().add(b2);
            layout.getChildren().addAll(hbox);
            Scene scene2 = new Scene(layout, 1200, 900);
            screen.setScene(scene2);
            screen.show();
            screen.setIconified(false);
            menu();

        }


    public static void RunSimulation() {


        int maxTime =Time.Seconds;
        for (int i=0 ;i<trainQueue.size();i++){
            if(trainQueue.get(i).getSeconds()>maxTime){
                maxTime = trainQueue.get(i).getSeconds();
            }
        }

        int minTime =trainQueue.get(0).getSeconds();
        for (int i=1 ;i<trainQueue.size();i++){
            if(trainQueue.get(i).getSeconds()<minTime){
                minTime = trainQueue.get(i).getSeconds();
            }
        }


        double totalSeconds= 0;
        for (int i=1 ;i<trainQueue.size();i++){
            totalSeconds= totalSeconds+trainQueue.get(i).getSeconds();
        }
        double average = totalSeconds/trainQueue.size();




        screen = primaryStage;
        screen.setTitle("Booking Program for Denuwara Menike train to Badulla");

        ArrayList<Passenger> newTrain= arr.trainQueue;
        Label b2 = new Label("Boarded Passengers");
        b2.setFont(Font.font("Cambria", 32));
        b2.setTranslateY(-350);
        b2.setTranslateX(-400);


        Label b3 = new Label("Report");
        b3.setFont(Font.font("Cambria", 32));
        b3.setTranslateY(-350);
        b3.setTranslateX(80);

        HBox hbox = new HBox();
        VBox vbox1 = new VBox(20);
        VBox vbox2 = new VBox(20);
        VBox vbox3 = new VBox(20);


        for (int i = 0; i < 42; i++) {

            if(newTrain.get(i) !=null){
                Button run = new Button(PassengerQueue.trainQueue.get(i).toString()+ " seat " + PassengerQueue.trainQueue.get(i).getSecondsInQueue()+ " Seconds");
                vbox1.setPadding(new Insets(200, 0, 200, 50));
                vbox1.getChildren().add(run);
                if (i==newTrain.size()-1){
                    break;
                }

            }

        }//the train queue is added to a new array list and a button is made when the elements in it are not null.
        // button sets the name according to methods in the passenger class.

        Button length = new Button("Number of Passengers are "+ newTrain.size() + " passengers");
        length.setStyle("-fx-background-color:LightSkyBlue;");
        Button max = new Button("The Maximum waiting time is " + maxTime + " Seconds");
        max.setStyle("-fx-background-color:LightSkyBlue;");
        Button min = new Button("The Minimum waiting time is " + minTime + " Seconds");
        min.setStyle("-fx-background-color:LightSkyBlue;");
        Button avg = new Button("The Average waiting time is " + average + " Seconds");
        avg.setStyle("-fx-background-color:LightSkyBlue;");
        vbox2.setPadding(new Insets(200, 0, 200, 250));
        vbox2.getChildren().add(length);
        vbox2.getChildren().add(max);
        vbox2.getChildren().add(min);
        vbox2.getChildren().add(avg);


        //a scroll bar is implemented
        ScrollBar scrollBar = new ScrollBar();
        scrollBar.setOrientation(Orientation.VERTICAL);
        AnchorPane scroll = new AnchorPane(scrollBar);
        AnchorPane.setTopAnchor(scrollBar, 0d);
        AnchorPane.setRightAnchor(scrollBar, 0d);
        AnchorPane.setBottomAnchor(scrollBar, 0d);
        scroll.setPadding(new Insets(200,0,200,300));



        StackPane layout = new StackPane();
        hbox.setSpacing(30.0);
        hbox.getChildren().addAll(vbox1,vbox2,scroll);
        layout.getChildren().add(b2);
        layout.getChildren().add(b3);
        layout.getChildren().addAll(hbox);
        Scene scene3 = new Scene(layout, 1200, 900);
        screen.setScene(scene3);
        screen.show();
        screen.setIconified(false);



        try {


            File saveFile = new File("run report.txt");

            FileWriter theFile = new FileWriter(saveFile.getAbsoluteFile());
            BufferedWriter bwriter = new BufferedWriter(theFile);


            bwriter.write("The Maximum Number of passengers are " + newTrain.size() + " passengers");
            bwriter.newLine();
            bwriter.write("The Maximum waiting time is " + maxTime + " Seconds");
            bwriter.newLine();
            bwriter.write("The Minimum waiting time is " + minTime + " Seconds");
            bwriter.newLine();
            bwriter.write("The Average waiting time is " + average + " Seconds");
            bwriter.newLine();
            //buffer writer writes the length , maxtime, mintime and average in the file in a new line

            bwriter.write('\n');
            System.out.println();
            bwriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static void waitingQueueGui() {
        screen = primaryStage;
        screen.setTitle("Booking Program for Denuwara Menike train to Badulla");
        Label b = new Label("Waiting Queue");
        b.setFont(Font.font("Cambria", 32));
        b.setTranslateY(-350);
        b.setTranslateX(-400);

        Label b2 = new Label("Train Queue");
        b2.setFont(Font.font("Cambria", 32));
        b2.setTranslateY(-350);
        b2.setTranslateX(80);
        HBox hbox = new HBox();
        VBox vbox1 = new VBox(20);
        VBox vbox2 = new VBox(20);
        VBox vbox3 = new VBox(20);
        VBox vbox4 = new VBox(20);
        VBox vbox5 = new VBox(20);
        VBox vbox6 = new VBox(20);


        for (int i = 0; i < 42; i++) {


            if (i == waitingRoom.size()) {
                break;
            }
            Button button = new Button(waitingRoom.get(i).getNames());
            vbox1.getChildren().add(button);
            vbox1.setPadding(new Insets(150, 50, 20, 50));

        }//shows the elements inside the waiting room array

        Button button1 = new Button("Click to add the names into the train Queue");
        vbox2.getChildren().add(button1);
        button1.setStyle("-fx-background-color:PaleTurquoise ;-fx-font-size: 16;");
        vbox2.setPadding(new Insets(300,0,20,0));
        button1.setOnAction(event -> {
           PassengerQueue.display();
           menu();
        });//this button is used to add the passengers from the waiting room to the train queue



        for (int i=0 ; i< PassengerQueue.trainQueue.size(); i++){

            Button bt = new Button(String.valueOf(PassengerQueue.trainQueue.get(i)));
            bt.setStyle("-fx-background-color:LightSkyBlue;");


            if (i >= 0 && i <= 10) {
                vbox3.getChildren().add(bt);
                vbox3.setPadding(new Insets(200, 0, 200, 50));
            }

            if (i >= 11 && i <= 20) {
                vbox4.getChildren().add(bt);
                vbox4.setPadding(new Insets(200, 0, 200, 50));
            }

            if (i >= 21 && i <= 31) {
                vbox5.getChildren().add(bt);
                vbox5.setPadding(new Insets(200, 0, 200, 50));
            }

            if (i >= 31 && i < 42) {
                vbox6.getChildren().add(bt);
                vbox6.setPadding(new Insets(200, 0, 200, 50));
            }

        }// a button is made every time passengers are added to the train queue



        StackPane layout = new StackPane();
        hbox.setSpacing(30.0);
        hbox.getChildren().addAll(vbox1, vbox2, vbox3, vbox4, vbox5, vbox6);
        layout.getChildren().add(b);
        layout.getChildren().add(b2);
        layout.getChildren().addAll(hbox);
        Scene scene = new Scene(layout, 1300, 900);
        screen.setScene(scene);
        screen.setIconified(true);
        screen.show();
        menu();
    }


}
