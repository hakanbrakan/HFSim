package se.frihak.hfsim.util;

public class Converter {

	public float meterTillKilometer(float meter) {
		return meter / 1000;
	}

	public float kilometerTillMeter(float km) {
		return km * 1000;
	}

	public float kilometerPerTimmeTillMeterPerSekund(float kmPerTimme) {
		float meterPerTimme = kilometerTillMeter(kmPerTimme);
		return meterPerTimme / 3600;
	}

	public float meterPerSekundTillKilometerPerTimme(float meterPerSekund) {
		float kmPerSekund = meterTillKilometer(meterPerSekund);
		return kmPerSekund * 3600;
	}

	public float tempoKilometerPerTimmeTillMinuterPerKilometer(float kmPerTimme) {
		float kmPerMinut = kmPerTimme / 60;
		return 1 / kmPerMinut;
	}

}
