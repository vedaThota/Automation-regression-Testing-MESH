package com.Locators;

import org.openqa.selenium.By;

public interface ClearenceCheckList_Loc {
	public static final By clearanceChecklist = By.xpath("//*[text()='Clearance Checklist']");
	public static final By soReviewIsCompletede = By.xpath("//*[contains(@aria-label, 'The SO review is completed')]");
	public static final By mostRecentTemplateCheckBox = By.xpath("//*[contains(@aria-label, 'The most recent template')]");
	public static final By originalEmailSubmision = By.xpath("//*[contains(@aria-label, 'Original email submission')]");
	public static final By mostRecentTemplateLink = By.xpath("//*[text()='most recent template']/..");
	public static final By submisionTypeCheckbox = By.xpath("//*[contains(@aria-label, 'Submission Type')]");
	public static final By scopeOfContractCheckbox = By.xpath("//*[contains(@aria-label, 'The scope of the contract')]");
	public static final By SOCompleted_Clearance = By.xpath("//*[text()='SO Completed the Clearance Checklist.']");
	public static final By saveButton = By.xpath("//*[text()='Save']");
	public static final By checklistSaved = By.xpath("//*[contains(text(), 'Checklist saved successfully')]");
//	public static final By decisionPackages = By.xpath("");
//	public static final By decisionPackages = By.xpath("");
//	public static final By decisionPackages = By.xpath("");
//	public static final By decisionPackages = By.xpath("");
//	public static final By decisionPackages = By.xpath("");
	
	
}
