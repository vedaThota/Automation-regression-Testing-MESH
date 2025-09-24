package com.Pages;

import com.Locators.HomePage_Loc;
import com.utility.SafeActions;

public class HomePage extends SafeActions implements HomePage_Loc {

	// Ops user navigation to Decision package screen
	public void navigateTo_OpsTeam_DecisionPackage_Screen(String userType) {
		// Below has been scripted to navigated to All users screen

		jsClickOn(setUpIcon, "setUpIcon");
		takeScreenshotFor("Set Up Menu");
		jsClickOn(setUpLink, "setUpLink");
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
		}
		else if (userType.contains("Division Director")) {
			jsClickOn(division_Director_LoginLink, "division_Director_LoginLink");
		}else if (userType.contains("FM Reviewer")) {
			jsClickOn(FM_Reviewer_loginLink, "FM_Reviewer_loginLink");
		}
		
	
			driver.switchTo().defaultContent();
		
		// Navigating to Decision Packages screen
		if (userType.contains("State Officer") || userType.contains("Deputy Director")|| userType.contains("FM Reviewer")
				|| userType.contains("Division Director")) {

		} else {
			jsClickOn(Decision_Packages, "Decision_Packages");
			waitFor(2);
			takeScreenshotFor("Decision_Packages Navigation");
		}
		
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
}