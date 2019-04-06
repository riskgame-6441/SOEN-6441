import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * This class is to implement Dice functionality to decide who is the winner
 * 
 * @author charan
 * @since 1.0.0
 */
public class RGPdiceroll {
	static String RGPattacker;
	static String RGPdefender;
	static int RGPindexv;
	static int RGPattackerCount;
	static int RGPdefenderCount;
	static int noofdefenderdice1;
	private static Scanner RGPscanner;
	private static Scanner string;

	/**
	 * This method is to delete the minimum value from attacker dice values
	 * 
	 * @param dicevalue
	 *            This parameter dicevalue consists of dice values
	 * @param index
	 *            This parameter index gives at what minimum value should be
	 *            deleted
	 * @return This returns the dice values after deleting minimum value
	 */
	public static int[] deleteMinNum(int[] dicevalue, int index) {
		if (dicevalue == null || index < 0 || index >= dicevalue.length) {
			return dicevalue;
		}
		int[] anotherArray = new int[dicevalue.length - 1];
		for (int i = 0, k = 0; i < dicevalue.length; i++) {
			if (i == index) {
				continue;
			}
			anotherArray[k++] = dicevalue[i];
		}
		return anotherArray;
	}

	/**
	 * This method find outs the maximum value of dice values
	 * 
	 * @param dicevalues
	 *            consists of different dice values
	 * @return Returns the maximum value
	 */
	public static int maxOfArray(int[] dicevalues) {
		int max = dicevalues[0];

		for (int i = 1; i < dicevalues.length; i++) {
			if (dicevalues[i] > max) {
				max = dicevalues[i];
			}
		}
		return max;
	}

	/**
	 * This method find outs the minimum value of dice values
	 * 
	 * @param dicevalues
	 *            consists of different dice values
	 * @return Returns the minimum value
	 */
	public int minOfArray(int[] dicevalues) {
		int min = dicevalues[0];

		for (int i = 1; i < dicevalues.length; i++) {
			if (dicevalues[i] < min) {
				min = dicevalues[i];
			}
		}
		return min;
	}

	/**
	 * This method provides the index for a minimum value in array
	 * 
	 * @param array
	 *            This parameter consists of dice values
	 * @return This returns the index of minimum value
	 */
	public static int minIndexValue(int[] array) {
		int indexv = array[0];
		int min = 0;

		for (int i = 1; i < array.length; i++) {
			if (array[i] < indexv) {
				indexv = array[i];
				min = i;
			}
		}
		return min;
	}

	/**
	 * This method provides the dice values for contestants
	 * 
	 * @param contestantdice
	 *            parameter defines either no of attacker dice or defender dice
	 * @return Returns either attacker or defender dice values
	 */
	static int[] rollOfDice(int contestantdice) {

		int att[] = new int[contestantdice];
		for (int i = 0; i < contestantdice; i++) {
			att[i] = diceNumgeneration();
		}
		return (att);

	}

	/**
	 * This method check the give country is valid to attack or not
	 * 
	 * @param attack_country
	 *            is attacking country
	 * @param country_per_player
	 *            is country list per player
	 * @param i
	 *            is player index
	 * @return returns where it is valid or not through int
	 */
	public int validattcacker(String attack_country, List<List<String>> country_per_player, int i) {
		int value;
		if (!country_per_player.get(i).contains(attack_country)) {
			// System.out.println("Please enter country that you own.");
			// break;
			value = 0;
		} else {
			value = 1;

		}
		return value;
	}

	/**
	 * This method check the valid defender
	 * 
	 * @param file
	 * @param country_per_player
	 *            is country list per player
	 * @param attack_country
	 *            is attacking country
	 * @param defend_country
	 *            is defending country
	 * @param country_list
	 *            is total country list
	 * @param i
	 *            is player index
	 * @param f
	 *            is count
	 * @return returns where it is valid or not through int
	 * @throws Exception
	 */
	public int   validdefender(File file, List<List<String>> country_per_player, String attack_country,
			String defend_country, ArrayList<String> country_list, int i, int f) throws Exception {
		RGPfortification o_fortification = new RGPfortification();
		int value;
		List<String> list = new ArrayList<String>();
		int g = o_fortification.checkConnection(file, attack_country, defend_country, country_list, list);
		if (country_per_player.get(i).contains(defend_country)) {
			f = 1;
		} else {
			f = 0;
		}
		if (g != 1 || f == 1) {
			System.out.println("Enter correct neighbouring country or other player country to attack");
			value = 0;
		} else {
			value = 1;
		}
		return value;
	}
  
