package com.Pages;

import com.Locators.HomePage_Loc;
import com.utility.SafeActions;

public class HomePage extends SafeActions implements HomePage_Loc {

	// Ops user navigation to Decision package screen
	public void navigateTo_OpsTeam_DecisionPackage_Screen() {
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
//		jsClickOn(oPsTeam_Login_Link, "oPsTeam_Login_Link");
		jsClickOn(ThotaVEda_Login_Link, "ThotaVEda_Login_Link");
		driver.switchTo().defaultContent();
		// Navigating to Decision Packages screen
		switchToWindowByIndex(1);
		jsClickOn(Decision_Packages, "Decision_Packages");
		waitFor(2);
		takeScreenshotFor("Decision_Packages Navigation");
	}
}