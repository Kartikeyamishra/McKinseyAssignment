package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

	@FindBy(xpath="//android.widget.TextView[@text='Main']")
	private WebElement mainBtn;
	
	WebDriver driver;
	
	public MainPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, MainPage.class);
	}
	
	public void VerifySuccessfulLogin(){
		mainBtn.isDisplayed();
	}
}
