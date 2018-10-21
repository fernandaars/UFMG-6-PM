package at3;

import java.util.Random;

public class VirtualPlayer {
    public Point generateNextMove(Point emptySquares[]){
        int numOfPossibleMoves = emptySquares.length;
        
        Random rand = new Random();
        int nextMove = rand.nextInt(numOfPossibleMoves - 1);
        return emptySquares[nextMove];
    }  
}
