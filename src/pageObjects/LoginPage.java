package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath="//android.widget.EditText[@text='User name']")
	private WebElement usernameField;
	
	@FindBy(xpath="//android.widget.EditText[@index='4']")
	private WebElement passwordField;
	
	@FindBy(xpath="//android.widget.TextView[@text='Log in']")
	private WebElement logInBtn;
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, LoginPage.class);
	}
	public void enterUsername(String username){
		usernameField.sendKeys("username");
	}
	public void enterPassword(String password){
		passwordField.sendKeys("password");
	}
	public void clickOnLoginBtn(){
		logInBtn.click();
	}
   

}
