package TestObjects;

import org.testng.annotations.Test;

import Assignment.Assess.Base;
import PageObjects.DashboardPage;

public class OpenCareerPathTest extends Base {

	@Test(priority = 5, description = "Open Career Path Page")
	public void OpenCareerPage() throws InterruptedException {

		DashboardPage dash = new DashboardPage();
		dash.careerPath(driver, wait);
	}

}
