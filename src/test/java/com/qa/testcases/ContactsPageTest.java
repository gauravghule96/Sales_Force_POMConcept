/*
 * author: Gaurav Ghule
 */


package com.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.utility.TestUtils;


public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtils testutils;
	ContactsPage contactpage;
	
	String sheetName="ContactsData";
	
	
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
	    testutils=new TestUtils();
	    contactpage=new ContactsPage();
		loginpage=new LoginPage();
		homepage=loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
		//testutils.switchToFrame();
		contactpage=homepage.ClickOnContactLink();
	}
	@Test(priority=1)
	public void verifyContactsPageLableTest(){
		Assert.assertTrue(contactpage.verifyContactsLable(),"contact lable is missing on page");
	}
	
	@Test(priority=2)
	public void selectContactsTest(){
		contactpage.SelectContactsByName("Edward Stamos (Sample)");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest(){
		contactpage.SelectContactsByName("Edward Stamos (Sample)");
		contactpage.SelectContactsByName("Jane West (Sample)");
	}
	
	@DataProvider
	public Object[][] getTestDataByDP() throws InvalidFormatException{
		Object data[][] = TestUtils.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=4, dataProvider="getTestDataByDP")
	public void validateCreateNewContact(String Salutations, String firstName, String lastName, String emailID){
		homepage.ClickOnNewContactsLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactpage.createNewContact(Salutations, firstName, lastName, emailID);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}


}