	/**
	 * This method is to place armies in country player won
	 * 
	 * @param attacker_armies
	 *            is no of attacker armies
	 * @param attack_country
	 *            is name of attacking country
	 * @param defend_country
	 *            is name of defending country
	 * @param army_per_country
	 *            is no of armies per country
	 * @return returns updated armies per country
	 */
	public HashMap<String, Integer> placeAttackArmies(int attacker_armies, String attack_country, String defend_country,
			HashMap<String, Integer> army_per_country) {
		int armies1, army1;
		Scanner ans = new Scanner(System.in);
		System.out.println("Attacker Armies:" + attacker_armies);
		System.out.println("Attacker has won" + " " + defend_country + " country");
		System.out.println(
				"Enter no of armies to place in " + defend_country + " up to (" + (attacker_armies - 1) + "armies)");
		armies1 = ans.nextInt();
		// j = 0;
		armies1 += army_per_country.get(defend_country);
		army_per_country.put(defend_country, armies1);
		army1 = attacker_armies - armies1;
		army_per_country.put(attack_country, army1);
		return army_per_country;
	}
	
	public HashMap<String, Integer> placeAttackArmiesAggressive(int attacker_armies, String attack_country, String defend_country, HashMap<String, Integer> army_per_country) {
		int armies1, army1;
		armies1 = 1;
		armies1 += army_per_country.get(defend_country);
		army_per_country.put(defend_country, armies1);
		army1 = attacker_armies - armies1;
		army_per_country.put(attack_country, army1);
		return army_per_country;
	}
	
	public HashMap<String, Integer> placeAttackArmiesRandom(int attacker_armies, String attack_country, String defend_country, HashMap<String, Integer> army_per_country) {
		int armies1, army1;
		armies1 = 1;
		armies1 += army_per_country.get(defend_country);
		army_per_country.put(defend_country, armies1);
		army1 = attacker_armies - armies1;
		army_per_country.put(attack_country, army1);
		return army_per_country;
	}

	/**
	 * This method is place country in players list
	 * 
	 * @param total_players
	 *            is total no of players
	 * @param attack_country
	 *            is name of attacking country
	 * @param defend_country
	 *            is name of defending country
	 * @param country_per_player
	 *            is countries per player
	 * @param i
	 *            player index
	 * @return updated country list per player
	 */
	public List<List<String>> placeAttackCountry(int total_players, String attack_country, String defend_country,
			List<List<String>> country_per_player, int i) {
		int j = 0;
		for (int l = 0; l < total_players; l++) {
			if (country_per_player.get(l).contains(defend_country)) {
				j = l;
				country_per_player.get(j).remove(defend_country);
			}
		}
		country_per_player.get(i).add(defend_country);
		return country_per_player;
	}
	
	public List<List<String>> placeAttackCountryAggressive(String attack_country, String defend_country, List<List<String>> country_per_player, int i, int d, List<Integer> out_players) {
		country_per_player.get(d).remove(defend_country);
		country_per_player.get(i).add(defend_country);
		if(country_per_player.get(d).size()==0) {
			out_players.add(d);
		}
		return country_per_player;
	}
	
	public List<List<String>> placeAttackCountryRandom(String attack_country, String defend_country, List<List<String>> country_per_player, int i, int d, List<Integer> out_players) {
		country_per_player.get(d).remove(defend_country);
		country_per_player.get(i).add(defend_country);
		if(country_per_player.get(d).size()==0) {
			out_players.add(d);
		}
		return country_per_player;
	}

	/**
	 * This method generates random dice value
	 * 
	 * @return return dice value
	 */
	static int diceNumgeneration() {
		final int numberOfSides = 6;
		int r;
		Random randomNumberGenerator = new Random();
		r = randomNumberGenerator.nextInt(numberOfSides) + 1;
		return r;
	}

