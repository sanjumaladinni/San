package TestCaseClass1;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.RegisterPage;
import POM.loginpage;
import POM.successMessagePage;
import TestComponent.BaseClass;

public class TestCasePageTestPOM extends BaseClass {
	
	@Test(dataProvider = "dataProvider")
	public void test(HashMap<String,String> input) throws IOException {

		// Register page
		RegisterPage rp=loginURL();
		
		rp.clicOnRegisterbutton();
		rp.selectFirstName(input.get("firstName"));
		rp.selectLastName(input.get("lastName"));
		rp.selectEmailName(input.get("emailName"));
		rp.selectuserMobileName(input.get("mobileName"));
		rp.SelectOccupation();
		
		rp.SelectGender(input.get("gender"));
		rp.enterUserpassword(input.get("userPassword"));
		rp.enterConfimationUserpassword(input.get("confirmationUserPassword"));
		rp.clickOclickOnCheckBoxn();

		successMessagePage sm = rp.clicOnRegisterbutton();
		loginpage lp = sm.verifyAccountCreationMessage();
		lp.enterUsermail(input.get("enterUserMail"));
		lp.enterUserPassword(input.get("enterUserPassword"));
		lp.clickOnLoginButton();

	}
	
	@DataProvider  
	public Object [] [] dataProvider() throws IOException {
		List<HashMap<String, String>> data =
				jsonReader(System.getProperty("user.dir")
				+"//src//test//java//dataProvieder//JsonData.json");		
		return new Object [] [] {{data.get(0)}};
		
	}

}
