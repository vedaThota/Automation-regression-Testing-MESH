package com.Pages;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.Locators.ClearenceCheckList_Loc;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.utility.SafeActions;

public class ClearenceChecklist extends SafeActions implements ClearenceCheckList_Loc {

	public void updateClearanceChecklist(String submisionType, String opDivType) {
		waitFor(5);
		jsClickOn(clearanceChecklistLast, "clearanceChecklistLast");
		jsClickOn(soReviewIsCompletede, "soReviewIsCompletede");
		jsClickOn(mostRecentTemplateCheckBox, "mostRecentTemplateCheckBox");
		jsClickOn(originalEmailSubmision, "originalEmailSubmision");
		
		
//		jsClickOn(mostRecentTemplateLink, "mostRecentTemplateLink");
//		waitFor(getRandomStateInitial());
//		int count = driver.getWindowHandles().size();
//		System.out.println("Count: " + count);
//		if (count == 3 || count == 2) {
//			test.log(Status.INFO,
//					MarkupHelper.createLabel("Most recent template link launching new window", ExtentColor.BLUE));
//		} else {
//			test.log(Status.FAIL,
//					MarkupHelper.createLabel("Most recent template link NOT launching new window", ExtentColor.RED));
//		}
//		waitFor(2);
//		if (submisionType.contains("APD")) {
//			driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
//			driver.close();
//			driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(0));
//		}
//		if (submisionType.contains("RFP") || submisionType.contains("Contract")) {
//			driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
//			driver.close();
//			driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(0));
//		}
		
		
		jsClickOn(submisionTypeCheckbox, "submisionTypeCheckbox");
		waitFor(1);
		if (submisionType.contains("Contract") || submisionType.contains("RFP"))
			jsClickOn(scopeOfContractCheckbox, "scopeOfContractCheckbox");
		if (submisionType.contains("APD") && opDivType.contains("FNS"))
			jsClickOn(theCorrespondingOpDiv, "theCorrespondingOpDiv");

		jsClickOn(SOCompleted_Clearance, "SOCompleted_Clearance");
		waitFor(3);
		jsClickOn(saveButton, "saveButton");
		waitFor(1);
		try {
			if(driver.findElement(saveButton).isDisplayed())
				jsClickOn(saveButton, "saveButton");
		}catch(Exception e) {}
		verifyTextDisplay(checklistSaved, "Checklist saved successfully");
		takeScreenshotFor("Updated clearance checklist screenshot");
	}
	
	public void updateParentDecsionPackage(String submisionType, String opDivType) {
		waitFor(5);
		jsClickOn(clearanceChecklistLast, "clearanceChecklistLast");
		jsClickOn(soReviewIsCompletede, "soReviewIsCompletede");
		jsClickOn(mostRecentTemplateCheckBox, "mostRecentTemplateCheckBox");
		jsClickOn(originalEmailSubmision, "originalEmailSubmision");
		
		jsClickOn(submisionTypeCheckbox, "submisionTypeCheckbox");
		waitFor(1);
		if (submisionType.contains("Contract") || submisionType.contains("RFP"))
			jsClickOn(scopeOfContractCheckbox, "scopeOfContractCheckbox");
		if (submisionType.contains("APD") && opDivType.contains("FNS"))
			jsClickOn(theCorrespondingOpDiv, "theCorrespondingOpDiv");

		jsClickOn(SOCompleted_Clearance, "SOCompleted_Clearance");
		jsClickOn(FM_CompletedClearanceChecklist, "FM_CompletedClearanceChecklist");
		waitFor(1);
		jsClickOn(saveButton, "saveButton");
		waitFor(1);
		try {
			if(driver.findElement(saveButton).isDisplayed())
				jsClickOn(saveButton, "saveButton");
		}catch(Exception e) {}
		verifyTextDisplay(checklistSaved, "Checklist saved successfully");
		takeScreenshotFor("Updated clearance checklist screenshot");
	}
	public void updateFirstChildClearance_CheckList() {
		waitFor(5);
		jsClickOn(clearanceChecklistLast, "clearanceChecklistLast");
		jsClickOn(spellCheckWasUsed, "spellCheckWasUsed");
		waitFor(1);
		scrollToBottomOfthePage();
		waitFor(5);
		jsClickOn(FM_CompletedClearanceChecklist, "FM_CompletedClearanceChecklist");
		waitFor(2);
		jsClickOn(saveButton, "saveButton");
		waitFor(5);
	}
	
	public void updateSecondChildClearance_CheckList() {
		waitFor(5);
		jsClickOn(clearanceChecklistLast, "clearanceChecklistLast");
		jsClickOn(spellCheckWasUsed, "spellCheckWasUsed");
		waitFor(1);
		scrollToBottomOfthePage();
		waitFor(5);
		jsClickOn(FM_CompletedClearanceChecklist, "FM_CompletedClearanceChecklist");
		waitFor(2);
		jsClickOn(saveButton, "saveButton");
		waitFor(1);
	}

	public void moveToMainPage() {
		driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(0));
		driver.close();
		driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(0));

	}

	public void moveToFistChildPackage() {
		jsClickOn(firstChildPackageNavigationLink, "firstChildPackageNavigationLink");
	}
	
	public void moveToSecondChildPpackageFromLleadPpackage() {
		jsClickOn(SC_Ffrom_leadpackage, "SC_Ffrom_leadpackage");
	}

	public void moveToSecondChildPackage() {
		jsClickOn(leadPpackageLlink, "leadPpackageLlink");
		waitFor(5);
		jsClickOn(SC_Ffrom_leadpackage, "SC_Ffrom_leadpackage");
		waitFor(2);
	}

	public void moveToLeadPackage() {
		waitFor(2);
		jsClickOn(leadPackageNavLink, "leadPackageNavLink");
	};
	
	

}