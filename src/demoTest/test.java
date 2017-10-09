package demoTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utility.FileRead;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class test {

	WebDriver driver;
	String FilePath="C:/Users/kmishra/workspace/Demo/src/TestData.properties";

	@BeforeClass
	public void configuration() throws MalformedURLException{
		File app = new File("C:/Users/kmishra/Downloads/app-debug.apk");
		DesiredCapabilities capabilites = new DesiredCapabilities();
		//capabilites.setCapability("BROWSER_NAME", "Android");
		capabilites.setCapability("VERSION", "6.0");
		capabilites.setCapability("deviceName", "HYKJFUMZLRWOKVIV");
		capabilites.setCapability("platformName", "Android");
		capabilites.setCapability("app", app.getAbsolutePath());
	
		driver = new RemoteWebDriver( new URL("http://127.0.0.1:4723/wd/hub"), capabilites);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void loginTest() throws Exception{
		// Reading logIn credentail from TestData.properties file 
		
		FileRead fileread=new FileRead(FilePath);
		String username=fileread.getData("username");
		String password=fileread.getData("password");
		
		HomePage homepage=new HomePage(driver);
		LoginPage loginpage=new LoginPage(driver);
		MainPage mainpage=new MainPage(driver);
		
		homepage.clickOnexistingUser();
		
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickOnLoginBtn();
		//verification after successfull login that next screen is appeared or not 
		mainpage.VerifySuccessfulLogin();
	}
	
	@AfterMethod
	public void afterMethod() throws Exception {
		driver.quit();
	}

}

