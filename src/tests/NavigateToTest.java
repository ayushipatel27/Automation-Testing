package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateToTest {

	public static void main(String[] args) throws InterruptedException {
		// Get OS of user 
		String OS = System.getProperty("os.name").toLowerCase();
		
		// If OS is Mac
		if (OS == "mac") {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver" );
		}
		
		// Else if OS is Windows
		else if (OS == "windows") {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe" );
		}
		
		// Initialize WebDriver as a ChromeDriver
		WebDriver driver = new ChromeDriver();
		
		// Navigate to URL
		driver.get("https://developers.google.com/");
		
		Thread.sleep(5000);  // Let the user actually see something!
		
		driver.quit();
	}
}
