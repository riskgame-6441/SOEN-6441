import java.util.ArrayList;
import java.util.List;

public class RGPworldDominationSubject {
	private List<RGPworldDominationObserver> observers = new ArrayList<RGPworldDominationObserver>();
	private int percent;
	private List<String> cont = new ArrayList<String>();
	private int totalarmy;
	private int player;

	public int getPercent() {
		return percent;
	}
	public List<String> getCont() {
		return cont;
	}
	public int getTotalArmy() {
		return totalarmy;
	}
	public int getPlayer() {
		return player;
	}
	public void setNameState(int player,int percent, List<String> cont, int totalarmy) {
		this.player = player;
		this.percent = percent;
		this.cont = cont;
		this.totalarmy = totalarmy;
		notifyAllObservers();
	}
	public void attach(RGPworldDominationObserver observer) {
		observers.add(observer);
	}
	public void deattach(RGPworldDominationObserver observer) {
		observers.remove(observer);
	}
	public void notifyAllObservers() {
		for(RGPworldDominationObserver observer : observers) {
			observer.update();
		}
	}
}
