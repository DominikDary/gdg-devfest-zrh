package sh.calaba.calabashdriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import sh.calaba.calabashdriver.common.CalabashBaseTest;
import sh.calaba.driver.CalabashCapabilities;
import sh.calaba.driver.client.RemoteCalabashAndroidDriver;
import sh.calaba.driver.model.By;

/**
 * GreenhouseAndroid App test that is using calabash-driver for end-to-end
 * testing.
 * 
 * @author Dominik Dary
 * 
 */
public class GreenhousAndroidTests extends CalabashBaseTest {
	private RemoteCalabashAndroidDriver driver;

	public GreenhousAndroidTests() {
		super(CalabashCapabilities.android("greenhouse-android", "4.0.3",
				"de_DE", "emulator-5554", "emulator",
				"com.springsource.greenhouse",
				"com.springsource.greenhouse.MainActivity"));
	}

	@Test
	public void testSignIn() {
		driver = new RemoteCalabashAndroidDriver(host, port, capabilities);

		signInUser("craig@habuma.com", "freebird");

		//Verify Event
		driver.waitForTextIsPresent("Events");
		driver.findViewById("event_list_item_title").click();
		driver.findL10nElement(By.l10nElement("title_event_details")).waitFor();
		Assert.assertEquals(driver.findViewById("event_details_date").getText(),
				"Do., Okt 18 - So., Okt 21, 2012");
		
		//Session schedule
		driver.findButton(By.text("Session Schedule")).press();
		driver.findL10nElement(By.l10nElement("title_event_sessions_schedule"))
				.waitFor();
		driver.findButton(By.text("Donnerstag, Okt 18")).press();
		driver.waitForTextIsPresent("Donnerstag, Okt 18");
		String openingKeynoteId = "event_sessions_list_item_title";
		Assert.assertEquals(driver.findViewById(openingKeynoteId).getText(),
				"Opening Keynote");
		driver.findViewById(openingKeynoteId).click();

		//session detaials
		driver.findL10nElement(By.l10nElement("title_event_session_details"))
				.waitFor();
		Assert.assertEquals(driver
				.findViewById("event_session_details_leaders").getText(),
				"Rod Johnson");
		Assert.assertEquals(
				driver.findViewById("event_session_details_description")
						.getText(), "Rod kicks off #s2gx with a bang.");
	}

	private void signInUser(String userName, String password) {
		driver.waitForViewIsPresent("signin_button").click();
		driver.waitForElement().waitFor(5);
		driver.webview(By.css("input#login")).enterText(userName);
		driver.webview(By.css("input#password")).enterText(password);
		driver.webview(By.css("form#signin p button")).click();
		driver.waitForElement().waitFor(2);
		// Click the authorize button
		driver.webview(By.css("button")).click();

		driver.waitForElement().waitForProgressCloses();
	}
}
