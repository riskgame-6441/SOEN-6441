
public class RGPobserverGamePhase extends RGPobserverObserver{
	public RGPobserverGamePhase(RGPobserverSubject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("STATE: " + subject.getState());
		
	}

	

}
