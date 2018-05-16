package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCases {
	private static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		navigateTo("https://developers.google.com/");
		confirmText("Hone your skills on the latest cloud technologies with Google experts at hundreds of breakout sessions and interactive on-demand hands-on labs and bootcamps. You'll have the opportunity to engage with the best minds in cloud technology on how your industry is adapting, innovating, and growing with cloud.", "//*[@id='gc-wrapper']/div[2]/article/article/section[1]/div/div[1]/div/div[1]/p[1]");
		clickButton("//*[@id=\'gc-wrapper\']/div[2]/article/article/section[1]/div/div[1]/div/a");
		confirmText("Imagine", "//*[@id=\'main\']/span/div[2]/div/div/div[1]/div[1]/div/div[1]/div[2]/h3");
		clickButton("//*[@id=\'main\']/span/div[1]/div/div/div/div[3]/div[2]/div/button");
		sendKeys();
		selectFromDropDown();
	}
	
	public static void navigateTo(String url) throws InterruptedException {
		System.out.println("Trying to navigate to url: " + url);

		// Get OS of user 
		String OS = System.getProperty("os.name").toLowerCase();
		
		// The driver executable is set by the webdriver.chrome.driver system property
		if (OS == "mac") {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver" );
		}
		else if (OS == "windows") {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe" );
		}
		
		// Initialize WebDriver as a ChromeDriver
		driver = new ChromeDriver();
		
		// Navigate to URL
		driver.get(url);
		
		System.out.println("Successfully navigated to url: " + url + "\n\n");
		
	}
	
	public static void confirmText(String text, String xpath) {
		System.out.println("Trying to confirm that given string is equal to the text on page.");
		WebElement element = driver.findElement(By.xpath(xpath));
		waitToLocate(xpath);
		System.out.println("Test case: " + text);
		System.out.println("Result: " + element.getText());
		if (element.getText() == text) {
			System.out.println("\nEquals.");
		}
		else {
			System.out.println("\nDoes not equals.");
		}
		System.out.println("\n\n");
	}
	
	
	public static void clickButton(String xpath) {
		System.out.println("Trying to click a link.");
		WebElement element = null;
		try {
		element = driver.findElement(By.xpath(xpath));
		waitToLocate(xpath);
		}
		catch (Exception e) {
			System.out.println("Cannot find element.");
		}
		element.click();
		System.out.println("Succesfully clicked the link." + "\n\n");

	}
	
	public static void sendKeys() {
		WebElement firstname = driver.findElement(By.id("firstName"));
		waitToLocate("//*[@id=\'firstName\']");
		firstname.sendKeys("Ayushi");
		WebElement lastname = driver.findElement(By.xpath("//*[@id=\'lastName\']"));
		waitToLocate("//*[@id=\'lastName\']");
		lastname.sendKeys("Patel");
		WebElement email = driver.findElement(By.xpath("//*[@id=\'email\']"));
		waitToLocate("//*[@id=\'email\']");
		email.sendKeys("ayushiipatel27@gmail.com");
		WebElement jobtitle = driver.findElement(By.xpath("//*[@id=\'jobTitle\']"));
		waitToLocate("//*[@id=\'jobTitle\']");
		jobtitle.sendKeys("QA Engineer");
		WebElement company = driver.findElement(By.xpath("//*[@id=\'company\']"));
		waitToLocate("//*[@id=\'company\']");
		company.sendKeys("Influence Health");
	}
	
	public static void selectFromDropDown() {
		Select industry = new Select(driver.findElement(By.xpath("//*[@id=\'industry\']")));
		industry.selectByValue("Education");
		Select country = new Select(driver.findElement(By.xpath("//*[@id=\'country\']")));
		country.selectByValue("United States");
	}
	
	public static void waitToLocate(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
}
