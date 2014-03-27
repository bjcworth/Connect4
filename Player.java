/*  Sample Player class which just makes a random move
 */


import java.util.Random; 
public class Player {
  private static Random ran = new Random();
  static final int height = 8;          
  static final int width = 8;
  private static int [][] slot = new int[height][width];                 // 0 = no piece; 1 = player;  2 = machine
 
    
 public Pair move(int[][] board) {
  while(true) {

  
 //if(board[row][col] == 0) {
 return trackPlayer(1);
  }
 }
      
  
  
  private static boolean rowOfThree(int [][] board, int player, 
                                int i, int j, int rowInc, int colInc) { 
      for(int k = 0; k <= 3; ++k) {
        if(board[i][j] != player)
          return false;
        i += rowInc;
        j += colInc;   
      }
      return true; 
   }
  
  private Pair trackPlayer(int player) {    
  int row = 0;
  int col = 0;

    // check all horizontal slots
    for(int i = 0; i < height; ++i)
      for(int j = 0; j < width-4; ++j) {
         if(rowOfThree(slot, player , i, j, 0, 1)) {
           int j2 = j + 1;
           if(slot[i][j2] ==0) {
            row = i;
            col = j2;
           }
         }
         else {
      col = ran.nextInt(7);     // which slot to start search for a move
      row = ran.nextInt(7); 
         
         } return new Pair (row, col);
    } 
  
 
    // check all vertical slots
    for(int i = 0; i < height-4; ++i)
      for(int j = 0; j < width; ++j) {
         if(rowOfThree(slot, player, i, j, 1, 0)) {
           
           //when found
        int i2 = i + 1;
        if(slot[i2][j] == 0) {
     row = i2;
       col = j;
        }
         }
         else {
      col = ran.nextInt(7);     // which slot to start search for a move
      row = ran.nextInt(7); 
         
         } 
    } return new Pair (row, col);

/*
   // check all lower-left to upper-right diagonals
    for(int i = 3-1; i < height; ++i)
      for(int j = 0; j < width-3+1; ++j) {
      
         if(rowOfThree(slot, player, i, j, -1, 1)) {
             // code when found win
           int i2 = i; int j2 = j; 
           for(int k = 0; k < 3; ++k) {
             slotButton[i2][j2].setBackground(win[player]); 
             slotButton[i2][j2].setOpaque(true); 
             i2 += -1; j2 += 1; 
           }
 
         }  
    }   
    // check all upper-left to lower-right diagonals
    for(int i = 0; i < height-3+1; ++i)
      for(int j = 0; j < width-3+1; ++j) {
         if(rowOfThree(slot, player, i, j, 1, 1)) {
           int i2 = i; int j2 = j; 
           for(int k = 0; k < 3; ++k) {
             slotButton[i2][j2].setBackground(win[player]); 
             slotButton[i2][j2].setOpaque(true); 
             i2 += 1; j2 += 1; 
           }

         }
    } */

  } 
  
  

  
}