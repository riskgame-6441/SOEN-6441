import java.util.*;

/**
 * This class is about Card Dealing in the Game. 
 * 
 * 
 * @author Krisha Patel
 * @version 1.0.0
 *
 */
public class RGPcardDivision {
	
	private static HashMap<String,Integer> asd1 = new HashMap<String,Integer>();
	private static HashMap<String,Integer> asd2 = new HashMap<String,Integer>();
	
	/**
	 * This method will help the user to create a hashMap for the cards.
	 * Each card will have a country allocated to it and a card type.
	 * Type will be 1,2,3(Artillery, Calvary,Infantry) 
	 * This hashMap will have the name of the country and its type.
	 * 
	 * @param country_names This parameter will have an arrayList provided by the user.
	 * The list of the countries included in the game.
	 * 
	 * @return This Method will return a HashMap which will have country as key and type of card as its value.
	 * 
	 */
	public static HashMap<String,Integer> hm1(ArrayList<String> country_names) {
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		int n=country_names.size();
		int j=0;
		for(int i=0;i<n;i++) {
			int v=j+1;
			j++;
			hm.put(country_names.get(i),v);
			if(j==3){
				j=0;
			}
		}
		return hm;
	}
		
	/**
	 * This method will check the types of cards and provide reinforcement armies 
	 * as per the dealing of Cards.
	 * 
	 * @param a its type is HashMap. This parameter contains value for card 1.
	 *   
	 * @param b its type is HashMap. This parameter contains value for card 2.
	 * 
	 * @param c its type is HashMap. This parameter contains value for card 3.
	 *
	 * @return This method returns the additional number of Reinforcement armies for a particular Player. 
	 *
	 */
	public static int check_cards_deal(HashMap<String,Integer> a, HashMap<String,Integer> b, HashMap<String,Integer> c) {
		HashMap<String,Integer> a1 =new HashMap<String,Integer>();
		HashMap<String,Integer> b1 =new HashMap<String,Integer>();
		HashMap<String,Integer> c1 =new HashMap<String,Integer>();
		a1=a; 
		b1=b;
		c1=c;
		int extra_army=0;
		
		if(a1.containsValue(3) && b1.containsValue(3) && c1.containsValue(3)) {
			extra_army+=8;
			//System.out.println("Reinforcement +8");
		} else if(a1.containsValue(2) && b1.containsValue(2) && c1.containsValue(2)) {
			extra_army+=6;
			//System.out.println("Reinforcement +6");
		} else if(a1.containsValue(1) && b1.containsValue(1) && c1.containsValue(1)) {
			extra_army+=4;
			//System.out.println("Reinforcement +4");
		} else if(a1.containsValue(1) && b1.containsValue(2) && c1.containsValue(3)||
		 a1.containsValue(1) && b1.containsValue(3) && c1.containsValue(2)||
		 a1.containsValue(2) && b1.containsValue(1) && c1.containsValue(3)||
		 a1.containsValue(2) && b1.containsValue(3) && c1.containsValue(1)||
		 a1.containsValue(3) && b1.containsValue(1) && c1.containsValue(2)||
		 a1.containsValue(3) && b1.containsValue(2) && c1.containsValue(1)) {
			extra_army+=10;
			//System.out.println("Reinforcement +10");
		} else {
			System.out.println("No Reinforcement : check the cards you entered.");
		}
		return extra_army;
	}

	/**
	 * This method will Transfer one element from one ArrayList to another ArrayList.
	 *  
	 * @param a This parameter will contain ArrayList provided by the user.
	 * 
	 * @param b This parameter will contain ArrayList provided by the user.
	 * 
	 * @return This Method will return two updated ArrayList.
	 */
	public static void add_sub(ArrayList<String> a, ArrayList<String> b) {
		ArrayList<String> al1 = new ArrayList<String>();
		ArrayList<String> al2 = new ArrayList<String>();
		al1=a;
		al2=b;
		al1.add("A");
		al1.add("B");
		al1.add("C");
		al1.add("D");
		al1.add("E");
		al1.add("F");
		al1.add("G");
		al2.add(al1.remove(1));
	}

