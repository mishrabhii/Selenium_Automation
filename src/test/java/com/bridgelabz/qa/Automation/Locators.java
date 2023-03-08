package com.bridgelabz.qa.Automation;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.bridgelabz.base.BaseClass;

public class Locators extends BaseClass {

	@Test

	public void checkAllLocators () throws InterruptedException {
		
		driver.get("https://bldev.bridgelabz.com/webinar");
	
		driver.findElement(By.id("deftphnumber")).sendKeys("9651094335");

		driver.findElement(By.tagName("input"));

		driver.findElement(By.name("ContactNumber")).sendKeys("9651094335");

		driver.findElement(By.cssSelector("input#deftusername")).sendKeys("Abhishek Mishra");

		WebElement element =driver.findElement(By.xpath("/html/body/section[1]/div/div[6]/div[2]/div[2]/div[2]/div/input"));
		element.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		element.click();
		driver.findElement(By.xpath("//*[@id=\"deftdegree\"]")).click();
		driver.findElement(By.className("anchor-tag")).click();
		
		Thread.sleep(1000);
		driver.navigate().to("https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/5.3.1");

		driver.findElement(By.linkText("Gradle")).click();
		
		driver.findElement(By.partialLinkText("5.3")).click();

		

	}

}
