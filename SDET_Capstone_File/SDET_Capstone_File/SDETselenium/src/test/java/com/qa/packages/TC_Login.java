package com.qa.packages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.demopages.Login;

public class TC_Login extends Baseclass{
	@Test
	public void usern() throws InterruptedException, IOException {
		Login login=new Login(driver);
		login.user("standard_user");
		Thread.sleep(3000);
		login.pass("secret_sauce");
		Thread.sleep(3000);
		login.log();
		Thread.sleep(3000);
		captureScreenshot(driver, "Login");
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
		 Assert.assertEquals(actualUrl, expectedUrl);
		 System.out.println("Login successful with valid credentials");

		
	}
	

}
