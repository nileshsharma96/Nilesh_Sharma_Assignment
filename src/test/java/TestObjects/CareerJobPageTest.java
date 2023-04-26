package TestObjects;

import org.testng.annotations.Test;

import Assignment.Assess.Base;
import PageObjects.JobPage;

public class CareerJobPageTest extends Base {

	@Test(priority = 3, description = "Send the Text Message")
	public void StartTheConvo() throws InterruptedException {

		JobPage jp = new JobPage();
		jp.startConversation(driver, wait);
	}

	@Test(priority = 4, description = "Verify the message sent to the Admin")
	public void verifyMessage() throws InterruptedException {

		JobPage jp = new JobPage();
		jp.openProfile(driver, wait);
	}
}
