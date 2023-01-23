package steps;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SunflowerTest {

	private AppiumDriver appiumDriver;

	@When("User launch Sunflower app")
	public void user_launch_sunflower_app() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "11.0");
		capabilities.setCapability("deviceName", "Nexus 6");
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("newCommandTimeout", 120);

		// Launches the below android virtual device and waits for 120 seconds for AVD
		// to be ready
		capabilities.setCapability("avd", "Nexus6_API_30");
		capabilities.setCapability("avdReadyTimeout", 120000);

		capabilities.setCapability("appPackage", "com.google.samples.apps.sunflower");
		capabilities.setCapability("appActivity", "com.google.samples.apps.sunflower.GardenActivity");

		appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@Then("User sees My Garden screen with {string} text")
	public void user_sees_my_garnden_screen_with_text(String expTxt) {
		String actualTxt = appiumDriver.findElement(By.id("com.google.samples.apps.sunflower:id/empty_garden"))
				.getText();
		System.out.println(actualTxt);
		expTxt = "Your garden is empty";
		if (expTxt.equals(actualTxt)) {
			System.out.println("Correct message is displayed!!!");
		}
		 

	}

	@Then("User sees My Garden screen with {string} button")
	public void user_sees_my_garnden_screen_with_button(String expBtnTxt) {

		expBtnTxt = "ADD PLANT";

		if (appiumDriver.findElement(By.id("com.google.samples.apps.sunflower:id/add_plant")).isDisplayed()) {

			System.out.println("ADD PLANT Button is Displayed!!!");

		} else {

			System.out.println("ADD PLANT Button is missing!!!");
		}

		String actBtnTxt = appiumDriver.findElement(By.id("com.google.samples.apps.sunflower:id/add_plant")).getText();

		System.out.println(actBtnTxt);

		if (expBtnTxt.equals(actBtnTxt)) {

			System.out.println("Button text is displayed correctly!!!");

		} else {

			System.out.println("Button text is incorrect!!!");
		}

	}

}
