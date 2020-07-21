package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//h1[contains(text(),'Obsolete Page')]")
	WebElement Sales_userNameLable;
	
	@FindBy(xpath="//a[contains(@title,'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontactlink;
	
	@FindBy(xpath="//a[contains(@title,'Opportunities')]")
	WebElement opportunitiesLink;
	
	@FindBy(xpath="//a[contains(@title,'Tasks')]")
	WebElement tasksLink;
	
	
	public HomePage(){
		PageFactory.initElements(driver,this);
	}
	
	public String verifyhomepagetitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifycorrectuserSales(){
		return Sales_userNameLable.isDisplayed();
	}
	
	
	public ContactsPage ClickOnContactLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	public void ClickOnNewContactsLink(){
		Actions actions=new Actions(driver);
		actions.moveToElement(contactsLink).build().perform();
		newcontactlink.click();
		
	}
	
	public OpportunitiesPage ClickOnOpportunitiesLink(){
		opportunitiesLink.click();
		return new OpportunitiesPage();
	}
	
	public TasksPage ClickOnTaskLink(){
		tasksLink.click();
		return new TasksPage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
