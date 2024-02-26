package Mobile.SDETMobile_Testing;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import com.mobiletest.sdet.pages.homepage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseClass {
	protected AndroidDriver driver;
	public homepage userdetails;

	@BeforeClass
	public void AppiumApplication() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("platformName", "Android");

		caps.setCapability("deviceName", "Pixel 6a");

		caps.setCapability("appPackage",
				"C:\\Users\\ANJANEYULUKOLLI\\eclipse-workspace\\SDETMobile_Testing\\SDETMobile_Testing\\Resources\\General-Store.apk"); 
		 caps.setCapability("newCommandTimeout", 100000);
	        caps.setCapability("noReset", true);
		caps.setCapability("appActivity", ".MainActivity");
		caps.setCapability("automationName", "UiAutomator2");

		try {

			UiAutomator2Options options = new UiAutomator2Options();
			options.setDeviceName("Pixel 6a");
			options.setApp(
					"C:\\Users\\ANJANEYULUKOLLI\\eclipse-workspace\\SDETMobile_Testing\\SDETMobile_Testing\\Resources\\General-Store.apk");

			driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
			Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} catch (Exception e) {

			e.printStackTrace();

		}
		
	}

}
