
package tp1;

import java.util.Random;
public class Tp1 {
    private static Knight chesspiece;
    private static Chessboard cBoard;
    private static WarnsdorffAlgorithm solution;
    
    public static void main(String[] args) {
        int x, y;
        int sizeOfBoard = 8;
        
        Random rand = new Random();
        Square firstPosition;
        firstPosition = new Square(x = rand.nextInt(sizeOfBoard - 1),
                y = rand.nextInt(sizeOfBoard - 1));
        
        System.out.println("Simulação do Passeio do Cavalo em Tabuleiro 8x8");
        System.out.println("Coordenadas Iniciais:["+(x+1)+"]["+(y+1)+"]");
        
        Tp1.solution = new WarnsdorffAlgorithm(Tp1.chesspiece, Tp1.cBoard);
        long startTime = System.currentTimeMillis();
        if(Tp1.solution.findSolution(firstPosition, sizeOfBoard) ==  true){
            System.out.println("Existe Solução:");
            Tp1.solution.cBoard.printChessboard();
            System.out.println("Números de Casas Visitadas: " + 
                    Tp1.solution.numOfMoves);
        }else{
            System.out.println("NÃO EXISTE SOLUÇÃO!");
        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Tempo de Execução: "+elapsedTime+ " Milissegundos");
        System.out.println();
    }
}