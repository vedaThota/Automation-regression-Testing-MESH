package com.Locators;

import org.openqa.selenium.By;

public interface ClearenceCheckList_Loc {
	public static final By clearanceChecklist = By.xpath("//a[@data-label='Status Memo']/following::a[text()='Clearance Checklist']");
	public static final By clearanceChecklistLast = By.xpath("(//a[@data-label='Status Memo']/following::a[text()='Clearance Checklist'])[last()]");
	public static final By soReviewIsCompletede = By.xpath("//*[contains(@aria-label, 'The SO review is completed')]");
	public static final By mostRecentTemplateCheckBox = By.xpath("//input[contains(@aria-label, 'The most recent template')]");
	public static final By originalEmailSubmision = By.xpath("//*[contains(@aria-label, 'Original email submission')]");
	public static final By mostRecentTemplateLink = By.xpath("//*[text()='most recent template']");
	public static final By submisionTypeCheckbox = By.xpath("//*[contains(@aria-label, 'Submission Type')]");
	public static final By scopeOfContractCheckbox = By.xpath("//*[contains(@aria-label, 'The scope of the contract')]");
	public static final By SOCompleted_Clearance = By.xpath("//*[text()='SO Completed the Clearance Checklist.']");
	public static final By saveButton = By.xpath("//*[text()='Save']");
	public static final By checklistSaved = By.xpath("//*[contains(text(), 'Checklist saved successfully')]");
	public static final By secondChildPackageNavigationLink = By.xpath("//*[text()='Bundled Packages']/following::a//*[contains(text(), 'Contract')]");
	public static final By firstChildPackageNavigationLink = By.xpath("//*[text()='Bundled Packages']/following::a//*[contains(text(), 'RFP')]");
	public static final By leadPackageNavLink = By.xpath("//*[text()='Lead Package']/following::a[1]");
	public static final By theCorrespondingOpDiv = By.xpath("//*[contains(@aria-label, 'The corresponding')]");
	
	
	
}
