package san;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class drodownselect {
	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ixigo.com/?utm_source=Google_Search&utm_medium=paid_search_google&utm_campaign=AC_Mar_NewUser&gad_source=1&gad_campaignid=22367144869&gbraid=0AAAAAC5edWDO8urBkR9IpnrFzX_6FKFez&gclid=Cj0KCQjwh-HPBhCIARIsAC0p3ccopEjP35rtQigqott1WP9N-IlWkz8CH_FH8URGFDCL2dJ7tnKB6sgaApIPEALw_wcB");	
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//label[text()='From']")).click();
		List<WebElement> list = driver.findElements(By.xpath("//label[text()='From']//following::div[contains(@class,\"flex relative\")]"));
		
		for( WebElement e: list) {
			System.out.println(e.getText());
			
		}
		
		
	}

}
