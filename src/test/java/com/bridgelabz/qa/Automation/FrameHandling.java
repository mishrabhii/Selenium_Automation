package com.bridgelabz.qa.Automation;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.bridgelabz.base.BaseClass;

public class FrameHandling extends BaseClass {
	@Test

	public void SignInPage() throws InterruptedException {

		driver.get("https://www.linkedin.com/home");

		driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[1]/div/a")).click();
		driver.findElement(By.id("email-or-phone")).sendKeys("sanjuu5737@gmail.com");
		Thread.sleep(500);
		driver.findElement(By.id("password")).sendKeys("abhishek@123");
		Thread.sleep(500);
		driver.findElement(By.id("join-form-submit")).click();
		Thread.sleep(500);
		driver.findElement(By.id("first-name")).sendKeys("Sanjay");
		driver.findElement(By.id("last-name")).sendKeys("Mishra");
		WebElement clickButton = driver.findElement(By.id("join-form-submit"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", clickButton);
		Thread.sleep(500);

		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("No of Frames :" +size);

		for(int i=0;i<=size;i++) {
			driver.switchTo().frame(i);
			int total = driver.findElements(By.xpath("//iframe[@src='/checkpoint/challengeIframe/AQFO5EYo6sVddAAAAYacZ0N9Tt_JY08iciY2uzvq2wKvScuLBH5oT_4Dv8092L5Pbc_7R2mSMCzT7MdwTO3zArNmnk8wWA?ut=3LtPuktdSYFGE1']")).size();
			System.out.println(total);
			driver.findElement(By.name("phoneNumber")).sendKeys("9651094335");
			driver.switchTo().defaultContent();
		}

		driver.close();
	}


}