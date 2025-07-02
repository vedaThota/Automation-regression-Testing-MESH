package com.Locators;

import org.openqa.selenium.By;

public interface DecisionPackage_Loc {
	public static final By decisionPackages = By.xpath("(//*[text()='Decision Packages'])[last()]");
	public static final By newDecisionPackage = By.xpath("//a[@title='New']");
	public static final By State_Medicaid_Agency_Input = By
			.xpath("//*[text()='State Medicaid Agency']/following-sibling::div//input");
	public static final By State_Medicaid_Agency_Option = By
			.xpath("//*[text()='State Medicaid Agency']/following::lightning-base-combobox-item");
	public static final By Submission_Type = By.xpath("//*[text()='Submission Type']/following-sibling::div//button");
	public static final By SubmissionTypeOption_APD = By.xpath(
			"//*[text()='Submission Type']/following-sibling::div//button/following::lightning-base-combobox-item//span[text()='APD']");
	public static final By SubmissionTypeOption_RFP = By.xpath(
			"//*[text()='Submission Type']/following-sibling::div//button/following::lightning-base-combobox-item//span[text()='RFP']");
	public static final By SubmissionTypeOption_Contract = By.xpath(
			"//*[text()='Submission Type']/following-sibling::div//button/following::lightning-base-combobox-item//span[text()='Contract']");
	public static final By submitDate = By.xpath("//*[text()='Submission Date']/following-sibling::div//input");
	public static final By acknowledgementDate = By
			.xpath("//*[text()='Acknowledgement Date']/following-sibling::div//input");
	public static final By submitButton = By.xpath("//button[text()='Submit']");
	public static final By State_Medicaid_Agency_is_required = By
			.xpath("//*[text()='State Medicaid Agency is required.']");
	public static final By Submission_Type_is_required = By.xpath("//*[text()='Submission Type is required.']");
	public static final By At_least_one_Funding_Type_must_be_selected = By
			.xpath("//*[text()='At least one Funding Type must be selected.']");
	public static final By Submission_Date_is_required = By
			.xpath("//*[text()='Submission Date must be today or earlier.']");
	public static final By Acknowledgement_Date_is_required = By
			.xpath("//*[text()='Acknowledgement date cannot be a future date.']");
	public static final By At_least_one_OpDiv_must_be_selected = By
			.xpath("//*[text()='At least one OpDiv must be selected.']");
	public static final By Maximum_file_size_is_4MB = By.xpath("//*[contains(text(), 'Maximum file size is 4MB.')]");
	public static final By New_Decision_Package_Form = By.xpath("//div[@aria-label='New Decision Package Form']");
	public static final By Emergency_Request = By.xpath("//label[text()='Emergency Request']/following::label[1]/span");
	public static final By fundType_E_E = By.xpath("// *[text()='E&E']/preceding-sibling::span");
	public static final By oPsDiv_HHS = By.xpath("//*[text()='HHS']/preceding-sibling::span");
	public static final By uploadFiles = By.xpath("(//*[text()='Upload Files']/lightning-primitive-icon)[last()]");
	public static final By done_Button = By.xpath("//*[text()='Done']/..");
	public static final By successMessage = By
			.xpath("//*[contains(text(), 'The Decision Package has been Created Sucessfully')]");
	public static final By decisionPackageTitle = By
			.xpath("//*[text()='Decision Package']/following::lightning-formatted-text[1]");
	
	public static final By Edit_Recommended_Action = By.xpath("//button[@title='Edit Recommended Action']");
	public static final By Recommended_Action = By.xpath("//button[@aria-label='Recommended Action']");
	public static final By Approve_Option = By.xpath("//*[@data-value='Approve']");
	public static final By save_Button = By.xpath("(//button[text()='Save'])[last()]");
	public static final By State_Medicaid_Director_Input =  By.xpath("//label[text()='State Medicaid Director']/following::input[1]");
	public static final By state_Medicaid_Director_Option = By.xpath("//label[text()='State Medicaid Director']/following::input[1]/following::ul[1]//lightning-base-combobox-item[1]/span[2]/span/lightning-base-combobox-formatted-text");
	public static final By APD_Type = By.xpath("//span[@title='Planning Advanced Planning Document (PAPD)']");
	public static final By APD_Type_Option = By.xpath("//span[@title='Planning Advanced Planning Document (PAPD)']/following::button");
	
	public static final By APD_Update_Type = By.xpath("//span[@title='Initial Submission']");
	public static final By APD_Update_Type_Add_Button = By.xpath("//span[@title='Initial Submission']/following::button");
	public static final By event_Summary_TextArea = By.xpath("//*[text()='Executive Summary']/../following-sibling::div/div/div[3]/div");
	public static final By event_Summary_TextArea_AfterClick = By.xpath("//div[contains(@class, 'ql-editor ql-blan')]");
	public static final By estimatedAmount = By.xpath("//label[text()='Estimated Funding Request']/following-sibling::div/input");
	public static final By approveChoosen = By.xpath("//lightning-formatted-text[text()='Approve']");
	public static final By APD_Type_Choosen = By.xpath("//lightning-formatted-text[text()='Planning Advanced Planning Document (PAPD)']");
	public static final By APD_Update_Type_Choosen = By.xpath("//lightning-formatted-text[text()='Initial Submission']");
	public static final By event_Summary_Entered = By.xpath("//p[text()='Event Summary Added']");
	public static final By stateMedicaidDirector_selected = By.xpath("//*[text()='State Medicaid Director']/following::a[1]/span//span//span");
	public static final By State_Medicaid_Agency = By.xpath("(//*[text()='State Medicaid Agency']/following::a[1]/span//span//span)[last()]");
	
