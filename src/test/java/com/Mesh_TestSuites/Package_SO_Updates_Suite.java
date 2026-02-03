package com.Mesh_TestSuites;

import java.text.ParseException;

import org.testng.annotations.Test;

import com.Base.TestBase;
import com.Pages.DecisionPackagePage;
import com.Pages.HomePage;
import com.Pages.Package_SO_Page;

public class Package_SO_Updates_Suite extends TestBase {

	HomePage homePage = new HomePage();
	Package_SO_Page ps_Page = new Package_SO_Page();
	DecisionPackagePage dpp = new DecisionPackagePage();

	@Test
	public void TC_001_Verify_Package_SO_Updates_Displays_Only_For_Admin_OPsTeam() {
		homePage.naviateToDecisionPackage();
		ps_Page.navigateTo_PackageSO_Updates();
		ps_Page.packageSOUpdates_Display_For_Admin();
		dpp.logoutFromApp();
		waitFor(1);
		loginToApplication();
		waitFor(5);
		homePage.navigateTo_OpsTeam_DecisionPackage_Screen("State Officer");
		waitFor(5);
		homePage.closePreviousWindows();
		waitFor(3);
		ps_Page.verifyPackageSOUpdates_NON_Display_For_StateOfficer();
		dpp.logoutFromApp();
		waitFor(1);
		loginToApplication();
		waitFor(5);
		homePage.navigateTo_OpsTeam_DecisionPackage_Screen("Ops Team");
		waitFor(5);
		homePage.closePreviousWindows();
		waitFor(3);
		
	}

	
	  @Test public void TC_002_Verify_Package_SO_Updates_StateOfficer_Replacement()
	  { ps_Page.verifyStateOfficerReplacement();
	  
	  }
	  
	  @Test public void
	  TC_003_Verify_Email_Notification_After_StateOfficer_Replacement() throws
	  ParseException {
		  ps_Page.validateEmailNotification();
	  
	  }
	 

	@Test
	public void TC_004_Verify_Package_SO_Updates_StateOfficer_Re_ASSIGN() {
		ps_Page.verifyStateOfficer_ReAssign();

	}

	@Test
	public void TC_005_Verify_Email_Notification_After_StateOfficer_ReAssignment() throws ParseException {
		ps_Page.validate_Reassignment_EmailNotification();

	}

}
