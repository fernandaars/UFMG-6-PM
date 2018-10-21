
package at1;
import java.util.Scanner;
public class At1 {
    public static void main(String[] args) {
        System.out.println(".: Atividade 1 de Programação Modular :.");
        try (Scanner reader = new Scanner(System.in)) {
            System.out.println(" Insira o Total de Elementos da Lista de Inteiros: ");
            int totalOfElements = reader.nextInt();
            intList listOfIntegers = new intList(totalOfElements);
            
            int i;
            System.out.println("Insira os Elementos da Lista: ");
            for(i=0; i<listOfIntegers.totalOfElements; i++){
                int n = reader.nextInt();
                listOfIntegers.insertElement(n);
            }
            System.out.println("Elementos da Lista: ");
            listOfIntegers.printList();
            System.out.println("Ordenando Lista ... ");
            listOfIntegers.sortList();
            System.out.println("Elementos da Lista: ");
            listOfIntegers.printList();
            
            System.out.println(" Insira o Total de Elementos da Lista de Strings: ");
            totalOfElements = reader.nextInt();
            stringList listOfStrings = new stringList(totalOfElements);
            System.out.println("Insira os Elementos da Lista: ");
            for(i=0; i<listOfStrings.totalOfElements; i++){
                String m = reader.nextLine();
                listOfStrings.insertElement(m);
            }
            System.out.println("Elementos da Lista: ");
            listOfStrings.printList();
            System.out.println("Ordenando Lista ... ");
            listOfStrings.sortList();
            System.out.println("Elementos da Lista: ");
            listOfStrings.printList();
        }
    }
    
}
