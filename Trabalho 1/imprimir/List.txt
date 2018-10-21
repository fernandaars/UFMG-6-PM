
package at1;
public abstract class List {
    int numOfElements;
    int totalOfElements;
    Object[] elements;
    
    public List(int totalOfElements){
        this.numOfElements = -1;
        this.totalOfElements = totalOfElements;
        this.elements = new Object[this.totalOfElements];
    }
    
    void printList(){
        int i;
        for(i=0; i<this.totalOfElements;i++){
            System.out.print(this.elements[i] + " ");
        }
        System.out.println("");
    }
    
    void insertElement(Object element){
        this.numOfElements += 1;
        this.elements[this.numOfElements] = element;
        
    }
}
