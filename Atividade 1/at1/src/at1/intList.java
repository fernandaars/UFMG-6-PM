
package at1;
import java.util.Arrays;

public class intList extends List{

    public intList(int totalOfElements) {
        super(totalOfElements);
    }
    
    void insertElement(int element){
        super.insertElement(element);
    }
    
    void sortList(){
        Arrays.sort(this.elements);
    }
    
}