	/**
	 * This method will Transfer one element from one HashMap to another HashMap.
	 *   
	 * @param a This parameter will contain HashMap provided by the user.
	 * 
	 * @param b This parameter will contain HashMap provided by the user.
	 *
	 * @return This method will return two updated HashMap.
	 */
	public static void hash_add_sub(HashMap<String,Integer> a, HashMap<String,Integer> b) {
		asd1=a;
		asd2=b;
		Object[] key_set = asd1.keySet().toArray();
		Object key = key_set[new Random().nextInt(key_set.length)];
		String str = String.valueOf(key);
		System.out.println(str);
		int n = asd1.get(key);
		asd2.put(str,n);
		//asd1.remove(key);
	}
		
	public static HashMap<String,Integer> getCards(){
		return asd1;
	}
	
	public static HashMap<String,Integer> getPlayerCard(){
		return asd2;
	}
		
	/**
	 * This method will get the Key from its value corresponding to the HashMap.
	 * 
	 * @param a This parameter will have HashMap provider by the user.
	 * 
	 * @param value This parameter will have the value of the HashMap for which will need to find the Key Value
	 * 
	 * @return This Method will Return the Key to the given value if true.
	 *          if false will return null.
	 */
	public static String getting_key(HashMap<String,Integer> a, int value) {
		for(String o:a.keySet()) {
			if(a.get(o).equals(value)) {
				return o;
			}
		}
		return null;
	}
		
	/**
	 * This method is used to trade cards and to get value of extra armies
	 * 
	 * @author Dhruvi Gadhiya
	 * @param cards This parameter is contains HashMap of cards owned by a player
	 * 
	 * @return This method will return number of armies collected by trading cards
	 * */
	public static int trade_card(HashMap<String,Integer> cards) {
		int extra_army=0;
		HashMap<String,Integer> a_1 =new HashMap<String,Integer>();
		HashMap<String,Integer> b_1 =new HashMap<String,Integer>();
		HashMap<String,Integer> c_1 =new HashMap<String,Integer>();
		if(cards.size()<5 && cards.size()>=3) {
			Scanner a = new Scanner(System.in);
			System.out.println("Do you want to trade cards?(y/n) : ");
			String a1 = a.next();
			if(a1.equals("y")) {
				a_1 = get_card(cards);
				b_1 = get_card(cards);
				c_1 = get_card(cards);
				extra_army = check_cards_deal(a_1, b_1, c_1);
			}	
		}else {
			a_1 = get_card(cards);
			b_1 = get_card(cards);
			c_1 = get_card(cards);
			extra_army = check_cards_deal(a_1, b_1, c_1);
		}
		if(extra_army!=0) {
			cards.remove(a_1);
			cards.remove(b_1);
			cards.remove(c_1);
		}
		return extra_army;
	}
	
	/**
	 * This method is used to get cards entered by asking player   
	 * 
	 * @author Dhruvi Gadhiya
	 * @param cards This parameter is contains HashMap of cards owned by a player
	 * 
	 * @return This method will return card entered by player to trade in form of HashMap 
	 * */
	public static HashMap<String,Integer> get_card(HashMap<String,Integer> cards){
		HashMap<String,Integer> card = new HashMap<String,Integer>();
		String c1 = "";
		Scanner ab = new Scanner(System.in);
		int flag=0;
		while(flag==0) {
			while(flag==0) {
				System.out.println("Enter card(country name) : ");
				c1 = ab.next();
				System.out.println(c1);
				System.out.println(cards);
				if(!cards.containsKey(c1)) {
					System.out.println("Please enter card that you own.");
					break;
				}else {
					flag=1;
				}
			}
		}
		int key = cards.get(c1);
		card.put(c1,key);
		return card;
	}
}
