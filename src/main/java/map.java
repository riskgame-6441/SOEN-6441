import java.util.ArrayList;
import java.util.HashMap;

public class map {
	
	printtable o_printtable = new printtable();
	
	public int validateConnectedContinents(ArrayList<String> country_list, ArrayList<String> continent_list, HashMap<String, String> country_continent) throws Exception {
		ArrayList<String> neighbour_country = new ArrayList<String>();
		ArrayList<String> new_continent_list = new ArrayList<String>();
		new_continent_list = continent_list;
		int n = country_list.size();
		String continent = " ",continent1 = " ",country = " ";
		int flag = 0,a=0;
		
		for(int i=0;i<n;i++) {
			//System.out.println(new_continent_list);
			if(new_continent_list.isEmpty()) {
				System.out.println("Continents are connected.");
				a=1;
				break;
			}
			country = country_list.get(i);
			if(flag == 0) {
				continent = country_continent.get(country);
				flag = 1;
			}
			neighbour_country = o_printtable.getNeighbour(country);
			for(int j=0;j<neighbour_country.size();j++) {
				continent1 = country_continent.get(neighbour_country.get(j));
				if(country_continent.get(country) != country_continent.get(neighbour_country.get(j))) {
					new_continent_list.remove(continent);
					continent = continent1;
				}
			}
			
		}
		return a;
	}
	
	public int validateConnectedCountries(ArrayList<String> country_list, ArrayList<String> continent_list) throws Exception {
		
		ArrayList<String> neighbour_country = new ArrayList<String>();
		ArrayList<String> new_country_list = new ArrayList<String>();
		int n = country_list.size();
		String country=" ",country1=" ";
		int flag=0,flag1=0,a=0;
		new_country_list = country_list;
		//System.out.println(country_list);

		for(int i=0;i<n;i++) {
			if(new_country_list.isEmpty()) {
				System.out.println("Countries are connected.");
				a=1;
				break;
			}
			flag1=0;
			//System.out.println(new_country_list);
			if(flag == 0) {
				country = country_list.get(i);
				flag = 1;
			}else if(flag1==0){
				country = new_country_list.get(0);
				n++;
			}else {
				for(int k=0;k<n;k++) {
					if(country1.equals(country_list.get(k))) {
						country = country_list.get(k);
						break;
					}
				}
			}
			//System.out.println("Country : "+country);
			neighbour_country = o_printtable.getNeighbour(country);
			//System.out.println(neighbour_country);
			new_country_list.remove(country);
			n--;
			for(int j=0;j<neighbour_country.size();j++) {
				if(new_country_list.contains(neighbour_country.get(j))) {
					country1 = neighbour_country.get(j);
					//System.out.println("Country1 : "+country1);
					//System.out.println();
					flag1=1;
					break;
				}
			}
			if(flag1==0) {
				new_country_list.remove(country1);
				n++;
			}
		}
		return a;
	}
	
}
