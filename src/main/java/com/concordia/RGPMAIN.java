package com.concordia;

import java.util.ArrayList;

public class RGPMAIN {
	public static void main(String[] args) {
		RGPprintTable o_printtable = new RGPprintTable();

		for (int i = 0; i < total_players; i++) {
			//Players world domination view
        	for(int j=0;j<total_players;j++) {
        		int total_country_num = country_list.size();
        		int player_country_num = (country_per_player.get(j)).size();
        		float map_per_player = (float)(100*player_country_num)/total_country_num;
        		System.out.println("Map(%) : "+map_per_player+" %");
        		
        		ArrayList<String> continent_list_per_player;
        		for(int k=0;k<country_per_player.get(j).size();k++){
        			
        		}
            	//System.out.println("Continents : "+continent_list_per_player);
            	
            	int total_army_per_player=0;
            	for(int k=0;k<country_per_player.get(j).size();k++){
            		total_army_per_player+=army_per_country.get(country_per_player.get(j).get(k));
            	}
            	System.out.println("Total armies : "+total_army_per_player);
        	}
	}
}
