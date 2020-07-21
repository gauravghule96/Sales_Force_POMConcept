package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//span[contains(@class,'slds-var-p-right_x-small "
			+ "uiOutputText forceBreadCrumbItem')]")
	WebElement contactLable;
	
	@FindBy(xpath="//input[@id='5835:0']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='5845:0']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='5958:0']")
	WebElement EmailID;
	
	@FindBy(xpath="//button[@title='Save']")
	WebElement Savebtn;
	
	
	

	public ContactsPage(){
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyContactsLable(){
		return contactLable.isDisplayed();
	}
	
	public void SelectContactsByName(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"'] //parent::td[@class='slds-cell-edit cellContainer']//preceding-sibling::td"
				+ "[@class='slds-cell-edit cellContainer']//input[@type='checkbox']")).click();;
	}
	
	public void createNewContact(String salutation,String fname,String lname,String email){
		Select select=new Select(driver.findElement(By.xpath("//a[@data-aura-rendered-by='5806:0']//parent::div")));
		select.deselectByVisibleText(salutation);
		
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		EmailID.sendKeys(email);
		Savebtn.click();
		
	}
	

	
	

}
