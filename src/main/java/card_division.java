package risk;

import java.util.*;
import java.util.HashMap;


public class card_division 
{
	public static void main(String args[])
	{
		int noc=42;   //no of countries;
		//int nocards=42;
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		ArrayList<String> country_names = new ArrayList<String>();
		ArrayList<String> new_country = new ArrayList<String>();
		for(int i=0;i<noc;i++)
			{
			country_names.add("country "+i);
			hm = hm1(country_names);
			}
		System.out.println(country_names);
		new_country.add(country_names.remove(2));
		System.out.println("Elements are "+new_country);
		System.out.println("Elements are "+country_names);
		hm = hm1(country_names);
		System.out.println(hm);
		
		HashMap<String,Integer> hm1= new HashMap<String,Integer>();
		HashMap<String,Integer> hm2= new HashMap<String,Integer>();
		HashMap<String,Integer> hm3= new HashMap<String,Integer>();

		hm1.put("hi",1);
		hm2.put("k",2);
		hm3.put("m",3);
		check_cards_deal(hm1,hm2,hm3);
		add_sub();
	}


	public static HashMap<String,Integer> hm1(ArrayList<String> country_names)
{
	HashMap<String,Integer> hm = new HashMap<String,Integer>();
	int n=country_names.size();
	int j=0;
	for(int i=0;i<n;i++)	
		{
		int v=j+1;
		j++;
		hm.put(country_names.get(i),v);
		if(j==3)
		  {
		  j=0;
		  }
		}
	return hm;
}

	public static void check_cards_deal(HashMap<String,Integer> a, HashMap<String,Integer> b, HashMap<String,Integer> c)
	{
		HashMap<String,Integer> a1 =new HashMap<String,Integer>();
		HashMap<String,Integer> b1 =new HashMap<String,Integer>();
		HashMap<String,Integer> c1 =new HashMap<String,Integer>();
		a1=a; 
		b1=b;
		c1=c;
	 if(a1.containsValue(3) && b1.containsValue(3) && c1.containsValue(3))
	 {
		 System.out.println("Reinforcement +8");
	 }
	 else if(a1.containsValue(2) && b1.containsValue(2) && c1.containsValue(2))
	 {
		 System.out.println("Reinforcement +6");
	 }
	 else if(a1.containsValue(1) && b1.containsValue(1) && c1.containsValue(1))
	 {
		 System.out.println("Reinforcement +4");
	 }
	 else if(a1.containsValue(1) && b1.containsValue(2) && c1.containsValue(3)||
			 a1.containsValue(1) && b1.containsValue(3) && c1.containsValue(2)||
			 a1.containsValue(2) && b1.containsValue(1) && c1.containsValue(3)||
			 a1.containsValue(2) && b1.containsValue(3) && c1.containsValue(1)||
			 a1.containsValue(3) && b1.containsValue(1) && c1.containsValue(2)||
			 a1.containsValue(3) && b1.containsValue(2) && c1.containsValue(1))
			 
	 {
		 System.out.println("Reinforcement +10");
	 }
	 else
	 {
		 System.out.println("No Reinforcement");
	 }
	}

	public static void add_sub()
	{
		ArrayList<String> al1 = new ArrayList<String>();
		ArrayList<String> al2 = new ArrayList<String>();
		
		al1.add("A");
		al1.add("B");
		al1.add("C");
		al1.add("D");
		al1.add("E");
		al1.add("F");
		al1.add("G");
		System.out.println("Elements are "+al1);
		//String remo;
		//al1.remove(1);
		al2.add(al1.remove(1));
		System.out.println("Elements are "+al1);
		System.out.println("Elements are "+al2);
	}

}

	










