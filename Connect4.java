/* Title:  Connect4.java
 * Author: Wayne Snyder (waysnyder@gmail.com)
 * Date: 4/19/12
 * Purpose: This is a driver program for a Connect4 program for CS 112
 * Uses: method move() from class Player
 */    


import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.EventObject;


public class Connect4 {
  
  static final int height = 8;           // If you change these you'll need to rewrite the GUI
  static final int width = 8;
  static final int N = 4; 
  static String [] names = { "", "", "", "Three", "Four", "Five", "Six", "Seven", "Eight" }; 
  
  private static JFrame frame=new JFrame("Connect " + names[N]);
  private static int [][] slot = new int[height][width];                 // 0 = no piece; 1 = player;  2 = machine
  private static JButton [][] slotButton = new JButton[height][width];   // Background color = no piece; red = player; blue = machine
  private static JLabel l1=new JLabel("Connect " + names[N]); 
  private static JButton resetButton = new JButton("Reset");
  private static JButton quitButton = new JButton("Quit");
  private static JLabel results = new JLabel("Playing....");  

  
  private static Color bg = new Color(255,240,180); 
  private static Color [] normal = { new Color(255,240,180), new Color(255,100,100), new Color(100,100,255) };  
  private static Color [] win  = { new Color(255,240,180), new Color(200,0,0), new Color(0,0,200) };   
  
  // Determines whether a sequence of N slots is inhabited by player, where the sequence starts at (i,j) and
  //     moves along the rows by rowInc (-1,0, or 1) and along the columns by colInc (-1,0, or 1). 
  private static boolean equalN(int [][] board, int N, int player,  
                                int i, int j, int rowInc, int colInc) { 
      for(int k = 0; k < N; ++k) {
        if(board[i][j] != player)
          return false;
        i += rowInc;
        j += colInc;   
      }
      return true; 
   }
   
  // check for win by player, 4 in a sequence
  private static boolean checkWin(int player) {    // 1 = player, 2 = machine

    // check all horizontal rows
    for(int i = 0; i < height; ++i)
      for(int j = 0; j < width-N+1; ++j) {
         if(equalN(slot, N, player, i, j, 0, 1)) {
             // code when found win
           int j2 = j;
           for(int k = 0; k < N; ++k) {
             slotButton[i][j2].setBackground(win[player]); 
             slotButton[i][j2].setOpaque(true); 
             j2 += 1; 
           }
           return true;
         }
      }
 
    // check all vertical columns
    for(int i = 0; i < height-N+1; ++i)
      for(int j = 0; j < width; ++j) {
         if(equalN(slot, N, player, i, j, 1, 0)) {
             // code when found win
           int i2 = i;
           for(int k = 0; k < N; ++k) {
             slotButton[i2][j].setBackground(win[player]); 
             slotButton[i2][j].setOpaque(true); 
             i2 += 1; 
           }
           return true;
         }
    } 

 
    // check all lower-left to upper-right diagonals
    for(int i = N-1; i < height; ++i)
      for(int j = 0; j < width-N+1; ++j) {
      
         if(equalN(slot, N, player, i, j, -1, 1)) {
             // code when found win
           int i2 = i; int j2 = j; 
           for(int k = 0; k < N; ++k) {
             slotButton[i2][j2].setBackground(win[player]); 
             slotButton[i2][j2].setOpaque(true); 
             i2 += -1; j2 += 1; 
           }
           return true;
         }  
    }   
    // check all upper-left to lower-right diagonals
    for(int i = 0; i < height-N+1; ++i)
      for(int j = 0; j < width-N+1; ++j) {
         if(equalN(slot, N, player, i, j, 1, 1)) {
           int i2 = i; int j2 = j; 
           for(int k = 0; k < N; ++k) {
             slotButton[i2][j2].setBackground(win[player]); 
             slotButton[i2][j2].setOpaque(true); 
             i2 += 1; j2 += 1; 
           }
           return true;
         }
    }

     return false;  
  }
  

  
  private static void reset() {
     for(int i = 0; i < height; ++i)
       for(int j = 0; j < width; ++j)
          slot[i][j] = 0; 
     for(int i = 0; i < height; ++i)
       for(int j = 0; j < width; ++j) {
          slotButton[i][j].setBackground(bg); 
          slotButton[i][j].setOpaque(true); 
       }
     results.setText("Playing...."); 
  }
  
