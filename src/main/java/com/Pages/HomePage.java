package com.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import com.CertificationWorkflow_Pages.CW_CreationPage;
import com.Locators.HomePage_Loc;
import com.utility.SafeActions;

public class HomePage extends SafeActions implements HomePage_Loc {

	// Ops user navigation to Decision package screen
	public void navigateTo_OpsTeam_DecisionPackage_Screen(String userType) {
		// Below has been scripted to navigated to All users screen
		
		driver.navigate().refresh();
		waitFor(5);
		jsClickOn(setUpIcon, "setUpIcon");
		takeScreenshotFor("Set Up Menu");
		waitFor(3);
		jsClickOn(setUpLink, "setUpLink");
		waitFor(3);
		switchToWindowByIndex(1);
		waitFor(1);
		jsClickOn(userSideMenu, "userSideMenu");
		jsClickOn(userLink, "userLink");
		waitFor(1);
		switchToFrame(allUsersFrame);
		// Navigating to T Users list
//		jsClickOn(userList_O, "userList_O");
//		waitFor(3);
//		driver.switchTo().defaultContent();
//		takeScreenshotFor("User Selection Screen"+userType);
//		switchToFrame(allUsersFrame);
		// Navigating to Ops Team login screen
		if (userType.contains("Ops Team")) {
			jsClickOn(userList_O, "userList_O");
			waitFor(3);
			driver.switchTo().defaultContent();
			takeScreenshotFor("User Selection Screen" + userType);
			switchToFrame(allUsersFrame);
			jsClickOn(oPsTeam_Login_Link, "oPsTeam_Login_Link");
			switchToWindowByIndex(2);
		} else if (userType.contains("Vedha")) {
			jsClickOn(userList_T, "userList_T");
			waitFor(3);
			driver.switchTo().defaultContent();
			takeScreenshotFor("User Selection Screen" + userType);
			switchToFrame(allUsersFrame);
			jsClickOn(ThotaVEda_Login_Link, "ThotaVEda_Login_Link");
			switchToWindowByIndex(1);
		}else if (userType.contains("Banton")) {
			jsClickOn(userList_B, "userList_B");
			waitFor(3);
			driver.switchTo().defaultContent();
			takeScreenshotFor("User Selection Screen" + userType);
			switchToFrame(allUsersFrame);
			jsClickOn(Banton_Login_Link, "Banton_Login_Link");
			switchToWindowByIndex(1);
		} else if (userType.contains("State Officer")) {
			jsClickOn(userList_S, "userList_S");
			waitFor(3);
			driver.switchTo().defaultContent();
			takeScreenshotFor("User Selection Screen" + userType);
			switchToFrame(allUsersFrame);
			jsClickOn(stateOfficer_LoginLink, "stateOfficer_LoginLink");
		} else if (userType.contains("Deputy Director")) {
			jsClickOn(userList_D, "userList_D");
			waitFor(3);
			driver.switchTo().defaultContent();
			takeScreenshotFor("User Selection Screen" + userType);
			switchToFrame(allUsersFrame);
			jsClickOn(deputyDirector_LoginLink, "deputyDirector_LoginLink");
		} else if (userType.contains("Division Director")) {
			jsClickOn(userList_D, "userList_D");
			waitFor(3);
			driver.switchTo().defaultContent();
			takeScreenshotFor("User Selection Screen" + userType);
			switchToFrame(allUsersFrame);
			jsClickOn(division_Director_LoginLink, "division_Director_LoginLink");
		} else if (userType.contains("FM Reviewer")) {
			jsClickOn(userList_F, "userList_F");
			waitFor(3);
			driver.switchTo().defaultContent();
			takeScreenshotFor("User Selection Screen" + userType);
			switchToFrame(allUsersFrame);
			jsClickOn(FM_Reviewer_loginLink, "FM_Reviewer_loginLink");
		}

		driver.switchTo().defaultContent();

		// Navigating to Decision Packages screen
		if (userType.contains("State Officer") || userType.contains("Deputy Director")
				|| userType.contains("FM Reviewer") || userType.contains("Division Director")) {

		} else {

			naviateToDecisionPackage();

		}

	}

	public void naviateToDecisionPackage() {
		driver.navigate().refresh();
		waitFor(5);
		jsClickOn(appLauncher, "appLauncher");
		waitFor(1);
		typeText(Escalation_Tracking_PO.appSearchTextField, "Decision Package Workflow", "appSearchTextFiel");
		waitFor(1);
		jsClickOn(Escalation_Tracking_PO.decisionPackageWorkFlow, "decisionPackageWorkFlow");
		waitFor(1);
		jsClickOn(Decision_Packages, "Decision_Packages");
		waitFor(2);
		takeScreenshotFor("Decision_Packages Navigation");
	}

