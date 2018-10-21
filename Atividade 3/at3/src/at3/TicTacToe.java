package at3;

class TicTacToe{
    int side;
    int numOfsquares;
    int memory[][];
    VirtualPlayer vPlayer;
    GraphicalInterface window;
    
    static int EMPTY_POSITIONS = 0;
    static int REAL_PLAYER_POINT = 1;
    static int VIRTUAL_PLAYER_POINT = -1;
    
    public TicTacToe(int side) {
       this.side = side;
       this.numOfsquares = this.side*this.side;
       this.memory = new int[this.side][this.side];
       for(int i=0; i<this.side; i++){
           for(int j=0; j<this.side; j++){
               this.memory[i][j] = TicTacToe.EMPTY_POSITIONS;
           }
       }
       this.window = new GraphicalInterface(this.side, this);
    }
    
    public void startGame(){
        this.window.createWindow();
    }
    
    private boolean gameHasEnded(int whichPlayerMadeMove){
        // Define All Possible Kinds Of Victory
        int possibleVictories[] = new int[this.side+this.side+2];
        // Define The Characters to do the Comparation
        int possibleWinners[] = new int[this.side+this.side+2];
        
        for(int i=0; i<this.side+this.side+2; i++){
            possibleVictories[i] = TicTacToe.EMPTY_POSITIONS;
            possibleWinners[i] = TicTacToe.EMPTY_POSITIONS;
        }
        possibleWinners[this.side+this.side] = this.memory[0][0];
        possibleWinners[this.side+this.side+1] = this.memory[this.side-1][0];
        for(int i=0; i<this.side; i++){
            possibleWinners[i] = this.memory[i][0];
            possibleWinners[this.side+i] = this.memory[0][i];
            for(int j=0; j<this.side; j++){
                if(this.memory[i][j] != TicTacToe.EMPTY_POSITIONS){           
                    if(possibleWinners[i] == this.memory[i][j])
                        possibleVictories[i] += 1;
                    
                    if((i==j && possibleWinners[this.side+this.side] == this.memory[i][j]))
                        possibleVictories[this.side+this.side] += 1;
                    
                    if((i+j == (this.side-1) && possibleWinners[this.side+this.side+1] == this.memory[i][j]))
                        possibleVictories[this.side+this.side+1] += 1;     
                }
                
                if(this.memory[j][i] != TicTacToe.EMPTY_POSITIONS){     
                    if(possibleWinners[this.side+i] == this.memory[j][i])
                        possibleVictories[this.side+i] += 1;
                }
            }
        }

        for(int i=0; i<this.side+this.side+2; i++){
            if(possibleVictories[i] == this.side){
                return true;
            }
        }
        return false;
    }
    private void handleEndGame(int whichPlayerMadeMove){
        System.out.println("cabou");
    }

    private Point[] findEmptyMoves(){
        int numOfEmptyMoves = 0;
        for(int i=0; i<this.side; i++){
            for(int j=0; j<this.side; j++){
                if(this.memory[i][j] != TicTacToe.EMPTY_POSITIONS) {
                } else {
                    numOfEmptyMoves += 1;
                }
            }
        }
        System.out.println(numOfEmptyMoves);
        int count = 0;
        Point[] emptySquares = new Point[numOfEmptyMoves];
        System.out.println("TAMANHO:"+emptySquares.length);
        for(int i=0; i<this.side; i++){
            for(int j=0; j<this.side; j++){
                if(this.memory[i][j] == TicTacToe.EMPTY_POSITIONS){
                    System.out.println(count);
                    emptySquares[count] = new Point(i,j);
                    count += 1;
                }
            }
        }
        System.out.println("aqui");
        return emptySquares;
    }
    
    public void handlePlayerMove(Point i, int whichPlayerMadeMove){
        int x,y;
        x = (int) i.getX();
        y = (int) i.getY();
        this.memory[x][y] = whichPlayerMadeMove;
        if(this.gameHasEnded(int whichPlayerMadeMove)){
            this.handleEndGame(int whichPlayerMadeMove);
        }
        if(whichPlayerMadeMove == TicTacToe.REAL_PLAYER_POINT){
            Point nextMove = this.vPlayer.generateNextMove(this.findEmptyMoves());
            System.out.println("cheguei");
            x = nextMove.getX();
            y = nextMove.getY();
            this.memory[x][y] = TicTacToe.VIRTUAL_PLAYER_POINT;
            this.window.markPlayerMove(nextMove,TicTacToe.VIRTUAL_PLAYER_POINT);
            if(this.gameHasEnded(int whichPlayerMadeMove)){
                this.handleEndGame(int whichPlayerMadeMove);
            }
        }
    }
}
