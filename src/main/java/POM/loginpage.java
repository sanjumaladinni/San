package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	WebDriver driver;

	public loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "userEmail")
	WebElement userEmail;
	
	@FindBy(id = "userPassword")
	WebElement userPassword;
	
	@FindBy(id = "login")
	WebElement login;
	
	
	public void enterUsermail(String LoginUserMail) {
		userEmail.sendKeys(LoginUserMail);
	}
	public void enterUserPassword(String LoginUserPassword) {
		userPassword.sendKeys(LoginUserPassword);
	}
	public void clickOnLoginButton() {
		login.click();
	}
}
