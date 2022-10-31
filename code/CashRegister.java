package Assignement2SDAAGroup17;

import java.util.Scanner;


public class CashRegister {

    private CRScanner CRS = new CRScanner();
    private double total = 0;
    private Product p = null;

    //method to check the database (text file) for the product associated with the GUI and print info associated with it and add its price to the total
    public String Notify(int upc){
        String s = "";
        p = CRScanner.AddProdUPC(upc); //CRScanner scans the barcode to scan the database for the product with the associated UPCcode

        if (p==null){ //if there is no product display unknown product and increment total
            s = "Unknown Product";
            total+=0;
        }
        else{ //if there is a product display the product info and add to the total price
            s = p.toString();
            total+=p.getPrice();

        }
        return s;
    }

    //getter for total
    public double getTotal(){
        return total;
    }



}
