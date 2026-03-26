package com.Mesh_TestSuites;

import org.testng.annotations.Test;

import com.Base.TestBase;
import com.CertificationWorkflow_Pages.CW_CreationPage;
import com.CertificationWorkflow_Pages.CW_DetailsPage;
import com.Pages.HomePage;

public class CertificationWorkflow_TestSuite extends TestBase {
	
	CW_DetailsPage CW_Details_Page = new CW_DetailsPage();
	CW_CreationPage CW_Creation_Page = new CW_CreationPage();
	HomePage homePage = new HomePage();
	
	@Test
	public void TC_001_Verifying_Certification_Workflow_Creation() {
		homePage.switchTo_User_Vedha_Profile_Screen();
		waitFor(5);
		CW_Details_Page.navigateTo_Certification_Workflow_Screen();
		CW_Creation_Page.verifying_Mandatory_Fields_CW_Creation_Form();
		CW_Creation_Page.create_Certification_Workflow();
		CW_Details_Page.verify_Generate_template_Activity();
		CW_Details_Page.verify_SO_Review_Activity();
		homePage.logoutAs_currentUser();
		waitFor(1);
		loginToApplication();
		waitFor(5);
		
	}
	
	@Test
	public void TC_002_Verifying_CW_SO_Review() {
		homePage.navigateTo_StateOfficer_Screen();
		homePage.navigateTo_CW();
		CW_Details_Page.verify_SO_Begin_review();
		homePage.logoutAs_currentUser();
		waitFor(1);
		loginToApplication();
		waitFor(5);
		
	}
	
	@Test
	public void TC_003_Verifying_CMS_Certification_Lead_Review() {
		homePage.navigateTo_Certification_Lead_Screen();
		homePage.navigateTo_CW();
		CW_Details_Page.verify_CMS_Certification_lead_review();
		homePage.logoutAs_currentUser();
		waitFor(1);
		loginToApplication();
		waitFor(5);
	}
	
	@Test
	public void TC_004_Verifying_DSS_DSG_Review() {
		homePage.navigateTo_DSS_DSG_Screen();
		homePage.navigateTo_CW();
		CW_Details_Page.verify_DSS_DSG_review();
		homePage.logoutAs_currentUser();
		waitFor(1);
		loginToApplication();
		waitFor(5);
	}
	
	@Test
	public void TC_005_Verifying_Pending_Issuance_To_State_Review() {
		homePage.navigateTo_Pending_Issuance_To_State_Screen();
		homePage.navigateTo_CW();
		CW_Details_Page.verify_pending_issuance_review();
		
	}

}
