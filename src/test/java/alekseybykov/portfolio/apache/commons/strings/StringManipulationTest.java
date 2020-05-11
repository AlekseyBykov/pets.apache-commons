package alekseybykov.portfolio.apache.commons.strings;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringManipulationTest {

	private final String string = "this is an Example of.a simple string";

	@Test
	public void testAbbreviateString() {
		assertEquals("this is...", StringUtils.abbreviate(string, 10));
		assertEquals("...Example of ...", StringUtils.abbreviate(string, 11, 17));
		assertEquals("this is an [censored]ple string", StringUtils.abbreviateMiddle(string, "[censored]", 31));
	}

	@Test
	public void testCapitalizeString() {
		assertEquals("This is an Example of a simple string", StringUtils.capitalize(string));
		assertEquals("This Is An Example Of A Simple String", WordUtils.capitalize(string));
		assertEquals("This Is An Example Of A Simple String", WordUtils.capitalizeFully(string));
	}

	@Test
	public void testSwapCaseOfString() {
		assertEquals("THIS IS AN eXAMPLE OF A SIMPLE STRING", StringUtils.swapCase(string));
	}

	@Test
	public void testCountMatchesInString() {
		assertEquals(4, StringUtils.countMatches(string, "i"));
		assertEquals(2, StringUtils.countMatches(string, "is"));
	}

	@Test
	public void testExtractInitialLettersFromString() {
		assertEquals("tiaEo.ass", WordUtils.initials(string, ' ', '.'));
	}

	@Test
	public void testNormalizeSpacesInString() {
		String string = "\t\tthis   is  \t an Example of .   a simple       string\n  ";
		assertEquals("this is an Example of . a simple string", StringUtils.normalizeSpace(string));
	}

	@Test
	public void testAppendToStringIfMissing() {
		assertEquals("this is an Example of.a simple string.", StringUtils.appendIfMissing(string, "."));
	}

	@Test
	public void testPrependToStringIfMissing() {
		assertEquals(".this is an Example of.a simple string", StringUtils.prependIfMissing(string, "."));
		assertEquals("?this is an Example of.a simple string", StringUtils.prependIfMissing(string, "?", "Is"));
	}
}
