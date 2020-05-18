package alekseybykov.portfolio.apache.commons.strings;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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

	@Test
	public void testStringContains() {
		assertTrue(StringUtils.contains(string, "."));
		assertFalse(StringUtils.contains(string, ","));

		assertTrue(StringUtils.containsIgnoreCase(string, "STR"));

		assertTrue(StringUtils.containsAny(string, "qws"));
		assertTrue(StringUtils.containsAny(string, 'q', 'w', 's'));

		assertFalse(StringUtils.containsOnly(string, 'q', 'w', 's'));

		assertTrue(StringUtils.containsNone(string, 'q', 'w', 'Z'));
		assertFalse(StringUtils.containsNone(string, 'q', 'w', 's'));
	}

	@Test
	public void testStringStartsWith() {
		assertTrue(StringUtils.startsWith(string, "this"));
		assertFalse(StringUtils.startsWith(string, "This"));

		assertTrue(StringUtils.startsWithIgnoreCase(string, "ThIS"));
		assertTrue(StringUtils.startsWithAny(string, new String[]{"this", "This"}));
	}

	@Test
	public void testSubstring() {
		assertEquals("this", StringUtils.left(string, 4));
		assertEquals("is", StringUtils.mid(string, 5, 2));
		assertEquals("this is an", StringUtils.mid(string, -19, 10));
		assertEquals("string", StringUtils.right(string, 6));
	}

	@Test
	public void testRemoveSubstringsIfMatched() {
		String string = "https://www.oracle.com";
		string = StringUtils.removeStart(string, "https://www.");
		string = StringUtils.removeEnd(string, ".en");
		assertEquals("oracle.com", string);
	}

	@Test
	public void testCheckCaseForWholeString() {
		assertFalse(StringUtils.isAllUpperCase(string));
		assertFalse(StringUtils.isAllLowerCase(string));
	}

	@Test
	public void testGenerateRandomStrings() {
		assertTrue(StringUtils.isAsciiPrintable(RandomStringUtils.randomAscii(10)));
		assertTrue(RandomStringUtils.randomAlphanumeric(10).matches("^[a-zA-Z0-9]+$"));
		assertTrue(RandomStringUtils.randomAlphabetic(10).matches("^[a-zA-Z]+$"));
		assertTrue(RandomStringUtils.randomNumeric(10).matches("^[0-9]+$"));
		assertTrue(RandomStringUtils.random(10, "abc123").matches("^[abc123]+$"));
	}

	@Test
	public void testJoinKeyValueFromMapToString() {
		Map<String, String> map = new HashMap<>();
		map.put("key 1", "value 1");
		map.put("key 2", "value 2");
		map.put("key 3", "value 3");

		assertEquals("key 1|key 2|key 3", StringUtils.join( map.keySet(), '|'));
		assertEquals("value 1|value 2|value 3", StringUtils.join( map.values(), '|'));
	}
}
