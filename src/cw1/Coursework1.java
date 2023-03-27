package cw1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;




public class Coursework1 extends Application {

    int final_seat;
    static final int SEATING_CAPACITY = 42;
    static String[] firstNames = {"null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null",
            "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null",
            "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null"};

    static String[] lastNames = {"null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null",
            "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null",
            "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null"};

    static Stage screen;
    Scene scene, scene2,scene3;

    @Override
    public void start(Stage primaryStage) throws Exception {
        layout(primaryStage);
        menu();

    }

    //The GUI
    public  void layout(Stage primaryStage) {
        screen = primaryStage;
        screen.setTitle("Booking Program for Denuwara Menike train to Badulla");
        Label b = new Label("Booking Seats");
        b.setPadding(new Insets(10, 50, 100, 50));
        HBox hbox = new HBox();
        VBox vbox1 = new VBox(20);
        VBox vbox2 = new VBox(20);
        VBox vbox3 = new VBox(20);
        VBox vbox4 = new VBox(20);

        //Looping to create the buttons
        for (int i = 1; i <= SEATING_CAPACITY; i++) {
            int seat_no = i;
            Button button = new Button("Seat " + String.valueOf(i));
            button.setStyle("-fx-background-color:LightSkyBlue;");
            //Sets the action to every single button
            button.setOnAction(e -> {
                final_seat = seat_no; //to find the button clicked by the user
                screen.setIconified(true);
                Scanner input = new Scanner(System.in);
                System.out.println("Enter your First name");
                String u_names = input.nextLine();
                System.out.println("Enter your Second name");
                String u_names2 = input.nextLine();
                if(u_names.matches(".*\\d+.*")) {
                    System.out.println("This name contains numbers, Please enter name again!!!");
                    addCustomer();
                } else {
                    button.setStyle("-fx-background-color:Lime");
                    System.out.println(u_names +" " +  u_names2 + " is in seat" + final_seat);
                    firstNames[final_seat - 1] = u_names;
                    lastNames[final_seat - 1] = u_names2;
                    System.out.println(Arrays.toString(firstNames));
                    System.out.println(Arrays.toString(lastNames));
                    button.setDisable(true);
                    menu();
                }

            });

            //Creating Vboxes to align the buttons properly
            if (i >= 1 && i <= 11) {

                vbox1.getChildren().addAll(button);
                vbox1.setPadding(new Insets(150, 50, 20, 100));
            }

            if (i >= 12 && i <= 21) {
                vbox2.getChildren().addAll(button);
                vbox2.setPadding(new Insets(150, 50, 50, 10));
            }

            if (i >= 22 && i <= 32) {
                vbox3.getChildren().addAll(button);
                vbox3.setPadding(new Insets(150, 10, 50, 50));
            }

            if (i >= 32 && i <= 42) {

                vbox4.getChildren().addAll(button);
                vbox4.setPadding(new Insets(150, 20, 100, 50));
            }


        }
        StackPane layout = new StackPane();
        hbox.setSpacing(30.0);
        hbox.getChildren().addAll(vbox1, vbox2, vbox3, vbox4);
        layout.getChildren().add(b);
        layout.getChildren().addAll(hbox);
        Scene scene = new Scene(layout, 800, 800);
        screen.setScene(scene);
        screen.show();
        screen.setIconified(true);

    }

    public static void main(String[] args) {
        Load();
        launch(args);


    }

    public static void menu() {
        //Asking the user to input a,v,e,d,f,o,s,l or q to run the menu and gives invalid input if any other letter or number is entered
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Denuwara Menike train from Colombo to Badulla ");
        System.out.println("Enter \"A\" to add a customer");
        System.out.println("Enter \"V\" to view all seat");
        System.out.println("Enter \"E\" to view empty seat");
        System.out.println("Enter \"D\" to delete a booked seat");
        System.out.println("Enter \"F\" to find a seat by customer name");
        System.out.println("Enter \"O\" to view seats ordered alphabetically");
        System.out.println("Enter \"S\" to Save Names");
        System.out.println("Enter \"L\" to Load Names");
        System.out.println("Enter \"Q\" to quit");
        System.out.print("Enter input : ");


        String option = sc.next().toLowerCase();
        switch (option) {
            case "a":
                addCustomer();
                System.out.println("hello");
                break;

            case "v":
                viewAllSeat();

                break;

            case "e":
                viewEmptySeat();
                break;

            case "d":
                delete();
                break;

            case "f":
                findSeatByCustomer();
                break;

            case "o":
                ViewSeatsOrderedAlphabetically();
                break;

            case "s":
                Save();
                break;

            case "l":
                Load();
                break;

            case "q":
                quit();
                break;

            default:
                System.out.println("Invalid Input");


        }

    }



