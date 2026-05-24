package TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import POM.RegisterPage;

public class BaseClass {
	public WebDriver driver;
	Properties prop;
	FileInputStream file;

	public void initializer() throws IOException {
		prop = new Properties();
		file = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//source//Data.properties");
		prop.load(file);

		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.get("https://rahulshettyacademy.com/client/#/auth/register");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	}

	public static List<HashMap<String, String>> jsonReader(String filePath) throws IOException {
		File file = new File(filePath);
		String jsonReader = FileUtils.readFileToString(file, StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonReader,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;

	}

	public RegisterPage loginURL() throws IOException {
		initializer();
		driver.get("https://rahulshettyacademy.com/client/#/auth/register");
//		driver.get(prop.getProperty("url"));
		RegisterPage rp = new RegisterPage(driver);
		return rp;
	}

}
