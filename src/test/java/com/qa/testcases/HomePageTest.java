package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.TasksPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.OpportunitiesPage;
import com.qa.pages.ContactsPage;
import com.utility.TestUtils;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtils testutils;
	ContactsPage contactpage;
	
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
	    testutils=new TestUtils();
	    contactpage=new ContactsPage();
		loginpage=new LoginPage();
		homepage=loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verfiyHomePagetitleTest(){
		String homepagetitle=homepage.verifyhomepagetitle();
		Assert.assertEquals(homepagetitle, "Verify Your Identity | Salesforce","Home Page title not match");
	}
	
	@Test(priority=2)
	public void  verifyUserNameTest(){
		//testutils.switchToFrame();
		Assert.assertTrue(homepage.verifycorrectuserSales());
	}
	
	@Test(priority=3)
	public void verifyContactLinkTest(){
		//testutils.switchToFrame();
		contactpage=homepage.ClickOnContactLink();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
