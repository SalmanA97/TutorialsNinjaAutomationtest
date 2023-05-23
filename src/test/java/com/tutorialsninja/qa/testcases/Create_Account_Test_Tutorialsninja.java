package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tutorialsninja.qa.Utils.Utilities;
import com.tutorialsninja.qa.testbase.TestBase;

public class Create_Account_Test_Tutorialsninja extends TestBase {
	public Create_Account_Test_Tutorialsninja() throws Exception {
		super();
		
	}

	public WebDriver driver;
	public SoftAssert softassert = new SoftAssert();

@BeforeMethod
public void setUp() {
	driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
	driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
    driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/ul/li[1]/a")).click();
}  

@Test(priority = 1)
public void enterAllValidFeilds() {
driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("FirstName"));
driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("LastName"));
driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("TelephoneNumber"));
driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("ValidPassword"));
driver.findElement(By.id("input-confirm")).sendKeys(dataprop.getProperty("ConfirmValidPassword"));
driver.findElement(By.xpath("/html/body/div[2]/div/div/form/fieldset[3]/div/div/label[2]/input")).click();
driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div/input[1]")).click();
driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div/input[2]")).click();
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
@AfterMethod	
public void tearDown() {	
driver.quit();
}	
}	
	