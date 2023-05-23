package com.tutorialsninja.qa.testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tutorialsninja.qa.Utils.Utilities;
import com.tutorialsninja.qa.testbase.TestBase;

public class Login_Test_Tutorialsninja<HardAssert> extends TestBase{

	public Login_Test_Tutorialsninja() throws Exception {
		super();
	
	}

	public WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp () {
	    
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/ul/li[2]/a")).click();
	}
	
	
	    @Test (priority = 1)
	public void VerifyingLoginTestwithValidUserNameAndPassWord () {
	      driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validUsername"));
	      driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
	      driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
	      driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/ul/li[2]/a")).click();
	      driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/form/input")).click();
	      

	    }
	
	@Test (priority = 2)
	public void VerifyingLoginTestwithInValidUserNameAndInvalidPassWord () {
		
	   driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
	   driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("InValidPassword"));
	   driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/form/input")).click();
	   String actualWarningMessage = driver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText();
	   String expectedWarningMessage = dataprop.getProperty("WrongCredentialsMessage");
       softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Warning message is not correct");	
	  softassert.assertAll();
	   
	}
	@Test (priority = 3)
	public void VerifyingLoginTestwithValidUserNameAndInValidPassWord () {
		
	    driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validUsername"));
	    driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("InValidPassword"));
	    driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/form/input")).click();
	    String actualWarningMessage = driver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText();
	    String expectedWarningMessage = dataprop.getProperty("WrongCredentialsMessage");
        softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Warning message is not correct");	
	    softassert.assertAll();
	
	}
	@Test (priority = 4)
	public void VerifyingLoginTestwithEmptyUserNameAndValidPassWord () {
		
	    driver.findElement(By.id("input-password")).sendKeys((prop.getProperty("validPassword")));
	    driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/form/input")).click();
	    String actualWarningMessage = driver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText();
	    String expectedWarningMessage = dataprop.getProperty("WrongCredentialsMessage");
        softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Warning message is not correct");	
	    softassert.assertAll();
	}
	@Test (priority = 5)
	public void VerifyingLoginTestwithValidUserNameAndEmptyPassWord () {
		
	    driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validUsername"));
	    driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/form/input")).click();
	    String actualWarningMessage = driver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText();
	    String expectedWarningMessage = dataprop.getProperty("WrongCredentialsMessage");
        softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Warning message is not correct");	
	    softassert.assertAll();
	}
	@Test (priority = 6)
	public void VerifyingLoginTestwithEmptyUserNameAndEmptyPassWord () {
	
	    driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/form/input")).click();
	    String actualWarningMessage = driver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText();
	    String expectedWarningMessage = dataprop.getProperty("WrongCredentialsMessage");
        softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Warning message is not correct");	
	    softassert.assertAll();
	}
	
	@AfterMethod
	public void tearDown() {
	driver.quit();
	
	}	
}
