package sh.calaba.calabashdriver;

import org.testng.annotations.Test;

import sh.calaba.calabashdriver.common.CalabashBaseTest;
import sh.calaba.driver.client.RemoteCalabashAndroidDriver;
import sh.calaba.driver.model.CalabashAndroidDriver;

/**
 * GreenhouseAndroid App test that is using calabash-driver for end-to-end
 * testing.
 * 
 * @author Dominik Dary
 * 
 */
public class GreenhousAndroidTests extends CalabashBaseTest {
	@Test
	public void testSignIn() {
		CalabashAndroidDriver driver = new RemoteCalabashAndroidDriver(host,
				port, capabilities);
	}
}
