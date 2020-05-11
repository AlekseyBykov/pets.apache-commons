package alekseybykov.portfolio.apache.commons.strings;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringManipulationTest {

	@Test
	public void testAbbreviateLongString() {
		String string = "This is an example of a simple string";
		assertEquals("This is...", StringUtils.abbreviate(string, 10));
	}
}
