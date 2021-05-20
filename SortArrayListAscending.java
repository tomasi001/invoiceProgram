import java.util.ArrayList; 
import java.util.Collections;   

// create class which takes an array list and sorts the list
// according to the natural order of elements
public class SortArrayListAscending{

      private ArrayList<String> arrayList;       
    
      public SortArrayListAscending(ArrayList<String> arrayList) {         
        this.arrayList = arrayList;     
      }       
    
      public ArrayList<String> sortAscending() {         
        Collections.sort(this.arrayList);         
        return this.arrayList;     
      }       
}
