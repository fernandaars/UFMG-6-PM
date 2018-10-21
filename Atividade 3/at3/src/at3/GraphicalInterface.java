package at3;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;
    
class GraphicalInterface extends JFrame {
    int side;
    int numOfButtons;
    private JButton squares[][];
    TicTacToe controller;
    
    static String REAL_PLAYER_MARK = "O";
    static String VIRTUAL_PLAYER_MARK = "X";
   
    GraphicalInterface(int side, TicTacToe controller) {
       super("Tic Tac Toe");
       this.side = side;
       this.numOfButtons = this.side*this.side;
       this.squares = new JButton[this.side][this.side];
       this.controller = controller;
    }
    
    public void createGameWindow(){
        int i, j;
        JButton n = new JButton();
        for(i=0; i<this.side; i++){
            for(j=0; j<this.side; j++){
                this.squares[i][j] = new JButton("");
                this.squares[i][j].setBorder(new LineBorder(Color.pink));
                this.squares[i][j].setBackground(Color.WHITE);
                this.squares[i][j].setFont(new Font("Times New Roman", Font.PLAIN, 40));
                this.squares[i][j].addActionListener((java.awt.event.ActionEvent evt) -> {                    
                    this.handlePressedButton((JButton) evt.getSource());
                });
            }
        }
        
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(this.side, this.side));
        for(i=0; i<this.side; i++){
            for(j=0; j<this.side; j++){
                pane.add(this.squares[i][j]);
            }
        }
        pane.setBounds(2, 2, 2, 2);
        this.setPreferredSize(new Dimension(300,300));
        this.setBackground(Color.pink);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.pack();
    }
    public void markPlayerMove(Point nextMove, int whichPlayerMadeMove){
        int x = (int) nextMove.getX();
        int y = (int) nextMove.getY();
        
        if(whichPlayerMadeMove == TicTacToe.REAL_PLAYER_POINT)
            this.squares[x][y].setText(GraphicalInterface.REAL_PLAYER_MARK);
        else
            this.squares[x][y].setText(GraphicalInterface.VIRTUAL_PLAYER_MARK);
    }
    private void handlePressedButton(JButton pressedButton) {
        for(int i=0; i<this.side; i++){
            for(int j=0; j<this.side; j++){
                if(pressedButton.equals(this.squares[i][j])){
                    this.controller.handlePlayerMove(new Point(i,j), TicTacToe.REAL_PLAYER_POINT);
                    this.markPlayerMove(new Point(i,j), TicTacToe.REAL_PLAYER_POINT);
                    break;
                }
            }
        }
    }
} 

