package com.CertificationWorkflow_Pages;

import com.CertificationWorkflow_Loc.CW_DetailsPage_Loc;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
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

	public void verify_Generate_template_Activity() {
		
		jsClickOn(Edit_Director, "Edit_Director");
		typeText(director_Input, "a", "director_Input");
		waitFor(2);
		jsClickOn(director_Option, "director_Option");
		waitFor(1);
		jsClickOn(save_Button, "save_Button");
		waitFor(5);
		takeScreenshotFor("Director Updated");
		jsClickOn(Box_Link, "Box_Link");
		waitFor(10);
		jsClickOn(create_Folder, "create_Folder");
		waitFor(10);
		jsClickOn(generate_Template_button, "generate_Template_button");
		waitFor(2);
		jsClickOn(generate_Word_Document_button, "generate_Word_Document_button");
		verifyTextDisplay(documentUploaded_Successfully, "Document successfully uploaded");
		takeScreenshotFor("Document successfully uploaded");
		waitFor(10);
		jsClickOn(generate_Template_button, "generate_Template_button");
		waitFor(2);
		jsClickOn(generate_Word_Document_button, "generate_Word_Document_button");
		takeScreenshotFor("This template has already been generated");
		verifyTextDisplay(templateError_Messaage, "This template has already been generated");
		jsClickOn(cancel_Close, "cancel_Close");

	}

	public void verify_SO_Review_Activity() {
		jsClickOn(move_to_SO_Reeview, "move_to_SO_Reeview");
		jsClickOn(confirm_Button, "confirm_Button");
		waitFor(5);
		verifyTextDisplay(status_Updated, "SO Review");
		scrollToTopofThePage();
		takeScreenshotFor("SO Review Tab status");
		String status = getAttribute(SO_Review_Tab, "aria-selected", "SO_Review_Tab");
		if (status.equals("true")) {
			test.log(Status.INFO,
					MarkupHelper.createLabel("Status moved to SO Review" , ExtentColor.GREEN));
		} else {
			test.log(Status.INFO,
					MarkupHelper.createLabel("Status NOT moved to SO Review" , ExtentColor.RED));
		}

	}
	
	public void verify_SO_Begin_review() {
		waitFor(5);
		verifyTextDisplay(status_Updated, "SO Review");
		jsClickOn(beginReview, "beginReview");
		waitFor(2);
		jsClickOn(Move_to_CMS_Certification_Lead, "Move_to_CMS_Certification_Lead");
		waitFor(2);
		
	}
	
	public void verify_CMS_Certification_lead_review() {
		verifyTextDisplay(status_Updated, "CMS Certification Lead");
		jsClickOn(beginReview, "beginReview");
		waitFor(10);
		jsClickOn(Move_to_DSS_Review, "Move_to_DSS_Review");
		waitFor(2);
		jsClickOn(confirm_Button, "confirm_Button");
		waitFor(2);
		takeScreenshotFor("Moved to DSS review");
	}
	
	public void verify_DSS_DSG_review() {
		verifyTextDisplay(status_Updated, "DSS/DSG Review");
		jsClickOn(beginReview, "beginReview");
		waitFor(2);
		takeScreenshotFor("DSS Begin Review");
		jsClickOn(approve_Package, "approve_Package");
		waitFor(2);
		takeScreenshotFor("moved to pending issueance to State");
	}
	
	public void verify_pending_issuance_review() {
		verifyTextDisplay(status_Updated, "Pending Issuance to State");
		jsClickOn(closeOut_Package, "closeOut_Package");
		waitFor(2);
		takeScreenshotFor("Confirm Closeout package");
		jsClickOn(confirm_Button, "confirm_Button");
		waitFor(1);
		verifyTextDisplay(update_Failed_Error_Message, "Update failed: Issuance to State Date must be completed to closeout package");
		takeScreenshotFor("Update failed: Issuance to State Date must be completed to closeout package");
		jsClickOn(edit_Issuance_To_StateDate,"edit_Issuance_To_StateDate");
		waitFor(2);
		typeText(issuanceDate_Input, fetchWeekdayDate("M/d/yyyy", 0), "issuanceDate_Input");
		jsClickOn(save_Button, "Save Button");
		waitFor(2);
		jsClickOn(save_Button, "Save Button");
		waitFor(2);
		jsClickOn(closeOut_Package, "closeOut_Package");
		waitFor(2);
		jsClickOn(confirm_Button, "confirm_Button");
		waitFor(10);
		
		String status = getAttribute(completed_Tab, "aria-selected", "completed_Tab");
		if (status.equals("true")) {
			test.log(Status.INFO,
					MarkupHelper.createLabel("Status moved to Completed" , ExtentColor.GREEN));
		} else {
			test.log(Status.INFO,
					MarkupHelper.createLabel("Status NOT moved to Completed" , ExtentColor.RED));
		}
	}
	
	

}