	/**
	 * This method decided the winner of roll dice
	 * 
	 * @param attack_armies
	 *            no of attacker armies
	 * @param defend_armies
	 *            no of defender armies
	 * @param file
	 *            is file name
	 * @param p
	 *            is player index
	 * @param country_per_player
	 *            no of countries per player
	 * @param army_per_country
	 *            no of armies per country
	 * @param attack_country
	 *            is name of attacker country
	 * @param defend_country
	 *            is name of defender country
	 * @return returns hashmap with armies and winner
	 * @throws Exception
	 */
	public HashMap<String, Integer> rollDice(int attack_armies, int defend_armies, File file, int p,
			List<List<String>> country_per_player, HashMap<String, Integer> army_per_country, String attack_country,
			String defend_country) throws Exception {
		HashMap<Integer, Integer> armies = new HashMap<Integer, Integer>();
		RGPfortification o_fortification = new RGPfortification();
		int attacker_armies = attack_armies;
		int defender_armies = defend_armies;
		int noOfAttackerDice = 0;
		Scanner scan = new Scanner(System.in);
		int z = 1;
		String ans = null;
		if (attacker_armies >= 2) {
			System.out.println("Do you want go with 'all out mode'?(yes/no)");
			ans = scan.next();
			if (ans.equalsIgnoreCase("yes")) {
				while ((attacker_armies != 0) && (defender_armies != 0)) {
					if (attacker_armies > 1) {
						int[] minattckerarmy = new int[2];
						minattckerarmy[0] = attacker_armies;
						minattckerarmy[1] = 3;
						int noofattackerdice = minOfArray(minattckerarmy);
						int noofdefenderdice = 2;

						int a[] = rollOfDice(noofattackerdice);

						if (defender_armies < 2) {
							noofdefenderdice1 = noofdefenderdice - 1;

						} else {
							noofdefenderdice1 = noofdefenderdice;
						}
						if (noofattackerdice < 2) {
							noofdefenderdice1 = noofattackerdice;
						}
						int b[] = rollOfDice(noofdefenderdice1);

						int minvalue = minOfArray(a);
						System.out.println("Attacker Dice values");
						for (int i = 0; i < a.length; i++) {
							System.out.println(a[i]);
						}
						// System.out.println("Min value in three dice");
						// System.out.println(minvalue);

						int indexv = minIndexValue(a);
						// System.out.println("index is" + indexv);
						if (attacker_armies > 2) {
							a = deleteMinNum(a, indexv);
						}
						// System.out.println("Attacker Dice values after
						// deleting min value");
						// for (int i = 0; i < a.length; i++) {
						// System.out.println(a[i]);
						// }
						System.out.println("Defender Dice values");
						for (int i = 0; i < b.length; i++) {
							System.out.println(b[i]);
						}

						int max_dicevalue_attacker = maxOfArray(a);
						int max_dicevalue_defender = maxOfArray(b);
						int min_dicevalue_attacker = minOfArray(a);
						int min_dicevalue_defender = maxOfArray(b);
						if (max_dicevalue_attacker > max_dicevalue_defender
								&& min_dicevalue_attacker > min_dicevalue_defender) {

							RGPattackerCount++;
						} else if (max_dicevalue_attacker >= max_dicevalue_defender
								&& min_dicevalue_attacker > min_dicevalue_defender) {
							RGPattackerCount++;
						} else if (max_dicevalue_attacker > max_dicevalue_defender
								&& min_dicevalue_attacker >= min_dicevalue_defender) {
							RGPattackerCount++;
						} else if (max_dicevalue_attacker < max_dicevalue_defender
								&& min_dicevalue_attacker < min_dicevalue_defender) {
							RGPdefenderCount++;
						} else if (max_dicevalue_attacker <= max_dicevalue_defender
								&& min_dicevalue_attacker < min_dicevalue_defender) {
							RGPdefenderCount++;
						} else if (max_dicevalue_attacker < max_dicevalue_defender
								&& min_dicevalue_attacker <= min_dicevalue_defender) {
							RGPdefenderCount++;
						} else {
							RGPdefenderCount++;
						}
						if (RGPattackerCount > 0) {
							defender_armies = defender_armies - 1;
							System.out.println("Defender Armies count value" + defender_armies);
							System.out.println("Attacker Armies count value" + attacker_armies);
							RGPattackerCount = 0;
						}
						if (RGPdefenderCount > 0) {
							attacker_armies = attacker_armies - 1;
							System.out.println("Attacker Armies count value" + attacker_armies);
							System.out.println("Defender Armies count value" + defender_armies);
							RGPdefenderCount = 0;
						}
					} else {
						System.out.println("you can't attack anymore with one army");
						break;
					}

				}
				if (attacker_armies < 1) {
					army_per_country.put(attack_country, attacker_armies);
					army_per_country.put(defend_country, defender_armies);
				}
				if (defender_armies < 1) {
					army_per_country.put(attack_country, attacker_armies);
					army_per_country.put(defend_country, defender_armies);
				}

			}

			else if (ans.equalsIgnoreCase("no")) {
				string = new Scanner(System.in);
				int[] minattckerarmy = new int[2];
				minattckerarmy[0] = attacker_armies;
				minattckerarmy[1] = 3;
				int a_army = minOfArray(minattckerarmy);
				int noofdefenderdice = 2;
				int noofattackerdice = 0;
				int flag = 0;
				if (a_army < 3)
					noofattackerdice = a_army - 1;
				else
					noofattackerdice = a_army;
				
				while(flag == 0) {
					System.out.println("Enter no of dice you want to play with " + "(maximum of" + (noofattackerdice) + ")");
		          	noOfAttackerDice = string.nextInt();
		          	System.out.println(noOfAttackerDice);
					if (noOfAttackerDice > 3) {
						System.out.println("Please enter correct no of dice");
						continue;
					} else {
						flag = 1;
					}
				}
				int a[] = rollOfDice(noOfAttackerDice);

				if (defender_armies < 2) {
					noofdefenderdice1 = noofdefenderdice - 1;

				} else {
					noofdefenderdice1 = noofdefenderdice;
				}

				if (noOfAttackerDice < 2) {
					noofdefenderdice1 = noOfAttackerDice;
				}

				int b[] = rollOfDice(noofdefenderdice1);

				int minvalue = minOfArray(a);
				System.out.println("Attacker Dice values");
				for (int i = 0; i < a.length; i++) {
					System.out.print(a[i]);
					System.out.println(" ");
				}
				if (noOfAttackerDice == 3) {
					int indexv = minIndexValue(a);
					System.out.println("index is" + indexv);
					if (attacker_armies > 2) {
						a = deleteMinNum(a, indexv);
					}
					System.out.println("Attacker Dice values after deleting min value");
					for (int i = 0; i < a.length; i++) {
						System.out.println(a[i]);
					}
				}
				System.out.println("Defender Dice values");
				for (int i = 0; i < b.length; i++) {
					System.out.print(b[i]);
					System.out.println(" ");
				}

				int max_dicevalue_attacker = maxOfArray(a);
				int max_dicevalue_defender = maxOfArray(b);
				int min_dicevalue_attacker = minOfArray(a);
				int min_dicevalue_defender = minOfArray(b);
				if (noOfAttackerDice == 1) {
					if ((max_dicevalue_attacker > max_dicevalue_defender) && (defender_armies > 0)) {

						defender_armies = defender_armies - 1;
						System.out.println("Attacker Dice Won");
						System.out.println("Attacker: " + attack_country + "(" + attacker_armies + ")");
						System.out.println("Defender: " + defend_country + "(" + defender_armies + ")");

					}
					if (max_dicevalue_attacker <= max_dicevalue_defender && (defender_armies > 0)) {
						attacker_armies = attacker_armies - 1;
						System.out.println("Defender Dice Won");
						System.out.println("Attacker: " + attack_country + "(" + attacker_armies + ")");
						System.out.println("Defender: " + defend_country + "(" + defender_armies + ")");

					}
				}
				if (noOfAttackerDice == 2 || noOfAttackerDice == 3) {
					if ((max_dicevalue_attacker > max_dicevalue_defender) && (defender_armies > 0)) {

						defender_armies = defender_armies - 1;
						System.out.println("Attacker Dice Won");
						System.out.println("Attacker: " + attack_country + "(" + attacker_armies + ")");
						System.out.println("Defender: " + defend_country + "(" + defender_armies + ")");

					}
					if (max_dicevalue_attacker <= max_dicevalue_defender && (defender_armies > 0)) {
						attacker_armies = attacker_armies - 1;
						System.out.println("Defender Dice Won");
						System.out.println("Attacker: " + attack_country + "(" + attacker_armies + ")");
						System.out.println("Defender: " + defend_country + "(" + defender_armies + ")");

					}
					if (min_dicevalue_attacker <= min_dicevalue_defender && (defender_armies > 0)) {
						attacker_armies = attacker_armies - 1;
						System.out.println("Defender Dice Won");
						System.out.println("Attacker: " + attack_country + "(" + attacker_armies + ")");
						System.out.println("Defender: " + defend_country + "(" + defender_armies + ")");

					}
					if ((min_dicevalue_attacker > min_dicevalue_defender) && (defender_armies > 0)) {

						defender_armies = defender_armies - 1;
						System.out.println("Attacker Dice Won");
						System.out.println("Attacker: " + attack_country + "(" + attacker_armies + ")");
						System.out.println("Defender: " + defend_country + "(" + defender_armies + ")");

					}
				}
				TimeUnit.SECONDS.sleep(3);
			}
		}
		army_per_country.put(attack_country, attacker_armies);
		army_per_country.put(defend_country, defender_armies);

		return army_per_country;
	}
	
