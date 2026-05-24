package san;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDown {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hdfc.bank.in/");
		
		  
		  driver.findElement(By.xpath("//a[@data-labeltext=\"Discover Products\"]")). click(); //
		  driver.findElement(By.xpath("//a[@data-labeltext=\"Deposits\"]")).click();
		 
		List<WebElement> list = driver.findElements(
				By.xpath("//div[@class=\"rightMenu headcustom-scroll level4accountWrapp show\"]//div//li"));

		for (WebElement e : list) {
			System.out.println(e.getText());
			if (e.getText().equalsIgnoreCase("Overdraft Against Fixed Deposits")) {
				e.click();
				break;
			}
		}

	}

}
