package springapp.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeaderResponseTest {

	@Test
	public void headerResponseCanPopulateStatus() {
		HeaderResponse headerResponse = new HeaderResponse();
		headerResponse.status = "OK";
		assertEquals("OK",headerResponse.status);
	}

}
