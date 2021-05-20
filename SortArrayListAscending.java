import java.util.ArrayList; 
import java.util.Collections;   

public class SortArrayListAscending{

      private ArrayList<String> arrayList;       
    
      public SortArrayListAscending(ArrayList<String> arrayList) {         
        this.arrayList = arrayList;     
      }       
    
      public ArrayList<String> getArrayList() {         
        return this.arrayList;     
      }       
    
      public ArrayList<String> sortAscending() {         
        Collections.sort(this.arrayList);         
        return this.arrayList;     
      }       
}
