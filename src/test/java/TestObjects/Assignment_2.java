package TestObjects;

import org.testng.annotations.Test;

import Assignment.Assess.Base;
import PageObjects.CareerPathPage;
import PageObjects.DashboardPage;

public class Assignment_2 extends Base {

	@Test(priority = 5, description = "Open Career Path Page")
	public void OpenCareerPage() throws InterruptedException {

		DashboardPage dash = new DashboardPage();
		dash.careerPath(driver, wait);
	}

	@Test(priority = 6, description = "Open page and validate all the cards in inspiration")
	public void blogVerification() throws InterruptedException {
		CareerPathPage carpath = new CareerPathPage();
		carpath.checkBlogs(driver, wait);
	}

	@Test(priority = 7, description = "To verify all the recent open blogs are showing on dashboard")
	public void verifyRecentBlogs() throws InterruptedException {

		DashboardPage dash = new DashboardPage();
		dash.careerChoice(driver, wait);

	}
}
