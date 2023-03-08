package com.bridgelabz.qa.Automation;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.bridgelabz.base.BaseClass;

public class WindowHandling extends BaseClass {

	@Test

	public void getWindowAndHandle () {

		driver.get("https://demoqa.com/browser-windows");
		driver.findElement(By.id("windowButton")).click();
		String mainWindowHandle = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> iterator = allWindows.iterator();
		while (iterator.hasNext()) 
		{
			String chileWindow = iterator.next();
			if(!mainWindowHandle.equalsIgnoreCase(chileWindow)) 
			{
				driver.switchTo().window(chileWindow);
				WebElement text = driver.findElement(By.id("sampleHeading"));
				System.out.println(text.getText());
			}
		}
	}
}
