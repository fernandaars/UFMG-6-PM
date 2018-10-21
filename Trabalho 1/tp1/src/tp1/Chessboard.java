
package tp1;
public class Chessboard {
    int size;
    int[][] positions;

    public Chessboard(int size) {
        this.size = size;
        this.positions = new int[this.size][this.size];
        this.cleanChessboard();
    }
    
    final void cleanChessboard(){
        int i, j;
        for(i=0; i<this.size; i++){
            for(j=0; j<this.size; j++){
                this.positions[i][j] = 0;
            }
        }
    }
    
    void printChessboard(){
        int i, j;
        System.out.println("-----------------------------------------");
        for(i=0; i<this.size; i++){
            for(j=0; j<this.size; j++){
                System.out.format("| %2d ", this.positions[i][j]);
            }
            System.out.println("|");
            System.out.println("-----------------------------------------");
        }
    }
    
    boolean isNotBorder(Square coordinate){
        return ((coordinate.x >= 0 && coordinate.y >= 0) && (coordinate.x < this.size && coordinate.y < this.size));
    }
    
    boolean isUnvisited(Square coordinate){
        return (isNotBorder(coordinate)) && (this.positions[coordinate.x][coordinate.y] == 0);
    }
}
