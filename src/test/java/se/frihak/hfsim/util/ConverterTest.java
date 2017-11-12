package se.frihak.hfsim.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ConverterTest {
	
	private Converter converter;

	@Before
	public void initiera() {
		converter = new Converter();
	}

	@Test
	public void testMeterTillKilometer() {
		assertEquals(3.45f, converter.meterTillKilometer(3450f), 0);
	}

	@Test
	public void testKilometerTillMeter() {
		assertEquals(2345f, converter.kilometerTillMeter(2.345f), 0);
	}

	@Test
	public void testMeterPerSekundTillKilometerPerTimme() {
		assertEquals(19.548f, converter.meterPerSekundTillKilometerPerTimme(5.43f), 0);
	}
	
	@Test
	public void testKilometerPerTimmeTillMeterPerSekund() {
		assertEquals(2.9167f, converter.kilometerPerTimmeTillMeterPerSekund(10.5f), 0.002f);
	}
	
	@Test
	public void testTempoKilometerPerTimmeTillMinuterPerKilometer() {
		assertEquals(5.714f, converter.tempoKilometerPerTimmeTillMinuterPerKilometer(10.5f), 0.002f);
	}
}
