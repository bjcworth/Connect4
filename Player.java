/**  
 * Player class.
 * 
 * 
 * 
 * code implemented by: Alex Brewer & Brandon Charlesworth
 * 
 * This code calculates the score of each space on the board, depending on the number
 * of adjacent player-occupied spaces, and accounts for a few special cases. It finds the
 * space with the maximum score and returns that space to move. With the exception of
 * a few clever tatics, it will block most efforts to get four in a row. It gives 
 * priority to blocking the opponent over getting a win itself, which is playing it
 * on the safe(defensive) side. End.
 **/

import java.util.Random; 

public class Player {

    private final int height = 8;
    private final int width = 8;

    //calls whereIsMax
    public Pair move(int[][] board) {
        while(true) {
            return whereIsMax(board, 2);
        }  
}
    /**
     * This move function is for the extra credit.
     */
    public Pair move(int[][] board, int player) {
        while(true) {
            return whereIsMax(board, player);
        }  
}

    //Increments a score object based on the strategic value of the position
    public int findScore(Pair p, int[][] board, int player) {
        int score = 0;
        if(p.row < 5 && p.col < 5) {
            if(board[p.row + 1][p.col + 1] == (player % 2) + 1 && board[p.row + 2][p.col + 2] == (player % 2) + 1 && board[p.row + 3][p.col + 3] == (player % 2) + 1) score += 200;
        }
        if(p.row > 2 && p.col > 2) {
            if(board[p.row - 1][p.col - 1] == (player % 2) + 1 && board[p.row - 2][p.col - 2] == (player % 2) + 1 && board[p.row - 3][p.col - 3] == (player % 2) + 1) score += 200;
        }
        if(p.row < 5 && p.col > 2) {
            if(board[p.row + 1][p.col - 1] == (player % 2) + 1 && board[p.row + 2][p.col - 2] == (player % 2) + 1 && board[p.row + 3][p.col - 3] == (player % 2) + 1) score += 200;
        }
        if(p.row > 2 && p.col < 5) {
            if(board[p.row - 1][p.col + 1] == (player % 2) + 1 && board[p.row - 2][p.col + 2] == (player % 2) + 1 && board[p.row - 3][p.col + 3] == (player % 2) + 1) score += 200;
        }
        if(p.row < 5) {
            if(board[p.row + 1][p.col] == (player % 2) + 1 && board[p.row + 2][p.col] == (player % 2) + 1 && board[p.row + 3][p.col] == (player % 2) + 1) score += 200;
        }
        if(p.row > 2) {
            if(board[p.row - 1][p.col] == (player % 2) + 1 && board[p.row - 2][p.col] == (player % 2) + 1 && board[p.row - 3][p.col] == (player % 2) + 1) score += 200;
        }
        if(p.col < 5) {
            if(board[p.row][p.col + 1] == (player % 2) + 1 && board[p.row][p.col + 2] == (player % 2) + 1 && board[p.row][p.col + 3] == (player % 2) + 1) score += 200;
        }
        if(p.col > 2) {
            if(board[p.row][p.col - 1] == (player % 2) + 1 && board[p.row][p.col - 2] == (player % 2) + 1 && board[p.row][p.col - 3] == (player % 2) + 1) score += 200;
        }
        if(p.row < 6 && p.col < 6) {
            if(board[p.row + 1][p.col + 1] == (player % 2) + 1 && board[p.row + 2][p.col + 2] == (player % 2) + 1) score += 20;
        }
        if(p.row > 1 && p.col > 1) {
            if(board[p.row - 1][p.col - 1] == (player % 2) + 1 && board[p.row - 2][p.col - 2] == (player % 2) + 1) score += 20;
        }
        if(p.row < 6 && p.col > 1) {
            if(board[p.row + 1][p.col - 1] == (player % 2) + 1 && board[p.row + 2][p.col - 2] == (player % 2) + 1) score += 20;
        }
        if(p.row > 1 && p.col < 6) {
            if(board[p.row - 1][p.col + 1] == (player % 2) + 1 && board[p.row - 2][p.col + 2] == (player % 2) + 1) score += 20;
        }
        if(p.row < 6) {
            if(board[p.row + 1][p.col] == (player % 2) + 1 && board[p.row + 2][p.col] == (player % 2) + 1) score += 20;
        }
        if(p.row > 1) {
            if(board[p.row - 1][p.col] == (player % 2) + 1 && board[p.row - 2][p.col] == (player % 2) + 1) score += 20;
        }
        if(p.col < 6) {
            if(board[p.row][p.col + 1] == (player % 2) + 1 && board[p.row][p.col + 2] == (player % 2) + 1) score += 20;
        }
        if(p.col > 1) {
            if(board[p.row][p.col - 1] == (player % 2) + 1 && board[p.row][p.col - 2] == (player % 2) + 1) score += 20;
        }
        if(p.row < 7 && p.col < 7) {
            if(board[p.row + 1][p.col + 1] == (player % 2) + 1) score += 2;
        }
        if(p.row > 0 && p.col > 0) {
            if(board[p.row - 1][p.col - 1] == (player % 2) + 1) score += 2;
        }
        if(p.row < 7 && p.col > 0) {
            if(board[p.row + 1][p.col - 1] == (player % 2) + 1) score += 2;
        }
        if(p.row > 0 && p.col < 7) {
            if(board[p.row - 1][p.col + 1] == (player % 2) + 1) score += 2;
        }
        if(p.row < 7) {
            if(board[p.row + 1][p.col] == (player % 2) + 1) score += 2;
        }
        if(p.row > 0) {
            if(board[p.row - 1][p.col] == (player % 2) + 1) score += 2;
        }
        if(p.col < 7) {
            if(board[p.row][p.col + 1] == (player % 2) + 1) score += 2;
        }
        if(p.col > 0) {
            if(board[p.row][p.col - 1] == (player % 2) + 1) score += 2;
        }
        if(p.row < 5 && p.col < 5) {
            if(board[p.row + 1][p.col + 1] == player && board[p.row + 2][p.col + 2] == player && board[p.row + 3][p.col + 3] == player) score += 250;
        }
        if(p.row > 2 && p.col > 2) {
            if(board[p.row - 1][p.col - 1] == player && board[p.row - 2][p.col - 2] == player && board[p.row - 3][p.col - 3] == player) score += 250;
        }
        if(p.row < 5 && p.col > 2) {
            if(board[p.row + 1][p.col - 1] == player && board[p.row + 2][p.col - 2] == player && board[p.row + 3][p.col - 3] == player) score += 250;
        }
        if(p.row > 2 && p.col < 5) {
            if(board[p.row - 1][p.col + 1] == player && board[p.row - 2][p.col + 2] == player && board[p.row - 3][p.col + 3] == player) score += 250;
        }
        if(p.row < 5) {
            if(board[p.row + 1][p.col] == player && board[p.row + 2][p.col] == player && board[p.row + 3][p.col] == player) score += 250;
        }
        if(p.row > 2) {
            if(board[p.row - 1][p.col] == player && board[p.row - 2][p.col] == player && board[p.row - 3][p.col] == player) score += 250;
        }
        if(p.col < 5) {
            if(board[p.row][p.col + 1] == player && board[p.row][p.col + 2] == player && board[p.row][p.col + 3] == player) score += 250;
        }
        if(p.col > 2) {
            if(board[p.row][p.col - 1] == player && board[p.row][p.col - 2] == player && board[p.row][p.col - 3] == player) score += 250;
        }
        if(p.row < 6 && p.col < 6) {
            if(board[p.row + 1][p.col + 1] == player && board[p.row + 2][p.col + 2] == player) score += 10;
        }
        if(p.row > 1 && p.col > 1) {
            if(board[p.row - 1][p.col - 1] == player && board[p.row - 2][p.col - 2] == player) score += 10;
        }
        if(p.row < 6 && p.col > 1) {
            if(board[p.row + 1][p.col - 1] == player && board[p.row + 2][p.col - 2] == player) score += 10;
        }
        if(p.row > 1 && p.col < 6) {
            if(board[p.row - 1][p.col + 1] == player && board[p.row - 2][p.col + 2] == player) score += 10;
        }
        if(p.row < 6) {
            if(board[p.row + 1][p.col] == player && board[p.row + 2][p.col] == player) score += 10;
        }
        if(p.row > 1) {
            if(board[p.row - 1][p.col] == player && board[p.row - 2][p.col] == player) score += 10;
        }
        if(p.col < 6) {
            if(board[p.row][p.col + 1] == player && board[p.row][p.col + 2] == player) score += 10;
        }
        if(p.col > 1) {
            if(board[p.row][p.col - 1] == player && board[p.row][p.col - 2] == player) score += 10;
        }
        if(p.row < 7 && p.col < 7) {
            if(board[p.row + 1][p.col + 1] == player) score += 1;
        }
        if(p.row > 0 && p.col > 0) {
            if(board[p.row - 1][p.col - 1] == player) score += 1;
        }
        if(p.row < 7 && p.col > 0) {
            if(board[p.row + 1][p.col - 1] == player) score += 1;
        }
        if(p.row > 0 && p.col < 7) {
            if(board[p.row - 1][p.col + 1] == player) score += 1;
        }
        if(p.row < 7) {
            if(board[p.row + 1][p.col] == player) score += 1;
        }
        if(p.row > 0) {
            if(board[p.row - 1][p.col] == player) score += 1;
        }
        if(p.col < 7) {
            if(board[p.row][p.col + 1] == player) score += 1;
        }
        if(p.col > 0) {
            if(board[p.row][p.col - 1] == player) score += 1;
        }
        //special cases
        // diagonals
        if(p.row > 1 && p.row < 7 && p.col > 1 && p.col < 7) {
          if(board[p.row-2][p.col-2] == 1 && board[p.row - 1][p.col - 1] == (player % 2) + 1 && board[p.row + 1][p.col + 1] == (player % 2) + 1) score +=25;
        }
        if(p.row > 1 && p.row < 7 && p.col > 0 && p.col < 6) {
          if(board[p.row-2][p.col+2] == 1 && board[p.row - 1][p.col + 1] == (player % 2) + 1 && board[p.row + 1][p.col - 1] == (player % 2) + 1) score +=25;
        }
        if(p.row > 0 && p.row < 6 && p.col > 1 && p.col < 7) {
          if(board[p.row+2][p.col-2] == 1 && board[p.row + 1][p.col - 1] == (player % 2) + 1 && board[p.row - 1][p.col + 1] == (player % 2) + 1) score +=25;
        }
        if(p.row > 0 && p.row < 6 && p.col > 0 && p.col < 6) {
          if(board[p.row+2][p.col+2] == 1 && board[p.row - 1][p.col + 1] == (player % 2) + 1 && board[p.row + 1][p.col - 1] == (player % 2) + 1) score +=25;
        }
        
        // verticals
        if(p.row > 0 && p.row < 6) {
          if(board[p.row - 1][p.col] == (player % 2) + 1 && board[p.row + 1][p.col] == (player % 2) + 1 && board[p.row + 2][p.col] == (player % 2) + 1) score += 25;  
        }
        
        if(p.row > 1 && p.row < 7) {
          if(board[p.row - 1][p.col] == (player % 2) + 1 && board[p.row + 1][p.col] == (player % 2) + 1 && board[p.row - 2][p.col] == (player % 2) + 1) score += 25;
        }
        
        // horizontals
        if(p.col > 0 && p.col < 6) {
          if(board[p.row][p.col - 1] == (player % 2) + 1 && board[p.row][p.col + 1] == (player % 2) + 1 && board[p.row][p.col + 2] == (player % 2) + 1) score +=25;
        }
        if(p.col > 1 && p.col < 7) {
          if(board[p.row][p.col - 1] == (player % 2) + 1 && board[p.row][p.col + 1] == (player % 2) + 1 && board[p.row][p.col - 2] == (player % 2) + 1) score +=25;
        }
        return score;
    }
    
    //finds the value of each space on the board and returns the space with the largest value
    public Pair whereIsMax(int[][] board, int player) {
        Pair max = new Pair(0,0);
        for(int i = 0; i < height; i++) 
            for(int j = 0; j < width; j++) {
                Pair newMax = new Pair(i, j);
                if(board[newMax.row][newMax.col] == 0) {
                    if(findScore(newMax, board, player) >= findScore(max, board, player)) {
                        max = newMax;
                    }
                }
            }
        return max;
        }
    }
            