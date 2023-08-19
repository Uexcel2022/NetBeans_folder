
package Game;
import javax.swing.JFrame;

import java.util.Scanner;

public class runHangMan {
    
    public static void main(String[] args) {
        int i = 0;
        HangMan hg = new HangMan();
        hg.showManu();
        Scanner sc = new Scanner(System.in);
        while( i == 0){
           System.out.print("\nChose option: ");
           int choice  = sc.nextInt();
            if (choice == 1|| choice == 2|| choice == 3){
                i++;
                switch(choice){
                    case 1 -> hg.playGame();
                    case 2 -> hg.gameInstructions();
                    case 3 -> hg.exitGame();
                }
            }else System.err.println("\nInvalid");
        }
   }
}
 


  