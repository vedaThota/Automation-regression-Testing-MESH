package com.Mesh_TestSuites;

import org.testng.annotations.Test;

import com.Base.TestBase;
import com.Pages.Escalation_Tracking_PO;
import com.Pages.HomePage;

public class Escalation_Tracking extends TestBase {

	HomePage homePage = new HomePage();
	Escalation_Tracking_PO ET_PO = new Escalation_Tracking_PO();

	@Test
	public void TC_001_Verify_Creation_Of_New_Escalation_Tracking() {
		ET_PO.verifyMandatoryFieldsOn_EscalationTracking();
		ET_PO.verify_Escalation_Tracking_Creation();
		ET_PO.verifyLeadershipReview();
	}


}
