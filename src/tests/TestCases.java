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
		System.out.println("Test Case 1\n");
		navigateTo("https://developers.google.com/");
		System.out.println("Test Case 2\n");
		confirmText("Hone your skills on the latest cloud technologies with Google experts at hundreds of breakout sessions and interactive on-demand hands-on labs and bootcamps. You'll have the opportunity to engage with the best minds in cloud technology on how your industry is adapting, innovating, and growing with cloud.", "//*[@id='gc-wrapper']/div[2]/article/article/section[1]/div/div[1]/div/div[1]/p[1]");
		System.out.println("Test Case 3\n");
		clickButton("//*[@id=\'gc-wrapper\']/div[2]/article/article/section[1]/div/div[1]/div/a");
		System.out.println("Test Case 4\n");
		confirmText("Imagine", "//*[@id=\'main\']/span/div[2]/div/div/div[1]/div[1]/div/div[1]/div[2]/h3");
		System.out.println("Test Case 5\n");
		clickButton("//*[@id=\'main\']/span/div[1]/div/div/div/div[3]/div[2]/div/button");
		System.out.println("Test Case 6\n");
		sendKeys();
		selectFromDropDown();
	}
	/**
	 * This method navigating to given url on Chrome
	 * @param url : the url that user is trying to navigate
	 * @throws InterruptedException
	 */
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
	
	/**
	 * This method checks if the given string matches the string from the element located on the web page."
	 * @param text : given string
	 * @param xpath : xpath used to locate element
	 */
	public static void confirmText(String text, String xpath) {
		System.out.println("Trying to confirm that given string is equal to the text on page.");
		waitToLocate(xpath);
		WebElement element = driver.findElement(By.xpath(xpath));
		System.out.println("Test case: " + text);
		System.out.println("Result: " + element.getText());
		if (element.getText().equals(text)) {
			System.out.println("\nEquals.");
		}
		else {
			System.out.println("\nDoes not equals.");
		}
		System.out.println("\n\n");
	}
	
	/**
	 * This method tries to click a link or a button on the webpage
	 * @param xpath : xpath used to locate element
	 */
	public static void clickButton(String xpath) {
		System.out.println("Trying to click a link.\n");
		WebElement element = null;
		try {
		waitToLocate(xpath);
		element = driver.findElement(By.xpath(xpath));
		System.out.println("Link: " + element.getText());
		}
		catch (Exception e) {
			System.out.println("Cannot find element.");
		}
		element.click();
		System.out.println("\nSuccesfully clicked the link." + "\n\n");

	}
	
	/**
	 * This method sends keys to the input tag
	 */
	public static void sendKeys() {
		System.out.println("Trying to send keys.");
		
		waitToLocate("//*[@id=\'firstName\']");
		WebElement firstname = driver.findElement(By.xpath("//*[@id=\'firstName\']"));
		firstname.sendKeys("Ayushi");
		System.out.println("Firstname sent.");
		
		
		waitToLocate("//*[@id=\'lastName\']");
		WebElement lastname = driver.findElement(By.xpath("//*[@id=\'lastName\']"));
		lastname.sendKeys("Patel");
		System.out.println("Lastname sent.");
		
		
		waitToLocate("//*[@id=\'email\']");
		WebElement email = driver.findElement(By.xpath("//*[@id=\'email\']"));
		email.sendKeys("ayushiipatel27@gmail.com");
		System.out.println("Email sent.");
		
		
		waitToLocate("//*[@id=\'jobTitle\']");
		WebElement jobtitle = driver.findElement(By.xpath("//*[@id=\'jobTitle\']"));
		jobtitle.sendKeys("QA Engineer");
		System.out.println("Job Title sent.");
		
		
		waitToLocate("//*[@id=\'company\']");
		WebElement company = driver.findElement(By.xpath("//*[@id=\'company\']"));
		company.sendKeys("Influence Health");
		System.out.println("Company sent.");
		

		System.out.println("Succesfully sent the keys." + "\n\n");
	}
	
	/**
	 * This method selects values from the dropdown 
	 */
	public static void selectFromDropDown() {
		System.out.println("Trying to select from dropdown.");
		
		waitToLocate("//*[@id=\'industry\']");
		Select industry = new Select(driver.findElement(By.xpath("//*[@id=\'industry\']")));
		industry.selectByValue("Education");
		System.out.println("Selection complete.");
		
		waitToLocate("//*[@id=\'country\']");
		Select country = new Select(driver.findElement(By.xpath("//*[@id=\'country\']")));
		country.selectByValue("US");
		System.out.println("Selection complete.");

		
		
		System.out.println("Succesfully selected values from dropdown." + "\n\n");
	}
	
	/**
	 * This method waits for web driver to look for an element 
	 * @param xpath : xpath used to locate element
	 */
	public static void waitToLocate(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}
	
}
