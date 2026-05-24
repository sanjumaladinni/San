package TestCaseClass1;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;



public class TestCasePage {

	@Test
	public void test() {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		// Register page
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.findElement(By.cssSelector("#firstName")).sendKeys("Sanju");
		driver.findElement(By.cssSelector("#lastName")).sendKeys("maladinni");
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("sanju@1gamil.com");
		driver.findElement(By.cssSelector("#userMobile")).sendKeys("9343111111");

		WebElement occupation = driver.findElement(By.xpath("//select[@formcontrolname=\"occupation\"]"));
		Select sel = new Select(occupation);
		sel.selectByContainsVisibleText("Doctor");

		String gender = "Male";

		driver.findElement(By.xpath("//input[@value='" + gender + "']")).click();

		driver.findElement(By.cssSelector("#userPassword")).sendKeys("Sanju@123!@#");
		driver.findElement(By.cssSelector("#confirmPassword")).sendKeys("Sanju@123!@#");
		driver.findElement(By.cssSelector("[formcontrolname=\"required\"]")).click();
		driver.findElement(By.cssSelector("[value=\"Register\"]")).click();

		// verify account creation message
		String successMessage = driver.findElement(By.cssSelector("[class=\"headcolor\"]")).getText();
		System.out.println(successMessage);
		assertEquals(successMessage, "Account Created Successfully");
		driver.findElement(By.xpath("//button[text()='Login']")).click();

		// login page
		driver.findElement(By.id("userEmail")).sendKeys("Sanju@123!@#");
		driver.findElement(By.id("userPassword")).sendKeys("Sanju@123!@#");
		driver.findElement(By.id("login")).click();

		// forget password page
		driver.findElement(By.xpath("//a[contains(text(),'Forgot password?')]")).click();

	}

}
