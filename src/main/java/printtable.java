import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class printtable {
	
	calcline a = new calcline();
	mainmethod object_mainmethod = new mainmethod();
	int i = 0;
	
	
	public ArrayList<String> getNeighbour(String newword) throws Exception{
		ArrayList<String> neighbour = new ArrayList<String>();
		String searchword = " ";
		File file = new File("/Users/Guest1/SOEN-6441/src/main/java/Board.map");
        Scanner sc = new Scanner(file);
        int j = 0;
        int n = a.line2();
        while (sc.hasNextLine()) {
        	if(!sc.hasNext()) {
        		break;
        	}
        	searchword = sc.next();
            if (searchword.equals("[Territories]")) {
                for (i = 0; i < n-1; i++) {
                	if(!sc.hasNext()) {
                		break;
                	}
                    String text = sc.next();
                    String[] input = text.split(",");
                    int size = input.length;
                    if(input[0].equals(newword)) {
                    	for (j = 4; j < size ; j++) {
                    		neighbour.add(input[j]);
                    		
                    	}
                    }
                }
            }
        }
        return neighbour;
	}
	
	public void getTable(int player) {
		System.out.println("Player : "+player);
		System.out.println(object_mainmethod.getCountryPerPlayer());
		System.out.println("Country Name : ");
	}
}