	public void navigateTo_DeputyDirecter_Screen() {
		// Below has been scripted to navigated to All users screen

		jsClickOn(setUpIcon, "setUpIcon");
		takeScreenshotFor("Set Up Menu");
		waitFor(1);
		jsClickOn(setUpLink, "setUpLink");
		waitFor(1);
		switchToWindowByIndex(1);
		jsClickOn(userSideMenu, "userSideMenu");
		jsClickOn(userLink, "userLink");
		waitFor(1);
		switchToFrame(allUsersFrame);
		// Navigating to M Users list
		jsClickOn(userList_M, "userList_M");
		waitFor(30);
		driver.switchTo().defaultContent();
		takeScreenshotFor("User Selection Screen");
		switchToFrame(allUsersFrame);
		jsClickOn(Melendez_Login_Link, "Melendez_Login_Link");
		// Navigating to Ops Team login screen

	}

	public void navigateTo_Director_Screen(int index) {
		// Below has been scripted to navigated to All users screen
		waitFor(8);
		jsClickOn(setUpIcon, "setUpIcon");

		takeScreenshotFor("Set Up Menu");
		waitFor(3);
		jsClickOn(setUpLink, "setUpLink");
		waitFor(5);
		switchToWindowByIndex(index);
		jsClickOn(userSideMenu, "userSideMenu");
		jsClickOn(userLink, "userLink");
		waitFor(1);
		switchToFrame(allUsersFrame);
		// Navigating to M Users list
		jsClickOn(userList_H, "userList_H");
		waitFor(3);
		driver.switchTo().defaultContent();
		takeScreenshotFor("User Selection Screen");
		switchToFrame(allUsersFrame);
		jsClickOn(Alimu_Login_Link, "Alimu_Login_Link");
		// Navigating to Ops Team login screen

	}

	public void switchTo_User_Vedha_Profile_Screen() {
		// Below has been scripted to navigated to All users screen

		jsClickOn(setUpIcon, "setUpIcon");
		takeScreenshotFor("Set Up Menu");
		waitFor(1);
		jsClickOn(setUpLink, "setUpLink");
		waitFor(5);
		switchToWindowByIndex(1);
		jsClickOn(userSideMenu, "userSideMenu");
		jsClickOn(userLink, "userLink");
		waitFor(1);
		switchToFrame(allUsersFrame);
		// Navigating to M Users list
		jsClickOn(userList_T, "userList_T");
		waitFor(3);
		driver.switchTo().defaultContent();
		takeScreenshotFor("User Selection Screen");
		switchToFrame(allUsersFrame);
		jsClickOn(ThotaVEda_Login_Link, "ThotaVEda_Login_Link");
		switchToWindowByIndex(1);

	}

	public void logoutFromApp() {
		jsClickOn(userProfile, "userProfile");
		waitFor(4);
		jsClickOn(logOutButton, "logOutButton");
	}

	public void logoutAs_currentUser() {
		waitFor(2);
//		jsClickOn(logout_AS, "logout_AS");
		jsClickOn(userProfile, "userProfile");
		jsClickOn(logOutButton, "logOutButton");
		waitFor(2);
	}

	public void navigateTo_StateOfficer_Screen(int windowIndex) {
		// Below has been scripted to navigated to All users screen
		waitFor(5);
		jsClickOn(setUpIcon, "setUpIcon");
		takeScreenshotFor("Set Up Menu");
		waitFor(1);
		jsClickOn(setUpLink, "setUpLink");
		waitFor(1);
		switchToWindowByIndex(windowIndex);
		jsClickOn(userSideMenu, "userSideMenu");
		jsClickOn(userLink, "userLink");
		waitFor(30);
		switchToFrame(allUsersFrame);
		// Navigating to M Users list
		jsClickOn(userList_S, "userList_S");
		waitFor(3);
		driver.switchTo().defaultContent();
		takeScreenshotFor("User Selection Screen");
		switchToFrame(allUsersFrame);
		jsClickOn(Brandy_Login_Link, "Brandy_Login_Link");
		closePreviousWindow();
		if (windowIndex == 2)
			switchToWindowByIndex(1);
	}

	public void navigateTo_Certification_Lead_Screen() {
		// Below has been scripted to navigated to All users screen
		waitFor(5);
		jsClickOn(setUpIcon, "setUpIcon");
		takeScreenshotFor("Set Up Menu");
		waitFor(1);
		jsClickOn(setUpLink, "setUpLink");
		waitFor(1);
		switchToWindowByIndex(2);
		jsClickOn(userSideMenu, "userSideMenu");
		jsClickOn(userLink, "userLink");
		waitFor(30);
		switchToFrame(allUsersFrame);
		// Navigating to M Users list
		jsClickOn(userList_J, "userList_J");
		waitFor(3);
		driver.switchTo().defaultContent();
		takeScreenshotFor("User Selection Screen");
		switchToFrame(allUsersFrame);
		jsClickOn(Johnson_Login_Link, "Johnson_Login_Link");
		closePreviousWindow();
		switchToWindowByIndex(1);
	}

