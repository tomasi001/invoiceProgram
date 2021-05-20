import java.io.FileNotFoundException;
import java.util.Formatter;

public class WriteToFile {
    // create constructor to write a variable of type invoice to a text file
    public WriteToFile(Invoice inv) {
        try {
            Formatter f = new Formatter("textDocs/invoice.txt");
            f.format("%s", inv);
            f.close();

        } catch (FileNotFoundException e) {
        }
    }
}
