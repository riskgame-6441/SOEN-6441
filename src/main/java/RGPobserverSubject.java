import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
/**
 * This is subject class for phase view 
 * @author pavan
 *
 */
public class RGPobserverSubject {
	private List<RGPobserverObserver> observers = new ArrayList<RGPobserverObserver>();
	private String state;
	private String name;
	private String message;
    /**
     * This method is to get player name
     * @return player name
     */
	public String getName() {
		return name;
	}
	/**
	 * This is to get phase state of a player
	 * @return state of current phase
	 */
	public String getState() {
		return state;
	}
	/**
	 * This is to get message for phase details
	 * @return message of current phase
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * This method set phase details of current player
	 * @param name is player name
	 * @param state is current phase
	 * @param message is phase message
	 */
	public void setNameState(String name, String state, String message) {
		this.name = name;
		this.state = state;
		this.message = message;
		notifyAllObservers();
	}
	/**
	 * This method is to attach details to arraylist
	 * @param observer
	 */
	public void attach(RGPobserverObserver observer) {
		observers.add(observer);
	}
	/**
	 * This method is to detach details to arraylist
	 * @param observer
	 */
	public void deattach(RGPobserverObserver observer) {
		observers.remove(observer);
	}
	/**
	 * This method is notify all observers about phase change
	 */
	public void notifyAllObservers() {
		for(RGPobserverObserver observer : observers) {
			observer.update();
		}
	}
}
