package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginScreen {

	private By emailField = By.xpath("//input[@id='email']");
	private By passwordField = By.xpath("//input[@id='password']");
	private By loginButton = By.xpath("//button[@type='submit']");

	public void logInUser(WebDriver driver, String host, String email, String password) throws InterruptedException {
		driver.get(host);
		driver.findElement(emailField).sendKeys(email);
		Thread.sleep(2000);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
		Thread.sleep(5000);

	}

}
