package com.CertificationWorkflow_Pages;

import com.CertificationWorkflow_Loc.CW_DetailsPage_Loc;
import com.utility.SafeActions;

public class CW_DetailsPage extends SafeActions implements CW_DetailsPage_Loc {
	
	public void navigateTo_Certification_Workflow_Screen() {
		waitFor(2);
		jsClickOn(appLauncher, "appLauncher");
		waitFor(1);
		typeText(appSearchTextField, "Certification Workflow", "appSearchTextFiel");
		waitFor(3);
		jsClickOn(certification_Workflow_Nav_Link, "certification_Workflow_Nav_Link");
		waitFor(3);
		takeScreenshotFor("Navigated to Certification Workflow screen");
	}

}