	public HashMap<String, Integer> rollDiceAggressive(int attack_armies, int defend_armies, File file, int p, List<List<String>> country_per_player, HashMap<String, Integer> army_per_country, String attack_country, String defend_country) throws Exception {
		HashMap<Integer, Integer> armies = new HashMap<Integer, Integer>();
		int attacker_armies = attack_armies;
		int defender_armies = defend_armies;
		int noOfAttackerDice = 0;
		int z = 1;
		String ans = null;
			
		while (attacker_armies > 1 && defender_armies > 0) {
				int[] minattckerarmy = new int[2];
				minattckerarmy[0] = attacker_armies-1;
				minattckerarmy[1] = 3;
				int noofattackerdice = minOfArray(minattckerarmy);
				int a[] = rollOfDice(noofattackerdice);

				int noofdefenderdice;
				if (defender_armies < 2) {
					noofdefenderdice1 = 1;
				} else {
					noofdefenderdice1 = 2;
				}
				if (noofattackerdice < 2) {
					noofdefenderdice1 = noofattackerdice;
				}
				int b[] = rollOfDice(noofdefenderdice1);

				int minvalue = minOfArray(a);
				System.out.println("Attacker Dice values");
				for (int i = 0; i < a.length; i++) {
					System.out.println(a[i]);
				}
				// System.out.println("Min value in three dice");
				// System.out.println(minvalue);

				int indexv = minIndexValue(a);
				// System.out.println("index is" + indexv);
				if (attacker_armies > 2) {
					a = deleteMinNum(a, indexv);
				}
				
				System.out.println("Defender Dice values");
				for (int i = 0; i < b.length; i++) {
					System.out.println(b[i]);
				}

				int max_dicevalue_attacker = maxOfArray(a);
				int max_dicevalue_defender = maxOfArray(b);
				int min_dicevalue_attacker = minOfArray(a);
				int min_dicevalue_defender = maxOfArray(b);
				if (max_dicevalue_attacker > max_dicevalue_defender
						&& min_dicevalue_attacker > min_dicevalue_defender) {

					RGPattackerCount++;
				} else if (max_dicevalue_attacker >= max_dicevalue_defender
						&& min_dicevalue_attacker > min_dicevalue_defender) {
					RGPattackerCount++;
				} else if (max_dicevalue_attacker > max_dicevalue_defender
						&& min_dicevalue_attacker >= min_dicevalue_defender) {
					RGPattackerCount++;
				} else if (max_dicevalue_attacker < max_dicevalue_defender
						&& min_dicevalue_attacker < min_dicevalue_defender) {
					RGPdefenderCount++;
				} else if (max_dicevalue_attacker <= max_dicevalue_defender
						&& min_dicevalue_attacker < min_dicevalue_defender) {
					RGPdefenderCount++;
				} else if (max_dicevalue_attacker < max_dicevalue_defender
						&& min_dicevalue_attacker <= min_dicevalue_defender) {
					RGPdefenderCount++;
				} else {
					RGPdefenderCount++;
				}
				if (RGPattackerCount > 0) {
					defender_armies = defender_armies - 1;
					System.out.println("Defender Armies count value" + defender_armies);
					System.out.println("Attacker Armies count value" + attacker_armies);
					RGPattackerCount = 0;
				}
				if (RGPdefenderCount > 0) {
					attacker_armies = attacker_armies - 1;
					System.out.println("Attacker Armies count value" + attacker_armies);
					System.out.println("Defender Armies count value" + defender_armies);
					RGPdefenderCount = 0;
				}
		}
		if (attacker_armies < 1) {
			army_per_country.put(attack_country, attacker_armies);
			army_per_country.put(defend_country, defender_armies);
		}
		if (defender_armies < 1) {
			army_per_country.put(attack_country, attacker_armies);
			army_per_country.put(defend_country, defender_armies);
		}
		
		army_per_country.put(attack_country, attacker_armies);
		army_per_country.put(defend_country, defender_armies);

		return army_per_country;
	}
	
