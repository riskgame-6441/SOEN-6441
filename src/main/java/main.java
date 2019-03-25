import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class main {

	static int total_players;
	static File file;

	public static void main(String[] args) throws Exception {

		RGParmy o_army = new RGParmy();
		RGPlisting o_uem = new RGPlisting();
		RGPfortification o_fortification = new RGPfortification();

		System.out.println("--------WELCOME TO RISK--------\n");
		menu();

		HashMap<String, Integer> contvalue = o_uem.getcontinentandcontrolvalue();
		HashMap<String, Integer> contvalue1 = o_uem.getcontinentandcountry();
		HashMap<String, String> country_continent = o_uem.getCountryContinent();
		ArrayList<String> continent_list = o_uem.continentlist();
		ArrayList<String> country_list = o_uem.countrylist();

		RGPreinforcement o_reinforcement = new RGPreinforcement();
		int total_country = o_uem.countrylist().size();
		ArrayList<String> country_name = o_uem.countrylist();
		System.out.println(country_name);
		System.out.println(total_players);

		int armies_per_player = o_army.totalArmy(total_players, total_country);
		System.out.println("Total No. of countries : " + total_country);
		System.out.println("Per Player armies : " + armies_per_player);

		List<List<String>> country_per_player = new ArrayList<List<String>>();
		country_per_player = o_army.divideCountry(total_players, country_name);
		System.out.println("\nList of country per player");
		System.out.println(country_per_player);

		HashMap<String, Integer> army_per_country = new HashMap<String, Integer>();
		army_per_country = o_army.armyPerCountry(total_players, armies_per_player, country_per_player);
		System.out.println("No. of armies per country");
		System.out.println(army_per_country);

	        

		RGPprintTable o_printtable = new RGPprintTable();

		for (int i = 0; i < total_players; i++) {
			// print table
			System.out.println("Player : " + (i + 1));
			System.out.println("=========================================");
			o_printtable.getTable(file, i, country_per_player, army_per_country);

			// reinforce armies
			System.out.println("Reinforcement Phase");
			System.out.println("=====================================");
			int z = o_reinforcement.calReinforcementArmies(country_per_player.get(i), contvalue1, country_continent,
					contvalue);
			System.out.println("Number of armies to Reinforcement : " + z);

			army_per_country = o_reinforcement.placeReinforceArmies(z, i, country_per_player, army_per_country);
			// print table
			o_printtable.getTable(file, i, country_per_player, army_per_country);

			// reinforcement ends
			HashMap<Integer, Integer> armies = new HashMap<Integer, Integer>();
			int attacker_armies = 0;
			int defender_armies = 0;
			int attacker_armies1 = 0;
			int defender_armies1 = 0;
			String attack_country = null;
			String defend_country = null;
			int armies1 = 0;
			int army1 = 0;
			Scanner ab = new Scanner(System.in);
			System.out.println("Attack Phase");
			System.out.println("=====================================");

			for (int k = 0; k < 100; k++) {

				System.out.println("Do you want to attack ?(y/n)");
				String ans = ab.next();
				if (ans.equalsIgnoreCase("y")) {
					
					// attack phase
					int flag = 0, g = 0,p =0,h=0;
					RGPdiceroll o_dice = new RGPdiceroll();

					while (flag == 0) {
						while ( p == 0){
						System.out.println("Enter country name from which you want to attack");
						attack_country = ab.next();
					int value =	o_dice.validattcacker(attack_country,country_per_player,i);
						/**if (!country_per_player.get(i).contains(attack_country)) {
							System.out.println("Please enter country that you own.");
							break;
						} else {
							flag = 1;
							
						}*/
					if (value == 0) {
					System.out.println("Please enter country that you own.");
					break;
				} else {
					flag = 1;
					
				}
						int j;
						ArrayList<String> neighbour_countries = o_printtable.getNeighbour(file, attack_country);
						int m = neighbour_countries.size();
						for(j=0;j<m;j++) {
							if (country_per_player.get(i).contains(neighbour_countries.get(j))) {
								
								h++;
							} 
						}
							if ( h == m){
								p = 0;
								System.out.println("You can't attack adjacent country which is owned by you.");
							}
							else{
								p = 1;
							}
						
							
						}
					}
					int f = 1;
					int value = 0;
					while (value == 0) {
						System.out.println("Enter country name on which you want to attack");
						defend_country = ab.next();
						 value = o_dice.validdefender(file,country_per_player,attack_country, defend_country,country_list,i,f);
						/**List<String> list = new ArrayList<String>();
						g = o_fortification.checkConnection(file, attack_country, defend_country, country_list, list);
						if (country_per_player.get(i).contains(defend_country)) {
							f = 1;
						} else {
							f = 0;
						}
						if (g != 1 || f == 1) {
							System.out.println("Enter correct neighbouring country or other player country to attack");
						}*/
					}
					attacker_armies = army_per_country.get(attack_country);
					defender_armies = army_per_country.get(defend_country);
					if ((attacker_armies > 1)) {
						if (attacker_armies < 2) {
							System.out.println("You armies are not sufficient to attack ");
							o_fortification.fortification(file, i, country_per_player, army_per_country,
									attacker_armies, defender_armies, attack_country, defend_country);
							// break;
						} else {
							army_per_country = o_dice.rollDice(attacker_armies, defender_armies, file, i,
									country_per_player, army_per_country, attack_country, defend_country);
							attacker_armies = army_per_country.get(attack_country);
							defender_armies = army_per_country.get(defend_country);
							int j = 0;

							if ((attacker_armies < 1) || (defender_armies < 1)) {
								if (attacker_armies < 1) {
									/*System.out.println("defender_armies:" + defender_armies);
									System.out.println("Defender has won" + attack_country + "country");
									System.out.println("Enter no of armies to place in " + attack_country + "up to ("
											+ (defender_armies - 1) + "armies)");
									armies1 = ab.nextInt();
									j = 0;
									armies1 += army_per_country.get(attack_country);
									army_per_country.put(attack_country, armies1);
									army1 = defender_armies - (armies1 - 1);
									army_per_country.put(defend_country, army1);
									*/
									army_per_country =o_dice.placeDefendArmies(defender_armies, attack_country, defend_country,army_per_country);
									country_per_player= o_dice.placeDefendCountry(total_players,attack_country,defend_country,country_per_player, i);
									/*for (int l = 0; l < total_players; l++) {
										if (country_per_player.get(l).contains(defend_country)) {
											j = l;
											country_per_player.get(j).add(attack_country);
										}
									}
									country_per_player.get(i).remove(attack_country);
									*/
								}

								else if (defender_armies < 1) {
									/*System.out.println("Attacker Armies:" + attacker_armies);
									System.out.println("Attacker has won" + " " +defend_country +" country");
									System.out.println("Enter no of armies to place in " + defend_country + " up to ("
											+ (attacker_armies - 1) + "armies)");
									armies1 = ab.nextInt();
									j = 0;
									armies1 += army_per_country.get(defend_country);
									army_per_country.put(defend_country, armies1);
									army1 = attacker_armies - armies1;
									army_per_country.put(attack_country, army1);
									*/
									//System.out.println(country_per_player.get(i));
									army_per_country =o_dice.placeAttackArmies(attacker_armies, attack_country, defend_country,army_per_country);
									country_per_player= o_dice.placeAttackCountry(total_players,attack_country,defend_country,country_per_player, i);
									/*for (int l = 0; l < total_players; l++) {
										if (country_per_player.get(l).contains(defend_country)) {
											j = l;
											country_per_player.get(j).remove(defend_country);
										}
									}
									country_per_player.get(i).add(defend_country);
									*/
								}
							}

						}
					}else{
						System.out.println("You can't attack with 1 Army");
					}
					System.out.println(country_per_player.get(i));
						o_printtable.getTable(file, i, country_per_player, army_per_country);			
				}
					if (ans.equalsIgnoreCase("n")) {
						break;
					}

				}
			System.out.println("Fortification Phase");
			System.out.println("=====================================");
			
			o_fortification.fortify(file,country_per_player.get(i),army_per_country);
			o_printtable.getTable(file,i,country_per_player,army_per_country);
			
		}

	}

	public static void menu() throws Exception {
		int i = 0;
		Scanner a = new Scanner(System.in);

		while (i == 0) {
			System.out.println("************");
			System.out.println("* 1- Start *");
			System.out.println("* 2- Help  *");
			System.out.println("* 3- Exit  *");
			System.out.println("************\n");
			System.out.println("Enter your option");
			int option = a.nextInt();
			switch (option) {
			case 1:
				mapo();
				i = i + 1;
				break;
			case 2:
				System.out.println("Risk Game Help");
				menu();
			case 3:
				System.exit(option);
				i = i + 1;
				break;
			default:
				while (option > 3) {
					System.out.println("Enter one of the given options ");
					break;
				}

			}
		}

	}

	public static void mapo() throws Exception {
		int i = 0;
		RGPmapCentral mapob = new RGPmapCentral();
		RGPeditMap o_editOptions = new RGPeditMap();
		RGPnamingPlayers o_namingplayers = new RGPnamingPlayers();
		RGPcreateMap o_RGPCreatin_map = new RGPcreateMap();
		Scanner a = new Scanner(System.in);

		while (i == 0) {
			System.out.println("1- Create a new map");
			System.out.println("2- Use an existing map");
			System.out.println("3- Edit an existing map");
			System.out.println("4- Go back");

			int option = a.nextInt();
			file = mapob.mapOption(option);
			switch (option) {
			case 1:
				o_RGPCreatin_map.createmap(file);
				o_namingplayers.namep(file);
				i = i + 1;
				break;
			case 2:
				if (file.exists()) {
					o_namingplayers.namep(file);
					i = i + 1;
				} else {
					System.out.println("File which you have provided doesn't exists");
				}
				break;
			case 3:
				o_editOptions.editMap();
				o_namingplayers.namep(file);
				i = i + 1;
				break;
			case 4:
				menu();
				i = i + 1;
				break;
			default:
				System.out.println("Enter correct option");
			}
		}
		total_players = o_namingplayers.pinp;
	}


}