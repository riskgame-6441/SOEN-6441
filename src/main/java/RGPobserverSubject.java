import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
public class RGPobserverSubject {
	private List<RGPobserverObserver> observers = new ArrayList<RGPobserverObserver>();
	private String state;
	private String name;
<<<<<<< HEAD
	private String message;
=======
>>>>>>> 2e836c5a771b75a4c2dfc84e99010af1c0494959
	public String getName() {
		return name;
	}
	public String getState() {
		return state;
	}
<<<<<<< HEAD
	public String getMessage() {
		return message;
	}
	public void setNameState(String name, String state, String message) {
		this.name = name;
		this.state = state;
		this.message = message;
=======
	public void setNameState(String name) {
		this.name = name;
		notifyAllObservers();
	}
	public void setPhaseState(String state) {
		this.state = state;
>>>>>>> 2e836c5a771b75a4c2dfc84e99010af1c0494959
		notifyAllObservers();
	}
	public void attach(RGPobserverObserver observer) {
		observers.add(observer);
	}
	public void deattach(RGPobserverObserver observer) {
		observers.remove(observer);
	}
	public void notifyAllObservers() {
		for(RGPobserverObserver observer : observers) {
			observer.update();
		}
	}
}
