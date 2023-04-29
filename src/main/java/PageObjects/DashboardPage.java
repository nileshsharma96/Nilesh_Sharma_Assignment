package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class DashboardPage {

	private By careerButton = By.xpath("//button[@aria-label='Career']");
	private By jobButton = By.xpath("//p[normalize-space()='Jobs']");
	private By careerPathButton = By.xpath("//p[normalize-space()='Career Paths']");
	private By thirdRadioButton = By.xpath("(//span[@class='ant-radio-inner'])[3]");
	private By skipButton = By.xpath("//button[normalize-space()='Skip']");
	private By updateButton = By
			.xpath("(//a[@class='ant-btn edit-banner-section-cta custom-btn-link ant-btn-default'])[1]");
	private By homeButton = By.xpath("//button[@aria-label='Home']");
	private By recentView = By.xpath("//h2[contains(text(),'Recently viewed careers ')]");

	private By cardName(int i) {
		return By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div["
				+ i + "]/div[1]/div[1]/a[1]/div[1]/div[2]/div[1]/div[1]/div[1]");
	}

	public void careerPath(WebDriver driver, Wait<WebDriver> wait) throws InterruptedException {

		driver.findElement(homeButton).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOfElementLocated(careerButton));
		driver.findElement(careerButton).click();
		Thread.sleep(2000);
		driver.findElement(careerPathButton).click();

	}

	public void careerJob(WebDriver driver, Wait<WebDriver> wait) throws InterruptedException {

		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(careerButton));
		driver.findElement(careerButton).click();
		Thread.sleep(2000);
		driver.findElement(jobButton).click();

	}

	public void careerChoice(WebDriver driver, Wait<WebDriver> wait) throws InterruptedException {
		driver.findElement(homeButton).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOfElementLocated(updateButton));
		driver.findElement(updateButton).click();
		Thread.sleep(2000);

		boolean choice = driver.findElement(thirdRadioButton).isSelected();

		if (choice == true) {
			driver.findElement(thirdRadioButton).click();
			driver.findElement(updateButton).click();
		} else {
			driver.findElement(skipButton).click();
			Thread.sleep(2000);
		}
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOfElementLocated(recentView));

		WebElement element = driver.findElement(recentView);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);

		for (int i = 1; i <= 3; i++) {
			String Card = driver.findElement(cardName(i)).getText();
			if (i == 1) {
				Assert.assertEquals(CareerPathPage.arr.get(2), Card, CareerPathPage.arr.get(2));
			}
			if (i == 2) {
				Assert.assertEquals(CareerPathPage.arr.get(1), Card, CareerPathPage.arr.get(1));
			}
			if (i == 3) {
				Assert.assertEquals(CareerPathPage.arr.get(0), Card, CareerPathPage.arr.get(0));
			}
		}

	}

}
