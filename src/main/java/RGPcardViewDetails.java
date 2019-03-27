import java.util.HashMap;
/**
 * This class is to show card details
 * @author pavan
 *
 */
public class RGPcardViewDetails extends RGPcardViewObserver{
	public RGPcardViewDetails(RGPcardViewSubject subject3) {
		this.subject3 = subject3;
		this.subject3.attach(this);
	}

	@Override
	/**
	 * This method is to show no of cards player owned
	 */
	public void update() {
		System.out.println(subject3.getCardPrint());

		
	}

}
