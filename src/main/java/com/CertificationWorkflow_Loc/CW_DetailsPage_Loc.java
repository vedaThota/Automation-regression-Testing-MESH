package com.CertificationWorkflow_Loc;

import org.openqa.selenium.By;

public interface CW_DetailsPage_Loc {
	public static By appSearchTextField = By.xpath("//input[@placeholder='Search apps and items...']");
	public static By certification_Workflow_Nav_Link = By.xpath("//b[text()='Certification Workflow']");
	public static By decisionPackageWorkFlow = By.xpath("//b[text()='Decision Package Workflow']");
	public static By generate_Template_button = By.xpath("//button[text()='Generate Template']");
	public static By generate_Word_Document_button = By.xpath("//button[text()='Generate Word Document']");
	public static By templateError_Messaage = By.xpath("//*[text()='This template has already been generated']");
	public static By move_to_SO_Reeview = By.xpath("//*[text()='Move to SO Review']");
	public static By Edit_Director = By.xpath("//button[@title='Edit DSS/DSG Director']");
	public static By director_Input = By.xpath("//*[text()='DSS/DSG Director']/following::input[1]");
	public static By director_Option = By.xpath("//*[text()='DSS/DSG Director']/following::input[1]/following::lightning-base-combobox-item[2]");
	public static By save_Button = By.xpath("//*[text()='Save']");
	public static By confirm_Button = By.xpath("//*[text()='Confirm']");
	public static By status_Updated = By.xpath("(//*[text()='Status']/following::lightning-formatted-text[1])[last()]");
	public static By beginReview = By.xpath("//*[text()='Begin Review']");
	public static By cancel_Close = By.xpath("//button[@title='Cancel and close']");
	public static By SO_Review_Tab = By.xpath("//*[@data-tab-name='SO Review']");
	public static By Move_to_CMS_Certification_Lead = By.xpath("//button[text()='Move to CMS Certification Lead']");
	public static By Move_to_DSS_Review = By.xpath("//button[text()='Move to DSS/DSG Review']");
	public static By approve_Package = By.xpath("//button[text()='Approve Package']");
	public static By closeOut_Package = By.xpath("//*[text()='Closeout Package']");
	public static By update_Failed_Error_Message = By.xpath("//*[text()='Update failed: Issuance to State Date must be completed to closeout package']");
	public static By edit_Issuance_To_StateDate = By.xpath("//button[@title='Edit Issuance to State Date']");
	public static By issuanceDate_Input = By.xpath("//label[text()='Issuance to State Date']/following::input[1]");
	public static By completed_Tab = By.xpath("//*[@data-tab-name='Completed']");
	public static By create_Folder = By.xpath("//button[text()='Create Folder']");
	public static By Box_Link = By.xpath("//a[@data-label='Box']");
	public static By documentUploaded_Successfully = By.xpath("//*[text()='Document successfully uploaded']");

	public static By withdrawn_Button = By.xpath("//button[text()='Withdraw']");
	public static By reason_For_Withdrawn = By.xpath("//select[@name='Reason_for_Withdraw']");
	public static By withdrawal_Comments = By.xpath("//*[text()='Withdrawal Comments']/following::input");
	public static By next_Button = By.xpath("//button[text()='Next']");
	public static By Status_Field = By.xpath("//*[text()='Status']/following::lightning-formatted-text[1]");
	public static By Sub_Status_Field = By.xpath("//*[text()='Sub-status']/following::lightning-formatted-text[1]");
	public static By Edit_Certification_Request_Date = By.xpath("//button[@title='Edit Certification Request Date']");
	public static By certificationPackage_Locked = By.xpath("//*[text()='The Certification Package is Completed and Locked.']");
	public static By Cancel_Button = By.xpath("//button[text()='Cancel']");
	public static By submittionDate_Field = By.xpath("//*[contains(text(),'Submission Date​')]/following::lightning-formatted-text[1]");
	
	public static By emailThread = By.xpath("//div[@data-testid='message-list']//a[2]");
	public static By emailHeader = By.xpath("//h3[@data-testid='subject']");
	public static By Re_assign_emailHeader = By.xpath("//h3[contains(text(),'Sandbox:')]");
	public static By emptyServer = By.xpath("//*[text()='Empty Server']");
	public static By emailAddressTextField = By.xpath("//label[text()='Email address']/following::input");
	
	public static By continueButton = By.xpath("//button[text()='Continue']");
	public static By passwordTextField = By.xpath("//label[text()='Password']/following::input");
	public static By loginButtonEmail = By.xpath("//button[text()='Log in']");
//	public static By dateRecieved = By.xpath("//tbody/tr/td[2]/div/div[2]/p");
	public static By dateRecieved = By.xpath("//div[@data-testid='message-list']//a[2]//div[3]");
	public static By emailBody = By.xpath("//div[@data-testid='email-html-viewer']");
	
	
	public static By other_Reason_Without_Comments = By.xpath("//*[text()='Comments are required when \"Other\" is selected as the Reason for Withdraw.']");
	public static By goBackButton = By.xpath("//*[text()='Go back']");
	public static By CT_Tab = By.xpath("(//*[@title='Certification Workflow'])[last()]");
	public static By dropShadow = By.xpath("//*[contains(@filter, 'drop-shadow')]");
	public static By insertShadow = By.xpath("//*[contains(@filter, 'inset-shadow')]");
	
//	public static By decisionPackageWorkFlow = By.xpath("gbjbjgfnbkgfkj");
//	public static By decisionPackageWorkFlow = By.xpath("gbjbjgfnbkgfkj");
//	public static By decisionPackageWorkFlow = By.xpath("gbjbjgfnbkgfkj");
//	public static By decisionPackageWorkFlow = By.xpath("gbjbjgfnbkgfkj");
//	public static By decisionPackageWorkFlow = By.xpath("gbjbjgfnbkgfkj");
//	public static By decisionPackageWorkFlow = By.xpath("gbjbjgfnbkgfkj");
//	public static By decisionPackageWorkFlow = By.xpath("gbjbjgfnbkgfkj");
//	public static By decisionPackageWorkFlow = By.xpath("gbjbjgfnbkgfkj");
//	public static By decisionPackageWorkFlow = By.xpath("gbjbjgfnbkgfkj");
//	public static By decisionPackageWorkFlow = By.xpath("gbjbjgfnbkgfkj");
//	public static By decisionPackageWorkFlow = By.xpath("gbjbjgfnbkgfkj");
	
	
	
}
