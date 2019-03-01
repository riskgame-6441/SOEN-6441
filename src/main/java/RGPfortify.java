import java.util.Scanner;

/**
 * This class is for fortification phase of the game This class has fortify
 * method which calculate fortify armies
 * 
 * @author charan
 * @version 1.0.0
 */
public class RGPfortify {
	private static Scanner RGPscanner;

	/**
	 * This method is for calculating fortify armies
	 * 
	 * @param country1
	 *            is country name from which armies need to be fortified
	 * @param country2
	 *            is country name to which armies need to be fortified
	 * @param country1_armies
	 *            is sender country armies
	 * @param country2_armies
	 *            is receiving country armies
	 * @param fortarmies
	 *            is no of armies to be fortified
	 */
	public static void fortify(String country1, String country2, int country1_armies, int country2_armies,
			int fortarmies) {
		int fortifblearmies = country1_armies - 1;
		if (fortarmies > fortifblearmies) {
			System.out.println("You can only fortify " + fortifblearmies + " armies");
		} else {
			country1_armies = country1_armies - fortarmies;
			country2_armies = country2_armies + fortarmies;
		}
		System.out.println(country1 + " armies are " + country1_armies);
		System.out.println(country2 + " armies are " + country2_armies);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String country1, country2;
		System.out.println("Enter country name from which you want to send armies");
		Scanner country = new Scanner(System.in);
		country1 = country.nextLine();
		System.out.println("Enter country name to which you want to send armies");
		Scanner countrys = new Scanner(System.in);
		country2 = countrys.nextLine();

		System.out.println("Enter armies for " + country1);
		RGPscanner = new Scanner(System.in);
		int country1_armies = RGPscanner.nextInt();
		System.out.println("Enter armies for " + country2);
		int country2_armies = RGPscanner.nextInt();
		// boolean countryb;
		System.out.println("Enter no of armies to be fortified");
		Scanner fort_armies = new Scanner(System.in);
		int fortarmies = fort_armies.nextInt();
		fortify(country1, country2, country1_armies, country2_armies, fortarmies);
		/*
		 * System.out.println("Enter no of armies to be fortified"); Scanner
		 * fort_armies = new Scanner(System.in); int fortarmies =
		 * fort_armies.nextInt(); int fortifblearmies = country1_armies - 1; if
		 * (fortarmies > fortifblearmies) { System.out.println(
		 * "You can only fortify " + fortifblearmies + " armies"); } else {
		 * country1_armies = country1_armies - fortarmies; country2_armies =
		 * country2_armies + fortarmies; } System.out.println(country1 +
		 * " armies are " + country1_armies); System.out.println(country2 +
		 * " armies are " + country2_armies);
		 * 
		 * /** int no_of_cards = 0; System.out.println(
		 * "Enter either country won or looes true/false"); Scanner decide = new
		 * Scanner(System.in); boolean bol = decide.nextBoolean();
		 * System.out.println("do you want to attack? yes/no"); Scanner string =
		 * new Scanner(System.in); String str = string.nextLine(); if
		 * (str.equalsIgnoreCase("no")) { if (bol == true) { no_of_cards++; }
		 * 
		 * }
		 */

	}

}
