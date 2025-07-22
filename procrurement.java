package kimball;

import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class procrurement {

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
				.visibilityOfElementLocated(By.xpath("//div[@class='role-text' and text()='Procurement User']")));
		WebElement n = driver.findElement(By.xpath("//div[@class='role-text' and text()='Procurement User']"));
		n.click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class,'css-1hwfws3 select-dropdown__value-container')]")));
		WebElement select = driver
				.findElement(By.xpath("//div[contains(@class,'css-1hwfws3 select-dropdown__value-container')]"));
		select.click();
		WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait7.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(.,'All Facilities')]")));

		WebElement dropdown = driver.findElement(By.xpath("//strong[contains(.,'All Facilities')]"));
		dropdown.click();
		

		Thread.sleep(4000);
		WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait8.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//span[contains(text(), '6405unique')])[2]")));

		WebElement element = driver.findElement(By.xpath("(//span[contains(text(), '6405unique')])[2]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		element.click();
		WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='po-input']")));

		WebElement ABB = driver.findElement(By.xpath("//input[@class='po-input']"));
		ABB.sendKeys("Anything");

		WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait10.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='css-1pcexqc-container supplier-dropdown default-supplier'])[1]")));

		WebElement Supplier = driver
				.findElement(By.xpath("(//div[@class='css-1pcexqc-container supplier-dropdown default-supplier'])[1]"));
		Supplier.click();

		WebElement option1 = driver.findElement(By.xpath("//th[2]/div/div[2]/div/div"));
		option1.click();

		WebElement Supplier2 = driver
				.findElement(By.xpath("(//div[@class='css-1pcexqc-container supplier-dropdown default-supplier'])[2]"));
		Supplier2.click();

		WebElement option2 = driver.findElement(By.xpath("//th[2]/div/div[2]/div/div"));
		option2.click();

		WebElement Supplier3 = driver
				.findElement(By.xpath("(//div[@class='css-1pcexqc-container supplier-dropdown default-supplier'])[3]"));
		Supplier3.click();

		WebElement option3 = driver.findElement(By.xpath("//th[2]/div/div[2]/div/div"));
		option3.click();

		List<WebElement> all = driver.findElements(By.xpath("(//div[@class='position-relative form-group'])"));
		System.out.println(all.size());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust wait time as needed

		for (int i = 0; i < all.size(); i++) {
			if (i == 0) {
				WebElement first = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("(//div[@class='css-1pcexqc-container select-container field-focus'])[1]")));
				first.click();
				WebElement dd1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div/div[3]")));
				dd1.click();
				WebElement nest1 = driver.findElement(By.xpath("(//button[@class='nest-btn'])[1]"));
				nest1.click();
			} else if (i == 1) {
				WebElement second = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("(//div[@class='css-1pcexqc-container select-container field-focus'])[2]")));
				JavascriptExecutor jt = (JavascriptExecutor) driver;
				jt.executeScript("window.scrollBy(0,1000)");
				second.click();
				WebElement dd2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div/div[3]")));
				dd2.click();
				WebElement nest2 = driver.findElement(By.xpath("(//button[@class='nest-btn'])[2]"));
				nest2.click();
			} else if (i == 2) {
				WebElement third = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("(//div[@class='css-1pcexqc-container select-container field-focus'])[3]")));
				third.click();
				WebElement dd3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='react-select-19-option-2']")));
				dd3.click();
				WebElement nest3 = driver.findElement(By.xpath("(//button[@class='nest-btn'])[3]"));
				nest3.click();
			} else if (i == 3) {
				WebElement fourth = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("(//div[@class='css-1pcexqc-container select-container field-focus'])[4]")));
				fourth.click();
				WebElement dd4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='react-select-19-option-2")));
				dd4.click();
				WebElement nest4 = driver.findElement(By.xpath("(//button[@class='nest-btn'])[4]"));
				nest4.click();
			} else if (i == 4) {
				WebElement fifth = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("(//div[@class='css-1pcexqc-container select-container field-focus'])[5]")));
				fifth.click();
				WebElement dd5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='react-select-19-option-2")));
				dd5.click();
				WebElement nest5 = driver.findElement(By.xpath("(//button[@class='nest-btn'])[5]"));
				nest5.click();
			} else if (i == 5) {
				WebElement sixth = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("(//div[@class='css-1pcexqc-container select-container field-focus'])[6]")));
				JavascriptExecutor ju = (JavascriptExecutor) driver;
				ju.executeScript("window.scrollBy(0,1000)");
				sixth.click();
				WebElement dd6 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='react-select-19-option-2")));
				dd6.click();
				WebElement nest6 = driver.findElement(By.xpath("(//button[@class='nest-btn'])[6]"));
				nest6.click();

			} else {
				System.out.println("nesting is done");
			}

		}

		Thread.sleep(5000);
		WebElement update = driver.findElement(By.xpath("//button[text()='Update']"));
		update.click();
		
		Thread.sleep(5000);

		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Print for Pricing']")));
		WebElement print = driver.findElement(By.xpath("//button[text()='Print for Pricing']"));
		print.click();
		
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='multiselect-dropdown-container multiselect-dropdown-supplier']")));
		WebElement DD = driver.findElement(By.xpath("//div[@class='multiselect-dropdown-container multiselect-dropdown-supplier']"));
		
		DD.click();
		
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='picky-list']/div[1]/input[1]")));
		WebElement Supply = driver.findElement(By.xpath("//div[@id='picky-list']/div[1]/input[1]"));
		Thread.sleep(3000);
		
		
		if(Supply.isSelected()) {
			System.out.print("Already selected ");
		}
		else {
			Supply.click();
		}
		
		
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Subject']/following::input")));
		WebElement content = driver.findElement(By.xpath("//label[text()='Subject']/following::input"));
		content.sendKeys("Content  is  required");

		
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
		WebElement butt = driver.findElement(By.xpath("//button[text()='Submit']"));
		butt.click();
		
		WebElement close = driver.findElement(By.xpath("//button[@aria-label='Close']"));
		close.click();
		
		Thread.sleep(3000);
		
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit BOM']")));
		WebElement SubmitBOM = driver.findElement(By.xpath("//button[text()='Submit BOM']"));
		SubmitBOM.click();
		
		
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='multiselect-dropdown-container multiselect-dropdown-supplier']")));
		WebElement DD1 = driver.findElement(By.xpath("//div[@class='multiselect-dropdown-container multiselect-dropdown-supplier']"));
		DD1.click();
		
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='picky-list']/div[1]/input[1]")));
		WebElement Supply1 = driver.findElement(By.xpath("//div[@id='picky-list']/div[1]/input[1]"));
		Thread.sleep(3000);
		
		
		if(Supply1.isSelected()) {
			System.out.print("Already selected ");
		}
		else {
			Supply1.click();
		}
		
		
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Subject']/following::input")));
		WebElement content1 = driver.findElement(By.xpath("//label[text()='Subject']/following::input"));
		content1.sendKeys("Content  is  required");
		
	
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
		WebElement butt1 = driver.findElement(By.xpath("//button[text()='Submit']"));

		butt1.click();
		
		WebElement close1 = driver.findElement(By.xpath("//button[@aria-label='Close']"));
		close1.click();
		
		Thread.sleep(4000);
		wait8.until(ExpectedConditions
				.visibilityOfElementLocated(By.partialLinkText("3471unique")));

		WebElement element1 = driver.findElement(By.partialLinkText("3471unique"));
		JavascriptExecutor jw = (JavascriptExecutor) driver;
		jw.executeScript("window.scrollBy(0,1000)");
		element1.click();
		
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Receive All']")));
		WebElement recieve = driver.findElement(By.xpath("//button[text()='Receive All']"));
		recieve.click();
		
		

	}

}
