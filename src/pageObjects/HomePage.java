package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath="//android.widget.TextView[@text='Already have an account?']")
	private WebElement existingUser;
	
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, HomePage.class);
	}
	
	public LoginPage clickOnexistingUser(){
		existingUser.click();
		return new LoginPage(driver);
	}
	

}
