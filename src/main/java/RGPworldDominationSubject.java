import java.util.ArrayList;
import java.util.List;
/**
 * This is subject class for world domination view
 * @author pavan
 *
 */
public class RGPworldDominationSubject {
	private List<RGPworldDominationObserver> observers = new ArrayList<RGPworldDominationObserver>();
	private int percent;
	private List<String> cont = new ArrayList<String>();
	private int totalarmy;
	private int player;
  
	/**
     * This method is to get percentage of world map player conquered
     * @return percent
     */
	public int getPercent() {
		return percent;
	}
	/**
	 * This method is to get country list
	 * @return country list
	 */
	public List<String> getCont() {
		return cont;
	}
	/**
	 * This method is to get total army
	 * @return total army
	 */
	public int getTotalArmy() {
		return totalarmy;
	}
	/**
	 * This method is to get player name
	 * @return player name
	 */
	public int getPlayer() {
		return player;
	}
	/**
	 * This method is to set world domination details
	 * @param player is player name
	 * @param percent is percentage of world conquered
	 * @param cont is continent list
	 * @param totalarmy is total army
	 */
	public void setNameState(int player,int percent, List<String> cont, int totalarmy) {
		this.player = player;
		this.percent = percent;
		this.cont = cont;
		this.totalarmy = totalarmy;
		notifyAllObservers();
	}
	/**
	 * This method is to attach details to arraylist
	 * @param observer
	 */
	public void attach(RGPworldDominationObserver observer) {
		observers.add(observer);
	}
	/**
	 * This method is to detach details to arraylist
	 * @param observer
	 */
	public void deattach(RGPworldDominationObserver observer) {
		observers.remove(observer);
	}
	/**
	 * This method is notify all observers about world domination details
	 */
	public void notifyAllObservers() {
		for(RGPworldDominationObserver observer : observers) {
			observer.update();
		}
	}
}
