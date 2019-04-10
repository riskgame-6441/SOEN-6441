import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class main implements Serializable {

	static int total_players;
	static HashMap<String, Integer> player_names;
	static File file;

	public static void main(String[] args) throws Exception {

		RGPtournament o_tourny = new RGPtournament();

		RGParmy o_army = new RGParmy();
		RGPlisting o_uem = new RGPlisting();
		RGPfortification o_fortification = new RGPfortification();
		RGPcardDivision o_card = new RGPcardDivision();
		RGPplayer o_player = new RGPplayer();
		RGPattack o_attack = new RGPattack();
		RGPprintTable o_printtable = new RGPprintTable();
		RGPreinforcement o_reinforcement = new RGPreinforcement();
		RGPdiceroll o_dice = new RGPdiceroll();
		RGPaggressive o_aggressive = new RGPaggressive();
		RGPobserverSubject subject = new RGPobserverSubject();
		RGPobserverObserver RGPobserverName = new RGPobserverName(subject);
		RGPworldDominationSubject subject1 = new RGPworldDominationSubject();
		RGPworldDominationObserver RGPworldDominationDetails = new RGPworldDominationDetails(subject1);
		RGPcardViewSubject subject3 = new RGPcardViewSubject();
		RGPcardViewObserver RGPcardViewDetails = new RGPcardViewDetails(subject3);
		RGPsaveLoadGame saveload = new RGPsaveLoadGame();
		RGPGameElements gameElements = new RGPGameElements();

		RGPcontex a_contex = new RGPcontex(new RGPplayeraggressive());
		RGPcontex b_contex = new RGPcontex(new RGPplayerBenevolent());
		RGPcontex r_contex = new RGPcontex(new RGPplayerRandom());
		RGPcontex c_contex = new RGPcontex(new RGPplayerCheater());
		
		HashMap<String, Integer> contvalue = null;
		HashMap<String, Integer> contvalue1 = null;
		HashMap<String, String> country_continent = null;
		ArrayList<String> continent_list = null;
		ArrayList<String> country_list = null;
		int total_country = 0;
		ArrayList<String> country_name = null;
		int armies_per_player = 0;
		List<List<String>> country_per_player = new ArrayList<List<String>>();
		HashMap<String, Integer> army_per_country = new HashMap<String, Integer>();
		List<List<String>> continent_list_per_player = new ArrayList<List<String>>();

		String phase1 = "REINFORCEMENT PHASE";
		String phase2 = "ATTACK PHASE";
		String phase3 = "FORTIFICATION PHASE";
		String message1 = "This phase will give players reinforcement army for each turn according to countries and continents owned along with by treding cards player can get some extra army. Player can put that armies into the countries owned accordingly.";
		String message2 = "This phase is to attack on neighbouring countries and to conquer countries.";
		String message3 = "This phase is fortify armies in player owned countries.";

		System.out.println("--------WELCOME TO RISK--------\n");
		Scanner scan = new Scanner(System.in);
		System.out.println("Do you want load the game from previously saved game (yes/no)?");
		String ans = scan.next();
		if (ans.equalsIgnoreCase("yes")) {
			gameElements = saveload.loadGame();

			armies_per_player = gameElements.armies_per_player;
			army_per_country = gameElements.army_per_country;
			continent_list = gameElements.continent_list;
			country_continent = gameElements.country_continent;
			country_list = gameElements.country_list;
			country_per_player = gameElements.country_per_player;
			total_players = gameElements.total_players;
			file = gameElements.file;
			player_names = gameElements.player_names;
			continent_list_per_player = gameElements.continent_list_per_player;
			contvalue = gameElements.contvalue;
			contvalue1 = gameElements.contvalue1;
			total_country = gameElements.total_country;
			country_name = gameElements.country_name;
			contvalue1 = gameElements.contvalue1;
			total_country = gameElements.total_country;
			country_name = gameElements.country_name;
			file = gameElements.file;
			System.out.println(country_name);
			System.out.println(total_players);
			System.out.println("Total No. of countries : " + total_country);
			System.out.println("Per Player armies : " + armies_per_player);
			System.out.println("No. of armies per country");
			System.out.println(army_per_country);

		} else if (ans.equalsIgnoreCase("no")) {
			menu();

			contvalue = o_uem.getcontinentandcontrolvalue(file);
			contvalue1 = o_uem.getcontinentandcountry(file);
			country_continent = o_uem.getCountryContinent(file);
			continent_list = o_uem.continentlist(file);
			country_list = o_uem.countrylist(file);

			total_country = o_uem.countrylist(file).size();
			country_name = o_uem.countrylist(file);
			System.out.println(country_name);
			System.out.println(total_players);

			armies_per_player = o_army.totalArmy(total_players, total_country);
			System.out.println("Total No. of countries : " + total_country);
			System.out.println("Per Player armies : " + armies_per_player);

			country_per_player = o_army.divideCountry(total_players, country_name);

			army_per_country = o_army.armyPerCountry(total_players, armies_per_player, country_per_player);
			System.out.println("No. of armies per country");
			System.out.println(army_per_country);
		}
		HashMap<String, Integer> cards = new HashMap<String, Integer>();
		HashMap<String, Integer> card_1 = new HashMap<String, Integer>();
		HashMap<String, Integer> card_2 = new HashMap<String, Integer>();
		HashMap<String, Integer> card_3 = new HashMap<String, Integer>();
		HashMap<String, Integer> card_4 = new HashMap<String, Integer>();
		HashMap<String, Integer> card_5 = new HashMap<String, Integer>();
		HashMap<String, Integer> card_6 = new HashMap<String, Integer>();
		cards = o_card.hm1(country_name);

		List<Integer> out_players = new ArrayList<Integer>();

		int player_flag = 1;
		String winner = null;
		int i;
		while (player_flag == 1) {
			for (i = 0; i < total_players; i++) {
				Set<Map.Entry<String, Integer>> mapSet = player_names.entrySet();
				Map.Entry<String, Integer> elementAt = (Map.Entry<String, Integer>) mapSet.toArray()[i];
				String player = elementAt.getKey();
				System.out.println(out_players);
				
				if (out_players != null) {
					System.out.println(out_players);
					if (out_players.contains(i)) {
						continue;
					} else {
						winner = player;
					}
					if (out_players.size() == (total_players - 1)) {
						player_flag = 0;
						continue;
					}
				}

				System.out.println("\nWORLD DOMINATION VIEW\n");
				System.out.println("==========================");
						for (int j = 0; j < total_players; j++) {
							int total_country_num = country_list.size();
							int player_country_num = (country_per_player.get(j)).size();
							float map_per_player = (float) (100 * player_country_num) / total_country_num;
							continent_list_per_player = o_reinforcement.getContinent(country_per_player, country_continent,
									contvalue1);
							int total_army_per_player = 0;
							for (int d = 0; d < country_per_player.get(j).size(); d++) {
								String country = country_per_player.get(j).get(d);
								total_army_per_player += army_per_country.get(country);
							}
		
							subject1.setNameState(j + 1, (int) map_per_player, continent_list_per_player.get(i),
									total_army_per_player);
							System.out.println("\n");
						}
						System.out.println("==========================");
		
						if (player_names.get(player) == 1) {
							// phase view
							if (gameElements.r_flag == 0) {
								System.out.println("\nPHASE VIEW");
								System.out.println("\n=============================");
								subject.setNameState(player, phase1, message1);
								System.out.println("=============================\n");
								o_printtable.getTable(file, i, country_per_player, army_per_country);
		
								// card exchange view
								int extra_army = 0;
								if (i == 0 && !card_1.isEmpty()) {
									System.out.println("\nCARD EXCHANGE VIEW\n");
									subject3.setNameState(card_1);
									if (card_1.size() >= 3) {
										extra_army = o_card.trade_card(card_1);
									}
								} else if (i == 1 && !card_2.isEmpty()) {
									System.out.println("\nCARD EXCHANGE VIEW\n");
									subject3.setNameState(card_2);
									if (card_2.size() >= 3) {
										extra_army = o_card.trade_card(card_2);
									}
								} else if (i == 2 && !card_3.isEmpty()) {
									System.out.println("\nCARD EXCHANGE VIEW\n");
									subject3.setNameState(card_3);
									if (card_3.size() >= 3) {
										extra_army = o_card.trade_card(card_3);
									}
								} else if (i == 3 && !card_4.isEmpty()) {
									System.out.println("\nCARD EXCHANGE VIEW\n");
									subject3.setNameState(card_4);
									if (card_4.size() >= 3) {
										extra_army = o_card.trade_card(card_4);
									}
								} else if (i == 4 && !card_5.isEmpty()) {
									System.out.println("\nCARD EXCHANGE VIEW\n");
									subject3.setNameState(card_5);
									if (card_5.size() >= 3) {
										extra_army = o_card.trade_card(card_5);
									}
								} else if (i == 5 && !card_6.isEmpty()) {
									System.out.println("\nCARD EXCHANGE VIEW\n");
									subject3.setNameState(card_6);
									if (card_6.size() >= 3) {
										extra_army = o_card.trade_card(card_6);
									}
								}
								int extra_army_continent = 0;
								System.out.println("Extra armies by trading cards : " + extra_army);
								int z = o_reinforcement.calReinforcementArmies(country_per_player.get(i), contvalue1,
										country_continent, contvalue);
								z += extra_army;
								for (int h = 0; h < continent_list_per_player.get(i).size(); h++) {
									String continent = continent_list_per_player.get(i).get(h);
									extra_army_continent = contvalue.get(continent);
								}
								System.out.println("Extra armies by continent : " + extra_army_continent);
								z += extra_army_continent;
								System.out.println("Number of armies to Reinforcement : " + z);
		
								army_per_country = o_reinforcement.placeReinforceArmies(z, i, country_per_player,
										army_per_country);
								// print table
								o_printtable.getTable(file, i, country_per_player, army_per_country);
								gameElements = saveload.gameelements(armies_per_player, army_per_country, continent_list,
										country_continent, country_list, country_per_player, total_players, file, player_names,
										continent_list_per_player, contvalue, contvalue1, total_country, country_name, i);
								System.out.println("Do you want to save the game (yes/no)?");
								ans = scan.next();
								if (ans.equalsIgnoreCase("yes")) {
									gameElements = saveload.gameelements(armies_per_player, army_per_country, continent_list,
											country_continent, country_list, country_per_player, total_players, file,
											player_names, continent_list_per_player, contvalue, contvalue1, total_country,
											country_name, i);
									gameElements.r_flag = 1;
									saveload.saveGame(gameElements);
									System.out
											.println("Game has been saved and terminated,please restart to continue the game");
									System.exit(0);
								}
								// reinforcement ends
							} else {
								gameElements.r_flag = 0;
								i = gameElements.i;
								 mapSet = player_names.entrySet();
								 elementAt = (Map.Entry<String, Integer>) mapSet.toArray()[i];
								 player = elementAt.getKey();
							}
		
							if (gameElements.a_flag == 0) {
								int attacker_armies = 0;
								int defender_armies = 0;
								int attacker_armies1 = 0;
								int defender_armies1 = 0;
								String attack_country = null;
								String defend_country = null;
		
								System.out.println("\nPHASE VIEW");
								System.out.println("\n=============================");
								subject.setNameState(player, phase2, message2);
								System.out.println("=============================\n");
								o_printtable.getTable(file, i, country_per_player, army_per_country);
								o_player.attack(attack_country, i, country_per_player, file, defend_country, country_list,
										attacker_armies, defender_armies, attacker_armies1, defender_armies1, army_per_country,
										cards, card_1, card_2, card_3, card_4, card_5, card_6, out_players, total_players);
		
								System.out.println("Do you want to save the game (yes/no)?");
								ans = scan.next();
								if (ans.equalsIgnoreCase("yes")) {
									gameElements = saveload.gameelements(armies_per_player, army_per_country, continent_list,
											country_continent, country_list, country_per_player, total_players, file,
											player_names, continent_list_per_player, contvalue, contvalue1, total_country,
											country_name, i);
									gameElements.r_flag = 1;
									gameElements.a_flag = 1;
									saveload.saveGame(gameElements);
									System.out
											.println("Game has been saved and terminated,please restart to continue the game");
									System.exit(0);
								}
							} else {
								gameElements.a_flag = 0;
								gameElements.r_flag = 0;
								i = gameElements.i;
								mapSet = player_names.entrySet();
								 elementAt = (Map.Entry<String, Integer>) mapSet.toArray()[i];
								 player = elementAt.getKey();
								 System.out.println(player+""+i);
							}
							if (gameElements.f_flag == 0) {
								System.out.println("\n=============================");
								subject.setNameState(player, phase3, message3);
								System.out.println("=============================\n");
								o_printtable.getTable(file, i, country_per_player, army_per_country);
								o_player.fortify(file, i, country_per_player, army_per_country);
		
								System.out.println("Do you want to save the game (yes/no)?");
								ans = scan.next();
								if (ans.equalsIgnoreCase("yes")) {
									gameElements = saveload.gameelements(armies_per_player, army_per_country, continent_list,
											country_continent, country_list, country_per_player, total_players, file,
											player_names, continent_list_per_player, contvalue, contvalue1, total_country,
											country_name, i);
									gameElements.f_flag = 1;
									gameElements.r_flag = 1;
									gameElements.a_flag = 1;
									saveload.saveGame(gameElements);
									System.out.println("Game has been saved and terminated,please restart to continue the game");
									System.exit(0);
								}
							} else {
								gameElements.f_flag = 0;
								gameElements.a_flag = 0;
								gameElements.r_flag = 0;
								i = gameElements.i;
							}
						} else if (player_names.get(player) == 2) {
							
							System.out.println("Player : " + player);
							o_printtable.getTable(file, i, country_per_player, army_per_country);
							int extra_army = 0;
							int z = o_reinforcement.calReinforcementArmies(country_per_player.get(i), contvalue1,
									country_continent, contvalue);
							z += extra_army;
							army_per_country = o_reinforcement.placeReinforceArmiesAggressive(z, i, country_per_player,
									army_per_country);
							System.out.println("Reinforced armies : " + z);
							
							//a_contex.reinforcement(army_per_country, country_per_player, i, contvalue1, contvalue, country_continent);
							System.out.println("After Reinforcement : ");
							o_printtable.getTable(file, i, country_per_player, army_per_country);
							// System.exit(0);
							int attacker_armies = 0;
							int defender_armies = 0;
							int attacker_armies1 = 0;
							int defender_armies1 = 0;
							String attack_country = null;
							String defend_country = null;
							System.out.println("\nPHASE VIEW");
							System.out.println("\n=============================");
							subject.setNameState(player, phase2, message2);
							System.out.println("=============================\n");
							//a_contex.attack(attack_country, i, country_per_player, file, defend_country, country_list, attacker_armies, defender_armies, attacker_armies1, defender_armies1, army_per_country, cards, card_1, card_2, card_3, card_4, card_5, card_6, out_players, defender_armies1);
							String a_country = o_attack.getAttackingCountryAggressive(country_per_player.get(i),
									army_per_country);
							System.out.println("Attacker Country : " + a_country);
							ArrayList<String> neighbour_countries = o_printtable.getNeighbour(file, a_country);
							ArrayList<String> to_be_attacked_countries = o_attack.toBeAttackedCountry(country_per_player.get(i),
									neighbour_countries);
							int a_armies = army_per_country.get(a_country);
							System.out.println("Attacker Armies : " + a_armies);
		
							for (int l = 0; l < to_be_attacked_countries.size(); l++) {
								if (a_armies <= 1) {
									break;
								}
								String d_country = to_be_attacked_countries.get(l);
								int d = o_dice.getDefenderIndex(d_country, country_per_player);
								int d_armies = army_per_country.get(d_country);
		
								army_per_country = o_dice.rollDiceAggressive(a_armies, d_armies, file, i, country_per_player,
										army_per_country, a_country, d_country);
								a_armies = army_per_country.get(a_country);
								d_armies = army_per_country.get(d_country);
		
								if (d_armies == 0) {
									army_per_country = o_dice.placeAttackArmiesAggressive(a_armies, a_country, d_country,
											army_per_country);
									country_per_player = o_dice.placeAttackCountryAggressive(a_country, d_country,
											country_per_player, i, d, out_players);
								}
								System.out.println(army_per_country);
								System.out.println(country_per_player);
							}
							o_printtable.getTable(file, i, country_per_player, army_per_country);
							System.out.println("Attack Phase done");
							System.out.println("\n=============================");
							subject.setNameState(player, phase3, message3);
							System.out.println("=============================\n");
							o_aggressive.fortify(file, defender_armies1, country_per_player, army_per_country);
							//a_contex.fortify(file, defender_armies1, country_per_player, army_per_country);
							o_fortification.fortifyAggressive(file, country_per_player.get(i), army_per_country);
							System.out.println("Fortification Phase done");
							o_printtable.getTable(file, i, country_per_player, army_per_country);
							// System.exit(0);
						} else if (player_names.get(player) == 3) {
							System.out.println("Player : " + player);
							o_printtable.getTable(file, i, country_per_player, army_per_country);
							//b_contex.reinforcement(army_per_country, country_per_player, i, contvalue1, contvalue1, country_continent);
							int extra_army = 0;
							int z = o_reinforcement.calReinforcementArmies(country_per_player.get(i), contvalue1,
									country_continent, contvalue);
							z += extra_army;
							army_per_country = o_reinforcement.placeReinforceArmiesBenevolent(z, i, country_per_player,
									army_per_country);
							System.out.println("Reinforced armies : " + z);
							
							System.out.println("After Reinforcement : ");
							o_printtable.getTable(file, i, country_per_player, army_per_country);
							// no attack phase
							System.out.println("\n=============================");
							subject.setNameState(player, phase3, message3);
							System.out.println("=============================\n");
							//b_contex.fortify(file, i, country_per_player, army_per_country);
							o_fortification.fortifyBenevolent(file, country_per_player.get(i), army_per_country);
							System.out.println("Fortification Phase done");
							o_printtable.getTable(file, i, country_per_player, army_per_country);
							// System.exit(0);
						} else if (player_names.get(player) == 4) {
							System.out.println("Player : " + player);
							o_printtable.getTable(file, i, country_per_player, army_per_country);
							int extra_army = 0;
							int z = o_reinforcement.calReinforcementArmies(country_per_player.get(i), contvalue1,
									country_continent, contvalue);
							z += extra_army;
							army_per_country = o_reinforcement.placeReinforceArmiesRandom(z, i, country_per_player,
									army_per_country);
							System.out.println("Reinforced armies : " + z);
							
							//r_contex.reinforcement(army_per_country, country_per_player, i, contvalue1, contvalue1, country_continent);
							System.out.println("After Reinforcement : ");
							o_printtable.getTable(file, i, country_per_player, army_per_country);
							int attacker_armies = 0;
							int defender_armies = 0;
							int attacker_armies1 = 0;
							int defender_armies1 = 0;
							String attack_country = null;
							String defend_country = null;
							System.out.println("\nPHASE VIEW");
							System.out.println("\n=============================");
							subject.setNameState(player, phase2, message2);
							System.out.println("=============================\n");
							String a_country = o_attack.getAttackingCountryRandom(country_per_player.get(i), army_per_country);
							System.out.println("Attacker Country : " + a_country);
							ArrayList<String> neighbour_countries = o_printtable.getNeighbour(file, a_country);
							ArrayList<String> to_be_attacked_countries = o_attack.toBeAttackedCountry(country_per_player.get(i),
									neighbour_countries);
							int a_armies = army_per_country.get(a_country);
							System.out.println("Attacker Armies : " + a_armies);
		
							for (int l = 0; l < to_be_attacked_countries.size(); l++) {
								if (a_armies <= 1) {
									break;
								}
								String d_country = to_be_attacked_countries.get(l);
								int d = o_dice.getDefenderIndex(d_country, country_per_player);
								int d_armies = army_per_country.get(d_country);
		
								army_per_country = o_dice.rollDiceRandom(a_armies, d_armies, file, i, country_per_player,
										army_per_country, a_country, d_country);
								a_armies = army_per_country.get(a_country);
								d_armies = army_per_country.get(d_country);
		
								if (d_armies == 0) {
									army_per_country = o_dice.placeAttackArmiesRandom(a_armies, a_country, d_country,
											army_per_country);
									country_per_player = o_dice.placeAttackCountryRandom(a_country, d_country,
											country_per_player, i, d, out_players);
								}
								System.out.println(army_per_country);
								System.out.println(country_per_player);
							}
							//r_contex.attack(attack_country, armies_per_player, country_per_player, file, defend_country, country_list, attacker_armies, defender_armies, attacker_armies1, defender_armies1, army_per_country, cards, card_1, card_2, card_3, card_4, card_5, card_6, out_players, i);
							o_printtable.getTable(file, i, country_per_player, army_per_country);
							System.out.println("Attack Phase done");
							System.out.println("\n=============================");
							subject.setNameState(player, phase3, message3);
							System.out.println("=============================\n");
							//r_contex.fortify(file, i, country_per_player, army_per_country);
							o_fortification.fortifyRandom(file, country_per_player.get(i), army_per_country);
							System.out.println("Fortification Phase done");
							o_printtable.getTable(file, i, country_per_player, army_per_country);
							// System.exit(0);
						} else if (player_names.get(player) == 5) {
							System.out.println("Player : " + player);
							o_printtable.getTable(file, i, country_per_player, army_per_country);
							army_per_country = o_reinforcement.placeReinforceArmiesCheater(i, country_per_player, army_per_country);
							//c_contex.reinforcement(army_per_country, country_per_player, i, contvalue1, contvalue1, country_continent);
							System.out.println("After Reinforcement : ");
							o_printtable.getTable(file, i, country_per_player, army_per_country);
							
							int attacker_armies = 0;
							int defender_armies = 0;
							int attacker_armies1 = 0;
							int defender_armies1 = 0;
							String attack_country = null;
							String defend_country = null;
							System.out.println("\nPHASE VIEW");
							System.out.println("\n=============================");
							subject.setNameState(player, phase2, message2);
							System.out.println("=============================\n");
							country_per_player = o_attack.attackCheater(file, i, country_per_player, out_players);
							//System.out.println("Attack Phase done");
							//c_contex.attack(attack_country, armies_per_player, country_per_player, file, defend_country, country_list, attacker_armies, defender_armies, attacker_armies1, defender_armies1, army_per_country, cards, card_1, card_2, card_3, card_4, card_5, card_6, out_players, i);
							o_printtable.getTable(file, i, country_per_player, army_per_country);
							System.out.println("\n=============================");
							subject.setNameState(player, phase3, message3);
							System.out.println("=============================\n");
							o_fortification.fortifyCheater(file, country_per_player.get(i), army_per_country);
							//System.out.println("Fortification Phase done");
							//c_contex.fortify(file, i, country_per_player, army_per_country);
							o_printtable.getTable(file, i, country_per_player, army_per_country);
							System.out.println(country_per_player);
							System.out.println(player_names);
							// System.exit(0);
						}
					}
				}	
			
		
		System.out.println("Winner : " + winner);
		System.out.println("The End");
	}

	/**
	 * This method is for menu options
	 * 
	 * @throws Exception
	 */
	public static void menu() throws Exception {
		int i = 0;
		Scanner a = new Scanner(System.in);
		RGPtournament o_tourny = new RGPtournament();

		while (i == 0) {
			System.out.println("*************************");
			System.out.println("* 1- Single player mode *");
			System.out.println("* 2- Tournament mode    *");
			System.out.println("* 3- Help               *");
			System.out.println("* 4- Exit               *");
			System.out.println("*************************\n");
			System.out.println("Enter your option");
			int option = a.nextInt();
			switch (option) {
			case 1:
				mapo();
				i = i + 1;
				break;
			case 2:
				o_tourny.tournament();
				i = i + 1;
				break;
			case 3:
				System.out.println("Risk Game Help");
				menu();
			case 4:
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
	 * 
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