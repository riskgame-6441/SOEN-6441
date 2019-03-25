//import java.util.Observer;

public class RGPobserverMain {
	public static void main(String[] args) {
		RGPobserverSubject subject = new RGPobserverSubject();
		RGPobserverObserver RGPobserverName =  new RGPobserverName(subject);
		subject.setPhaseState("Reinforcement");
		subject.setNameState("pavan");
	}
}
