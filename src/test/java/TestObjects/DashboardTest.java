package TestObjects;

import org.testng.annotations.Test;

import Assignment.Assess.Base;
import PageObjects.DashboardPage;

public class DashboardTest extends Base {

	@Test(priority = 2, description = "Open the Job page to start the conversation")
	public void openJobPage() throws InterruptedException {

		DashboardPage dash = new DashboardPage();
		dash.careerJob(driver, wait);

	}

	@Test(priority = 7, description = "To verify all the recent open blogs are showing on dashboard")
	public void verifyRecentBlogs() throws InterruptedException {

		DashboardPage dash = new DashboardPage();
		dash.careerChoice(driver, wait);

	}

}
