import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
/**
 * This class is to play tournament mode based on player strategies
 * @author pavan
 *
 */
public class RGPtournament {

	static int total_players;
	static HashMap<String,Integer> player_names = new HashMap<String,Integer>();
	static File file;
	static int i = 0;
	static ArrayList<Integer> names = new ArrayList<Integer>();
	static int d = 0;
	static int k = 0;
	static int b;
	static String[] winner_list;
	static HashMap<String,String> Map1 = new HashMap<String,String>();
	static HashMap<String,String> Map2 = new HashMap<String,String>();
	static HashMap<String,String> Map3 = new HashMap<String,String>();
	static HashMap<String,String> Map4 = new HashMap<String,String>();
	static HashMap<String,String> Map5 = new HashMap<String,String>();
	static HashMap<String,String> winnerslist1 = new HashMap<String,String>();
	static HashMap<String,String> winnerslist2 = new HashMap<String,String>();
	static HashMap<String,String> winnerslist3 = new HashMap<String,String>();
	static HashMap<String,String> winnerslist4 = new HashMap<String,String>();
	static HashMap<String,String> winnerslist5 = new HashMap<String,String>();
	static String map = " ";
	static String game = " ";
	static String win = "";
	/**
	 * This method is to initiate the values to tournament
	 * @throws Exception
	 */
	public static void tournament() throws Exception {
		Scanner a = new Scanner(System.in);
		System.out.println("Enter number of map to be played ");
		b= a.nextInt();
		System.out.println("Enter number of players ");
		total_players  = a.nextInt();
		System.out.println("Aggressive = 1");
		System.out.println("Benevolent = 2");
		System.out.println("Random = 3");
		System.out.println("Cheater = 4");
		for(i=0;i<total_players;i++) {
			
			System.out.println("Enter player "+(i+1)+" behaviour :");
			int opt = a.nextInt();
			System.out.println("Enter player "+(i+1)+" name :");
			String opt1 = a.next();
			player_names.put(opt1, opt);
		}
		System.out.println("Number of games to be played on each map");
		int g = a.nextInt();
		System.out.println("Number of turns each game should be played");
		d = a.nextInt();
		if(b==1) {
			for(i=0;i<g;i++) {
				file = new File("D:\\Projects\\Risk\\SOEN-6441\\src\\main\\java\\world.map");
				System.out.println("Map1 : ");
				for(int i=0;i<g;i++) {
					win = tournamentstart(file);
					map = "map1";
					game = "game" + (i+1);
					winnerslist1.put(map, game);
					Map1.put(winnerslist1.get(map),win);
				}
			}
			System.out.println("\n************************************************************************");
			System.out.println("Map 1: " + Map1);
			System.out.println("************************************************************************\n");
		}
		if(b==2) {
			file = new File("D:\\Projects\\Risk\\SOEN-6441\\src\\main\\java\\world.map");
			//String win = "";
			//System.out.println("Map1 : ");
			for(int i=0;i<g;i++) {
				win = tournamentstart(file);
				map = "map1";
				game = "game" + (i+1);
				winnerslist1.put(map, game);
				Map1.put(winnerslist1.get(map),win);
				//System.out.println(winners);
				//System.out.println("Game "+i+" : "+win);
			}
			//System.out.println(winners);
			//win = " ";
			file = new File("D:\\Projects\\Risk\\SOEN-6441\\src\\main\\java\\world.map");
			//System.out.println("Map2 : ");
			for(int i=0;i<g;i++) {
				win = tournamentstart(file);
				map = "map2";
				game = "game" + (i+1);
				winnerslist2.put(map, game);
				Map2.put(winnerslist2.get(map),win);
				//System.out.println(winners);
				//System.out.println("Game "+i+" : "+win);
			}
			System.out.println("\n************************************************************************");
			System.out.println("Map 1: " + Map1);
			System.out.println("Map 2: " + Map2);
			System.out.println("************************************************************************\n");
		}
		
		if(b==3) {
			file = new File("D:\\Projects\\Risk\\SOEN-6441\\src\\main\\java\\world.map");
			String win = "";
			System.out.println("Map1 : ");
			for(int i=0;i<g;i++) {
				win = tournamentstart(file);
				map = "map1";
				game = "game" + (i+1);
				winnerslist1.put(map, game);
				Map1.put(winnerslist1.get(map),win);
			}
			file = new File("D:\\Projects\\Risk\\SOEN-6441\\src\\main\\java\\world.map");
			System.out.println("Map2 : ");
			for(int i=0;i<g;i++) {
				win = tournamentstart(file);
				map = "map2";
				game = "game" + (i+1);
				winnerslist1.put(map, game);
				Map2.put(winnerslist1.get(map),win);
			}
			file = new File("D:\\Projects\\Risk\\SOEN-6441\\src\\main\\java\\world.map");
			System.out.println("Map3 : ");
			for(int i=0;i<g;i++) {
				win = tournamentstart(file);
				map = "map3";
				game = "game" + (i+1);
				winnerslist3.put(map, game);
				Map3.put(winnerslist3.get(map),win);
			}
			System.out.println("\n************************************************************************");
			System.out.println("Map 1: " + Map1);
			System.out.println("Map 2: " + Map2);
			System.out.println("Map 3: " + Map3);
			System.out.println("************************************************************************\n");
			
		}
		if(b==4) {
			file = new File("D:\\Projects\\Risk\\SOEN-6441\\src\\main\\java\\world.map");
			String win = "";
			System.out.println("Map1 : ");
			for(int i=0;i<g;i++) {
				win = tournamentstart(file);
				map = "map1";
				game = "game" + (i+1);
				winnerslist1.put(map, game);
				Map1.put(winnerslist1.get(map),win);
			}
			file = new File("D:\\Projects\\Risk\\SOEN-6441\\src\\main\\java\\world.map");
			System.out.println("Map2 : ");
			for(int i=0;i<g;i++) {
				win = tournamentstart(file);
				map = "map2";
				game = "game" + (i+1);
				winnerslist2.put(map, game);
				Map2.put(winnerslist2.get(map),win);
			}
			file = new File("D:\\Projects\\Risk\\SOEN-6441\\src\\main\\java\\world.map");
			System.out.println("Map3 : ");
			for(int i=0;i<g;i++) {
				win = tournamentstart(file);
				map = "map3";
				game = "game" + (i+1);
				winnerslist3.put(map, game);
				Map3.put(winnerslist3.get(map),win);
			}
			file = new File("D:\\Projects\\Risk\\SOEN-6441\\src\\main\\java\\world.map");
			System.out.println("Map4 : ");
			for(int i=0;i<g;i++) {
				win = tournamentstart(file);
				map = "map4";
				game = "game" + (i+1);
				winnerslist4.put(map, game);
				Map4.put(winnerslist4.get(map),win);
			}
			System.out.println("\n************************************************************************");
			System.out.println("Map 1: " + Map1);
			System.out.println("Map 2: " + Map2);
			System.out.println("Map 3: " + Map3);
			System.out.println("Map 4: " + Map4);
			System.out.println("************************************************************************\n");
		}
		if(b==5) {
			file = new File("D:\\Projects\\Risk\\SOEN-6441\\src\\main\\java\\world.map");
			String win = "";
			System.out.println("Map1 : ");
			for(int i=0;i<g;i++) {
				win = tournamentstart(file);
				map = "map1";
				game = "game" + (i+1);
				winnerslist1.put(map, game);
				Map1.put(winnerslist1.get(map),win);
			}
			file = new File("D:\\Projects\\Risk\\SOEN-6441\\src\\main\\java\\world.map");
			System.out.println("Map2 : ");
			for(int i=0;i<g;i++) {
				win = tournamentstart(file);
				map = "map2";
				game = "game" + (i+1);
				winnerslist2.put(map, game);
				Map2.put(winnerslist2.get(map),win);
			}
			file = new File("D:\\Projects\\Risk\\SOEN-6441\\src\\main\\java\\world.map");
			System.out.println("Map3 : ");
			for(int i=0;i<g;i++) {
				win = tournamentstart(file);
				map = "map3";
				game = "game" + (i+1);
				winnerslist3.put(map, game);
				Map3.put(winnerslist3.get(map),win);
			}
			file = new File("D:\\Projects\\Risk\\SOEN-6441\\src\\main\\java\\world.map");
			System.out.println("Map4 : ");
			for(int i=0;i<g;i++) {
				win = tournamentstart(file);
				map = "map4";
				game = "game" + (i+1);
				winnerslist4.put(map, game);
				Map4.put(winnerslist4.get(map),win);
			}
			file = new File("D:\\Projects\\Risk\\SOEN-6441\\src\\main\\java\\world.map");
			System.out.println("Map5 : ");
			for(int i=0;i<g;i++) {
				win = tournamentstart(file);
				map = "map5";
				game = "game" + (i+1);
				winnerslist5.put(map, game);
				Map5.put(winnerslist5.get(map),win);
			}
			System.out.println("\n************************************************************************");
			System.out.println("Map 1: " + Map1);
			System.out.println("Map 2: " + Map2);
			System.out.println("Map 3: " + Map3);
			System.out.println("Map 4: " + Map4);
			System.out.println("Map 5: " + Map5);
			System.out.println("************************************************************************\n");
		}
		//System.out.println("winner list :"+winner_list);
		System.exit(0);
	}
		
