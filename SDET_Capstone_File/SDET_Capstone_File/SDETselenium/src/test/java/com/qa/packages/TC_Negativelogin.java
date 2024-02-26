package com.qa.packages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.demopages.Negativelogin;

public class TC_Negativelogin extends Baseclass{
	@Test
	
	public void negative() throws InterruptedException, IOException {
		Negativelogin negative=new Negativelogin(driver);
		negative.user("standard_Invaliduser");
		Thread.sleep(3000);
		negative.pass("secret_Invalidpwd");
		Thread.sleep(3000);
		negative.log();
		Thread.sleep(3000);
		captureScreenshot(driver, "negativelogin");
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
		 Assert.assertNotEquals(actualUrl, expectedUrl); 
		 System.out.print("Login notsuccessful with invalid credentials");
	}

}
