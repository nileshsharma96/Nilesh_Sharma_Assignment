package PageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class JobPage {

	public static String message;
	public static String messageLast;

	private By jobCard = By.xpath("(//div[@class='ant-card-body'])[1]");
	private By convoContinue = By.xpath("//button[normalize-space()='Keep the Convo Going!']");
	private By viewProfile = By.xpath("//button[@class='ant-btn btn-link']");
	private By userProfileButton = By.xpath(
			"(//div[@class='lazy-avatar lazy-avatar__shape-circle bg-info-dark preview-user-sider__header__avatar lazy-avatar__img lazy-avatar-default'])");
	private By toggleButton = By.xpath("//span[@class='ant-switch']");
	private By loginAsButton = By.xpath("//*[@id='topHeader']/div/div/div[3]/button");
	private By messageBox = By.xpath("//div[@class='fr-element fr-view fr-element-scroll-visible']//p");
	private By sendButton = By.xpath("//button[@class='ant-btn inbox__input__send-button ant-btn-primary ant-btn-lg']");
	private By viewMessage = By.xpath("//button[@class='ant-btn']");
	private By messageCard = By.xpath("(//div[@class='rich-text ql-editor'])");
	private By retunAdmin = By.xpath("//button[@class='ant-btn ant-btn-lg']");
	private By exitAdmin = By.xpath("//a[@class='standardnav-exitadmin dark']");

	public void startConversation(WebDriver driver, Wait<WebDriver> wait) throws InterruptedException {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		String formattedDate = sdf.format(date);

		driver.findElement(jobCard).click();
		driver.findElement(convoContinue).click();
		Thread.sleep(2000);
		message = "Nilesh Sharma " + formattedDate + "\n" + "Total years of Experience - 2";
		driver.findElement(messageBox).sendKeys(message);
		Thread.sleep(2000);
		driver.findElement(sendButton).click();
		Thread.sleep(2000);

	}

	public void openProfile(WebDriver driver, Wait<WebDriver> wait) throws InterruptedException {
		driver.findElement(viewProfile).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(userProfileButton));
		Thread.sleep(3000);
		driver.findElement(userProfileButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(toggleButton));
		Thread.sleep(3000);
		driver.findElement(toggleButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginAsButton));
		Thread.sleep(3000);
		driver.findElement(loginAsButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(viewMessage));
		Thread.sleep(3000);
		driver.findElement(viewMessage).click();
		Thread.sleep(3000);

//		Get the last message text
		List<WebElement> allElement = driver.findElements(messageCard);
		int count = allElement.size();
		messageLast = allElement.get(count - 1).getText();

		Assert.assertEquals(message, messageLast, message);

//		Back to initial user
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOfElementLocated(retunAdmin));
		driver.findElement(retunAdmin).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(exitAdmin));
		driver.findElement(exitAdmin).click();
		driver.navigate().refresh();
		Thread.sleep(4000);

	}

}
