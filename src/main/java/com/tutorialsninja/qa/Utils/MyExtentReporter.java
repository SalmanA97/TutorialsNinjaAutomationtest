package com.tutorialsninja.qa.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyExtentReporter {
public static ExtentReports generateExtentReporter() throws Throwable {


	
ExtentReports extentReport = new ExtentReports();
File extentReportFile = new File(System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html");
ExtentSparkReporter sparkreporter = new ExtentSparkReporter(extentReportFile);
sparkreporter.config().setTheme(Theme.DARK);
sparkreporter.config().setReportName("TUTORIALSNINJA TEST RESULTS");
sparkreporter.config().setDocumentTitle("TutorialsNinjaAutomationTest");  
sparkreporter.config().setTimeStampFormat("dd/mm/yyyy  hh:mm:ss");

extentReport.attachReporter(sparkreporter);
   
Properties configProp = new Properties();
FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
configProp.load(ip);

extentReport.setSystemInfo("Application url",configProp.getProperty("url"));
extentReport.setSystemInfo("Browser Name",configProp.getProperty("browserName"));
extentReport.setSystemInfo("Username",configProp.getProperty("validUsername"));
extentReport.setSystemInfo("password",configProp.getProperty("validPassword"));
extentReport.setSystemInfo("Operating System",System.getProperty("os.version"));
extentReport.setSystemInfo("Tester Name",System.getProperty("user.name"));
extentReport.setSystemInfo("Java Version",System.getProperty("java.version"));

return extentReport;


  }


}
