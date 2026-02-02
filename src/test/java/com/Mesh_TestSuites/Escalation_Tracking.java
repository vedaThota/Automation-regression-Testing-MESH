package com.Mesh_TestSuites;

import java.awt.AWTException;
import java.text.ParseException;

import org.testng.annotations.Test;

import com.Base.TestBase;
import com.Pages.DecisionPackagePage;
import com.Pages.Escalation_Tracking_PO;
import com.Pages.HomePage;

public class Escalation_Tracking extends TestBase {

	HomePage homePage = new HomePage();
	Escalation_Tracking_PO ET_PO = new Escalation_Tracking_PO();
	DecisionPackagePage dpp = new DecisionPackagePage();

	@Test
	public void TC_001_Verify_Creation_Of_New_Escalation_Tracking() {
		ET_PO.verifyMandatoryFieldsOn_EscalationTracking();
		ET_PO.verify_Escalation_Tracking_Creation();
		ET_PO.verifyLeadershipReview();
	}

	@Test
	public void TC_002_Verify_Escalation_Tracking_NoActionNeede() {

		ET_PO.OpenNew_ET_Creation_Form();
		ET_PO.verify_Escalation_Tracking_Creation();
		ET_PO.verifyEscalationTrackerwith_NoActionNeeded();

	}

	@Test
	public void TC_003_Verify_Escalation_Tracking_Other_Reason() {
		ET_PO.OpenNew_ET_Creation_Form();
		ET_PO.verify_Escalation_Tracking_Creation();
		ET_PO.verifyEscalationTrackerwith_OtherReason();
	}

	@Test
	public void TC_004_Verify_Escalation_Tracking_Return_Item() throws ParseException {
		dpp.logoutFromApp();
		waitFor(1);
		loginToApplication();
		waitFor(5);
		homePage.navigateTo_DeputyDirecter_Screen();
		waitFor(5);
		homePage.closePreviousWindows();
		homePage.go_to_Escalation_Tracking_Screen();
		ET_PO.OpenNew_ET_Creation_Form();
		ET_PO.verify_Escalation_Tracking_Creation();
		ET_PO.moveEscalationTo_Review_Stage();
		ET_PO.verifyReturnEscalationItem();
		ET_PO.validateEmailNotification("Login Require");
		
////		// Related Tab functionality
//		ET_PO.updateEscalationTracker();
//		ET_PO.validateUpdatedFields_Under_Related_Tab();
////		// Status Memo functionality
//		ET_PO.validateStatusMemo_Comment_Answer();
		
	}
	
	@Test
	public void TC_005_Verify_Escalation_Tracking_Creation_From_DecisionPackage() {
		dpp.logoutFromApp();
		waitFor(1);
		loginToApplication();
		waitFor(5);
		homePage.navigateTo_OpsTeam_DecisionPackage_Screen("Ops Team");
		homePage.jsClickOn(DecisionPackagePage.newDecisionPackage, "newDecisionPackage");
		dpp.verifyUserCanCreate_DecisionPackage(DecisionPackagePage.SubmissionTypeOption_APD, "APD", "CMSFNS");
		homePage.moveToEsalation_Stage();
		ET_PO.createEscationTracking();
	}
	
	@Test
	public void TC_006_Verify_Escalation_Tracking_Emails_Validations() throws ParseException, AWTException {
		
		dpp.logoutFromApp();
		waitFor(1);
		loginToApplication();
		waitFor(5);
		homePage.go_to_Escalation_Tracking_Screen();
		ET_PO.OpenNew_ET_Creation_Form();
		ET_PO.verify_Escalation_Tracking_Creation();
		ET_PO.validateEmailNotification("Login NOT Require");
		ET_PO.assignLeaderShip_VerifyEmail();
		dpp.logoutFromApp();
		waitFor(1);
		loginToApplication();
		waitFor(5);
		homePage.navigateTo_Director_Screen();
		homePage.go_to_Escalation_Tracking_Screen();
		homePage.navigateToRecentEscalation();
		ET_PO.beginReview_VerifyEmail();
		dpp.logoutFromApp();
		waitFor(1);
		loginToApplication();
		waitFor(5);
		homePage.go_to_Escalation_Tracking_Screen();
		homePage.navigateToRecentEscalation();
		ET_PO.returnToDirector_VerifyEmail();
		
	}
	
	
	
}
