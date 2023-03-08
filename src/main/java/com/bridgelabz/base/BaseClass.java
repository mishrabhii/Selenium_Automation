package com.bridgelabz.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
//import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver = null;
	

	@BeforeTest
	@Parameters("browser")
	public void setup (String Browser) {
		if(Browser.equalsIgnoreCase("Chrome")) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if (Browser.equalsIgnoreCase("safari")) {
		
		WebDriverManager.safaridriver().setup();
		driver = new SafariDriver();
		}
		else {
			System.out.println("Not selected any Browser!!!");
		}
			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@AfterTest

	public void tearDown(){
	driver.close();
	}

	public void screenshot() throws IOException {
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("/Users/atulnigam/Documents/AbhiEclipseWorkshop/Screenshot"+System.currentTimeMillis()+".jpg");
		FileUtils.copyFile(srcFile, destinationFile);
	}
}


