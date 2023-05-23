package com.tutorialsninja.qa.testbase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninja.qa.Utils.Utilities;

public class TestBase {
public WebDriver driver;
public Properties prop;
public Properties dataprop;
public FileInputStream ip;


public TestBase() throws Exception {
	prop = new Properties();
    ip = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
    prop.load(ip);
    dataprop = new Properties();
    ip = new FileInputStream(System.getProperty("user.dir") +"\\src\\test\\java\\com\\tutorialsninja\\qa\\testData\\testData.properties");
    dataprop.load(ip);
    
}



public WebDriver initializeBrowserAndOpenApplication(String browsername) {
if(browsername.equalsIgnoreCase("chrome")) {
	driver = new ChromeDriver();
	}else if( browsername.equalsIgnoreCase("edge")) {
	driver = new EdgeDriver();
	}else if( browsername.equalsIgnoreCase("FireFox")) {
	driver = new FirefoxDriver();
}
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.impliWaitTime));
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.pageLoadTime));
driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Utilities.scriptTime));
driver.get(prop.getProperty("url"));
return driver;
}
	
	
}

