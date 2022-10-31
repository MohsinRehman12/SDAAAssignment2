package Assignement2SDAAGroup17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CashRegisterDriver { //test driver app for cash register DUI

    public static void main(String[] args){
        Display d = new Display();
        JFrame frame = new JFrame();
        JFrame frame1 = new JFrame();
        JFrame frame2 = new JFrame();
        double total =0;

        CashRegister register = new CashRegister();

        d.cartMaker(frame, register);
    }

}
