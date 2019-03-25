import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
public class RGPobserverSubject {
	private List<RGPobserverObserver> observers = new ArrayList<RGPobserverObserver>();
	private String state;
	private String name;
	private String message;
	public String getName() {
		return name;
	}
	public String getState() {
		return state;
	}
	public String getMessage() {
		return message;
	}
	public void setNameState(String name, String state, String message) {
		this.name = name;
		this.state = state;
		this.message = message;
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
