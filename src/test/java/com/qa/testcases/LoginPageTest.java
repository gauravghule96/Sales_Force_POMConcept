package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest(){
		String title=loginpage.validateLoginPagetitle();
		Assert.assertEquals(title, "Login | Salesforce");
	}
	
	@Test(priority=2)
	public void SaleslogoImgtest(){
		boolean flag=loginpage.validateLogoImg();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest(){
		homepage=loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
