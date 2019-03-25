import java.util.Observer;

public class RGPobserverName extends RGPobserverObserver{
	public RGPobserverName(RGPobserverSubject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("NAME: " + subject.getName());
		System.out.println("PHASE: " + subject.getState());
		System.out.println("MESSAGE: " + subject.getMessage());
		
	}

}
