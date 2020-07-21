package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.utility.TestUtils;
import com.utility.WebEventListner;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties pro;
	public static EventFiringWebDriver e_driver;
	public static WebEventListner eventlistner;
	
	public TestBase(){
		try {
			pro=new Properties();
			FileInputStream ip=new FileInputStream("E:\\workspace2\\ShutterStock_MProj\\src\\main"
					+ "\\java\\com\\qa\\config\\Config.properties");
			pro.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName=pro.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chromedriver.driver", "chromedriver.exe");
			 driver=new ChromeDriver();
			 
		}else if (browserName.equals("FF")) {
			System.setProperty("webdriver.geckodriver.driver", "geckodriver.exe");
			 driver=new FirefoxDriver();
		}
		
		e_driver=new EventFiringWebDriver(driver);
		eventlistner=new WebEventListner();
		e_driver.register(eventlistner);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(pro.getProperty("url"));
		}
	
}
