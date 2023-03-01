package com.bridgelabz.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public ChromeDriver driver = null;

	@BeforeTest
	public void setup () {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@AfterTest

	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		//driver.close();
	}

	public void screenshot() throws IOException {
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("/Users/atulnigam/Documents/AbhiEclipseWorkshop/Drivers/screenshot"+System.currentTimeMillis()+".jpg");
		FileUtils.copyFile(srcFile, destinationFile);
	}
}


