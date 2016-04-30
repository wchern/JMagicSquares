import java.util.Scanner;
/**
 * Magic Squares
 * 
 * @author William Chern 
 * @version 01/07/2016
 */
public class Magic
{
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("What dimensions would you like for your Magic Square? (odd nums only)");
        int dimension = reader.nextInt();
        printMagicSquare(dimension);
        reader.close();
    }
    
    public static void printMagicSquare(int dimension) {
        int[][] board = new int [dimension][dimension]; // creates square board with odd dimensions specified by user
        board[0][dimension/2] = 1; // sets the center top number equal to 1
        
        int currentRow=0; // current coordinates
        int currentCol=dimension/2;
        int previousRow; //used for keeping track of the previous coordinates, in case going up to the right doesn't work
        int previousCol; // if going up to the right fails, use these coordinates to reset the coordinates to previous position in order to move down
        
        for (int i=2; i<=Math.pow(dimension,2); i++) {
            previousRow = currentRow; // use previous vars to store the coordinates of the last actual position
            previousCol = currentCol;
            if((currentRow-1)<0) currentRow = dimension-1; //if currentRow up 1 row is off the board, wrap it around to the bottom row
            else currentRow -= 1;
            if((currentCol+1)>=dimension) currentCol = 0; //if currentCol right 1 column is off the board, wrap it around to the first column
            else currentCol += 1;
            if (board[currentRow][currentCol] != 0) { // if position is taken already
                currentCol = previousCol; //reset currentCol back to previous column coordinate
                if ((previousRow+1)>=dimension) currentRow=0; //if previous row coordinate down 1 row is off the board, wrap it around to the top row
                else currentRow=previousRow+1; //else, move down 1 row
            }
            board[currentRow][currentCol] = i;
        }
        for (int r=0; r<dimension; r++) { //iterate through each row
            for (int c=0; c<dimension; c++) { //iterate through each column within r row
                System.out.print(board[r][c] + " "); //print board at coordinate
            }
            System.out.println();
        }
    }
}
