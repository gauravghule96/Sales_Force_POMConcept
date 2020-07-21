package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Object(Object Reporsitory):
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='pw']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@alt='Salesforce']")
	WebElement imglogo;
	
	//page object intializing:
	public LoginPage(){
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateLoginPagetitle(){
		return driver.getTitle();
	}
	
	public boolean validateLogoImg(){
		return imglogo.isDisplayed();
	}
	
	public HomePage login(String uname,String pass){
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginBtn.click();
		return new HomePage();
		
	}
	


}
