package se.frihak.hfsim.simobjects.commands;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import se.frihak.hfsim.simobjects.WalkingMan;

public class CommandFinishedSimulatingTest {
	@Mock
	private WalkingMan gaandeMan;

	@Before
	public void initera() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testarAttAvslutaSimulering() {
		WalkingManCommand cmd = new CommandFinishedSimulating();
		cmd.tick(gaandeMan);
		verify(gaandeMan, times(1)).removeCommand(cmd);;
		verify(gaandeMan, times(1)).finishSimulating();
		verifyNoMoreInteractions(gaandeMan);
	}

}
