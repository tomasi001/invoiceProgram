// import java swing library of functions.
import javax.swing.*;

public class Invoice {

    // declare attributes
    String orderNumber;
    String cusName;
    String cusEmail;
    String cusPhnNum;
    String cusCity;
    String resName;
    String cusOrder;
    String orderList;
    String specialPrep;
    String total;
    String driverName;
    String cusAdress;
    String resPhnNum;
    String resCity;

    // create new instance of writeToFile
    public static void main(String[] args) {
        Invoice inv = new Invoice();
        WriteToFile invFile = new WriteToFile(inv);
    }

    // declare constructor
    public Invoice() {
        // set attributes to inputted information
        orderList = "";
        orderNumber = JOptionPane.showInputDialog("Please Enter Customer's Order Number");
        cusName = JOptionPane.showInputDialog("Please Enter Customer's Name");
        cusEmail = JOptionPane.showInputDialog("Please Enter Customer's Email");
        cusPhnNum = JOptionPane.showInputDialog("Please Enter Customer's Phone Number");
        cusCity = JOptionPane.showInputDialog("Please Enter Customer's City");
        resName = JOptionPane.showInputDialog("Please Enter Restaurant's Name");
        cusOrder = JOptionPane.showInputDialog(
                "Please Enter Customer's Order, Quantity and the Price of each item\nEnter \"0\" when you are finished entering items\neg) 1x Pepperoni Pizza (R100)");
        while (nullCheck(cusOrder)) {
            while (!cusOrder.equalsIgnoreCase("0")) {
                cusOrder = JOptionPane.showInputDialog(
                        "Please Enter Customer's Order, Quantity and the Price of each item\nEnter \"0\" when you are finished entering items\neg) 1x Pepperoni Pizza (R100)");
                orderList += cusOrder + "\n";
            }
            if(cusOrder.equalsIgnoreCase("0")){
                break;
            }
        }
        orderList = orderList.replace("0\n", "");

        specialPrep = JOptionPane.showInputDialog("Please Enter Any Special preparation Instructions");
        total = JOptionPane.showInputDialog("Please Enter Total Price");

        cusAdress = JOptionPane.showInputDialog("Please Enter Customer's Street Name, House Number and Suburb");
        resPhnNum = JOptionPane.showInputDialog("Please Enter Restaurant's Phone Number");

        resCity = JOptionPane.showInputDialog("Please Enter Restaurant's City");

    }

    // declare ​toString ​method to display the values of all the attributes of each
    // class
    public String toString() {

        // create new instances of customer, restaurant and driver objects
        Customer cus = new Customer(orderNumber, cusName, cusEmail, cusPhnNum, cusAdress, cusCity);
        Restaurant res = new Restaurant(resName, resCity, resPhnNum);
        Driver driv = new Driver(resCity);

        // create necessary output
        String output = "Order Number: " + orderNumber;
        output += "\nCustomer: " + cus.name;
        output += "\nEmail: " + cus.email;
        output += "\nPhone Number: " + cus.phnNum;
        output += "\nLocation: " + cus.city;
        output += "\n\nYou have ordered the following from: " + res.name + " in " + res.city;
        output += "\n\n" + orderList;
        output += "\n\nSpecial Preparation Instructions: " + specialPrep;
        output += "\n\nTotal: " + total;
        output += "\n\n" + driv.driverOutput;
        output += "\n\n" + cus.address;
        output += "\n\nIf you need to contact the restaurant: " + res.phnNum;

        // return output for this method
        return output;
    }

    // method to check if a string is null
    private boolean nullCheck(String stringToCheck){
        if(stringToCheck != null){
            return true;
        }
        return false;
    }
}
