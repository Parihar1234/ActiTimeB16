package actiTimeTest;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import actiTimeLib.BaseTest;
import actiTimePO.ActiTimeLoginPagePO;


public class TestLogin extends BaseTest {
	private static final String TEST_URL = null;

	@Test(priority=1)
	public void testValidCredentials() {
		try {
			driver.get(TEST_URL);
			ActiTimeLoginPagePO loginPO = new ActiTimeLoginPagePO(driver);
			loginPO.login("shilpaparihar391", "shilpa391");
String eTitle="actiTIME - Enter Time-Track";
loginPO.checkTitle(eTitle);
String aTitle = driver.getTitle();
Assert.assertEquals(aTitle, eTitle);
		} catch (Exception e) {
		e.printStackTrace();
		Reporter.log("Exception Generated",true);
		Assert.fail();
		}
	
	}
	@Test(priority=2)
	public void testInvalidUn() {
		try {
			driver.get(TEST_URL);
			ActiTimeLoginPagePO loginPO=new ActiTimeLoginPagePO(driver);
			loginPO.login("shilpaparihar", "shilpa391");
			loginPO.checkWebElement(loginPO.errorMsg());
			boolean aStatus = loginPO.errorMsg().isDisplayed();
			boolean eStatus= true;
			Assert.assertEquals(aStatus, eStatus);			
		} catch (Exception e) {			
			e.printStackTrace();
			Reporter.log("Exception generated", true);
			Assert.fail();
		}	
		
	}
	
	@Test(priority=3)
	public void testInvalidPw() {
		try {
			driver.get(TEST_URL);
			ActiTimeLoginPagePO loginPO=new ActiTimeLoginPagePO(driver);
			loginPO.login("shilpaparihar391", "shilpa");
			loginPO.checkWebElement(loginPO.errorMsg());
			boolean aStatus = loginPO.errorMsg().isDisplayed();
			boolean eStatus= true;
			Assert.assertEquals(aStatus, eStatus);			
		} catch (Exception e) {			
			e.printStackTrace();
			Reporter.log("Exception generated", true);
			Assert.fail();
		}	
		
	}

	
}
