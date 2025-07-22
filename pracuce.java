package kimball;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.random.RandomGenerator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pracuce {

	public static void main(String[] args) throws AWTException, IOException, Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://staging.bkimechanical.com/login");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("swathi.a+2@westagilelabs.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='role-text' and text()='Administrator']")));
		WebElement n = driver.findElement(By.xpath("//div[@class='role-text' and text()='Administrator']"));
		n.click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Packages']")));
		WebElement pack = driver.findElement(By.xpath("//span[text()='Packages']"));
		pack.click();

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("input[placeholder='Package ID or Project Name or Project ID']")));
		WebElement dw = driver
				.findElement(By.cssSelector("input[placeholder='Package ID or Project Name or Project ID']"));
		dw.sendKeys("");
		dw.submit();

		/*WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("input[placeholder='Field Material Packages']")));

		WebElement packageID = driver.findElement(By.xpath("input[placeholder='Field Material Packages']"));
		packageID.click();
		dw.sendKeys("Samplepkg-56-oct18");
		dw.submit();

		WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("input[placeholder='Hanger Packages']")));

		WebElement Hanger = driver.findElement(By.xpath("input[placeholder='Hanger Packages']"));
		Hanger.click();
		dw.sendKeys("Samplepkg-56-oct18");
		dw.submit();   
		WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("input[placeholder='Misc. Fab Packages']")));

		WebElement MiscPackages = driver.findElement(By.xpath("input[placeholder='Misc. Fab Packages']"));
		MiscPackages.click();
		dw.sendKeys("Samplepkg-56-oct18");
		dw.submit();

		WebElement switchRole = driver.findElement(By.xpath("//div[@class='dropdown']//a[1]"));
		switchRole.click();
		WebElement SS = driver.findElement(By.xpath("//button[text()='Switch Roles']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", SS);*/
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait3.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@role='gridcell']//a)[1]")));
		
		WebElement packageID = driver.findElement(By.xpath("(//div[@role='gridcell']//a)[1]"));
		packageID.click();
		
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait4.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@role='gridcell']/following-sibling::div)[3]")));
		
		WebElement Stage1 = driver.findElement(By.xpath("(//div[@role='gridcell']/following-sibling::div)[3]"));
		  String text = Stage1.getText();	  
		  System.out.println("The first Stage in Adminstrative tab is  " + text);
		WebElement Status = driver.findElement(By.xpath("(//div[@class='css-1hwfws3 select-dropdown__value-container select-dropdown__value-container--has-value'])[8]"));
		String dropdown = Status.getText();
		System.out.println("The first Status in Administrative tab is  " + dropdown);
		
		WebElement button = driver.findElement(By.xpath("(//div[@class='spools-result-wrap'])//button[1]"));
		button.click();
		
		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait5.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='css-1pcexqc-container select-container']")));
		
		WebElement approvalDD = driver.findElement(By.xpath("//div[@class='css-1pcexqc-container select-container']"));
		approvalDD.click();
		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait6.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[text()='Approved as it is']")));
		WebElement Approved = driver.findElement(By.xpath("//div[text()='Approved as it is']"));
		Approved.click();
		
		WebElement button2 = driver.findElement(By.xpath("//button[@class='btn profile-save-btn']"));
		button2.click();
		
		WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait10.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[text()='Fitting'])[1]")));
		
		WebElement Stage2 = driver.findElement(By.xpath("(//div[text()='Fitting'])[1]"));
		 String text1 = Stage2.getText();	  
		  System.out.println("The Second Stage after procurement approval " + text1);
		  
		  WebElement Status2 = driver.findElement(By.xpath("(//div[text()='In Progress'])[1]"));
			String dropdown2 = Status2.getText();
			System.out.println("The Second Status after procurement approval " + dropdown2);

	}
}
