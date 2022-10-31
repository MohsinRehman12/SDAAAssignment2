package Assignement2SDAAGroup17;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class TicketGenerator {

    public void generateReceipt(String s){ //method that stores the string of ticket inside a text file so it can be printed



        try {

            PrintWriter writer = new PrintWriter("C:\\Users\\mshak\\IdeaProjects\\SofeYear3\\src\\Assignement2SDAAGroup17\\reciept.txt", "UTF-8");
            writer.println(s);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}
