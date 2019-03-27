
public class RGPplayer extends main{
	public void reinforcement(){
		int z = o_reinforcement.calReinforcementArmies(country_per_player.get(i), contvalue1, country_continent,
				contvalue);
		z += extra_army;
		System.out.println("Number of armies to Reinforcement : " + z);

		army_per_country = o_reinforcement.placeReinforceArmies(z, i, country_per_player, army_per_country);
		// print table
		o_printtable.getTable(file, i, country_per_player, army_per_country);
	}
}
