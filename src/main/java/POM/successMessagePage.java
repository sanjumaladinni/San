package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class successMessagePage {

	WebDriver driver;

	public successMessagePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	
	@FindBy(css = "[class=\"headcolor\"]")
	WebElement successMessage;
	
	public loginpage  verifyAccountCreationMessage() {
		String AccountsuccessMessage = successMessage.getText();
		System.out.println(AccountsuccessMessage);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		loginpage lp = new loginpage(driver);
		return lp;
	}
	
}
