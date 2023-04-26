package TestObjects;

import java.util.ArrayList;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Assignment.Assess.Base;
import Assignment.Assess.ExcelUploadMethod;
import PageObjects.DashboardPage;
import PageObjects.JobPage;
import PageObjects.LoginScreen;

public class Assignment_1 extends Base {

	public static ArrayList<String> host;
	public static ArrayList<String> email;
	public static ArrayList<String> password;

	@BeforeTest
	public void Initiate() throws Exception {

		ExcelUploadMethod pickData = new ExcelUploadMethod();
		host = pickData.getData("Host");
		email = pickData.getData("Email");
		password = pickData.getData("Password");

	}

	@Test(priority = 1, description = "Verify if the user able to login")
	public void UserLogin() throws InterruptedException {
		LoginScreen log = new LoginScreen();
		log.logInUser(driver, host.get(1), email.get(1), password.get(1));
	}

	@Test(priority = 2, description = "Open the Job page to start the conversation")
	public void openJobPage() throws InterruptedException {

		DashboardPage dash = new DashboardPage();
		dash.careerJob(driver, wait);

	}

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
