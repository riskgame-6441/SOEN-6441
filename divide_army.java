package risk;
import java.util.Arrays;


public class divide_army {
	public static void main(String args[]) {
		
		int n=5; //total number of players
		int totalCountry = 42;
		char p[]= {'a','b','c','d','e'}; //players name
		//int cp[]= {9,9,8,8,8}; //number of countries for each player
		int i=0,j=0; 
		int flag = 0;
		int ap = 0; //total number of armies per player
		int[] countryPerPlayer = new int[n];
		//int m = (int)(totalCountry/n)+1;
		int[][] armiesPerCountryPerPlayer = new int[n][totalCountry]; //number of armies per country per player
		int armiesPerPlayer = 0;
		
		//total army to players
		if(n == 2) {
			armiesPerPlayer = (int)(40*totalCountry)/42;
		}else if(n == 3) {
			armiesPerPlayer = (int)(35*totalCountry)/42;
		}else if(n == 4) {
			armiesPerPlayer = (int)(30*totalCountry)/42;
		}else if(n == 5) {
			armiesPerPlayer = (int)(25*totalCountry)/42;
		}else if(n == 6) {
			armiesPerPlayer = (int)(20*totalCountry)/42;
		}
		System.out.println("Total No. of countries : "+totalCountry);
		System.out.println("Per Player armies : "+armiesPerPlayer);
		
		//divide countries
		//System.out.println("Total No. of countries : "+totalCountry);
		for(i=0;i<n;i++) {
			
			totalCountry--;
			countryPerPlayer[i]++;
			if(totalCountry == 0)
				break;
			if(i == (n-1))
				i = -1;
		}
		for(i=0;i<n;i++) {
			System.out.println("Player Name(Countries) : "+p[i]+"("+countryPerPlayer[i]+")");
			//System.out.println("Countries : " + countryPerPlayer[i]);
		}
		
		
		//divide armies to countries
		
		for(i=0;i<n;i++) {
			ap = armiesPerPlayer;
			//System.out.println("Player Name : "+p[i]);
			//System.out.println("Total No. of armies : "+ap);
			
			
			for(j=0;j<countryPerPlayer[i];j++) {
					armiesPerCountryPerPlayer[i][j]++;
					ap--;
					
					//System.out.println("No. of army : "+ap);
					//System.out.println("No. of army for country : "+j);
					//System.out.println(armiesPerCountryPerPlayer[i][j]);
					if(ap == 0)
						break;
					if(j == (countryPerPlayer[i]-1))
						j = -1;
			}
		}
		
		//display
		for(i=0;i<n;i++) {
			System.out.println("*******************************");
			System.out.println("Player : "+p[i]);
			System.out.println("*******************************");
			for(j=0;j<countryPerPlayer[i];j++) {
				System.out.println("Country(Army) : "+j+"("+armiesPerCountryPerPlayer[i][j]+")");
				//System.out.println("Armies : "+armiesPerCountryPerPlayer[i][j]);
			}
		}
	}
}