	public static final By acknowledgementDate_LabelText = By.xpath("//*[text()='Acknowledgment Date']/following::lightning-formatted-text[1]");
	public static final By dueDate = By.xpath("//*[text()='Due Date']/following::lightning-formatted-text[1]");
	public static final By daysUntilDue = By.xpath("//*[text()='Days Until Due']/following::lightning-formatted-number[1]");
	public static final By edit_Emergency_Request = By.xpath("//button[@title='Edit Emergency Request']");
	public static final By emergency_Request_CheckBox = By.xpath("//*[text()='Emergency Request']/following::input[1]");
	public static final By ContractNumber = By.xpath("//label[text()='Contract Number']/following::input[1]");
	public static final By Total_ContractValue = By.xpath("//label[text()='Total Contract Value']/following::input[1]");
	public static final By contractType = By.xpath("//label[text()='Contract Type']//following::button");
	public static final By contracType_SoleSource = By.xpath("//span[text()='Sole Source']");
	public static final By vendor = By.xpath("//*[text()='Vendor']/following::input");
	public static final By vendorOption = By.xpath("//*[text()='Vendor']/following::input/following::ul/li[1]//lightning-base-combobox-formatted-text");
	public static final By claimsProcessing_CheckBox = By.xpath("//*[text()='Claims Processing']/following::input[1]");
	public static final By auditingCheckBox = By.xpath("//*[text()='Auditing']/following::input[1]");
	
	public static final By RelatedProjects_button = By.xpath("//*[contains(text(), 'Related Projects')]//following::button[1]");
	public static final By New_Link = By.xpath("//*[text()='New']");
	public static final By MDBT_Project_Tab_Name = By.xpath("//*[text()='MDBT Project Tab Name']/following::input");
	public static final By NewProject = By.xpath("//*[text()='New Project']");
	public static final By newProject_MDBT_Project_Tab_Name = By.xpath("//*[text()='Project Details']//following::*[text()='MDBT Project Tab Name']/following::input");
	public static final By newProject_FullName = By.xpath("//*[text()='Project Details']//following::*[text()='Full Project Name']/following::input");
	public static final By newProject_State_Medicaid_Agency = By.xpath("//*[text()='Project Details']//following::*[text()='State Medicaid Agency']/following::input");
	public static final By fundingType_EandE = By.xpath("//*[text()='Project Details']//following::*[text()='E&E']");
	public static final By newProject_FundType_AddButton = By.xpath("//*[text()='Project Details']//following::*[text()='E&E']/following::button[1]");
	public static final By systemTypeButton = By.xpath("//*[text()='System Type']//following::button[2]");
	public static final By newSystem = By.xpath("//*[text()='System Type']//following::button[2]/following::*[text()='New System']");
	public static final By newProject_State_Medicaid_Agency_Option = By.xpath("//*[text()='Project Details']//following::*[text()='State Medicaid Agency']/following::input/following::ul/li/lightning-base-combobox-item");
	
	public static final By beginReview = By.xpath("//*[text()='Begin Review']");
	public static final By stateOfficerReview = By.xpath("//*[text()='Status']/following::lightning-formatted-text[text()='State Officer Review']");
	public static final By inReview = By.xpath("//*[text()='Sub-Status']/following::lightning-formatted-text[text()='In Review']");
	public static final By estimatedFundingRequested = By.xpath("//*[text()='Estimated Funding Requested']/following::lightning-formatted-text[1]");
	public static final By totalContractValue = By.xpath("//*[text()='Total Contract Value']/following::lightning-formatted-text[1]");
	public static final By DetailsTab = By.xpath("//*[text()='Details']");
	
	public static final By generateTemplate = By.xpath("//*[text()='Generate Template']");
	public static final By selectATemplate = By.xpath("//*[text()='Select a Template']/following::button");
	public static final By templateFirstOption = By.xpath("//*[text()='Select a Template']/following::button/following::lightning-base-combobox-item");
	public static final By generateWordDocument = By.xpath("//*[text()='Generate Word Document']");
	
	public static final By fileUploadNewButton = By.xpath("//button[@data-resin-target='share']/preceding::button[@aria-label='New']");
	public static final By fileUploadButton = By.xpath("//*[text()='File Upload']/parent::li");
	public static final By boxFrame = By.xpath("//iframe[@title='Box Embed Widget']");
	public static final By parentBoxFrame = By.xpath("//iframe[contains(@class,'boxRecordBoxFolder')]");
	
	public static final By selectFile = By.xpath("//div[@class='SelectCheckboxButton']/following-sibling::div[@aria-label='File']");
	public static final By fileCheckbox = By.xpath("//div[@class='SelectCheckboxButton']/span/div");
	public static final By moreOptions = By.xpath("//button[@aria-label='More Options']");
	public static final By downloadButton = By.xpath("//*[@data-target-id='MenuItem-download']");
//	public static final By fileUploadNewButton = By.xpath("");
//	public static final By fileUploadNewButton = By.xpath("");
	
	
	
	
	
}