	public HashMap<String, Integer> rollDiceRandom(int attack_armies, int defend_armies, File file, int p, List<List<String>> country_per_player, HashMap<String, Integer> army_per_country, String attack_country, String defend_country) throws Exception {
		HashMap<Integer, Integer> armies = new HashMap<Integer, Integer>();
		int attacker_armies = attack_armies;
		int defender_armies = defend_armies;
		int noOfAttackerDice = 0;
		int z = 1;
		String ans = null;
			
		while (attacker_armies > 1 && defender_armies > 0) {
				int[] minattckerarmy = new int[2];
				minattckerarmy[0] = attacker_armies-1;
				minattckerarmy[1] = 3;
				int noofattackerdice = minOfArray(minattckerarmy);
				int a[] = rollOfDice(noofattackerdice);

				int noofdefenderdice;
				if (defender_armies < 2) {
					noofdefenderdice1 = 1;
				} else {
					noofdefenderdice1 = 2;
				}
				if (noofattackerdice < 2) {
					noofdefenderdice1 = noofattackerdice;
				}
				int b[] = rollOfDice(noofdefenderdice1);

				int minvalue = minOfArray(a);
				System.out.println("Attacker Dice values");
				for (int i = 0; i < a.length; i++) {
					System.out.println(a[i]);
				}
				// System.out.println("Min value in three dice");
				// System.out.println(minvalue);

				int indexv = minIndexValue(a);
				// System.out.println("index is" + indexv);
				if (attacker_armies > 2) {
					a = deleteMinNum(a, indexv);
				}
				
				System.out.println("Defender Dice values");
				for (int i = 0; i < b.length; i++) {
					System.out.println(b[i]);
				}

				int max_dicevalue_attacker = maxOfArray(a);
				int max_dicevalue_defender = maxOfArray(b);
				int min_dicevalue_attacker = minOfArray(a);
				int min_dicevalue_defender = maxOfArray(b);
				if (max_dicevalue_attacker > max_dicevalue_defender
						&& min_dicevalue_attacker > min_dicevalue_defender) {

					RGPattackerCount++;
				} else if (max_dicevalue_attacker >= max_dicevalue_defender
						&& min_dicevalue_attacker > min_dicevalue_defender) {
					RGPattackerCount++;
				} else if (max_dicevalue_attacker > max_dicevalue_defender
						&& min_dicevalue_attacker >= min_dicevalue_defender) {
					RGPattackerCount++;
				} else if (max_dicevalue_attacker < max_dicevalue_defender
						&& min_dicevalue_attacker < min_dicevalue_defender) {
					RGPdefenderCount++;
				} else if (max_dicevalue_attacker <= max_dicevalue_defender
						&& min_dicevalue_attacker < min_dicevalue_defender) {
					RGPdefenderCount++;
				} else if (max_dicevalue_attacker < max_dicevalue_defender
						&& min_dicevalue_attacker <= min_dicevalue_defender) {
					RGPdefenderCount++;
				} else {
					RGPdefenderCount++;
				}
				if (RGPattackerCount > 0) {
					defender_armies = defender_armies - 1;
					System.out.println("Defender Armies count value" + defender_armies);
					System.out.println("Attacker Armies count value" + attacker_armies);
					RGPattackerCount = 0;
				}
				if (RGPdefenderCount > 0) {
					attacker_armies = attacker_armies - 1;
					System.out.println("Attacker Armies count value" + attacker_armies);
					System.out.println("Defender Armies count value" + defender_armies);
					RGPdefenderCount = 0;
				}
		}
		if (attacker_armies < 1) {
			army_per_country.put(attack_country, attacker_armies);
			army_per_country.put(defend_country, defender_armies);
		}
		if (defender_armies < 1) {
			army_per_country.put(attack_country, attacker_armies);
			army_per_country.put(defend_country, defender_armies);
		}
		
		army_per_country.put(attack_country, attacker_armies);
		army_per_country.put(defend_country, defender_armies);

		return army_per_country;
	}

	/**
	 * This method is used to get index of defender during attack phase
	 * 
	 * @author Dhruvi Gadhiya
	 * @param defender_country This parameter contains value of country which is attacked during attack phase.
	 * @param country_per_player This parameter contains list of countries for each player
	 * @return This method will return index of defender
	 * */
	public static int getDefenderIndex(String defender_country, List<List<String>> country_per_player) {
		int n = -1;
		for(int i=0;i<country_per_player.size();i++) {
			List<String> list = country_per_player.get(i);
			if(list.contains(defender_country)) {
				n = country_per_player.indexOf(list);
			}
		}
		return n;
	}
}