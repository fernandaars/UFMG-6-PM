
package tp1;
import java.util.Random;

public class WarnsdorffAlgorithm {
    int numOfMoves;
    Knight chesspiece;
    Chessboard cBoard;

    public WarnsdorffAlgorithm(Knight chesspiece, Chessboard cBoard) {
        this.chesspiece = chesspiece;
        this.cBoard = cBoard;
        this.numOfMoves = 0;
    }
    
    boolean nextMove(){
        int min_deg_idx = -1;
        int min_deg = this.cBoard.size;
        int limits = this.chesspiece.numPossibleMoves;
        int c;
        Square n = new Square();

        Random rand = new Random();
        int start = rand.nextInt(limits - 1);
        for (int count = 0; count < limits; count++){
            int i = (start + count) % (limits);
            n.x = this.chesspiece.currentPosition.x + this.chesspiece.possibleMoves[i].x;
            n.y = this.chesspiece.currentPosition.y + this.chesspiece.possibleMoves[i].y;
            if ((c = this.chesspiece.getAdjacencyDegree(this.cBoard, n)) 
                    < min_deg && (this.cBoard.isUnvisited(n))){
                min_deg_idx = i;
                min_deg = c;
            }
        }
        
        if (min_deg_idx == -1)
            return false;

        n.x = this.chesspiece.currentPosition.x + 
                this.chesspiece.possibleMoves[min_deg_idx].x;
        n.y = this.chesspiece.currentPosition.y + 
                this.chesspiece.possibleMoves[min_deg_idx].y;
        
        this.numOfMoves++;
        this.cBoard.positions[n.x][n.y] = this.numOfMoves;
        this.chesspiece.currentPosition = n;
        return true;
    }
    
    boolean findSolution(Square firstPosition, int sizeOfBoard){
        this.cBoard = new Chessboard(sizeOfBoard);
        this.chesspiece = new Knight(firstPosition);
        
        this.numOfMoves++;
        cBoard.positions[chesspiece.currentPosition.x][chesspiece.currentPosition.y] = this.numOfMoves;
        int limits = (cBoard.size)*(cBoard.size) - 1;
        for (int i = 0; i < limits; i++)
            if (nextMove() == false)
                return false;

        return this.chesspiece.passedAllSquares(this.cBoard);
    }
    
}
