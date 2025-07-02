package com.Pages;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.Locators.ClearenceCheckList_Loc;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.utility.SafeActions;

public class ClearenceChecklist extends SafeActions implements ClearenceCheckList_Loc {

	public void updateClearanceChecklist(String type) {
	
		jsClickOn(clearanceChecklist, "clearanceChecklist");
		jsClickOn(soReviewIsCompletede, "soReviewIsCompletede");
		jsClickOn(mostRecentTemplateCheckBox, "mostRecentTemplateCheckBox");
		jsClickOn(originalEmailSubmision, "originalEmailSubmision");
		jsClickOn(mostRecentTemplateLink, "mostRecentTemplateLink");
		waitFor(getRandomStateInitial());
		int count = driver.getWindowHandles().size();
		System.out.println("Count: " + count);
		if (count == 4 || count == 2) {
			test.log(Status.INFO,
					MarkupHelper.createLabel("Most recent template link launching new window", ExtentColor.BLUE));
		} else {
			test.log(Status.FAIL,
					MarkupHelper.createLabel("Most recent template link NOT launching new window", ExtentColor.RED));
		}
		jsClickOn(submisionTypeCheckbox, "submisionTypeCheckbox");
		if (type.contains("Contract") || type.contains("RFP"))
			jsClickOn(scopeOfContractCheckbox, "scopeOfContractCheckbox");
		jsClickOn(SOCompleted_Clearance, "SOCompleted_Clearance");
		jsClickOn(saveButton, "saveButton");
//		waitFor(1);
		if (type.contains("Contract") || type.contains("RFP"))
			driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(0));
		else
			driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(2));
		verifyTextDisplay(checklistSaved, "Checklist saved successfully");
		takeScreenshotFor("Updated clearance checklist screenshot");
	}

}