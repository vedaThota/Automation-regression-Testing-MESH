package com.CertificationWorkflow_Loc;

import org.openqa.selenium.By;

public interface CW_CreationPage_Loc {
	public static By new_Button = By.xpath("//*[@title='New']");
	public static By submit_Button = By.xpath("//*[text()='Submit']");
	public static By stateMedicaidAgencyIs_required = By.xpath("//*[text()='State Medicaid Agency is required.']");
	public static By reviewType_ErrorMessage = By.xpath("//*[text()='Select at least one Review Type.']");
	public static By certification_ModuleIs_Required = By.xpath("//*[text()='Certification Module is required.']");
	public static By requestDate_Is_Required = By.xpath("//*[text()='Request Date is required.']");
	public static By ORR_Date_is_required = By.xpath("//*[text()='ORR Date is required.']");
	public static By Submission_Date_is_required = By.xpath("//*[text()='Submission Date is required.']");
	public static By reviewDateIsRequired = By.xpath("//*[text()='Review Date is required.']");
	public static By fileUplaodErrorMessage = By.xpath("//*[text()=' Maximum file size is 4MB. Larger file sizes can be added via the Box tab after submitting.']");
//	public static By appSearchTextField = By.xpath("vndfjkvnfdvkjfvnjj");
//	public static By appSearchTextField = By.xpath("vndfjkvnfdvkjfvnjj");
//	public static By appSearchTextField = By.xpath("vndfjkvnfdvkjfvnjj");
//	public static By appSearchTextField = By.xpath("vndfjkvnfdvkjfvnjj");

}
