package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(css = "#firstName")
	WebElement firstName;

	@FindBy(css = "#lastName")
	WebElement lastName;

	@FindBy(css = "#userEmail")
	WebElement userEmail;

	@FindBy(css = "#userMobile")
	WebElement userMobile;

	@FindBy(xpath = "//select[@formcontrolname=\"occupation\"]")
	WebElement occupation;

	@FindBy(css = "#userPassword")
	WebElement passWord;

	@FindBy(css = "#confirmPassword")
	WebElement ConfirmationPassWord;

	@FindBy(css = "[formcontrolname=\"required\"]")
	WebElement checkBox;
	
	@FindBy(css = "[value=\"Register\"]")
	WebElement Register;

	public void enterUserpassword(String userpassWord) {
		passWord.sendKeys(userpassWord);
	}

	public void enterConfimationUserpassword(String userConfirmationPassWord) {
		ConfirmationPassWord.sendKeys(userConfirmationPassWord);
	}

	public void clickOclickOnCheckBoxn() {
		checkBox.click();
	}

	public void SelectOccupation() {
		Select sel = new Select(occupation);
		sel.selectByContainsVisibleText("Doctor");
	}

	public void SelectGender(String gender) {
		driver.findElement(By.xpath("//input[@value='" + gender + "']")).click();
	}

	

	public void selectFirstName(String FirstName) {
		firstName.sendKeys(FirstName);
	}

	public void selectLastName(String LastName) {
		lastName.sendKeys(LastName);
	}

	public void selectEmailName(String Email) {
		userEmail.sendKeys(Email);

	}

	public void selectuserMobileName(String mobileNO) {
		userMobile.sendKeys(mobileNO);
		
	}
	public successMessagePage clicOnRegisterbutton() {
		Register.click();
		successMessagePage sm = new successMessagePage(driver);
		return sm;
	}

}
