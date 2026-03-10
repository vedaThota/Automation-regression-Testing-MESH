package com.Locators;

import org.openqa.selenium.By;

public interface HomePage_Loc {
	
	public static final By setUpIcon = By.xpath("//*[@icon-name='utility:setup']");
	public static final By setUpLink = By.xpath("//a[@title='Setup']");
	public static final By userSideMenu = By.xpath("//div[@title='Users']/button");
	public static final By userLink = By.xpath("(//div[@title='Users'])[last()]/a");
	public static final By userList_T = By.xpath("//*[@class='listItemPad'][text()='T']/parent::a");
	public static final By userList_O = By.xpath("//*[@class='listItemPad'][text()='O']/parent::a");
	public static final By userList_M = By.xpath("//*[@class='listItemPad'][text()='M']/parent::a");
	public static final By userList_S = By.xpath("//*[@class='listItemPad'][text()='S']/parent::a");
	public static final By userList_J = By.xpath("//*[@class='listItemPad'][text()='J']/parent::a");
	public static final By userList_D = By.xpath("//*[@class='listItemPad'][text()='D']/parent::a");
	public static final By userList_G = By.xpath("//*[@class='listItemPad'][text()='G']/parent::a");
	public static final By userList_F = By.xpath("//*[@class='listItemPad'][text()='F']/parent::a");
	public static final By userList_H = By.xpath("//*[@class='listItemPad'][text()='H']/parent::a");
	public static final By userList_E = By.xpath("//*[@class='listItemPad'][text()='E']/parent::a");
	public static final By oPsTeam_Login_Link = By.xpath("//a[text()='Ops Team, Test']/../preceding-sibling::td/a[text()='Login']");
	public static final By Decision_Packages = By.xpath("//a[@title='Decision Packages']");
	public static final By allUsersFrame = By.xpath("(//iframe[@title='All Users ~ Salesforce - Unlimited Edition'])[last()]");
	public static final By userList_V = By.xpath("//*[@class='listItemPad'][text()='V']/parent::a");
	public static final By ThotaVEda_Login_Link = By.xpath("//a[contains(text(), 'Thota, Veda')]/../preceding-sibling::td/a[text()='Login']");
	public static final By Melendez_Login_Link = By.xpath("//a[text()='Melendez, Ricardo']/../preceding-sibling::td/a[text()='Login']");
	public static final By Brandy_Login_Link = By.xpath("//a[text()='Spaulding, Brandy']/../preceding-sibling::td/a[text()='Login']");
	public static final By Purvi_Login_Link = By.xpath("//a[text()='Dholakia, Purvi']/../preceding-sibling::td/a[text()='Login']");
	public static final By Johnson_Login_Link = By.xpath("//a[text()='Johnson, Alejandra']/../preceding-sibling::td/a[text()='Login']");
	public static final By Gabriyelov_Login_Link = By.xpath("//a[text()='Gabriyelov, Eugene']/../preceding-sibling::td/a[text()='Login']");
	public static final By Alimu_Login_Link = By.xpath("//a[text()='Haimiti, Alimu']/../preceding-sibling::td/a[text()='Login']");
	public static final By johnson_Login_Link = By.xpath("//a[text()='Johnson, Alejandra']/../preceding-sibling::td/a[text()='Login']");
	public static final By Walter_Login_Link = By.xpath("//a[text()='Ellis, Walter']/../preceding-sibling::td/a[text()='Login']");

	public static final By stateOfficer_LoginLink = By.xpath("//a[text()='State Officer 01, Test']/../preceding-sibling::td/a[text()='Login']");
	public static final By deputyDirector_LoginLink = By.xpath("//a[contains(text(), 'Deputy Director')]/../preceding-sibling::td/a[text()='Login']");
	public static final By FM_Reviewer_loginLink = By.xpath("//a[contains(text(), 'FM Reviewer')]/../preceding-sibling::td/a[text()='Login']");
	public static final By division_Director_LoginLink = By.xpath("//a[contains(text(), 'Division Director')]/../preceding-sibling::td/a[text()='Login']");
	
//	public static final By appLauncher = By.xpath("//*[@title='App Launcher']");
	public static final By searchApps_Items = By.xpath("//input[@placeholder='Search apps and items...']");
	public static final By Escalation_Tracking_Link = By.xpath("(//b[text()='Escalation Tracking'])[last()]");
	public static final By SDPTrackerButton = By.xpath("//a[@data-label='SDP Tracker']");
	public static By cmcs_PRA_Tracker = By.xpath("//a[@data-label='CMCS PRA Tracker']");
	
	public static final By edit_EscalationTracking = By.xpath("//button[@title='Edit Escalation Tracking']");
	public static final By check_Escalation_Tracking = By.xpath("//input[@name='Escalation_Tracking__c']");
	public static final By save_Button = By.xpath("//*[text()='Save']");
	
	public static final By recentlyViewed = By.xpath("//span[text()='Recently Viewed']");
	public static final By allOption = By.xpath("//lightning-base-combobox-item[@data-value='All']");
	public static final By searchList = By.xpath("//input[@aria-label='Search this list...']");
	public static final By userProfile = By.xpath("//span[contains(@class, 'userProfileCardTriggerRoot')]//button");
	public static final By logOutButton = By.xpath("//a[text()='Log Out']");
	public static final By logout_AS = By.xpath("//a[contains(text(), 'Log out as ')]");
	public static final By recently_Viewed = By.xpath("//*[text()='Recently Viewed']");
	public static final By All_CW = By.xpath("//*[@title='All']");
	public static final By search_CW_text_Field = By.xpath("//input[@placeholder='Search this list...']");
	
	public static final By begin_Review = By.xpath("//*[text()='Begin Review']");
//	public static final By setUp = By.xpath("");
//	public static final By setUp = By.xpath("");
//	public static final By setUp = By.xpath("");
//	public static final By setUp = By.xpath("");
//	public static final By setUp = By.xpath("");

}
