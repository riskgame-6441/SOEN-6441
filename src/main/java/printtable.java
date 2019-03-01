import java.io.File;
import java.util.HashMap;
import java.util.List;
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
		File file = new File("E:/Risk Game Git/SOEN-6441/src/main/java/world.map");
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
	
	public void getTable(int player, List<List<String>> country_per_player, HashMap<String,Integer> army_per_country) throws Exception{
		System.out.println("\nPlayer : "+(player+1));
		System.out.println("*************************");
		//System.out.println(country_per_player.get(player));
		int n = country_per_player.get(player).size();
		for(int i=0;i<n;i++) {
			String country_name = country_per_player.get(player).get(i);
			int c_army = army_per_country.get(country_per_player.get(player).get(i));
			System.out.println("\nCountry Name : "+country_name+"("+c_army+")");
			ArrayList<String> neighbour_countries = getNeighbour(country_name);
			int m = neighbour_countries.size();
			//System.out.println(m);
			for(int j=0;j<m;j++) {
				int army = army_per_country.get(neighbour_countries.get(j));
				//System.out.println(army);
				System.out.println("=> "+neighbour_countries.get(j)+"("+army+")");
			}
		}
	}
}
