package TestObjects;

import java.util.ArrayList;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Assignment.Assess.Base;
import PageObjects.LoginScreen;
import Assignment.Assess.ExcelUploadMethod;

public class LoginScreenTest extends Base {

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
}
