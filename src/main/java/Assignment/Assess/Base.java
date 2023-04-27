package Assignment.Assess;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Base {

	public static WebDriver driver;
	public static Wait<WebDriver> wait;

	@BeforeSuite
	public void initialization() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver");
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-extensions");
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(600)).pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

	public static String getScreenshot(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts = ((TakesScreenshot) driver);
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(destinationFile));
		return Base64.getEncoder().encodeToString(imageBytes);
	}

}
