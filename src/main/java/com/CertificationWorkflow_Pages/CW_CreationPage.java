package com.CertificationWorkflow_Pages;

import com.CertificationWorkflow_Loc.CW_CreationPage_Loc;
import com.utility.SafeActions;

public class CW_CreationPage extends SafeActions implements CW_CreationPage_Loc {

	public void verifying_Mandatory_Fields_CW_Creation_Form() {
		jsClickOn(new_Button, "new_Button");
		waitFor(3);
		jsClickOn(submit_Button, "submit_Button");
		waitFor(3);
		verifyTextDisplay(stateMedicaidAgencyIs_required, "State Medicaid Agency is required.");
		verifyTextDisplay(reviewType_ErrorMessage, "Select at least one Review Type.");
		verifyTextDisplay(certification_ModuleIs_Required, "Certification Module is required.");
		verifyTextDisplay(requestDate_Is_Required, "Request Date is required.");
		verifyTextDisplay(ORR_Date_is_required, "ORR Date is required.");
		verifyTextDisplay(Submission_Date_is_required, "Submission Date is required.");
		verifyTextDisplay(reviewDateIsRequired, "Review Date is required.");
		verifyTextDisplay(fileUplaodErrorMessage, "Maximum file size is 4MB. Larger file sizes can be added via the Box tab after submitting.");
		jsClickOn(fileUplaodErrorMessage, "fileUplaodErrorMessage");
		
	}

}
