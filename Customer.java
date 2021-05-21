import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Customer {
    // declare attributes
    String orderNumber;
    String name;
    String email;
    String phnNum;
    String address;
    String city;

    // declare array list to store list of customers
    ArrayList<String> nameAndOrderNumList = new ArrayList<>();
    ArrayList<String> capeList = new ArrayList<>();
    ArrayList<String> johannesList = new ArrayList<>();
    ArrayList<String> durbanList = new ArrayList<>();
    ArrayList<String> potchList = new ArrayList<>();
    ArrayList<String> springList = new ArrayList<>();
    ArrayList<String> bloemList = new ArrayList<>();
    ArrayList<String> portList = new ArrayList<>();
    ArrayList<String> witList = new ArrayList<>();

    

    // declare constructor with parameters
    public Customer(String orderNumber, String name, String email, String phnNum, String address, String city) {
        this.orderNumber = orderNumber;
        this.name = name;
        this.email = email;
        this.phnNum = phnNum;
        this.address = address;
        this.city = city;
        addNameAndLocation(name, city, orderNumber);
    }

    private void addNameAndLocation(String name, String city, String orderNumber){
        while(nullCheck(city)){
            // add new names in an array
            if(city.equalsIgnoreCase("Cape Town")){
                writeToAreaFile("capeTown.txt", name, orderNumber);
            }
            else if(city.equalsIgnoreCase("Durban")){
                writeToAreaFile("durban.txt", name, orderNumber);
            }
            else if(city.equalsIgnoreCase("Johannesburg")){
                writeToAreaFile("johannesburg.txt", name, orderNumber);
            }
            else if(city.equalsIgnoreCase("Bloemfontein")){
                writeToAreaFile("bloemfontein.txt", name, orderNumber);
            }
            else if(city.equalsIgnoreCase("Witbank")){
                writeToAreaFile("witbank.txt", name, orderNumber);
            }
            else if(city.equalsIgnoreCase("Port Elizabeth")){
                writeToAreaFile("portElizabeth.txt", name, orderNumber);
            }
            else if(city.equalsIgnoreCase("Springbok")){
                writeToAreaFile("springbok.txt", name, orderNumber);
            }
            else if(city.equalsIgnoreCase("Potchefstroom")){
                writeToAreaFile("potchefstroom.txt", name, orderNumber);
            }

            capeList = fetchList("capeTown.txt", capeList);
            durbanList = fetchList("durban.txt", durbanList);
            johannesList = fetchList("johannesburg.txt", johannesList);
            bloemList = fetchList("bloemfontein.txt", bloemList);
            witList = fetchList("witbank.txt", witList);
            portList = fetchList("portElizabeth.txt", portList);
            springList = fetchList("springbok.txt", springList);
            potchList = fetchList("potchefstroom.txt", potchList);



            writeListToFile();
            break;
        }
    }

    // method to output the list of names to a string
    private String listToOutput(ArrayList<String> arrayList){
        String listOutput = "";
        if(arrayList.size() > 0){
            for(int i = 0; i < arrayList.size(); i++){
                listOutput += arrayList.get(i) + "\n";
            }
        }
        else{
            return listOutput;
        }

        
        return listOutput;
    }

    // method to out put the lists of names in an easy to read format
    // under their respective area headings
    public String toString(){

        String output = "CAPE TOWN\n\n";
        output += listToOutput(capeList);
        output += "\n\nDURBAN\n\n";
        output += listToOutput(durbanList);
        output += "\n\nJOHANNESBURG\n\n";
        output += listToOutput(johannesList);
        output += "\n\nBLOEMFONTEIN\n\n";
        output += listToOutput(bloemList);
        output += "\n\nWITBANK\n\n";
        output += listToOutput(witList);
        output += "\n\nPORT ELIZABETH\n\n";
        output += listToOutput(portList);
        output += "\n\nSPRINGBOK\n\n";
        output += listToOutput(springList);
        output += "\n\nPOTCHEFSTROOM\n\n";
        output += listToOutput(potchList);

        return output;
    }

    // method to write customer names to their respective area files
    private void writeToAreaFile(String fileName, String name, String orderNumber){
        PrintWriter printWriter = null;

            try {
                printWriter = new PrintWriter(new FileOutputStream("textDocs/" + fileName, true));
                printWriter.write(name + ", " + orderNumber + "\n");
            } 
    
            // if input/output operation fails
            // print stack trace
            catch (IOException ioex) {
                ioex.printStackTrace();
            } 
    
            // finally if printWriter exists
            // flush and close the printWriter
            finally {
                if (printWriter != null) {
                    printWriter.flush();
                    printWriter.close();
                }
            }
    }

    // method to fetch customers names and sort them according to their natural ordering
    private ArrayList<String> fetchList(String fileName, ArrayList<String> arrayList){
        // fetch the file information
        // scan the file information
        // while file has a next line 
        // add each line to nameAndOrderNumArray
        try {
            File x = new File("textDocs/" + fileName);
            Scanner sc = new Scanner(x);
        
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if(line == ""){
                    break;
                }
                else{
                    arrayList.add(line);
                }
            }
        
            // close the scan of nameAndOrderNum.txt
            sc.close();
        
            // output an error if file is not found
        } catch (FileNotFoundException e) {
            System.out.println("FetchError");
        }

        return arrayList = sortList(arrayList);
    }

    // method to sort array list in natural order of elements
    private ArrayList<String> sortList(ArrayList<String> arrayList){
        SortArrayListAscending sortArrayList = new SortArrayListAscending(arrayList);
        ArrayList<String> sortedArrayListAscending = sortArrayList.sortAscending(); 

        return sortedArrayListAscending;
    }

    // method to write the Organised and structured Output of customer names
    // to its respective File
    private void writeListToFile(){
        try {
            Formatter f = new Formatter("textDocs/nameAndLocation.txt");
            f.format("%s", "");
            f.format("%s", toString());
            f.close();
        
        } catch (FileNotFoundException e) {
        }
    }

    // method to check if a string is null
    private boolean nullCheck(String stringToCheck){
        if(stringToCheck != null){
            return true;
        }
        return false;
    }
}



