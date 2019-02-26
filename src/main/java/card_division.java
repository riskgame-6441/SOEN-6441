package risk;

import java.io.*;
import java.util.*;
import java.lang.CharSequence;
import java.util.HashMap;


public class card_division 
{
	public static void main(String args[])
	{
		int noc=42;   //no of countries;
		int nocards=42;
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		ArrayList<String> country_names = new ArrayList<String>();
		for(int i=0;i<noc;i++)
			{
			country_names.add("country "+i);
			}
		System.out.println(country_names);
		hm = hm1(country_names);
		System.out.println(hm);
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

}

	