    /**
     * This method is to start the tournament mode
     * @param file is map file
     * @return winner of game
     * @throws Exception
     */
	public static String tournamentstart(File file) throws Exception {
		
		
		//System.out.println("number of players: " + b );
		
		
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
		RGPplayer o_player = new RGPplayer();
		RGPattack o_attack = new RGPattack();
		RGPprintTable o_printtable = new RGPprintTable();
		RGPreinforcement o_reinforcement = new RGPreinforcement();
		RGPdiceroll o_dice = new RGPdiceroll();
		RGPaggressive o_aggressive = new RGPaggressive();
		
		

		HashMap<String, Integer> contvalue = o_uem.getcontinentandcontrolvalue(file);
		HashMap<String, Integer> contvalue1 = o_uem.getcontinentandcountry(file);
		HashMap<String, String> country_continent = o_uem.getCountryContinent(file);
		ArrayList<String> continent_list = o_uem.continentlist(file);
		ArrayList<String> country_list = o_uem.countrylist(file);

		
		int total_country = o_uem.countrylist(file).size();
		ArrayList<String> country_name = o_uem.countrylist(file);
		//System.out.println(country_name);
		//System.out.println("total players = " + total_players);

		int armies_per_player = o_army.totalArmy(total_players, total_country);
		//System.out.println("Total No. of countries : " + total_country);
		//System.out.println("Per Player armies : " + armies_per_player);

		List<List<String>> country_per_player = new ArrayList<List<String>>();
		country_per_player = o_army.divideCountry(total_players, country_name);
		//System.out.println("\nList of country per player");
		//System.out.println(country_per_player);

		HashMap<String, Integer> army_per_country = new HashMap<String, Integer>();
		army_per_country = o_army.armyPerCountry(total_players, armies_per_player, country_per_player);
		//System.out.println("No. of armies per country");
		//System.out.println(army_per_country);

		HashMap<String, Integer> cards = new HashMap<String, Integer>();
		HashMap<String, Integer> card_1 = new HashMap<String, Integer>();
		HashMap<String, Integer> card_2 = new HashMap<String, Integer>();
		HashMap<String, Integer> card_3 = new HashMap<String, Integer>();
		HashMap<String, Integer> card_4 = new HashMap<String, Integer>();
		HashMap<String, Integer> card_5 = new HashMap<String, Integer>();
		HashMap<String, Integer> card_6 = new HashMap<String, Integer>();
		cards = o_card.hm1(country_name);

		List<Integer> out_players = new ArrayList<Integer>();
		List<List<String>> continent_list_per_player = new ArrayList<List<String>>();
		int player_flag = 1;
		String winner = null;
		//System.out.println(winner);
		int i;
		while(k != d) {
			
			for (i = 0; i < total_players; i++) {
				Set<Map.Entry<String, Integer>> mapSet = player_names.entrySet();
	            Map.Entry<String, Integer> elementAt = (Map.Entry<String, Integer>) mapSet.toArray()[i];
	            String player = elementAt.getKey();
	            //System.out.println("Player : "+player_names.get(player));
	           // System.out.println(out_players);
				if(out_players.size() != 0) {
					//System.out.println(out_players);
					if(out_players.contains(i)) {
						continue;
					}else {
						//System.out.println(player);
						winner = player;
					}
					if(out_players.size() == (total_players-1)) {
						player_flag = 0;
						continue;
					}
				}

				/*System.out.println("\nWORLD DOMINATION VIEW\n");
				System.out.println("==========================");
				//Players world domination view
	        	for(int j=0;j<total_players;j++) {
	        		int total_country_num = country_list.size();
	        		int player_country_num = (country_per_player.get(j)).size();
	        		float map_per_player = (float)(100*player_country_num)/total_country_num;
	        		continent_list_per_player = o_reinforcement.getContinent(country_per_player, country_continent, contvalue1);
	            	int total_army_per_player=0;
	            	for(int d=0;d<country_per_player.get(j).size();d++) {
	            		String country = country_per_player.get(j).get(d);
	            		total_army_per_player+=army_per_country.get(country);
	            	}
	            	
	            	//	o_player.reinforcement(army_per_country, country_per_player, j, total_army_per_player);
	            	
	            	subject1.setNameState(j+1,(int)map_per_player,continent_list_per_player.get(i),total_army_per_player);
	            	System.out.println("\n");
	        	}
	        	System.out.println("==========================");
	        	*/
	            if(player_names.get(player) == 1) {
	            	//System.out.println("Player : "+player);
					//o_printtable.getTable(file, i, country_per_player, army_per_country);
					int extra_army=0;    		
		    		int z = o_reinforcement.calReinforcementArmies(country_per_player.get(i), contvalue1, country_continent, contvalue);
					z += extra_army;
					army_per_country = o_reinforcement.placeReinforceArmiesAggressive(z, i, country_per_player, army_per_country);
					//System.out.println("Reinforced armies : "+z);
					
					//System.out.println("After Reinforcement : ");
					//o_printtable.getTable(file, i, country_per_player, army_per_country);
					//System.exit(0);
					int attacker_armies = 0;
					int defender_armies = 0;
					int attacker_armies1 = 0;
					int defender_armies1 = 0;
					String attack_country = null;
					String defend_country = null;
					//System.out.println("\nPHASE VIEW");
					//System.out.println("\n=============================");
					//subject.setNameState(player, phase2, message2);
					//System.out.println("=============================\n");
					//o_aggressive.attack(attack_country, armies_per_player, country_per_player, file, defend_country, country_list, attacker_armies, defender_armies, attacker_armies1, defender_armies1, army_per_country, cards, card_1, card_2, card_3, card_4, card_5, card_6, out_players, z);
					String a_country = o_attack.getAttackingCountryAggressive(country_per_player.get(i), army_per_country);
					//System.out.println("Attacker Country : "+a_country);
					ArrayList<String> neighbour_countries = o_printtable.getNeighbour(file, a_country);
					ArrayList<String> to_be_attacked_countries = o_attack.toBeAttackedCountry(country_per_player.get(i), neighbour_countries);
					int a_armies = army_per_country.get(a_country);
					//System.out.println("Attacker Armies : "+a_armies);
					
					for(int l=0;l<to_be_attacked_countries.size();l++) {
						if(a_armies<=1) {
							break;
						}
						String d_country = to_be_attacked_countries.get(l);
						int d = o_dice.getDefenderIndex(d_country, country_per_player);
						int d_armies = army_per_country.get(d_country);
											
						army_per_country = o_dice.rollDiceAggressive(a_armies, d_armies, file, i, country_per_player, army_per_country, a_country, d_country);
						a_armies = army_per_country.get(a_country);
						d_armies = army_per_country.get(d_country);
						
						if(d_armies == 0) {
							army_per_country = o_dice.placeAttackArmiesAggressive(a_armies, a_country, d_country, army_per_country);
							country_per_player = o_dice.placeAttackCountryAggressive(a_country, d_country, country_per_player, i, d, out_players);
						}
						//System.out.println(army_per_country);
						//System.out.println(country_per_player);
					}
					/*o_printtable.getTable(file, i, country_per_player, army_per_country);
					System.out.println("Attack Phase done");
					System.out.println("\n=============================");
					subject.setNameState(player, phase3, message3);
					System.out.println("=============================\n");*/
					//o_aggressive.fortify(file, defender_armies1, country_per_player, army_per_country);
					o_fortification.fortifyAggressive(file, country_per_player.get(i), army_per_country);
					//System.out.println("Fortification Phase done");
					//o_printtable.getTable(file, i, country_per_player, army_per_country);
					//System.exit(0);
	            }
	            
	            
	            else if(player_names.get(player) == 2) {
	            	//System.out.println("Player : "+player);
					//o_printtable.getTable(file, i, country_per_player, army_per_country);
					int extra_army=0;    		
		    		int z = o_reinforcement.calReinforcementArmies(country_per_player.get(i), contvalue1, country_continent, contvalue);
					z += extra_army;
					army_per_country = o_reinforcement.placeReinforceArmiesBenevolent(z, i, country_per_player, army_per_country);
					//System.out.println("Reinforced armies : "+z);
					
					/*System.out.println("After Reinforcement : ");
					o_printtable.getTable(file, i, country_per_player, army_per_country);
					//no attack phase
					System.out.println("\n=============================");
					subject.setNameState(player, phase3, message3);
					System.out.println("=============================\n");*/
					o_fortification.fortifyBenevolent(file, country_per_player.get(i), army_per_country);
					//System.out.println("Fortification Phase done");
					//o_printtable.getTable(file, i, country_per_player, army_per_country);
					//System.exit(0);
	            }
	            
	            
	            
	            
	            else if(player_names.get(player) == 3) {
	            	//System.out.println("Player : "+player);
					//o_printtable.getTable(file, i, country_per_player, army_per_country);
					int extra_army=0;    		
		    		int z = o_reinforcement.calReinforcementArmies(country_per_player.get(i), contvalue1, country_continent, contvalue);
					z += extra_army;
					army_per_country = o_reinforcement.placeReinforceArmiesRandom(z, i, country_per_player, army_per_country);
				/*	System.out.println("Reinforced armies : "+z);
					
					System.out.println("After Reinforcement : ");
					o_printtable.getTable(file, i, country_per_player, army_per_country);
					System.out.println("\nPHASE VIEW");
					System.out.println("\n=============================");
					subject.setNameState(player, phase2, message2);
					System.out.println("=============================\n");*/
					String a_country = o_attack.getAttackingCountryRandom(country_per_player.get(i), army_per_country);
					//System.out.println("Attacker Country : "+a_country);
					ArrayList<String> neighbour_countries = o_printtable.getNeighbour(file, a_country);
					ArrayList<String> to_be_attacked_countries = o_attack.toBeAttackedCountry(country_per_player.get(i), neighbour_countries);
					int a_armies = army_per_country.get(a_country);
					//System.out.println("Attacker Armies : "+a_armies);
					
					for(int l=0;l<to_be_attacked_countries.size();l++) {
						if(a_armies<=1) {
							break;
						}
						String d_country = to_be_attacked_countries.get(l);
						int d = o_dice.getDefenderIndex(d_country, country_per_player);
						int d_armies = army_per_country.get(d_country);
											
						army_per_country = o_dice.rollDiceRandom(a_armies, d_armies, file, i, country_per_player, army_per_country, a_country, d_country);
						a_armies = army_per_country.get(a_country);
						d_armies = army_per_country.get(d_country);
						
						if(d_armies == 0) {
							army_per_country = o_dice.placeAttackArmiesRandom(a_armies, a_country, d_country, army_per_country);
							country_per_player = o_dice.placeAttackCountryRandom(a_country, d_country, country_per_player, i, d, out_players);
						}
					//	System.out.println(army_per_country);
						//System.out.println(country_per_player);
					}
					/*o_printtable.getTable(file, i, country_per_player, army_per_country);
					System.out.println("Attack Phase done");
					System.out.println("\n=============================");
					subject.setNameState(player, phase3, message3);
					System.out.println("=============================\n");*/
					o_fortification.fortifyRandom(file, country_per_player.get(i), army_per_country);
					//System.out.println("Fortification Phase done");
					//o_printtable.getTable(file, i, country_per_player, army_per_country);
					//System.exit(0);
	            }
	            
	            
	            
	            
	            else if(player_names.get(player) == 4) {
	            	//System.out.println("Player : "+player);
					//o_printtable.getTable(file, i, country_per_player, army_per_country);
					army_per_country = o_reinforcement.placeReinforceArmiesCheater(i, country_per_player, army_per_country);
					/*
					System.out.println("After Reinforcement : ");
					o_printtable.getTable(file, i, country_per_player, army_per_country);
					System.out.println("\nPHASE VIEW");
					System.out.println("\n=============================");
					subject.setNameState(player, phase2, message2);
					System.out.println("=============================\n");*/
					country_per_player = o_attack.attackCheater(file, i, country_per_player, out_players);
					/*System.out.println("Attack Phase done");

					o_printtable.getTable(file, i, country_per_player, army_per_country);
					System.out.println("\n=============================");
					subject.setNameState(player, phase3, message3);
					System.out.println("=============================\n");*/
					o_fortification.fortifyCheater(file, country_per_player.get(i), army_per_country);
					/*System.out.println("Fortification Phase done");
					o_printtable.getTable(file, i, country_per_player, army_per_country);
					System.out.println(country_per_player);
					System.out.println(player_names);*/
					//System.exit(0);
	            }
			}
			k = k + 1;
		}
		if(winner == null) {
			 winner = "Draw";
		}
		//if(out_players.size() != (total_players-1)) {
		//	winner = "Draw";
		//}
		System.out.println(out_players);
		out_players.clear();
		k=0;
		System.out.println("Winner : "+winner);
		return winner;
		//System.out.println("Winner : "+winner);
		//System.out.println("The End");
	}

 
}