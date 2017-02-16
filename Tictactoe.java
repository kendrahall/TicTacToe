
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author Kendra
 */
public class Tictactoe {

   private String [] [] gameBoard;
   private String xPlayerName, oPlayerName;
   
   public Tictactoe(String xPlayer, String oPlayer)
   {
       gameBoard = new String [3] [3];         
       oPlayerName = oPlayer;
       xPlayerName = xPlayer;
       
       //put a space in possition of game board
       for (int row=0; row < gameBoard.length; row++)
       {
      Arrays.fill(gameBoard[row], "  ");
       }
   }
   public static void main (String[] args)
   {
       Tictactoe myGame =new Tictactoe("Kendra", "Ardnek");
       myGame.displayBoard();
       myGame.makeMove("X");
   }//end main
  /**
   * allows player too select open position in game board.
   */
   public void makeMove(String player){
           boolean continueAsking=true;
           do
           {
                  System.out.printf("%s, please enter the row: ", player);
                            int row =getValidInput();
                            System.out.printf("%s, please enter the col: ", player);
                            int col =getValidInput();
                            
                            if (gameBoard[row][col].equals("  "))
                            {
                                gameBoard[row][col]=player;
                            continueAsking = false;
                            }
                            else
                                System.out.printf("im sorry but [%d] [%d] is already taken. \n", row,col);
   } while(continueAsking);
   }
/**
 * this method will prompt user for a row or collumn , validate the input and keep 
 * asking until user provides valid input
 */
   public int getValidInput()
   {
       Scanner keyboard = new Scanner(System.in);
       int userInput = 0;
       do {
           System.out.print("valid number are 0-2");
           try{
               userInput =keyboard.nextInt();
           }
           catch(InputMismatchException exception){
               System.out.println("sorry, only numbers 0,1,2 are excepted");
               userInput =10;
           }
       }while(userInput<0 || userInput >2);{
  return userInput;
   }
}
public void displayBoard()
{
    for (int row=0; row<gameBoard.length; row++)
    {
       for(int col=0; col<gameBoard[row].length; col++)
        {
            if (col ==2)
                    System.out.printf ("%s |", gameBoard[row][col]);
            else 
                    System.out.printf ("%s |", gameBoard[row][col]);
        }
       System.out.println();
       if (row !=2)
           System.out.println("________________");
    }
}
}
//end of main
    
