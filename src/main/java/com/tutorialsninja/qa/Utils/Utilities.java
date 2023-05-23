package com.tutorialsninja.qa.Utils;

import java.util.Date;

public class Utilities {

public static String generateEmailWithTimeStamp()	{
	Date date = new Date();
String timeStamp = date.toString().replace(" ", "_").replace(":","_" ).substring(8, 19).replace("_","");
return "Salman" + timeStamp + "@gmail.com";
}
public static final int impliWaitTime = 10;
public static final int  pageLoadTime = 10;
public static final int  scriptTime = 100;

}