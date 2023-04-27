package PageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class CareerPathPage {

	public static ArrayList<String> arr;

	private By recommendedElemet = By.xpath("(//h3[@class='heading-3'])[1]");
	private By inspirationHeading = By.xpath("(//h3[@class='careers-row-title'])[2]");
	private By blogName = By.xpath("(//div[@class='career-title-n-salary'])[1]//h2");

	private By cardName(int i) {
		return By.xpath("//*[@id='main']/div[8]/div/div/div[2]/a[" + i + "]/div/div[2]/div/div/div[1]");
	}

	public void checkBlogs(WebDriver driver, Wait<WebDriver> wait) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(recommendedElemet));
		WebElement element = driver.findElement(inspirationHeading);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);

//		append names of vlog in array

		arr = new ArrayList<String>();

		for (int i = 1; i <= 9; i++) {

			String Card = driver.findElement(cardName(i)).getText();
			arr.add(Card);
			driver.findElement(cardName(i)).click();
			Thread.sleep(2000);
			String blog = driver.findElement(blogName).getText();
			Assert.assertEquals(blog, Card, blog);
			driver.navigate().back();
			Thread.sleep(2000);
			i = i + 3;

		}

	}

}
