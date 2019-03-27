import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class main {

	static int total_players;
	static String[] player_names;
	static File file;

	public static void main(String[] args) throws Exception {

		RGPobserverSubject subject = new RGPobserverSubject();
		RGPobserverObserver RGPobserverName =  new RGPobserverName(subject);
		RGPworldDominationSubject subject1 = new RGPworldDominationSubject();
		RGPworldDominationObserver RGPworldDominationDetails =  new RGPworldDominationDetails(subject1);
		RGPcardViewSubject subject3 = new RGPcardViewSubject();
		RGPcardViewObserver RGPcardViewDetails =  new RGPcardViewDetails(subject3);


		String phase1 = "REINFORCEMENT PHASE";
		String phase2 = "ATTACK PHASE";
		String phase3 = "FORTIFICATION PHASE";
		String message1 = "This phase will give players reinforcement army for each turn according to countries and continents owned along with by treding cards player can get some extra army. Player can put that armies into the countries owned accordingly.";
		String message2 = "This phase is to attack on neighbouring countries and to conquer countries.";
		String message3 = "This phase is fortify armies in player owned countries.";

		RGParmy o_army = new RGParmy();
		RGPlisting o_uem = new RGPlisting();
		RGPfortification o_fortification = new RGPfortification();
		RGPcardDivision o_card = new RGPcardDivision();

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
		//System.out.println("\nList of country per player");
		//System.out.println(country_per_player);

		HashMap<String, Integer> army_per_country = new HashMap<String, Integer>();
		army_per_country = o_army.armyPerCountry(total_players, armies_per_player, country_per_player);
		System.out.println("No. of armies per country");
		System.out.println(army_per_country);

		HashMap<String, Integer> cards = new HashMap<String, Integer>();
		HashMap<String, Integer> card_1 = new HashMap<String, Integer>();
		HashMap<String, Integer> card_2 = new HashMap<String, Integer>();
		HashMap<String, Integer> card_3 = new HashMap<String, Integer>();
		HashMap<String, Integer> card_4 = new HashMap<String, Integer>();
		HashMap<String, Integer> card_5 = new HashMap<String, Integer>();
		HashMap<String, Integer> card_6 = new HashMap<String, Integer>();
		cards = o_card.hm1(country_name);

		RGPprintTable o_printtable = new RGPprintTable();
		
		List<Integer> out_players = null;
		List<List<String>> continent_list_per_player = new ArrayList<List<String>>();
		int player_flag = 1;
		int i;
		while(player_flag == 1) {
		for (i = 0; i < total_players; i++) {
			if(out_players != null) {
				if(out_players.contains(i)) {
					break;
				}
				
			}
			System.out.println("\nWORLD DOMINATION VIEW\n");
			System.out.println("==========================");
			//Players world domination view
        	for(int j=0;j<total_players;j++) {
        		int total_country_num = country_list.size();
        		int player_country_num = (country_per_player.get(j)).size();
        		float map_per_player = (float)(100*player_country_num)/total_country_num;
        		//System.out.println("Map(%) : "+map_per_player+" %");
        		
        		continent_list_per_player = o_reinforcement.getContinent(country_per_player, country_continent, contvalue1);
        		//System.out.println(continent_list_per_player);
            	//System.out.println("Continents : "+continent_list_per_player);
            	//System.exit(0);
            	int total_army_per_player=0;
            	for(int k=0;k<country_per_player.get(j).size();k++){
            		total_army_per_player+=army_per_country.get(country_per_player.get(j).get(k));
            	}
            	//System.out.println("Total armies : "+total_army_per_player);
            	subject1.setNameState(j+1,(int)map_per_player,continent_list_per_player.get(i),total_army_per_player);
            	System.out.println("\n");
            	
        	}
        	System.out.println("==========================");
        	
        	//System.exit(0);
        	//phase view
        	System.out.println("\nPHASE VIEW");
        	System.out.println("\n=============================");
        	subject.setNameState(player_names[i],phase1,message1);
        	System.out.println("=============================\n");
        	o_printtable.getTable(file,i,country_per_player,army_per_country);
        	
        	//reinforce armies
        	//System.out.println("Reinforcement Phase");
    		//System.out.println("=====================================");
    		
    		//card exchange view
    		int extra_army=0;
    		if(i==0 && !card_1.isEmpty()) {
    			System.out.println("\nCARD EXCHANGE VIEW\n");
    			subject3.setNameState(card_1);
    			if(card_1.size()>=3) {
    				extra_army = o_card.trade_card(card_1);
    			}
    		}else if(i==1 && !card_2.isEmpty()) {
    			System.out.println("\nCARD EXCHANGE VIEW\n");
    			subject3.setNameState(card_2);
    			if(card_2.size()>=3) {
    				extra_army = o_card.trade_card(card_2);
    			}
    		}else if(i==2 && !card_3.isEmpty()) {
    			System.out.println("\nCARD EXCHANGE VIEW\n");
    			subject3.setNameState(card_3);
    			if(card_3.size()>=3) {
    				extra_army = o_card.trade_card(card_3);
    			}
    		}else if(i==3 && !card_4.isEmpty()) {
    			System.out.println("\nCARD EXCHANGE VIEW\n");
    			subject3.setNameState(card_4);
    			if(card_4.size()>=3) {
    				extra_army = o_card.trade_card(card_4);
    			}
    		}else if(i==4 && !card_5.isEmpty()) {
    			System.out.println("\nCARD EXCHANGE VIEW\n");
    			subject3.setNameState(card_5);
    			if(card_5.size()>=3) {
    				extra_army = o_card.trade_card(card_5);
    			}
    		}else if(i==5 && !card_6.isEmpty()) {
    			System.out.println("\nCARD EXCHANGE VIEW\n");
    			subject3.setNameState(card_6);
    			if(card_6.size()>=3) {
    				extra_army = o_card.trade_card(card_6);
    			}
    		}
    		int extra_army_continent = 0;
    		System.out.println("Extra armies by trading cards : "+extra_army);
			int z = o_reinforcement.calReinforcementArmies(country_per_player.get(i), contvalue1, country_continent,
					contvalue);
			z += extra_army;
			for(int h=0;h<continent_list_per_player.get(i).size();h++){
				String continent = continent_list_per_player.get(i).get(h);
				extra_army_continent = contvalue.get(continent);
			}
			System.out.println("Extra armies by continent : "+extra_army_continent);
			z+=extra_army_continent;
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
			System.out.println("\nPHASE VIEW");
			System.out.println("\n=============================");
			subject.setNameState(player_names[i], phase2, message2);
			System.out.println("=============================\n");

			for (int k = 0; k < 100; k++) {

				System.out.println("Do you want to attack ?(y/n)");
				String ans = ab.next();
				if (ans.equalsIgnoreCase("y")) {

					// attack phase
					int flag = 0, g = 0, p = 0, h = 0;
					RGPdiceroll o_dice = new RGPdiceroll();

					while (flag == 0) {
						while (p == 0) {
							System.out.println("Enter country name from which you want to attack");
							attack_country = ab.next();
							int value = o_dice.validattcacker(attack_country, country_per_player, i);
							if (value == 0) {
								System.out.println("Please enter country that you own.");
								break;
							} else {
								flag = 1;

							}
							int j;
							ArrayList<String> neighbour_countries = o_printtable.getNeighbour(file, attack_country);
							int m = neighbour_countries.size();
							for (j = 0; j < m; j++) {
								if (country_per_player.get(i).contains(neighbour_countries.get(j))) {

									h++;
								}
							}
							if (h == m) {
								p = 0;
								System.out.println("You can't attack adjacent country which is owned by you.");
							} else {
								p = 1;
							}

						}
					}
					int f = 1;
					int d = -1 ;
					int value = 0;
					while (value == 0) {
						System.out.println("Enter country name on which you want to attack");
						defend_country = ab.next();
						value = o_dice.validdefender(file, country_per_player, attack_country, defend_country,
								country_list, i, f);
						if(value != 0) {
							//get defender index
							d = o_dice.getDefenderIndex(defend_country, country_per_player);
							//System.out.println(d);
						}
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

								if (defender_armies < 1) {

									army_per_country = o_dice.placeAttackArmies(attacker_armies, attack_country,
											defend_country, army_per_country);
									country_per_player = o_dice.placeAttackCountry(total_players, attack_country,
											defend_country, country_per_player, i);
									//assign card to winner
									if (i == 0) {
										System.out.println(card_1);
										o_card.hash_add_sub(cards, card_1);
										cards = o_card.getCards();
										card_1 = o_card.getPlayerCard();
										System.out.println(card_1);
									} else if (i == 1) {
										System.out.println(card_2);
										o_card.hash_add_sub(cards, card_2);
										cards = o_card.getCards();
										card_2 = o_card.getPlayerCard();
										System.out.println(card_2);
									} else if (i == 2) {
										System.out.println(card_3);
										o_card.hash_add_sub(cards, card_3);
										cards = o_card.getCards();
										card_3 = o_card.getPlayerCard();
										System.out.println(card_3);
									} else if (i == 3) {
										System.out.println(card_4);
										o_card.hash_add_sub(cards, card_4);
										cards = o_card.getCards();
										card_4 = o_card.getPlayerCard();
										System.out.println(card_4);
									} else if (i == 4) {
										System.out.println(card_5);
										o_card.hash_add_sub(cards, card_5);
										cards = o_card.getCards();
										card_5 = o_card.getPlayerCard();
										System.out.println(card_5);
									} else if (i == 5) {
										System.out.println(card_6);
										o_card.hash_add_sub(cards, card_6);
										cards = o_card.getCards();
										card_6 = o_card.getPlayerCard();
										System.out.println(card_6);
									}
									//if defender loose all countries then assign all his cards to attacker and remove him from list of players
									if(country_per_player.get(d).size() == 0 ) {
										
										out_players.add(d);
										
										if(i == 0) {
											if(d == 1) {
												card_1.putAll(card_2);
												card_2.clear();
											} else if(d == 2) {
												card_1.putAll(card_3);
												card_3.clear();
											} else if(d == 3) {
												card_1.putAll(card_4);
												card_4.clear();
											} else if(d == 4) {
												card_1.putAll(card_5);
												card_5.clear();
											} else if(d == 5) {
												card_1.putAll(card_6);
												card_6.clear();
											}
										} else if(i == 1) {
											if(d == 0) {
												card_2.putAll(card_1);
												card_1.clear();
											} else if(d == 2) {
												card_2.putAll(card_3);
												card_3.clear();
											} else if(d == 3) {
												card_2.putAll(card_4);
												card_4.clear();
											} else if(d == 4) {
												card_2.putAll(card_5);
												card_5.clear();
											} else if(d == 5) {
												card_2.putAll(card_6);
												card_6.clear();
											}
										} else if(i == 2) {
											if(d == 0) {
												card_3.putAll(card_1);
												card_1.clear();
											} else if(d == 1) {
												card_3.putAll(card_2);
												card_2.clear();
											} else if(d == 3) {
												card_3.putAll(card_4);
												card_4.clear();
											} else if(d == 4) {
												card_3.putAll(card_5);
												card_5.clear();
											} else if(d == 5) {
												card_3.putAll(card_6);
												card_6.clear();
											}
										} else if(i == 3) {
											if(d == 0) {
												card_4.putAll(card_1);
												card_1.clear();
											} else if(d == 1) {
												card_4.putAll(card_2);
												card_2.clear();
											} else if(d == 2) {
												card_4.putAll(card_3);
												card_3.clear();
											} else if(d == 4) {
												card_4.putAll(card_5);
												card_5.clear();
											} else if(d == 5) {
												card_4.putAll(card_6);
												card_6.clear();
											}
										} else if(i == 4) {
											if(d == 0) {
												card_5.putAll(card_1);
												card_1.clear();
											} else if(d == 1) {
												card_5.putAll(card_2);
												card_2.clear();
											} else if(d == 2) {
												card_5.putAll(card_3);
												card_3.clear();
											} else if(d == 3) {
												card_5.putAll(card_4);
												card_4.clear();
											} else if(d == 5) {
												card_5.putAll(card_6);
												card_6.clear();
											}
										} else if(i == 5) {
											if(d == 0) {
												card_6.putAll(card_1);
												card_1.clear();
											} else if(d == 1) {
												card_6.putAll(card_2);
												card_2.clear();
											} else if(d == 2) {
												card_6.putAll(card_3);
												card_3.clear();
											} else if(d == 3) {
												card_6.putAll(card_4);
												card_4.clear();
											} else if(d == 4) {
												card_6.putAll(card_5);
												card_5.clear();
											}
										}
										
										// card exchange view
										int new_extra_army = 0;
										if (i == 0 && !card_1.isEmpty() && card_1.size()>=5) {
											System.out.println(card_1);
											new_extra_army = o_card.trade_card(card_1);
										} else if (i == 1 && !card_2.isEmpty() && card_2.size()>=5) {
											System.out.println(card_2);
											new_extra_army = o_card.trade_card(card_2);
										} else if (i == 2 && !card_3.isEmpty() && card_3.size()>=5) {
											System.out.println(card_3);
											new_extra_army = o_card.trade_card(card_3);
										} else if (i == 3 && !card_4.isEmpty() && card_4.size()>=5) {
											System.out.println(card_4);
											new_extra_army = o_card.trade_card(card_4);
										} else if (i == 4 && !card_5.isEmpty() && card_5.size()>=5) {
											System.out.println(card_5);
											new_extra_army = o_card.trade_card(card_5);
										} else if (i == 5 && !card_6.isEmpty() && card_6.size()>=5) {
											System.out.println(card_6);
											new_extra_army = o_card.trade_card(card_6);
										}
																		
										System.out.println("Number of armies to Reinforcement : " + new_extra_army);
							
										army_per_country = o_reinforcement.placeReinforceArmies(new_extra_army, i, country_per_player, army_per_country);
										// print table
										o_printtable.getTable(file, i, country_per_player, army_per_country);
								}
							}
							}
						}
					} else {
						System.out.println("You can't attack with one Army");
					}
					System.out.println(country_per_player.get(i));
					o_printtable.getTable(file, i, country_per_player, army_per_country);
				}
				if (ans.equalsIgnoreCase("n")) {
					break;
				}

			System.out.println("\nPHASE VIEW");


			}

			System.out.println("\n=============================");
			subject.setNameState(player_names[i], phase3, message3);
			System.out.println("=============================\n");

			System.out.println("Do you want to fortify ?(y/n)");
			String ans = ab.next();
			if (ans.equalsIgnoreCase("y")) {
				o_fortification.fortify(file, country_per_player.get(i), army_per_country);
				o_printtable.getTable(file, i, country_per_player, army_per_country);
			}
		}
		}
	}
    /**
     * This method is for menu options
     * @throws Exception
     */
	public static void menu() throws Exception {
		int i = 0;
		Scanner a = new Scanner(System.in);

		while (i == 0) {
			System.out.println("*************");
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
   /**
    * This method is for map options
    * @throws Exception
    */
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
		player_names = o_namingplayers.names;
	}

}
