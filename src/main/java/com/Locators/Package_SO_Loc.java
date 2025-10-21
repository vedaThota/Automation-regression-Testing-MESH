package com.Locators;

import org.openqa.selenium.By;

public interface Package_SO_Loc {
	
	public static By packageSO_Updates_Link = By.xpath("//a[@title='Package SO Updates']");
	public static By stateOfficerButton = By.xpath("//*[text()='Replace State Officer']");
	public static By selectCurrentStateOfficer = By.xpath("//label[text()='Select Current State Officer']/following::input");
	public static By firstSearchResult = By.xpath("//ul[@aria-label='Search Results']//span[2]");
	public static By selectReplacementStateOfficer = By.xpath("//*[text()='Select Replacement State Officer']/following::input");
	public static By selectStatecheckBox = By.xpath("//input[@name='stateCheckboxes']/following::span[1]");
	public static By startDateInput = By.xpath("//label[text()='Start Date']/following::input");
	public static By endDateInput = By.xpath("//label[text()='End Date']/following::input");
	public static By emptyStateOfficerErrorMessage = By.xpath("//*[text()='Please select a State Officer to replace.']");
	public static By submitButton = By.xpath("//*[text()='Submit']");
	public static By stateOfficer_SuccessMsg = By.xpath("//*[contains(text(), 'State Officer replaced')]");
	public static By removeSelectedStateOfficer = By.xpath("//button[@title='Remove selected State Officer']");
	public static By removeSelectedStateOfficer_last = By.xpath("(//button[@title='Remove selected State Officer'])[last()]");
	public static By endDate_ErrorMsg = By.xpath("//*[text()='End Date must be after Start Date.']");
	public static By startDate_ErrorMsg = By.xpath("//*[text()='Start Date is required when End Date is provided.']");
	// https://mailosaur.com/app/servers/drwhn6bn/messages/inbox
	public static By emailThread = By.xpath("//tbody/tr/td[2]/div/div");
	public static By emailHeader = By.xpath("//h2[text()='Sandbox: State Officer Change Notification']");
	public static By Re_assign_emailHeader = By.xpath("//h2[contains(text(),'Sandbox:')]");
	public static By emptyServer = By.xpath("//*[text()='Empty Server']");
	public static By emailAddressTextField = By.xpath("//label[text()='Email address']/following::input");
	
	public static By continueButton = By.xpath("//button[text()='Continue']");
	public static By passwordTextField = By.xpath("//label[text()='Password']/following::input");
	public static By loginButtonEmail = By.xpath("//button[text()='Log in']");
	public static By dateRecieved = By.xpath("//tbody/tr/td[2]/div/div[2]/p");
	public static By emailBody = By.xpath("//div[@id='mailcontainer']");
	
	public static By Reassign_Decision_Package = By.xpath("//button[text()='Reassign Decision Package']");
	public static By selectStateOfficer = By.xpath("//label[text()='Select State Officer']/following::input");
	public static By checkBoxOne = By.xpath("//input[@part='checkbox']/..//span[1]");
	public static By reassignPackageInput = By.xpath("//*[text()='Reassign 1 package(s) to New State Officer']/following::input");
	public static By reassignSuccessMessage = By.xpath("//*[text()='Decision packages reassigned successfully.']");
//	public static By packageSO_Updates_Link = By.xpath("//a[@title='Package SO Updates']");
//	public static By packageSO_Updates_Link = By.xpath("//a[@title='Package SO Updates']");
//	public static By packageSO_Updates_Link = By.xpath("//a[@title='Package SO Updates']");
//	public static By packageSO_Updates_Link = By.xpath("//a[@title='Package SO Updates']");
//	public static By packageSO_Updates_Link = By.xpath("//a[@title='Package SO Updates']");
//	public static By packageSO_Updates_Link = By.xpath("//a[@title='Package SO Updates']");
//	public static By packageSO_Updates_Link = By.xpath("//a[@title='Package SO Updates']");
//	public static By packageSO_Updates_Link = By.xpath("//a[@title='Package SO Updates']");
//	public static By packageSO_Updates_Link = By.xpath("//a[@title='Package SO Updates']");
//	public static By packageSO_Updates_Link = By.xpath("//a[@title='Package SO Updates']");
	


	
}