package atc.saf;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class automationpractice {
	
	public static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// Launch the application
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		
		// Verify whether the application launched 
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		
		// Verify title is correct	
		if (title.equalsIgnoreCase("My Store"))
			System.out.println("Title matches");
		else 
			System.out.println("Title doesn't match");	
		
		// Click on 'Sign In'
		driver.findElement(By.linkText("Sign in")).click();
		
		// 1. Login to the application		
		driver.findElement(By.id("email")).sendKeys("vishruth.cse@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("Test@1234");		
		driver.findElement(By.id("SubmitLogin")).click();
		
		// 2. Navigate to 'My Addresses' and add a new address
		//	Click on 'MY ADDRESSES'	
		driver.findElement(By.xpath("//span[text()='My addresses']")).click();
		// Click on 'Add a new address' 	
		driver.findElement(By.xpath("//span[text()='Add a new address']")).click();
		
		// 3. Fill all the informations(not only the mandatory)		
		driver.findElement(By.id("address1")).sendKeys("Test Ave S");
		Thread.sleep(2000);
		driver.findElement(By.id("address2")).sendKeys("Test Apt");
		Thread.sleep(2000);
		driver.findElement(By.id("city")).sendKeys("Test City");
		Thread.sleep(2000);
		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByVisibleText("Iowa");
		Thread.sleep(2000);
		driver.findElement(By.id("postcode")).sendKeys("50266");
		Thread.sleep(2000);
		driver.findElement(By.id("phone")).sendKeys("6128191111");
		Thread.sleep(2000);
		driver.findElement(By.id("phone_mobile")).sendKeys("6128192222");
		Thread.sleep(2000);
		driver.findElement(By.id("other")).sendKeys("Testing");
		Thread.sleep(2000);
		driver.findElement(By.id("alias")).clear();
		driver.findElement(By.id("alias")).sendKeys("My Address" + new Random().nextInt(1000));
		
		// 4. Click on 'Save'
		driver.findElement(By.xpath("//button[@id='submitAddress']/span")).click();	
		
		// 5. Navigate to 'Women' --> Summer dresses
		WebElement we = driver.findElement(By.linkText("Women"));
		Actions action = new Actions(driver);		
		action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//a[text()='Summer Dresses']"))).click().build().perform();
			
		// Close the web driver		
		driver.close();
		driver.quit();
	}

}
