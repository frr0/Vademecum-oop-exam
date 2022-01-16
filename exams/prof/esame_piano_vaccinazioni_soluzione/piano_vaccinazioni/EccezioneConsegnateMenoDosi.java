package piano_vaccinazioni;

@SuppressWarnings("serial")
public class EccezioneConsegnateMenoDosi extends Exception{
	int dosiConsegnate;
	
	public EccezioneConsegnateMenoDosi(int dosiConsegnate) {
		this.dosiConsegnate = dosiConsegnate;
	}
}
