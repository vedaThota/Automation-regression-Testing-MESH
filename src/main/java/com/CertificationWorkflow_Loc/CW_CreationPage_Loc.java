package com.CertificationWorkflow_Loc;

import org.openqa.selenium.By;

public interface CW_CreationPage_Loc {
	public static By new_Button = By.xpath("//*[@title='New']");
	public static By save_Button = By.xpath("//*[text()='Save']");
	public static By stateMedicaidAgencyIs_required = By.xpath("//*[text()='State Medicaid Agency is required.']");
	public static By reviewType_ErrorMessage = By.xpath("//*[text()='Select at least one Review Type.']");
	public static By certification_ModuleIs_Required = By.xpath("//*[text()='Certification Module is required.']");
	public static By requestDate_Is_Required = By.xpath("//*[text()='Request Date is required.']");
	public static By ORR_Date_is_required = By.xpath("//*[text()='ORR Date is required.']");
	public static By Submission_Date_is_required = By.xpath("//*[text()='Submission Date is required.']");
	public static By reviewDateIsRequired = By.xpath("//*[text()='Review Date is required.']");
	public static By fileUplaodErrorMessage = By.xpath("//*[text()=' Maximum file size is 4MB. Larger file sizes can be added via the Box tab after submitting.']");
	
	public static By State_Medicaid_Agency = By.xpath("//*[text()='State Medicaid Agency']/following::input[1]");
	public static By CAP_Request = By.xpath("//*[@title='CAP Request']");
	public static By Demo = By.xpath("//*[@title='Demo']");
	public static By Certification_Module = By.xpath("//*[text()='Certification Module']/following::button[1]");
	public static By certificaation_Module_Option = By.xpath("//*[text()='Certification Module']/following::button[1]/following::lightning-base-combobox-item[2]");
	public static By Certification_Request_Date_Input  = By.xpath("//*[text()='Certification Request Date']/following::input[1]");
	public static By ORR_Date_Input = By.xpath("//*[text()='ORR Date']/following::input[1]");
	public static By submission_Date_Input = By.xpath("//*[text()='Submission Date']/following::input[1]");
	public static By certifcation_Review_Date = By.xpath("//*[text()='Certification Review Date']/following::input[1]");
	public static By Executive_Summary = By.xpath("//div[contains(@class, 'slds-rich-text-area__content slds-grow slds-text-color-weak standin')]");
	public static By executive_Summary_ = By.xpath("//div[@part='rich-text-editor-textarea']/div");
	
	public static By weekend_Holiday_ErrorMessage = By.xpath("//*[text()='Selected date falls on a weekend or holiday. Please choose a valid business day.']");
	public static By RequestDate_CannotBeFuture_ErrorMsg = By.xpath("//*[text()='Request Date cannot be in the future.']");
	public static By ORR_Date_CannotBeFuture_ErrorMsg = By.xpath("//*[text()='ORR Date cannot be in the future.']");
	public static By Submission_Date_CannotBeFuture_ErrorMsg = By.xpath("//*[text()='Submission Date cannot be in the future.']");
	public static By Review_Date_CannotBeFuture_ErrorMsg = By.xpath("//*[text()='Review Date cannot be in the future.']");
	public static By moveToSelected = By.xpath("//button[@title='Move selection to Selected']");
	public static By uploadFiles = By.xpath("(//*[text()='Upload Files']/lightning-primitive-icon)[last()]");
	public static final By done_Button = By.xpath("//*[text()='Done']/..");
	public static By stateMedicaidOption = By.xpath("//*[text()='State Medicaid Agency']/following::lightning-base-combobox-item[1]");
	public static By successMessage = By.xpath("//*[text()='Certification Workflow created']");
	public static final By CW_Title = By.xpath("//h1/following::lightning-formatted-text[1]");
	
//	public static By appSearchTextField = By.xpath("vndfjkvnfdvkjfvnjj");
//	public static By appSearchTextField = By.xpath("vndfjkvnfdvkjfvnjj");
//	public static By appSearchTextField = By.xpath("vndfjkvnfdvkjfvnjj");
//	public static By appSearchTextField = By.xpath("vndfjkvnfdvkjfvnjj");
//	public static By appSearchTextField = By.xpath("vndfjkvnfdvkjfvnjj");
//	public static By appSearchTextField = By.xpath("vndfjkvnfdvkjfvnjj");
//	public static By appSearchTextField = By.xpath("vndfjkvnfdvkjfvnjj");
//	public static By appSearchTextField = By.xpath("vndfjkvnfdvkjfvnjj");
//	public static By appSearchTextField = By.xpath("vndfjkvnfdvkjfvnjj");

}
