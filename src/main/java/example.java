import java.util.ArrayList;

public class example{
	public static void main(String[] args) throws Exception{
		
		int player = 1;
		ArrayList<String> n_country = new ArrayList<String>();
		
		printtable a = new printtable();
		String ab = "Alaska";
		n_country = a.getNeighbour(ab);
		
		System.out.println(n_country);
		
		a.getTable();
	}
}