  public static void main(String [] args) {
    
     Player machine = new Player(); 
   
     frame.setSize(1000,1000);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setBackground(bg); 

     l1.setFont(new Font("TimesRoman",Font.BOLD,32)); 
     quitButton.setFont(new Font("TimesRoman",Font.BOLD,20)); 
     resetButton.setFont(new Font("TimesRoman",Font.BOLD,20)); 
     results.setFont(new Font("TimesRoman",Font.BOLD,20)); 
     

     
     for(int i = 0; i < height; ++i)
       for(int j = 0; j < width; ++j) {
          slotButton[i][j] = new JButton(); 
          JBox.setSize(slotButton[i][j],80,80); 
          slotButton[i][j].setBorder(BorderFactory.createEtchedBorder());
       }
 
     /*   This one is for a 6x6 board 
     JBox body=JBox.vbox(JBox.CENTER, 
                         JBox.vspace(20),
                         l1,
                         JBox.vspace(30), 
                         JBox.hbox(JBox.CENTER, 
                                   slotButton[0][0], slotButton[0][1], slotButton[0][2], slotButton[0][3], slotButton[0][4], slotButton[0][5]),
                         JBox.hbox(JBox.CENTER,                         
                                   slotButton[1][0], slotButton[1][1], slotButton[1][2], slotButton[1][3], slotButton[1][4], slotButton[1][5]),
                         JBox.hbox(JBox.CENTER,
                                   slotButton[2][0], slotButton[2][1], slotButton[2][2], slotButton[2][3], slotButton[2][4], slotButton[2][5]),
                         JBox.hbox(JBox.CENTER,
                                   slotButton[3][0], slotButton[3][1], slotButton[3][2], slotButton[3][3], slotButton[3][4], slotButton[3][5]),
                         JBox.hbox(JBox.CENTER,
                                   slotButton[4][0], slotButton[4][1], slotButton[4][2], slotButton[4][3], slotButton[4][4], slotButton[4][5]),
                          JBox.hbox(JBox.CENTER,
                                   slotButton[5][0], slotButton[5][1], slotButton[5][2], slotButton[5][3], slotButton[5][4], slotButton[5][5]),                          JBox.vspace(10),
                           JBox.vspace(20),
                         JBox.hbox(JBox.CENTER,
                                  
                                   quitButton, JBox.hspace(60), 
                                   resetButton, JBox.hspace(60), 
                                   results),
                         JBox.vspace(20)
     ); 
  */   
     JBox body=JBox.vbox(JBox.CENTER, 
                         JBox.vspace(10),
                         l1,
                         JBox.vspace(10), 
                         JBox.hbox(JBox.CENTER, 
                                   slotButton[0][0], slotButton[0][1], slotButton[0][2], slotButton[0][3], slotButton[0][4], slotButton[0][5], slotButton[0][6],slotButton[0][7]),
                         JBox.hbox(JBox.CENTER,                         
                                   slotButton[1][0], slotButton[1][1], slotButton[1][2], slotButton[1][3], slotButton[1][4], slotButton[1][5], slotButton[1][6], slotButton[1][7]),
                         JBox.hbox(JBox.CENTER,
                                   slotButton[2][0], slotButton[2][1], slotButton[2][2], slotButton[2][3], slotButton[2][4], slotButton[2][5], slotButton[2][6],slotButton[2][7]),
                         JBox.hbox(JBox.CENTER,
                                   slotButton[3][0], slotButton[3][1], slotButton[3][2], slotButton[3][3], slotButton[3][4], slotButton[3][5], slotButton[3][6],slotButton[3][7]),
                         JBox.hbox(JBox.CENTER,
                                   slotButton[4][0], slotButton[4][1], slotButton[4][2], slotButton[4][3], slotButton[4][4], slotButton[4][5], slotButton[4][6],slotButton[4][7]),
                         JBox.hbox(JBox.CENTER,
                                   slotButton[5][0], slotButton[5][1], slotButton[5][2], slotButton[5][3], slotButton[5][4], slotButton[5][5], slotButton[5][6],slotButton[5][7]),                                   
                         JBox.hbox(JBox.CENTER,
                                   slotButton[6][0], slotButton[6][1], slotButton[6][2], slotButton[6][3], slotButton[6][4], slotButton[6][5], slotButton[6][6],slotButton[6][7]),                                   
                        JBox.hbox(JBox.CENTER,
                                   slotButton[7][0], slotButton[7][1], slotButton[7][2], slotButton[7][3], slotButton[7][4], slotButton[7][5], slotButton[7][6],slotButton[7][7]),                                    
                         JBox.vspace(10),
                         JBox.hbox(JBox.CENTER,
                                   quitButton, JBox.hspace(100), 
                                   resetButton, JBox.hspace(100), 
                                   results),
                         JBox.vspace(10)
     ); 
  
                           
     frame.add(body);
     frame.setVisible(true);
     
     JEventQueue events=new JEventQueue();
     events.listenTo(resetButton,"reset");
     events.listenTo(quitButton,"quit");
     for(int i = 0; i < height; ++i) 
       for(int j = 0; j < width; ++j) 
         events.listenTo(slotButton[i][j], i + " " + j);
   
    eventloop:   while(true){
        EventObject event=events.waitEvent();
        String name=events.getName(event);
        if(name.equals("quit")){
            System.exit(1); 
        } else if(name.equals("reset")){
            reset(); 
        } else {
          for(int i = 0; i < height; ++i) 
            for(int j = 0; j < width; ++j) {
              if(name.equals(i + " " + j)){ 
                 if(slot[i][j] != 0)
                     continue eventloop; 
                 slot[i][j] = 1; 
                 slotButton[i][j].setBackground(normal[1]); 
                 slotButton[i][j].setOpaque(true); 
               
              }       
            }
          
          if(checkWin(1)) {
            results.setText("Red Player Wins!"); 
            try {
             Thread.sleep(2000);
            } catch(InterruptedException e) {
            }
            results.setText("Resetting...."); 
            try {
             Thread.sleep(2000);
            } catch(InterruptedException e) {
            }
            reset(); 
            continue; 
          }
          try {
             Thread.sleep(1000);
          } catch(InterruptedException e) {
          } 
          Pair p = machine.move(slot); 
          slot[p.row][p.col] = 2; 
          slotButton[p.row][p.col].setBackground(normal[2]); 
          slotButton[p.row][p.col].setOpaque(true); 
          if(checkWin(2)) {
            results.setText("Blue Player Wins!"); 
            try {
             Thread.sleep(2000);
            } catch(InterruptedException e) {
            }
            results.setText("Resetting...."); 
            try {
             Thread.sleep(2000);
            } catch(InterruptedException e) {
            }
            reset();  
          }
        }
     }
  }
  
}

 class Pair {
    int row;
    int col; 
    public Pair(int i, int j) { row = i; col = j; }
  }