	public void navigateTo_DSS_DSG_Screen() {
		// Below has been scripted to navigated to All users screen
		waitFor(5);
		jsClickOn(setUpIcon, "setUpIcon");
		takeScreenshotFor("Set Up Menu");
		waitFor(1);
		jsClickOn(setUpLink, "setUpLink");
		waitFor(1);
		switchToWindowByIndex(2);
		jsClickOn(userSideMenu, "userSideMenu");
		jsClickOn(userLink, "userLink");
		waitFor(30);
		switchToFrame(allUsersFrame);
		// Navigating to M Users list
		jsClickOn(userList_J, "userList_J");
		waitFor(3);
		driver.switchTo().defaultContent();
		takeScreenshotFor("User Selection Screen");
		switchToFrame(allUsersFrame);
		jsClickOn(johnson_Login_Link, "johnson_Login_Link");
		closePreviousWindow();
		switchToWindowByIndex(1);
	}

	public void navigateTo_Pending_Issuance_To_State_Screen() {
		// Below has been scripted to navigated to All users screen
		waitFor(5);
		jsClickOn(setUpIcon, "setUpIcon");
		takeScreenshotFor("Set Up Menu");
		waitFor(1);
		jsClickOn(setUpLink, "setUpLink");
		waitFor(1);
		switchToWindowByIndex(2);
		jsClickOn(userSideMenu, "userSideMenu");
		jsClickOn(userLink, "userLink");
		waitFor(30);
		switchToFrame(allUsersFrame);
		// Navigating to M Users list
		jsClickOn(userList_E, "userList_J");
		waitFor(3);
		driver.switchTo().defaultContent();
		takeScreenshotFor("User Selection Screen");
		switchToFrame(allUsersFrame);
		jsClickOn(Walter_Login_Link, "Walter_Login_Link");
		closePreviousWindow();
		switchToWindowByIndex(1);
	}

	public void moveToEsalation_Stage() {
		jsClickOn(edit_EscalationTracking, "edit_EscalationTracking");
		waitFor(3);
		jsClickOn(check_Escalation_Tracking, "check_Escalation_Tracking");
		jsClickOn(save_Button, "save_Button");
		waitFor(5);

	}

	public void navigateTo_CW() {
		waitFor(5);
		jsClickOn(recentlyViewed, "recentlyViewed");
		waitFor(2);
		jsClickOn(All_CW, "All_CW");
		String str = CW_CreationPage.CW_Title_text;
		jsClickOn(search_CW_text_Field, "search_CW_text_Field");
		waitFor(2);
		typeText(search_CW_text_Field, str, "search_CW_text_Field");
		waitFor(2);
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
		}
		waitFor(2);
		By cwTitle = By.xpath("//*[@title='" + str + "']");
		jsClickOn(cwTitle, "cwTitle");
		waitFor(2);

	}

	public void go_to_Escalation_Tracking_Screen() {
		driver.switchTo().defaultContent();
		waitFor(5);
		jsClickOn(appLauncher, "appLauncher");
		waitFor(1);
		typeText(searchApps_Items, "Escalation Tracking", "searchApps_Items");
		waitFor(1);
		jsClickOn(Escalation_Tracking_Link, "Escalation_Tracking_Link");
		waitFor(1);
		takeScreenshotFor("Escalation Tracking Form");
	}

	public void closePreviousWindows() {

		switchToWindowByIndex(0);
		driver.close();
		System.out.println("Closed first Window");

		switchToWindowByIndex(0);
		driver.close();
		System.out.println("Closed Second Window");
		switchToWindowByIndex(0);

	}

	public void closePreviousWindow() {
		switchToWindowByIndex(0);
		driver.close();
		System.out.println("Closed first Window");
		switchToWindowByIndex(0);
	}

	public void moveToActiveWindow() {
		switchToWindowByIndex(1);
	}

	public void navigateToRecentEscalation() throws AWTException {
		jsClickOn(recentlyViewed, "recentlyViewed");
		jsClickOn(allOption, "allOption");
		jsClickOn(searchList, "searchList");
		typeText(searchList, Escalation_Tracking_PO.title, "searchList");
		jsClickOn(searchList, "searchList");
		waitFor(3);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		waitFor(3);

		By ET_Link = By.xpath("//a[@title='" + Escalation_Tracking_PO.title + "']");
		jsClickOn(ET_Link, "ET_Link");
		waitFor(5);
	}

}