    public static void addCustomer() {

        screen.setIconified(false);
    }

    public static void viewAllSeat() {
        screen.setTitle("Booking Program for Denuwara Menike train to Badulla");
        Label b = new Label("Booking Seats");
        b.setPadding(new Insets(10, 50, 100, 50));
        HBox hbox = new HBox();
        VBox vbox1 = new VBox(20);
        VBox vbox2 = new VBox(20);
        VBox vbox3 = new VBox(20);
        VBox vbox4 = new VBox(20);


        for (int i = 1; i < 43; i++) {

            int seat_no = i;
            Button button = new Button("Seat " + String.valueOf(i));
            button.setStyle("-fx-background-color:LightSkyBlue;");
            if (!firstNames[i-1].equals("null"))  {
                button.setDisable(true);
            }         //checks if the array has a name or a null, if it's name the button disables


            if (i >= 1 && i <= 11) {

                vbox1.getChildren().addAll(button);
                vbox1.setPadding(new Insets(150, 50, 20, 100));
            }

            if (i >= 12 && i <= 21) {
                vbox2.getChildren().addAll(button);
                vbox2.setPadding(new Insets(150, 50, 50, 10));
            }

            if (i >= 22 && i <= 32) {
                vbox3.getChildren().addAll(button);
                vbox3.setPadding(new Insets(150, 10, 50, 50));
            }

            if (i >= 32 && i <= 42) {

                vbox4.getChildren().addAll(button);
                vbox4.setPadding(new Insets(150, 20, 100, 50));
            }


        }
        StackPane layout2 = new StackPane();
        hbox.setSpacing(30.0);
        hbox.getChildren().addAll(vbox1, vbox2, vbox3, vbox4);
        layout2.getChildren().add(b);
        layout2.getChildren().addAll(hbox);
        Scene scene2 = new Scene(layout2, 800, 800);
        screen.setScene(scene2);
        screen.setTitle("Empty seats");
        screen.show();
        screen.setIconified(false);
        menu();

    }



    public  static void viewEmptySeat() {
        screen.setTitle("Booking Program for Denuwara Menike train to Badulla");
        Label b = new Label("Booking Seats");
        b.setPadding(new Insets(10, 50, 100, 50));
        HBox hbox = new HBox();
        VBox vbox1 = new VBox(20);
        VBox vbox2 = new VBox(20);
        VBox vbox3 = new VBox(20);
        VBox vbox4 = new VBox(20);


        for (int i = 1; i < 43; i++) {

            int seat_no = i;
            Button button = new Button("Seat " + String.valueOf(i));
            button.setStyle("-fx-background-color:LightSkyBlue;");
            if (!firstNames[i-1].equals("null")) {
                button.setVisible(false);
            }
            //checks if the array has a name or a null, if it's a name the button becomes invisible


            if (i >= 1 && i <= 11) {

                vbox1.getChildren().addAll(button);
                vbox1.setPadding(new Insets(150, 50, 20, 100));

            }

            if (i >= 12 && i <= 21) {
                vbox2.getChildren().addAll(button);
                vbox2.setPadding(new Insets(150, 50, 50, 10));
            }

            if (i >= 22 && i <= 32) {
                vbox3.getChildren().addAll(button);
                vbox3.setPadding(new Insets(150, 10, 50, 50));
            }

            if (i >= 32 && i <= 42) {

                vbox4.getChildren().addAll(button);
                vbox4.setPadding(new Insets(150, 20, 100, 50));
            }


        }
        StackPane layout3 = new StackPane();
        hbox.setSpacing(30.0);
        hbox.getChildren().addAll(vbox1, vbox2, vbox3, vbox4);
        layout3.getChildren().add(b);
        layout3.getChildren().addAll(hbox);
        Scene scene3 = new Scene(layout3, 800, 800);
        screen.setScene(scene3);
        screen.setTitle("Empty seats");
        screen.show();
        screen.setIconified(false);
        menu();
    }



    public static void delete() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter customer's first name to be deleted : ");
        System.out.println("Enter customer's last name to be deleted : ");
        String entered;
        String entered2;
        entered = in.nextLine();
        entered2 = in.nextLine();
        for (int i = 0; i < firstNames.length; i++) {
            if (entered.equals(firstNames[i])) { //checks if the entered name is there in the array or not
                firstNames[i] = "null";  //if its there it makes it null.
                break;
            } else if ( i == firstNames.length - 1){
                System.out.println("Name doesn't exist"); // if it's not there it asks to enter again
                System.out.println(" Please enter name again");
                delete();
            }
        }

