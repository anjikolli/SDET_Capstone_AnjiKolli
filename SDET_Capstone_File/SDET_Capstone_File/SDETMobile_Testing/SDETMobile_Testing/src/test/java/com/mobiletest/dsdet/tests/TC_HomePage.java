package com.mobiletest.dsdet.tests;

import java.net.MalformedURLException;
import org.testng.annotations.Test;

import com.mobiletest.sdet.pages.homepage;

import Mobile.SDETMobile_Testing.BaseClass;

public class TC_HomePage extends BaseClass{

	@Test
	public void HomePage() throws InterruptedException, MalformedURLException {
		homepage home=new homepage(driver);
		home.addCustomer("Kolli Anjaneyulu");
		home.selectOptionByValue();
		home.selectGender();
		home.selectButton();
		
	
	}
}
