package kimball;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class fourth {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://staging.bkimechanical.com/login");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("swathi.a+2@westagilelabs.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait5.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='role-text' and text()='Administrator']")));
		WebElement n = driver.findElement(By.xpath("//div[@class='role-text' and text()='Administrator']"));
		n.click();
		
		
		wait5.until(ExpectedConditions
				.visibilityOfElementLocated(By.linkText("Schedule Manager")));
		WebElement schedule = driver.findElement(By.linkText("Schedule Manager"));
		schedule.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
		
		
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("")));
	
		WebElement source = driver.findElement(By.xpath("(//span[contains(text(), '3471unique')])"));
		
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='DQJ-3471unique']")));
		
		WebElement target = driver.findElement(By.xpath("//span[text()='DQJ-3471unique']"));
		  Actions actions = new Actions(driver);
		 actions.clickAndHold(source)       // Click on the source element
         .moveByOffset(0, 50)       // Move the source element downward (you can adjust these values)
         .moveToElement(target)     // Move the mouse to the target element
         .release()                  // Release the mouse to drop it
         .build().perform(); 
		 
		  JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].dispatchEvent(new MouseEvent('mousedown', {bubbles: true, cancelable: true}));", source);
	        js.executeScript("arguments[0].dispatchEvent(new MouseEvent('mousemove', {bubbles: true, cancelable: true}));", target);
	        js.executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseup', {bubbles: true, cancelable: true}));", target);
	        
	        Thread.sleep(4000);
	        
	        System.out.println("Drag and drop action completed!");

        
       
	}

}
