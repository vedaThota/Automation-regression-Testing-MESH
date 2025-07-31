package com.Locators;

import org.openqa.selenium.By;

public interface HomePage_Loc {
	
	public static final By setUpIcon = By.xpath("//*[@icon-name='utility:setup']");
	public static final By setUpLink = By.xpath("//a[@title='Setup']");
	public static final By userSideMenu = By.xpath("//div[@title='Users']/button");
	public static final By userLink = By.xpath("(//div[@title='Users'])[last()]/a");
	public static final By userList_T = By.xpath("//*[@class='listItemPad'][text()='T']/parent::a");
	public static final By oPsTeam_Login_Link = By.xpath("//a[text()='Test, Ops Team']/../preceding-sibling::td/a[text()='Login']");
	public static final By Decision_Packages = By.xpath("//a[@title='Decision Packages']");
	public static final By allUsersFrame = By.xpath("(//iframe[@title='All Users ~ Salesforce - Unlimited Edition'])[last()]");
	public static final By userList_V = By.xpath("//*[@class='listItemPad'][text()='V']/parent::a");
	public static final By ThotaVEda_Login_Link = By.xpath("//a[contains(text(), 'Thota, Veda')]/../preceding-sibling::td/a[text()='Login']");

//	public static final By setUp = By.xpath("");
//	public static final By setUp = By.xpath("");
//	public static final By setUp = By.xpath("");
//	public static final By setUp = By.xpath("");
//	public static final By setUp = By.xpath("");
//	public static final By setUp = By.xpath("");
//	public static final By setUp = By.xpath("");

}
