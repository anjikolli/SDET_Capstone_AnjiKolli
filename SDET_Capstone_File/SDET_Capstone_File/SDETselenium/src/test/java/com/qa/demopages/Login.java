package com.qa.demopages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	private WebDriver driver;
	By username=By.id("user-name");
	By password=By.id("password");
	By login  =By.id("login-button");
	
	public Login(WebDriver driver) {
		this.driver= driver;
	}
	public void user(String Anji) {
		driver.findElement(username).sendKeys(Anji);
	}
	public void pass(String Naidu) {
		driver.findElement(password).sendKeys(Naidu);
	}
	public void log() {
		driver.findElement(login).click();
	}

}
