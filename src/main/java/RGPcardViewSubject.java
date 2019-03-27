import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This is subject class for card exchange view to notify observers
 * @author pavan
 *
 */
public class RGPcardViewSubject {
		private List<RGPcardViewObserver> observers = new ArrayList<RGPcardViewObserver>();
		private HashMap<String, Integer> cardprint = new HashMap<String, Integer>();
		private int a;
		public int i = 0;
       /**
        * This method is to get card details to print
        * @return card details
        */
		public HashMap<String, Integer> getCardPrint() {
			return cardprint;
		}
		/**
		 * This method is to set name of current player
		 * @param cardprint contains card details
		 */
		public void setNameState(HashMap<String,Integer> cardprint) {
			this.cardprint = cardprint;
			notifyAllObservers();
		}
		/**
		 * This method is to attach details to arraylist
		 * @param observer
		 */
		public void attach(RGPcardViewObserver observer) {
			observers.add(observer);
		}
		/**
		 * This method is to detach details to arraylist
		 * @param observer
		 */
		public void deattach(RGPcardViewObserver observer) {
			observers.remove(observer);
		}
		/**
		 * This method is to notify all observers about change in player and state
		 */
		public void notifyAllObservers() {
			for(RGPcardViewObserver observer : observers) {
				observer.update();
			}
		}
	}

