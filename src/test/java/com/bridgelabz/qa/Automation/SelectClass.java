package com.bridgelabz.qa.Automation;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.bridgelabz.base.BaseClass;

public class SelectClass extends BaseClass {

	@Test(priority=3)

	public void getFacebookTitle () throws InterruptedException, IOException {
		createAccount();
		
		String title = driver.getTitle();
		System.out.println("Title is = "+title);
		AssertJUnit.assertEquals(title, "Sign up for Facebook | Facebook");
	}
	@Test(priority=4)

	public void findFacebookLogo () throws InterruptedException, IOException {
		createAccount();
		boolean flag =driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/img")).isDisplayed();
		AssertJUnit.assertTrue(flag);
	}
	@Test(priority = 1)

	public void createAccount() throws InterruptedException, IOException {
		driver.get("https://www.facebook.com/login/");
		driver.findElement(By.partialLinkText("Sign up")).click();
		driver.findElement(By.name("firstname")).sendKeys("Abhishek");
		driver.findElement(By.name("lastname")).sendKeys("Mishra");
		driver.findElement(By.name("reg_email__")).sendKeys("9651094335");
		driver.findElement(By.name("reg_passwd__")).sendKeys("Abhishek@123");

		WebElement dayDropDown	= driver.findElement(By.name("birthday_day"));
		Select ddDown = new Select(dayDropDown);
		ddDown.selectByVisibleText("10");
		Thread.sleep(1000);

		WebElement monthDropDown = driver.findElement(By.name("birthday_month"));
		Select mdDown = new Select(monthDropDown);
		mdDown.selectByIndex(9);
		Thread.sleep(1000);

		WebElement yearDropDown	= driver.findElement(By.name("birthday_year"));
		Select ydDown = new Select(yearDropDown);
		ydDown.selectByValue("1992");
		Thread.sleep(1000);

		driver.findElements(By.name("sex")).get(1).click();
		screenshot();
	}
	@Test(priority = 2)

	public void radioButtonIsSelectedOrNot () throws IOException, InterruptedException {
		createAccount();
		boolean flag =driver.findElements(By.name("sex")).get(1).isSelected();
		if (flag == true) {
			System.out.println("male radio button selected");
		}
		else {
			driver.findElements(By.name("sex")).get(1).click();	
		}
		screenshot();
	}
}

