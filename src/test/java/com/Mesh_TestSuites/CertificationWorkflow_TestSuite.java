package com.Mesh_TestSuites;

import org.testng.annotations.Test;

import com.Base.TestBase;
import com.CertificationWorkflow_Pages.CW_CreationPage;
import com.CertificationWorkflow_Pages.CW_DetailsPage;

public class CertificationWorkflow_TestSuite extends TestBase {
	CW_DetailsPage CW_Details_Page = new CW_DetailsPage();
	CW_CreationPage CW_Creation_Page = new CW_CreationPage();

	@Test
	public void TC_001_Verifying_Certification_Workflow_Creation() {
		CW_Details_Page.navigateTo_Certification_Workflow_Screen();
		CW_Creation_Page.verifying_Mandatory_Fields_CW_Creation_Form();
//		te
	}

}
