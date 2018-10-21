
package at1;
import java.util.Arrays;

public class stringList extends List{
    
    public stringList(int totalOfElements) {
        super(totalOfElements);
    }
    
     void insertElement(String element){
        super.insertElement(element);
    }
     
    void sortList(){
        Arrays.sort(this.elements);
    }

    
}
