#Assessment

TestNG Automation Framework Documentation:

1. Created new maven project eclipse and convert to testNG project

2. Added all the maven dependancy in pom.xml file

3. Created Base file to initialise the browser and added classes in testng.xml file

4. To generate html report, created class for extent report method

5. For Data Driven testing, created picker method to pick values from excel file

6. To capture logs and screenshot for every failed test case, implemented ItestListener interface in testng.xml file and define test rule invoke for each test result scenario

7. Converted screenshots into Base64 file and then attached into extent report so report can be shared over mail easily using smtp mailing method where everybody can access the available screenshots

8. Created two different classes a. PageObjects – In this class, all the elements path is defined and method b. TestObjects – In this class, methods are called using oops method by creating a new object and testNG annotations are defines with their respective attributes

9. Final report generated in the project directory only inside the report folder- "Report.html"
Report Shows:
	a. Test case start time
	b. Test case description
	c. Screenshot of screen failed test cases
	
10. To verify the values, Used assertion method to validate

11. To invoke script
	a. Take clone of GitHub repository - "https://github.com/nileshsharma96/Nilesh_Sharma_Assignment.git"
	b. User needs to go to the project directory of the project in Terminal and run command as - $ mvn test -Pexecute
	
12. Note:
	a. If build doesn't invoke first time, please run the same command again
	b. Fluent wait is given at login screen, so user can easily interact with the captcha which requires manual intervention
	
Selenium based web automation framework:

Assignment 1
1. Home > Career > Jobs (Completed)
2. Click on any job and message any recommended user (Completed)
3. Now Navigate to your inbox as explained in video and verify the message sent have
been listed under same user’s chat (Completed)
4. Navigate to User2’s profile and Login As him/her (Completed)
5. On Homepage click on top banner and navigate to Inbox to verify the message received
by User2 (Completed)


Assignment 2
1. Home> Career > Career Paths (Completed)
2. Click on any 3 career paths from “Inspiration from You” section Eg. option a, b, c is
clicked in a sequence (Completed - picked 1,5 & 9 location cards)
3. Store name in collections (Completed)
4. Career Stage section- > Make sure option 3 is pre selected(if not then add a step to
select this) (Completed)
5. Go back on homepage and refresh (Completed)
6. Verify “Recently viewed careers” and verify List is reversed when compared to step 2 (Completed)
