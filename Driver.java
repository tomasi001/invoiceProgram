import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Scanner;

public class Driver {
    // declare attributes
    String name;
    String driverOutput;

    // declare constructor with parameters
    public Driver(String resArea) {
        this.driverOutput = driverInfo(resArea);
    }

    // fetch driver details from driver.txt
    public String driverInfo(String resArea) {

        addToLoad(fetchDrivers(), selectDriver(fetchDrivers(), resArea), resArea);
        return driverOutput;
    }

    // method to fetch drivers information
    private ArrayList<String> fetchDrivers() {
        // declare array list to store list of drivers
        ArrayList<String> driverArray = new ArrayList<>();

        // fetch the file information
        // scan the file information
        // while file has a next line
        // add each line to driverArray
        try {
            File x = new File("textDocs/driver-info.txt");
            Scanner sc = new Scanner(x);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                driverArray.add(line);
            }

            // close the scan of driver-info.txt
            sc.close();

            // output an error if file is not found
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
        return driverArray;
    }

    // method to select the relevant driver for each order
    private String selectDriver(ArrayList<String> drivers, String resArea) {
        // declare temp array list to store list of drivers
        ArrayList<String> tempList = drivers;

        // declare array list to store list of potential drivers
        ArrayList<String> potentialDrivers = new ArrayList<>();

        // if a one of the drivers in the driver array contains the area
        // which the restaurant is situated add it to potentialDrivers array
        for (int i = 0; i < tempList.size(); i++) {
            String drivName = tempList.get(i);
            while (nullCheck(resArea)) {
                if (drivName.contains(resArea)) {
                    potentialDrivers.add(tempList.get(i));
                }
                break;
            }
        }

        // if there are no drivers in the array print out sorry message
        if (potentialDrivers.size() < 1) {
            driverOutput = "Sorry! Our drivers are too far away from your location";
        }

        // else create drivLoads array to store drivers loads
        else {
            ArrayList<Integer> drivLoads = new ArrayList<>();

            // add the load to the driv loads array
            for (int i = 0; i < potentialDrivers.size(); i++) {
                String drivInfo = potentialDrivers.get(i).split(", ")[2];
                int drivLoad = Integer.parseInt(String.valueOf(drivInfo));
                drivLoads.add(drivLoad);
            }

            // find the smallest number in the arraylist
            int smallestLoad = Collections.min(drivLoads);

            // if load of drivers in potential drivers matches smallest number in array list
            // get drivers name and print out relevant message
            for (int i = 0; i < potentialDrivers.size(); i++) {
                int drivInfo = Integer.parseInt(potentialDrivers.get(i).split(", ")[2]);
                if (drivInfo == smallestLoad) {
                    name = potentialDrivers.get(i).split(", ")[0];
                    driverOutput = name
                            + " is nearest to the restaurant and so they will be delivering your order to you at: ";
                }
            }
        }
        return name;
    }

    // method to add to a drivers load and call the function to update the drivers file
    private void addToLoad(ArrayList<String> drivers, String name, String resArea) {
        while (nullCheck(name)) {
            // declare temp array list to store list of drivers
            ArrayList<String> tempList = drivers;

            // if potential driversArray contains name variable
            // split the number from the string and parse to int
            // add 1 and concatenate the string again
            // remove line containing variable
            // add new line with updated load
            String drivInfo = "";
            String drivLoad = "";
            int newLoad = 0;

            for (int i = 0; i < tempList.size(); i++) {
                String drivName = tempList.get(i);
                while (nullCheck(name)) {
                    if (drivName.contains(name)) {
                        drivInfo = tempList.get(i);
                        drivLoad = drivInfo.split(", ")[2];
                        newLoad = Integer.parseInt(String.valueOf(drivLoad));
                        resArea = drivInfo.split(", ")[1];
                        tempList.remove(i);
                    }
                    break;
                }
            }

            drivInfo = name + ", " + resArea + ", " + (newLoad + 1);
            tempList.add(drivInfo);

            writeToDriverFile(toOutput(tempList));
            break;
        }
    }

    // method to output the array of drivers as an easy to read list
    private String toOutput(ArrayList<String> arrayList) {

        String output = "";

        for (int i = 0; i < arrayList.size(); i++) {
            output += arrayList.get(i) + "\n";
        }

        return output;
    }

    // method to write the easy to read list of drivers information 
    // to its respective file
    private void writeToDriverFile(String output) {
        try {
            Formatter f = new Formatter("textDocs/driver-info.txt");
            f.format("%s", output);
            f.close();

        } catch (FileNotFoundException e) {
        }
    }

    // method to check if a string is null
    private boolean nullCheck(String stringToCheck) {
        if (stringToCheck != null) {
            return true;
        }
        return false;
    }
}
