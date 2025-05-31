package com.Mesh_TestSuites;

import org.testng.annotations.Test;

import com.Base.TestBase;
import com.Pages.DecisionPackagePage;
import com.Pages.HomePage;

public class DecisionPackages extends TestBase {
	HomePage homePage = new HomePage();
	DecisionPackagePage dpp = new DecisionPackagePage();

	@Test(groups = { "Regression"})
	public void DecisionPackage_TC_001_Verify_OpsTeam_Can_Create_Package() {
		// Navigating to Decision package screen
		homePage.navigateTo_OpsTeam_DecisionPackage_Screen();
		// Validating the all mandatory fields on the Decision package creation form
		dpp.validateMandatoryFieldsErrorMessages();
		// Creation of Decision package
		dpp.verifyUserCanCreate_DecisionPackage();
		// Validation of required fields after decision package creation 
		dpp.verifyMandatoryFields_OnDecisionPackage();
	}
}
