package TestObjects;

import org.testng.annotations.Test;

import Assignment.Assess.Base;
import PageObjects.CareerPathPage;

public class CareerPathPageTest extends Base {
	
	@Test(priority = 6, description = "Open page and validate all the cards in inspiration")
	public void blogVerification() throws InterruptedException {
		CareerPathPage carpath = new CareerPathPage();
		carpath.checkBlogs(driver, wait);
	}
}
