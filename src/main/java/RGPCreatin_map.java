import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class is for creation of map by user
 * 
 * @author charan
 * @version 1.0.0
 */
public class RGPCreatin_map {
	/**
	 * This method is to create a map file
	 * 
	 * @param continent_name1
	 *            gives the continent name
	 * @param contint1
	 *            gives the no of continents
	 * @param cntry1
	 *            gives the no of countries
	 * @param continent_countries1
	 *            gives the countries of particular continent
	 * @param country_name1
	 *            gives the countries names
	 * @param country_cordinates1
	 *            gives the country coordinates
	 * @param country_continent1
	 *            gives the countries
	 * @param adjacent_countries1
	 *            gives the adjacent countries
	 * @throws FileNotFoundException
	 */
	public void file_creation(String[] continent_name1, int contint1, int cntry1, int[] continent_countries1,
			String[] country_name1, String[] country_cordinates1, String[] country_continent1,
			String[] adjacent_countries1) throws FileNotFoundException {
		PrintWriter mapcreation = new PrintWriter("createmap.txt");

		mapcreation.println("[Map]");
		mapcreation.println("author=charan");
		mapcreation.println("image=world.map");
		mapcreation.println("wrap=no");
		mapcreation.println("scroll=horizontal");
		mapcreation.println("warn=yes");
		mapcreation.println(" ");
		mapcreation.println("[Continents]");
		for (int i = 0; i < contint1; i++) {
			mapcreation.print(continent_name1[i] + " = ");
			mapcreation.print(continent_countries1[i]);
			mapcreation.println("");
		}
		mapcreation.println(" ");
		mapcreation.println("[Territories]");
		for (int i = 0; i < cntry1; i++) {
			mapcreation.print(country_name1[i] + ",");
			mapcreation.print(country_cordinates1[i] + ",");
			mapcreation.print(country_continent1[i] + ",");
			// for (int j = 0; j < contry[j].length(); i++) {
			mapcreation.print(adjacent_countries1[i]);
			// }
			mapcreation.println(" ");

		}
		System.out.println("Map has been created");
		mapcreation.close();

	}

	public void createmap() throws FileNotFoundException {

		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter no of Continents");
		int contint = input.nextInt();
		String[] continent_name = new String[contint];

		for (int i = 0; i < contint; i++) {
			System.out.println("Enter continent " + (i + 1));
			Scanner input1 = new Scanner(System.in);
			continent_name[i] = input1.nextLine();

		}
		System.out.println("Enter total no of Countries");
		int cntry = input.nextInt();
		int[] continent_countries = new int[cntry];

		for (int i = 0; i < contint; i++) {

			System.out.println("Enter no of countries in " + continent_name[i]);
			continent_countries[i] = input.nextInt();

		}
		String[] country_name = new String[cntry];
		String[] country_cordinates = new String[cntry];
		String[] adjacent_countries = new String[cntry];
		String[] country_continent = new String[cntry];

		for (int i = 0; i < cntry; i++) {
			System.out.println("Enter country " + (i + 1));
			Scanner input1 = new Scanner(System.in);
			country_name[i] = input1.nextLine();
			System.out.println("Enter continent name in which country should be included"); //
			Scanner input2 = new Scanner(System.in);
			country_continent[i] = input2.nextLine();
			System.out.println("Enter co-ordinates for the country");
			country_cordinates[i] = input2.nextLine();
			// for (int j = 0; j < cntint_contry[i]; j++) {
			System.out.println("Enter Adjacent countries with ',' seperator");
			// Scanner input2 = new Scanner(System.in);
			adjacent_countries[i] = input2.nextLine();
			// }
		}

		file_creation(continent_name, contint, cntry, continent_countries, country_name, country_cordinates,
				country_continent, adjacent_countries);

	}

}
