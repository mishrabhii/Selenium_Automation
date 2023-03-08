package com.bridgelabz.qa.Automation;

import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import com.bridgelabz.base.BaseClass;

public class JavaScriptExecutor extends BaseClass {

	@Test

	public void getNoOfFrames() throws InterruptedException {

		driver.get("https://www.guru99.com/api-testing.html");
		JavascriptExecutor executer = (JavascriptExecutor)driver;

		int  NoOfFrames = Integer.parseInt(executer.executeScript("return window.length").toString());
		System.out.println("NoOfFrames ="+NoOfFrames);

		for(int i=0;i<=NoOfFrames;i++) {
			System.out.println("Frame Title =" + driver.switchTo().frame(i).getTitle());

		}
		
		
		executer.executeScript("window.scrollBy(0,500)");
		Thread.sleep(500);
	}
}
