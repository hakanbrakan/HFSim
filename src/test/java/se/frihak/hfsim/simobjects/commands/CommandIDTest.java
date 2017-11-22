package se.frihak.hfsim.simobjects.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CommandIDTest {

	@Before
	public void initera() {
	}
	
	@Test
	public void testarTreTicks() {
		assertEquals("GoTo", CommandID.GoTo.toString());
		assertEquals("FinishedSimulating", CommandID.FinishedSimulating.toString());
		assertEquals("Rest", CommandID.Rest.toString());
		assertEquals("Rest", CommandID.Rest.name());
	}

}
