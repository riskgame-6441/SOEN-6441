import java.util.Observer;
/**
 * This class is to notify observers
 * @author pavan
 *
 */
public class RGPobserverName extends RGPobserverObserver{
	public RGPobserverName(RGPobserverSubject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	/**
	 * This method is to update phase details
	 */
	public void update() {
		System.out.println("NAME: " + subject.getName());
		System.out.println("PHASE: " + subject.getState());
		System.out.println("MESSAGE: " + subject.getMessage());

		
	}

}
