package piano_vaccinazioni;

@SuppressWarnings("serial")
public class EccezioneConsegnateMenoDosi extends Exception{

	int ndosi;

	public int getNdosi() {
		return ndosi;
	}

	public void setNdosi(int ndosi) {
		this.ndosi = ndosi;
	}
}
