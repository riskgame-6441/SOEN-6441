import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class namingplayers  {
    uem a1 = new uem();
    int pinp = 0;
    String[] names = new String[5];
    public int getPlayers() {
    	Scanner a = new Scanner(System.in);
    	System.out.println("enter no of players");
    	final int total_players = a.nextInt();
    	return total_players;
    }
    
    public int namep(){
    	
        Scanner a = new Scanner(System.in);

        pinp = getPlayers();
        String pname;
        int i;
        for (i = 0; i < pinp; i++) {
            System.out.print("Enter the name of the player " + (i+1) + ":");
            pname = a.next();
            names[i] = pname;
            if (i == 0){
                System.out.println("Player name : " + pname);
            }
            else if (i == 1){
                System.out.println("Player name : " + pname);
            }
            else if (i == 2){
                System.out.println("Player name : " + pname);
            }
            else if (i == 3){
                System.out.println("Player name : " + pname);
            }
            else
            {
                System.out.println("Player name : " + pname);
            }
        }
        return pinp;
    }
}
