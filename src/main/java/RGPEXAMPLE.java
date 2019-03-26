import java.util.HashMap;

public class RGPEXAMPLE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> card_2 = new HashMap<String, Integer>();
		RGPcardViewSubject subject3 = new RGPcardViewSubject();
		RGPcardViewObserver RGPcardViewDetails =  new RGPcardViewDetails(subject3);
		subject3.setNameState(card_2);
	}

}