        for (int i = 0; i < lastNames.length; i++) {
            if (entered2.equals(lastNames[i])) { //checks if the entered name is there in the array or not
                lastNames[i] = "null";  //if its there it makes it null.
                break;
            } else if ( i == lastNames.length - 1){
                System.out.println("Name doesn't exist"); // if it's not there it asks to enter again
                System.out.println(" Please enter name again");
                delete();
            }
        }


        System.out.println("Elements -- " ); //prints to check if the name's deleted
        for(int i = 0; i < firstNames.length; i++){
            System.out.print(" " + firstNames[i]);

        }

        System.out.println(" ");

        System.out.println("Elements -- " ); //prints to check if the name's deleted
        for(int i = 0; i < lastNames.length; i++){
            System.out.print(" " + lastNames[i]);

        }
        System.out.println(" ");
        menu();
    }


    public static void findSeatByCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name to find seat");
        String find = sc.nextLine();
        System.out.println("Enter last name to find seat");
        String find2 = sc.nextLine();

        for (int i = 0; i < firstNames.length; i++) {
            if (firstNames[i].equals(find)) { //checks if the entered name is available in the array

                i++;
                System.out.println("Found on seat " + i );
                i--;
                break;
            }
        }

        for (int i = 0; i < lastNames.length; i++) {
            if (lastNames[i].equals(find2)) { //checks if the entered name is available in the array

                i++;
                System.out.println(" ");
                i--;
                break;
            }
        }


        menu();
    }


    public static void ViewSeatsOrderedAlphabetically() {
        String temporary;
        String[] order = new String[firstNames.length]; //Creating an array to get the seat no
        System.arraycopy(firstNames, 0, order, 0, order.length);  //Copying the array
        System.out.println("Names in sorted order and their seat numbers :");

        for (int j = 0; j < order.length; j++) {
            for (int i = j + 1; i < order.length; i++) {
                if (order[i].compareTo(order[j]) < 0) { //checks if i and the j are in order
                    temporary = order[j];  //if not in order the elements are swapped
                    order[j] = order[i];
                    order[i] = temporary;
                }

            }
        }


        for (int j = 0; j < order.length; j++) {
            for (int i = 0; i < order.length; i++) {
                if (firstNames[i].equals(order[j])) { //if element in names is equal to the element in temporary array
                    if (!order[j].equals("null")) { //if the element in temporary array is not equals to null
                        i++;
                        System.out.println(order[j] + " is in seat " + i);
                        i--;
                    }
                }
            }

        }
        menu();
    }


    public static void Save() {
        try {
            File saveFile = new File("firstnames.txt");

            FileWriter theFile = new FileWriter(saveFile.getAbsoluteFile());
            BufferedWriter bwriter = new BufferedWriter(theFile);

            //for the first name
            for (int i = 0; i < firstNames.length; i++) {
                if (firstNames[i] !=null) {
                    bwriter.write(String.valueOf(firstNames[i]));
                    bwriter.newLine();     //The buffer writer uses the file writer to write each element to a new line in the text file
                }
            }

            bwriter.write('\n');
            System.out.println();
            bwriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File saveFile = new File("lastnames.txt");

            FileWriter theFile2 = new FileWriter(saveFile.getAbsoluteFile());
            BufferedWriter bwriter2 = new BufferedWriter(theFile2);


            //for the last name
            for (int i = 0; i < lastNames.length; i++) {
                if (lastNames[i] !=null) {
                    bwriter2.write(String.valueOf(lastNames[i]));
                    bwriter2.newLine();     //The buffer writer uses the file writer to write each element to a new line in the text file
                }
            }

            bwriter2.write('\n');
            System.out.println();
            bwriter2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        menu();
    }


    public static void Load()  {

        try (BufferedReader br = new BufferedReader(new FileReader("firstnames.txt"))) {

                for (int i = 0; i < firstNames.length; i++) {
                    firstNames[i] = br.readLine();
                }

            br.close();
            System.out.println(Arrays.toString(firstNames));    //the buffer reader uses the file reader to read the lines-
            // -in the file line by line to the names array

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("lastnames.txt"))) {

            for (int i = 0; i < lastNames.length; i++) {
                lastNames[i] = br.readLine();
            }

            br.close();
            System.out.println(Arrays.toString(lastNames));    //the buffer reader uses the file reader to read the lines-
            // -in the file line by line to the names array

        } catch (IOException exception) {
            exception.printStackTrace();
        }


        menu();
        }


    public static void quit (){
        //gui closes
        screen.close();
    }
}
