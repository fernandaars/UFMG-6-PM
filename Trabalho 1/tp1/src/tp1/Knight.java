
package tp1;
public class Knight {
    Square currentPosition;
    int numPossibleMoves = 8;
    Square possibleMoves[];
    
    public Knight(Square firstPosition){
        this.possibleMoves = new Square[8];
        this.currentPosition = firstPosition;
        this.setPossibleMoves();
    }
    
    public final void setPossibleMoves() {
        this.possibleMoves[0] = new Square( 1, 2);
        this.possibleMoves[1] = new Square( 1,-2);
        this.possibleMoves[2] = new Square( 2, 1);
        this.possibleMoves[3] = new Square( 2,-1);
        this.possibleMoves[4] = new Square(-1, 2);
        this.possibleMoves[5] = new Square(-1,-2);
        this.possibleMoves[6] = new Square(-2, 1);
        this.possibleMoves[7] = new Square(-2,-1);
    }
    
    boolean move(Square finalPosition){
        if(finalPosition != null){
            this.currentPosition = finalPosition;
            return true;
        }
        return false;
    }
    
    int getAdjacencyDegree(Chessboard cBoard, Square coordinate){
        int count = 0;
        Square newCoordinate = new Square(coordinate.x,coordinate.y);
    
        for (int i = 0; i < this.numPossibleMoves; i++){
            int x = coordinate.x + this.possibleMoves[i].x;
            int y = coordinate.y + this.possibleMoves[i].y;
        
            newCoordinate.x = x;
            newCoordinate.y = y;
            if (!cBoard.isUnvisited(newCoordinate)) {
            } else {
                count++;
            }
        }
        return count;
    }
    
    boolean passedAllSquares(Chessboard cBoard){
        for (int i = 0; i < cBoard.size; ++i){
            for (int j = 0; j < cBoard.size; ++j){
                if(cBoard.positions[i][j] == 0)
                    return false;
            
            }
        }
    return true;
}
}
