package com.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import com.Locators.HomePage_Loc;
import com.utility.SafeActions;

public class HomePage extends SafeActions implements HomePage_Loc {

	// Ops user navigation to Decision package screen
	public void navigateTo_OpsTeam_DecisionPackage_Screen(String userType) {
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
		// Navigating to T Users list
		jsClickOn(userList_T, "userList_T");
		waitFor(3);
		driver.switchTo().defaultContent();
		takeScreenshotFor("User Selection Screen");
		switchToFrame(allUsersFrame);
		// Navigating to Ops Team login screen
		if (userType.contains("Ops Team")) {
			jsClickOn(oPsTeam_Login_Link, "oPsTeam_Login_Link");
			switchToWindowByIndex(2);
		} else if (userType.contains("Vedha")) {
			jsClickOn(ThotaVEda_Login_Link, "ThotaVEda_Login_Link");
			switchToWindowByIndex(1);
		} else if (userType.contains("State Officer")) {
			jsClickOn(stateOfficer_LoginLink, "stateOfficer_LoginLink");
		} else if (userType.contains("Deputy Director")) {
			jsClickOn(deputyDirector_LoginLink, "deputyDirector_LoginLink");
		} else if (userType.contains("Division Director")) {
			jsClickOn(division_Director_LoginLink, "division_Director_LoginLink");
		} else if (userType.contains("FM Reviewer")) {
			jsClickOn(FM_Reviewer_loginLink, "FM_Reviewer_loginLink");
		}

		driver.switchTo().defaultContent();

		// Navigating to Decision Packages screen
		if (userType.contains("State Officer") || userType.contains("Deputy Director")
				|| userType.contains("FM Reviewer") || userType.contains("Division Director")) {

		} else {
			waitFor(2);
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
		waitFor(3);
		driver.switchTo().defaultContent();
		takeScreenshotFor("User Selection Screen");
		switchToFrame(allUsersFrame);
		jsClickOn(Melendez_Login_Link, "Melendez_Login_Link");
		// Navigating to Ops Team login screen
		
	}
	
	public void navigateTo_Director_Screen() {
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
		jsClickOn(userList_D, "userList_D");
		waitFor(3);
		driver.switchTo().defaultContent();
		takeScreenshotFor("User Selection Screen");
		switchToFrame(allUsersFrame);
		jsClickOn(Purvi_Login_Link, "Purvi_Login_Link");
		// Navigating to Ops Team login screen
		
	}
	
	public void moveToEsalation_Stage() {
		jsClickOn(edit_EscalationTracking,"edit_EscalationTracking");
		waitFor(3);
		jsClickOn(check_Escalation_Tracking, "check_Escalation_Tracking");
		jsClickOn(save_Button, "save_Button");
		waitFor(5);
		
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

	public void moveToActiveWindow() {
		switchToWindowByIndex(2);
	}
	
	public void navigateToRecentEscalation() throws AWTException {
		jsClickOn(recentlyViewed, "recentlyViewed");
		jsClickOn(allOption, "allOption");
		jsClickOn(searchList, "searchList");
		typeText(searchList, Escalation_Tracking_PO.title, "searchList");
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		waitFor(2);
		By ET_Link = By.xpath("//a[@title='"+Escalation_Tracking_PO.title+"']");
		jsClickOn(ET_Link, "ET_Link");
		
	}
	
	
}