/**
 * This class is for world domination view through observer patterns
 * @author pavan
 *
 */
public class RGPworldDominationDetails extends RGPworldDominationObserver{
	public RGPworldDominationDetails(RGPworldDominationSubject subject1) {
		this.subject1 = subject1;
		this.subject1.attach(this);
	}

	@Override
	/**
	 * This method is to print world domination details of player
	 */
	public void update() {
		System.out.println("PLAYER: " + subject1.getPlayer());
		System.out.println("PERCENT: " + subject1.getPercent());
		System.out.println("CONTINENTS OWNED: " + subject1.getCont());
		System.out.println("TOTAL ARMY: " + subject1.getTotalArmy());

		
	}

}
