package alekseybykov.portfolio.apache.commons.system;

import org.apache.commons.lang3.SystemUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SystemDataObtainingTest {

	@Test
	public void testFileEncoding() {
		assertEquals("UTF-8", SystemUtils.FILE_ENCODING);
	}

	@Test
	public void testSystemPaths() {
		assertNotNull(SystemUtils.JAVA_CLASS_PATH);
		assertNotNull(SystemUtils.JAVA_HOME);
		assertNotNull(SystemUtils.JAVA_IO_TMPDIR);
	}
}
