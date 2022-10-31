package Assignement2SDAAGroup17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display { //class for the display of the cash register

    //created and intialized varaibles to be used inside all methods within the class
    JFrame frame = new JFrame();
    CashRegister register = new CashRegister();
    TicketGenerator ticket =  new TicketGenerator();

    String orderTicket = "";

    JLabel [] items = new JLabel[100]; //JLabel array made to keep displaying the items on the screen

    int itemCount = 0;

    //Jpanels and buttons created for methods
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();

    JButton b1 = new JButton();
    JButton b2 = new JButton();
    JButton b3 = new JButton();


    public void displayMaker(JFrame frame){ //this method creates a generic GUI with 3 panels

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);


        frame.add(p1, BorderLayout.NORTH);
        frame.add(p2, BorderLayout.CENTER);
        frame.add(p3, BorderLayout.SOUTH);

        frame.setVisible(true);

    }

    //this method is made to add an item to a JPanel that will display its information and price or Unknown item based on the area index
    public void addToCarts(JLabel[] items, String s){

        items[itemCount]= new JLabel(s);

        p1.add(items[itemCount]);
        itemCount++;



    }

    //this method creates the cart GUI where the item and prices will be displayed when a UPCCode is entered
    public void cartMaker(JFrame frame, CashRegister register){

        displayMaker(frame); //call method to make generic frame that we will edit upon



        p2.setLayout(new FlowLayout(20));
        p1.setLayout(new BoxLayout(p1, BoxLayout.PAGE_AXIS));

        //create text field and label and add them to panel (top panel) for the entering of UPCCodes
        JTextField textField = new JTextField(20);
        JLabel code = new JLabel("Enter UPC Code:");
        p2.add(code);
        p2.add(textField);

        //Button intialized and meant to be pressed after up code is entered
        JButton button = new JButton("Press To Input Code");

        //method that listens to if a button is pressed
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //button is pressed

                //String takes in the upc code entered into text field then we convert it into an int
                String s = textField.getText();
                int code = Integer.parseInt(s);

                //take the int and use the CashRegister Notify Method to display the information about the item or if its an unknown product
                s = register.Notify(code);

                //call add to cart method to display the label associated with the information we got from addToCart method
                addToCarts(items, s);

                //pack it so that all labels appear and not just the last called one
                frame.pack();

            }
        });



        JButton Cbutton = new JButton("Proceed To Checkout");

        Cbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //CButton is pressed

                if (itemCount!=0){ //if there are items in the cart

                    //add the total to the ticket string
                    orderTicket+= "The Total was $" + register.getTotal() + " \n The items were: \n";

                    //loop through each item and add its information to the ticket
                    for (int i =0; i<itemCount; i++) {

                        orderTicket+= items[i].getText() + "\n";

                    }

                    //generate the reciept and store it in a text file
                    ticket.generateReceipt(orderTicket);



                }

                //close the j frame and create a new one for checkoug
                frame.dispose();
                JFrame checkout = new JFrame();



                Display d = new Display(); //create a display to call checkoutMake method
                d.checkoutMaker(checkout, register.getTotal());
                System.out.println(orderTicket); //ticket is printed out for all to see



            }
        });

        //add both button and CButton to panels
        p2.add(button);
        p3.add(Cbutton);


        JLabel count = new JLabel(String.valueOf(itemCount));

        //organize panels and their orientation in the GUI
        frame.add(p2, BorderLayout.NORTH);
        frame.add(p1, BorderLayout.CENTER);
        frame.add(p3, BorderLayout.SOUTH);



        frame.setVisible(true);


    }
// method made for the GUI for checkout
    public void checkoutMaker(JFrame frame, double total){

        //make a generic frame
        displayMaker(frame);


        //make a label that tells the user the total and asks them how they would like to pay and then add it to he panel
        JLabel title = new JLabel("Checkout: Your Total is:$ " + total +"\n" + " How would you like to pay?");
        p1.add(title);

        //create button for cash and when it is pressed close the frame and output paid with cash
        b1.setText("Cash");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Paid with Cash");


                frame.dispose();


            }
        });
        p2.add(b1);
        b2.setText("Debit");
        b3.setText("Credit");
        p2.add(b2);

        //create button for Debit and when it is pressed close the frame and output paid with Debit


        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Paid with Debit");


                frame.dispose();


            }
        });
        p2.add(b3);

        //create button for Credit and when it is pressed close the frame and output paid with Credit

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Paid with Credit");


                frame.dispose();


            }
        });

    }


}
