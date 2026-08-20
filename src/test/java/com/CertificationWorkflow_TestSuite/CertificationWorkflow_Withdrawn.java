package com.CertificationWorkflow_TestSuite;

import java.text.ParseException;

import org.testng.annotations.Test;

import com.Base.TestBase;
import com.CertificationWorkflow_Pages.CW_CreationPage;
import com.CertificationWorkflow_Pages.CW_DetailsPage;
import com.Pages.HomePage;

public class CertificationWorkflow_Withdrawn extends TestBase {

	CW_DetailsPage CW_Details_Page = new CW_DetailsPage();
	CW_CreationPage CW_Creation_Page = new CW_CreationPage();
	HomePage homePage = new HomePage();

	@Test
	public void TC_006_Verifying_CW_withdrawn_with_specific_Reason() throws ParseException {

		CW_Details_Page.navigateTo_Certification_Workflow_Screen();
		CW_Details_Page.jsClickOn(CW_Details_Page.CT_Tab, "CT_Tab");
		waitFor(3);
		CW_Creation_Page.verifying_Mandatory_Fields_CW_Creation_Form();
		CW_Creation_Page.create_Certification_Workflow(5);
		CW_Details_Page.verify_Generate_template_Activity();
		CW_Details_Page.verify_SO_Review_Activity();
		CW_Details_Page.verify_Withdrawn_Functionality(5);
		CW_Details_Page.validateEmailNotification("Required");
		
	}
	
	@Test
	public void TC_007_Verifying_CW_withdrawn_with_Other_Reason() throws ParseException {
		
		CW_Details_Page.navigateTo_Certification_Workflow_Screen();
		CW_Details_Page.jsClickOn(CW_Details_Page.CT_Tab, "CT_Tab");
		waitFor(3);
		CW_Creation_Page.verifying_Mandatory_Fields_CW_Creation_Form();
		CW_Creation_Page.create_Certification_Workflow(6);
		CW_Details_Page.verify_Generate_template_Activity();
		CW_Details_Page.verify_SO_Review_Activity();
		homePage.logoutAs_currentUser();
		waitFor(1);
		loginToApplication();
		waitFor(5);
		driver.navigate().refresh();
		waitFor(5);
		homePage.navigateTo_StateOfficer_Screen(1);
		homePage.navigateTo_CW();
		CW_Details_Page.verify_SO_Begin_review();
		
		CW_Details_Page.verify_Withdrawn_Functionality_Other_Reason(6);
		CW_Details_Page.validateEmailNotification("No Log in Require");
		
	}

}
