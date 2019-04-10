import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 * This is player class which has three methods of reinforcement,attack,fortification phase
 * @author raoko
 *
 */
public class RGPplayer implements RGPstrategy{
	/**
	 * This is reinforcement phase
	 */
	public void reinforcement(HashMap<String, Integer> army_per_country, List<List<String>> country_per_player, int i, Map<String,Integer> contvalue1, Map<String,Integer> contvalue, Map<String, String> country_continent) {
		
	}

    /**
     * This is attack phase
     */
	public void attack(String attack_country, int i, List<List<String>> country_per_player, File file, String defend_country,ArrayList<String> country_list,int attacker_armies,int defender_armies,int attacker_armies1,int defender_armies1,HashMap<String, Integer> army_per_country,HashMap<String, Integer> cards,HashMap<String, Integer> card_1,HashMap<String, Integer> card_2,HashMap<String, Integer> card_3,HashMap<String, Integer> card_4,HashMap<String, Integer> card_5,HashMap<String, Integer> card_6,List<Integer> out_players,int total_players) throws Exception {
		
		RGPprintTable o_printtable = new RGPprintTable();
		Scanner ab = new Scanner(System.in);
		RGPcardDivision o_card = new RGPcardDivision();
		RGPfortification o_fortification = new RGPfortification();
		RGPreinforcement o_reinforcement = new RGPreinforcement();
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
		}
	}
	/**
	 * This is method for fortification phase
	 */
	public void fortify(File file, int i,List<List<String>> country_per_player,HashMap<String, Integer> army_per_country) throws Exception{
		RGPprintTable o_printtable = new RGPprintTable();
		RGPfortification o_fortification = new RGPfortification();
		Scanner ab = new Scanner(System.in);
		System.out.println("Do you want to fortify ?(y/n)");
		String ans = ab.next();
		if (ans.equalsIgnoreCase("y")) {
			o_fortification.fortify(file, country_per_player.get(i), army_per_country);
			o_printtable.getTable(file, i, country_per_player, army_per_country);
		}
	}

}