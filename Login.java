package kimball;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;


import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class Login {
	public static void main(String[] args) throws AWTException, Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		try {
			driver.get("http://staging.bkimechanical.com/login");
			Home home = new Home(driver);
			Administration admin = new Administration(driver);
			packages pack = new packages(driver);
			procurement proc = new procurement(driver);
			Drag dragg = new Drag(driver);
			Heatnum heat = new Heatnum(driver);
			Check check = new Check(driver);
			home.performLogin();
			home.Design();
			home.mandatory();
			home.upload1();
			home.upload2();
			home.uploadPdf();
			home.fabric();
			home.upload3();
			home.upload4();
			home.uploadPdf1();
			home.field();
			home.hanger();
			home.hangPdf();
			home.Structure();
			home.Material();
			home.category();
			home.misc();
			home.hundred();
			home.submit();
			pack.fabricationpackages();
			admin.Administrator();
			proc.procs();
			dragg.DraggingDropping();
			heat.Heating();
			check.checking();

		} catch (Exception e) {
			System.out.println("Error occurred: " + e.getMessage());
		} finally {
			
		}
	}

}

class Check extends Login {
	private WebDriver driver;
	public String randomString;

	public Check(WebDriver driver) {
		this.driver = driver;
	}
	
	@Test
	public void checking() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='role-text' and text()='Administrator']")));
		WebElement n = driver.findElement(By.xpath("//div[@class='role-text' and text()='Administrator']"));
		n.click();
		WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Welder Average Report']")));
		WebElement A = driver.findElement(By.xpath("//h4[text()='Welder Average Report']"));
		A.click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait1.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul:nth-child(1) > li:nth-child(5) > a")));
		WebElement B = driver.findElement(By.cssSelector("ul:nth-child(1) > li:nth-child(5) > a"));
		B.click();

		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Packages')]")));
		WebElement C = driver.findElement(By.xpath("//span[contains(.,'Packages')]"));
		C.click();

		String randomhValue = RandomGenerator.getRandomh();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("input[placeholder='Package ID or Project Name or Project ID']")));
		WebElement dw = driver
				.findElement(By.cssSelector("input[placeholder='Package ID or Project Name or Project ID']"));

		System.out.println("The unique package number at package uploading is :  " + randomhValue);
		dw.sendKeys(randomhValue);
		dw.submit();

		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='gridcell']//a)[1]")));

		WebElement packageID = driver.findElement(By.xpath("(//div[@role='gridcell']//a)[1]"));
		packageID.click();

		Thread.sleep(5000);

		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait4.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@role='gridcell']/following-sibling::div)[3]")));

		WebElement Stage1 = driver.findElement(By.xpath("(//div[@role='gridcell']/following-sibling::div)[3]"));
		String text = Stage1.getText();
		System.out.println();
		System.out.println("The fourth Stage in Adminstrative tab is  " + text);
		WebElement Status = driver.findElement(By.xpath("(//div[text()='In Progress'])[1]"));
		String dropdown = Status.getText();
		System.out.println("The fourth Status in Administrative tab is  " + dropdown);

		Thread.sleep(5000);

		WebElement switchRole = driver.findElement(By.xpath("//div[@class='dropdown']//a[1]"));
		switchRole.click();
		WebElement SS = driver.findElement(By.xpath("//button[text()='Switch Roles']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", SS);
		
		Thread.sleep(5000);
		
		driver.quit();
	}

}

class Home extends Login {

	private WebDriver driver;
	public String randomString;

	public Home(WebDriver driver) {
		this.driver = driver;
	}
	@Test
	public void performLogin() {
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("swathi.a+2@westagilelabs.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@Test
	public void Design() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='role-text' and text()='Design User']")));
		WebElement n = driver.findElement(By.xpath("//div[@class='role-text' and text()='Design User']"));
		n.click();
	}
	@Test
	public void mandatory() {
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(150));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(("(//div[@class='css-bg1rzq-control select-dropdown__control']//div)[1]"))));
		// div[@class='css-1pcexqc-container select-container'][2]
		WebElement s = driver
				.findElement(By.xpath("(//div[@class='css-bg1rzq-control select-dropdown__control']//div)[1]"));
		s.click();

		try {

			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(150));
			wait2.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(("//div[text()='00-AAAA-WI-Finaltest']"))));
			WebElement job = driver.findElement(By.xpath("//div[text()='00-AAAA-WI-Finaltest']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", job);
			// job.click();
		} catch (ElementNotInteractableException e) {
			System.out.println("Element not interactable: " + e.getMessage());
		}
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(150));
		wait2.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(("//input[@class='form-control form-control']"))));
		WebElement y = driver.findElement(By.xpath("//input[@class='form-control form-control']"));
		y.click();

		String randomhValue = RandomGenerator.getRandomh();
		y.sendKeys(randomhValue);
		System.out.println("The unique number " + randomhValue);

		WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(150));
		wait9.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(("//div[@class='react-datepicker__input-container']"))));
		WebElement cal = driver.findElement(By.xpath("//div[@class='react-datepicker__input-container']"));
		cal.click();
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//div[@aria-label='day-31']]"))));
		WebElement date = driver.findElement(By.xpath("//div[@aria-label='day-31']"));
		date.click();

		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait5.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='css-1pcexqc-container design-user-facility-dropdown']")));

		WebElement dropdown = driver
				.findElement(By.xpath("//div[@class='css-1pcexqc-container design-user-facility-dropdown']"));
		dropdown.click();

		int at = 0;
		boolean success = false;
		while (at < 3 && !success) {
			try {
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/p")));
				WebElement FabricationDD = driver.findElement(By.xpath("//div/p"));
				FabricationDD.click();
				success = true;
			} catch (StaleElementReferenceException e) {
				at++;
				System.out.println("StaleElementReferenceException occurred, retrying...");

			}
		}

	}
	@Test
	public void upload1() throws AWTException, Exception {

		WebElement check = driver.findElement(By.id("thirdPartyExamination"));
		check.click();

		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait5.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//span[@id='Msaccess-filename']/following-sibling::div)[1]")));

		WebElement upload = driver.findElement(By.xpath("(//span[@id='Msaccess-filename']/following-sibling::div)[1]"));
		// Create an instance of Actions
		upload.click();

		// Runtime.getRuntime().exec("D:\\UP\\Up.Exe"); - unique -1
		Process upProcess = Runtime.getRuntime().exec("D:\\UP\\Up.Exe");
		int upExitCode = upProcess.waitFor();
		System.out.println("Up.Exe exited with code: " + upExitCode);

	}
	@Test
	public void upload2() throws AWTException, Exception {

		WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait7.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[contains(@class,'options-to-select upload-select-option')])[2]")));

		WebElement uploadDraw = driver
				.findElement(By.xpath("(//div[contains(@class,'options-to-select upload-select-option')])[2]"));
		uploadDraw.click();

		// Runtime.getRuntime().exec("D:\\Down\\Down.Exe"); - unique - 2
		Process downProcess = Runtime.getRuntime().exec("D:\\Down\\Down.Exe");
		int downExitCode = downProcess.waitFor();
		System.out.println("Down.Exe exited with code: " + downExitCode);

	}
	@Test
	public void uploadPdf() throws AWTException, Exception {

		WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait7.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='options-to-select upload-select-option position-relative form-group'])[3]")));

		WebElement uploadDraw = driver.findElement(
				By.xpath("(//div[@class='options-to-select upload-select-option position-relative form-group'])[3]"));
		uploadDraw.click();

		Process upProcess = Runtime.getRuntime().exec("D:\\PDF files\\BOM.exe");
		int upExitCode = upProcess.waitFor();
		System.out.println("Up.Exe exited with code: " + upExitCode);
	}
	@Test
	public void fabric() {

		WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait11.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='css-bg1rzq-control select-dropdown__control'])[2]")));

		WebElement Dropdown = driver
				.findElement(By.xpath("(//div[@class='css-bg1rzq-control select-dropdown__control'])[2]"));
		Dropdown.click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Carbon Steel']")));

		WebElement ddd = driver.findElement(By.xpath("//div[text()='Carbon Steel']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ddd);
	}
	@Test
	public void upload3() throws AWTException, Exception {
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait3.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[contains(@class,'options-to-select upload-select-option')])[4]")));

		WebElement uploadField = driver
				.findElement(By.xpath("(//div[contains(@class,'options-to-select upload-select-option')])[4]"));
		uploadField.click();

		// unique 3
		Process downProcess = Runtime.getRuntime().exec("D:\\fabric\\fabric.exe");
		int downExitCode = downProcess.waitFor();
		System.out.println("Down.Exe exited with code: " + downExitCode);

	}
	@Test
	public void upload4() throws AWTException, Exception {
		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait5.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[contains(@class,'options-to-select upload-select-option')])[5]")));

		WebElement uploadFieldZip = driver
				.findElement(By.xpath("(//div[contains(@class,'options-to-select upload-select-option')])[5]"));
		uploadFieldZip.click();

		// unique-4
		Process upProcess = Runtime.getRuntime().exec("D:\\Fabric_Zip\\FabricZip.exe");
		int upExitCode = upProcess.waitFor();
		System.out.println("Up.Exe exited with code: " + upExitCode);

	}
	@Test
	public void uploadPdf1() throws AWTException, Exception {

		WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait7.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='options-to-select upload-select-option position-relative form-group'])[6]")));

		WebElement uploadDraw = driver.findElement(
				By.xpath("(//div[@class='options-to-select upload-select-option position-relative form-group'])[6]"));
		uploadDraw.click();

		Process downProcess = Runtime.getRuntime().exec("D:\\PDF files\\BOM1.exe");
		int downExitCode = downProcess.waitFor();
		System.out.println("Down.Exe exited with code: " + downExitCode);

	}
	@Test
	public void field() {

		WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait7.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='css-bg1rzq-control select-dropdown__control'])[3]")));

		WebElement Dropdown = driver
				.findElement(By.xpath("(//div[@class='css-bg1rzq-control select-dropdown__control'])[3]"));
		Dropdown.click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Bronze']")));

		WebElement dd = driver.findElement(By.xpath("//div[text()='Bronze']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", dd);
	}
	@Test
	public void hanger() throws AWTException, Exception {

		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait4.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='options-to-select upload-select-option position-relative form-group'])[7]")));

		WebElement uploadField = driver.findElement(
				By.xpath("(//div[@class='options-to-select upload-select-option position-relative form-group'])[7]"));
		uploadField.click();
		Process upProcess = Runtime.getRuntime().exec("D:\\Hanger\\Hang.exe");
		int upExitCode = upProcess.waitFor();
		System.out.println("Up.Exe exited with code: " + upExitCode);

	}
	@Test
	public void hangPdf() throws AWTException, Exception {
		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait5.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='options-to-select upload-select-option position-relative form-group'])[8]")));

		WebElement uploadFieldPdf = driver.findElement(
				By.xpath("(//div[@class='options-to-select upload-select-option position-relative form-group'])[8]"));
		uploadFieldPdf.click();

		Process downProcess = Runtime.getRuntime().exec("D:\\Hanger\\HangPdf.exe");
		int downExitCode = downProcess.waitFor();
		System.out.println("Down.Exe exited with code: " + downExitCode);

	}
	@Test
	public void Structure() {

		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait5.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='position-relative form-group'])[7]")));

		WebElement struct = driver.findElement(By.xpath("(//div[@class='position-relative form-group'])[7]"));
		struct.click();

		WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Pan deck']")));

		WebElement d = driver.findElement(By.xpath("//div[text()='Pan deck']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", d);
	}
	@Test
	public void Material() {

		WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait9.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='position-relative form-group'])[8]")));

		WebElement str = driver.findElement(By.xpath("(//div[@class='position-relative form-group'])[8]"));
		str.click();

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Galvanized']")));

		WebElement dw = driver.findElement(By.xpath("//div[text()='Galvanized']"));
		JavascriptExecutor jh = (JavascriptExecutor) driver;
		jh.executeScript("arguments[0].click();", dw);

	}
	@Test
	public void category() {

		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait5.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='css-bg1rzq-control select-dropdown__control'])[6]")));

		WebElement dropdown = driver
				.findElement(By.xpath("(//div[@class='css-bg1rzq-control select-dropdown__control'])[6]"));
		dropdown.click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Assemble']")));

		WebElement ddd = driver.findElement(By.xpath("//div[text()='Assemble']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ddd);
	}
	@Test
	public void misc() throws AWTException, Exception {
		WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait9.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='options-to-select upload-select-option position-relative form-group'])[10]")));

		WebElement hang = driver.findElement(
				By.xpath("(//div[@class='options-to-select upload-select-option position-relative form-group'])[10]"));
		hang.click();

		Process upProcess = Runtime.getRuntime().exec("D:\\misc\\misck.exe");
		int upExitCode = upProcess.waitFor();
		System.out.println("Up.Exe exited with code: " + upExitCode);

	}
	@Test
	public void hundred() {
		WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='number'])[2]")));
		WebElement e1 = driver.findElement(By.xpath("(//input[@type='number'])[2]"));
		e1.sendKeys("20");
		WebElement e2 = driver.findElement(By.xpath("(//input[@type='number'])[3]"));
		e2.sendKeys("20");
		WebElement e3 = driver.findElement(By.xpath("(//input[@type='number'])[4]"));
		e3.sendKeys("20");
		WebElement e4 = driver.findElement(By.xpath("(//input[@type='number'])[5]"));
		e4.sendKeys("20");
		WebElement e5 = driver.findElement(By.xpath("(//input[@type='number'])[6]"));
		e5.sendKeys("10");
		WebElement e6 = driver.findElement(By.xpath("(//input[@type='number'])[7]"));
		e6.sendKeys("10");
	}
	@Test
	public void submit() throws Exception {
		WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn upload-package']")));
		WebElement button = driver.findElement(By.xpath("//button[@class='btn upload-package']"));
		button.submit();

	}

}

class packages extends Login {
	private WebDriver driver;

	public packages(WebDriver driver) {
		this.driver = driver;

	}
	@Test
	public void fabricationpackages() throws Exception {
		Thread.sleep(30000);

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(80));

		boolean clicked = false;
		int attempts = 0;
		while (!clicked && attempts < 3) {
			try {
				wait2.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("(//div[@class='css-bg1rzq-control select-dropdown__control'])[1]")));
				WebElement element = driver
						.findElement(By.xpath("(//div[@class='css-bg1rzq-control select-dropdown__control'])[1]"));
				element.click();
				clicked = true;
			} catch (ElementClickInterceptedException e) {
				// If click is intercepted, retry after waiting a little
				Thread.sleep(500);
				attempts++;
			}
			catch (StaleElementReferenceException e) {
				// If click is intercepted, retry after waiting a little
				Thread.sleep(500);
				attempts++;
			}
		}

		boolean clicked1 = false;
		int attempts1 = 0;
		while (!clicked1 && attempts1 < 3) {
			try {
				wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/p")));
				WebElement element = driver.findElement(By.xpath("//div/p"));
				element.click();
				clicked1 = true;
			} catch (ElementClickInterceptedException e) {
				// If click is intercepted, retry after waiting a little
				Thread.sleep(500);
				attempts1++;
			}catch (StaleElementReferenceException e) {
				// If click is intercepted, retry after waiting a little
				Thread.sleep(500);
				attempts1++;
			}
		}

		Thread.sleep(10000);

		wait2.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("input[placeholder='Package ID or Project Name or Project ID']")));
		WebElement dw = driver
				.findElement(By.cssSelector("input[placeholder='Package ID or Project Name or Project ID']"));

		String randomhValue = RandomGenerator.getRandomh();
		dw.sendKeys(randomhValue);
		System.out.println("The package number after completing the package upload :  " + randomhValue);
		dw.submit();
		Thread.sleep(3000);

		WebElement switchRole = driver.findElement(By.xpath("//div[@class='dropdown']//a[1]"));
		switchRole.click();
		WebElement SS = driver.findElement(By.xpath("//button[text()='Switch Roles']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", SS);

	}
}

class Administration extends Login {
	private WebDriver driver;

	public Administration(WebDriver driver) {
		this.driver = driver;

	}
	@Test
	public void Administrator() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='role-text' and text()='Administrator']")));
		WebElement n = driver.findElement(By.xpath("//div[@class='role-text' and text()='Administrator']"));
		n.click();
		WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Welder Average Report']")));
		WebElement A = driver.findElement(By.xpath("//h4[text()='Welder Average Report']"));
		A.click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait1.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul:nth-child(1) > li:nth-child(5) > a")));
		WebElement B = driver.findElement(By.cssSelector("ul:nth-child(1) > li:nth-child(5) > a"));
		B.click();

		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Packages')]")));
		WebElement C = driver.findElement(By.xpath("//span[contains(.,'Packages')]"));
		C.click();

		String randomhValue = RandomGenerator.getRandomh();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("input[placeholder='Package ID or Project Name or Project ID']")));
		WebElement dw = driver
				.findElement(By.cssSelector("input[placeholder='Package ID or Project Name or Project ID']"));

		System.out.println("The package number at administrative tab before procurement approval :  " + randomhValue);
		// dw.sendKeys(randomhValue);
		dw.sendKeys(randomhValue);
		dw.submit();

		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='gridcell']//a)[1]")));

		WebElement packageID = driver.findElement(By.xpath("(//div[@role='gridcell']//a)[1]"));
		packageID.click();

		Thread.sleep(5000);

		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait4.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@role='gridcell']/following-sibling::div)[3]")));

		WebElement Stage1 = driver.findElement(By.xpath("(//div[@role='gridcell']/following-sibling::div)[3]"));
		String text = Stage1.getText();
		
		System.out.println();
		System.out.println("The first Stage in Adminstrative tab is  " + text);
		WebElement Status = driver.findElement(By.xpath("(//div[text()='In Progress'])[1]"));
		String dropdown = Status.getText();
		System.out.println("The first Status in Administrative tab is  " + dropdown);

		Thread.sleep(5000);

		WebElement button = driver.findElement(By.xpath("(//div[@class='spools-result-wrap'])//button[1]"));
		button.click();

		Thread.sleep(5000);

		WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait10.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='css-1pcexqc-container select-container']//div)[1]")));

		WebElement approvalDD = driver
				.findElement(By.xpath("(//div[@class='css-1pcexqc-container select-container']//div)[1]"));
		approvalDD.click();
		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Approved as it is']")));
		WebElement Approved = driver.findElement(By.xpath("//div[text()='Approved as it is']"));
		Approved.click();

		WebElement button2 = driver.findElement(By.xpath("//button[@class='btn profile-save-btn']"));
		button2.click();

		Thread.sleep(5000);

		WebDriverWait wait16 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait16.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@role='gridcell']/following-sibling::div)[3]")));

		WebElement Stage2 = driver.findElement(By.xpath("(//div[@role='gridcell']/following-sibling::div)[3]"));
		String text1 = Stage2.getText();
		 System.out.println();
		System.out.println("The Second Stage after procurement approval is " + text1);

		WebElement Status2 = driver.findElement(By.xpath("(//div[text()='In Progress'])[1]"));
		String dropdown2 = Status2.getText();
		System.out.println("The Second Status after procurement approval is " + dropdown2);
		
		Thread.sleep(4000);
		
		WebElement switchRole = driver.findElement(By.xpath("//div[@class='dropdown']//a[1]"));
		switchRole.click();
		WebElement SS = driver.findElement(By.xpath("//button[text()='Switch Roles']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", SS);
		Thread.sleep(2000);

	}
}

class procurement extends Login {
	private WebDriver driver;

	public procurement(WebDriver driver) {
		this.driver = driver;

	}
	@Test
	public void procs() throws Exception {

		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait5.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='role-text' and text()='Procurement User']")));
		WebElement n = driver.findElement(By.xpath("//div[@class='role-text' and text()='Procurement User']"));
		n.click();

		boolean clicked1 = false;
		int attempts1 = 0;
		while (!clicked1 && attempts1 < 3) {
			try {
				wait5.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[contains(@class,'css-1hwfws3 select-dropdown__value-container')]")));
				WebElement element = driver.findElement(
						By.xpath("//div[contains(@class,'css-1hwfws3 select-dropdown__value-container')]"));
				element.click();
				clicked1 = true;
			} catch (StaleElementReferenceException e) {
				// If click is intercepted, retry after waiting a little
				Thread.sleep(500);
				attempts1++;
			}
		}

		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(.,'All Facilities')]")));

		WebElement dropdown = driver.findElement(By.xpath("//strong[contains(.,'All Facilities')]"));
		dropdown.click();
		//// div[@id='react-select-2-option-0']/strong

		Thread.sleep(4000);
		WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(80));
		String randomhValue = RandomGenerator.getRandomh();

		wait5.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//span[contains(text(), '" + randomhValue + "')])[2]")));

		WebElement element = driver.findElement(By.xpath("(//span[contains(text(), '" + randomhValue + "')])[2]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		element.click();
		WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='po-input']")));

		WebElement ABB = driver.findElement(By.xpath("//input[@class='po-input']"));
		ABB.sendKeys(randomhValue);

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

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Adjust wait time as needed

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
				second.click();

				int attempts = 0;
				boolean elementFound = false;

				while (attempts < 3 && !elementFound) {
					try {
						// Wait for the element to be present in the DOM
						WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(60));
						WebElement dd = wait4
								.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]/div/div[3]")));

						// Check if the element is clickable (visible and enabled)
						wait4.until(ExpectedConditions.elementToBeClickable(dd));
						dd.click();

						// If successful, set the flag to true to break out of the loop
						elementFound = true;
					} catch (org.openqa.selenium.TimeoutException e) {
						// This block catches the case where the element wasn't found in time
						System.out.println("Element not found (attempt " + attempts + "): " + e.getMessage());
					} catch (ElementNotInteractableException e) {
						// This block catches the case where the element is not interactable
						System.out.println("Element is not interactable (attempt " + attempts + "): " + e.getMessage());
					} catch (StaleElementReferenceException e) {
						// If click is intercepted, retry after waiting a little
						Thread.sleep(500);
						attempts++;
					}
				}

				if (!elementFound) {
					System.out.println("Element could not be found or interacted with after 3 attempts.");
				}

				WebElement nest2 = driver.findElement(By.xpath("(//button[@class='nest-btn'])[2]"));
				nest2.click();
			} else if (i == 2) {
				WebElement third = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("(//div[@class='css-1pcexqc-container select-container field-focus'])[3]")));
				third.click();
				WebElement dd3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div/div[3]")));
				dd3.click();
				WebElement nest3 = driver.findElement(By.xpath("(//button[@class='nest-btn'])[3]"));
				nest3.click();
			} else if (i == 3) {
				WebElement fourth = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("(//div[@class='css-1pcexqc-container select-container field-focus'])[4]")));
				fourth.click();
				WebElement dd4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div/div[3]")));
				dd4.click();
				WebElement nest4 = driver.findElement(By.xpath("(//button[@class='nest-btn'])[4]"));
				nest4.click();
			} else if (i == 4) {
				WebElement fifth = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("(//div[@class='css-1pcexqc-container select-container field-focus'])[5]")));
				fifth.click();
				WebElement dd5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div/div[3]")));
				dd5.click();
				WebElement nest5 = driver.findElement(By.xpath("(//button[@class='nest-btn'])[5]"));
				nest5.click();
			} else if (i == 5) {
				WebElement sixth = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("(//div[@class='css-1pcexqc-container select-container field-focus'])[6]")));
				JavascriptExecutor ju = (JavascriptExecutor) driver;
				ju.executeScript("window.scrollBy(0,1000)");
				sixth.click();
				WebElement dd6 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div/div[3]")));
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
		Thread.sleep(3000);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='multiselect-dropdown-container multiselect-dropdown-supplier']")));
		WebElement DD = driver
				.findElement(By.xpath("//div[@class='multiselect-dropdown-container multiselect-dropdown-supplier']"));

		DD.click();
		Thread.sleep(1000);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='picky-list']/div[1]/input[1]")));
		WebElement Supply = driver.findElement(By.xpath("//div[@id='picky-list']/div[1]/input[1]"));
		Supply.click();

		if (Supply.isSelected()) {
			System.out.println("Already selected ");
		} else {
			Supply.click();
		}

		wait5.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Subject']/following::input")));
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

		wait5.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='multiselect-dropdown-container multiselect-dropdown-supplier']")));
		WebElement DD1 = driver
				.findElement(By.xpath("//div[@class='multiselect-dropdown-container multiselect-dropdown-supplier']"));
		DD1.click();
		Thread.sleep(1000);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='picky-list']/div[1]/input[1]")));
		WebElement Supply1 = driver.findElement(By.xpath("//div[@id='picky-list']/div[1]/input[1]"));
		Supply1.click();
		if (Supply1.isSelected()) {
			System.out.println("Already selected ");
		} else {
			Supply1.click();
		}

		wait5.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Subject']/following::input")));
		WebElement content1 = driver.findElement(By.xpath("//label[text()='Subject']/following::input"));
		content1.sendKeys("Content  is  required");

		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Submit']")));
		WebElement butt1 = driver.findElement(By.xpath("//button[text()='Submit']"));

		butt1.click();

		WebElement close1 = driver.findElement(By.xpath("//button[@aria-label='Close']"));
		close1.click();

		Thread.sleep(4000);

		wait8.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(randomhValue)));

		WebElement element1 = driver.findElement(By.partialLinkText(randomhValue));
		JavascriptExecutor jw = (JavascriptExecutor) driver;
		jw.executeScript("window.scrollBy(0,1000)");
		element1.click();

		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Receive All']")));
		WebElement recieve = driver.findElement(By.xpath("//button[text()='Receive All']"));
		recieve.click();
		Thread.sleep(4000);
		WebElement switchRole = driver.findElement(By.xpath("//div[@class='dropdown']//a[1]"));
		switchRole.click();
		WebElement SS = driver.findElement(By.xpath("//button[text()='Switch Roles']"));
		JavascriptExecutor jr = (JavascriptExecutor) driver;
		jr.executeScript("arguments[0].click();", SS);

	}
}

class Drag extends Login {
	private WebDriver driver;

	public Drag(WebDriver driver) {
		this.driver = driver;

	}
	@Test
	public void DraggingDropping() throws Exception {

		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait5.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='role-text' and text()='Administrator']")));
		WebElement n = driver.findElement(By.xpath("//div[@class='role-text' and text()='Administrator']"));
		n.click();

		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Schedule Manager")));
		WebElement schedule = driver.findElement(By.linkText("Schedule Manager"));
		schedule.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));

		String randomhValue = RandomGenerator.getRandomh();
			System.out.println("Dragged package" + randomhValue);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//span[contains(text(), '" + randomhValue + "')])")));
		WebElement source = driver.findElement(By.xpath("(//span[contains(text(), '" + randomhValue + "')])"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='DQK-1540unique']")));

		WebElement target = driver.findElement(By.xpath("//span[text()='DQK-1540unique']"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(source) // Click on the source element
				.moveByOffset(0, 50) // Move the source element downward (you can adjust these values)
				.moveToElement(target) // Move the mouse to the target element
				.release() // Release the mouse to drop it
				.build().perform();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].dispatchEvent(new MouseEvent('mousedown', {bubbles: true, cancelable: true}));",
				source);
		js.executeScript("arguments[0].dispatchEvent(new MouseEvent('mousemove', {bubbles: true, cancelable: true}));",
				target);
		js.executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseup', {bubbles: true, cancelable: true}));",
				target);

		Thread.sleep(4000);

		System.out.println("Drag and drop action completed!");

		Thread.sleep(4000);
		
		WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Packages')]")));
		WebElement C = driver.findElement(By.xpath("//span[contains(.,'Packages')]"));
		C.click();
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("input[placeholder='Package ID or Project Name or Project ID']")));
		WebElement dw = driver
				.findElement(By.cssSelector("input[placeholder='Package ID or Project Name or Project ID']"));
		// dw.sendKeys(randomhValue);
		dw.sendKeys(randomhValue);
		dw.submit();

		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='gridcell']//a)[1]")));

		WebElement packageID = driver.findElement(By.xpath("(//div[@role='gridcell']//a)[1]"));
		packageID.click();

		Thread.sleep(5000);
		
		System.out.println(" Stage checking after package is dropped ");

		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait4.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@role='gridcell']/following-sibling::div)[3]")));

		WebElement Stage1 = driver.findElement(By.xpath("(//div[@role='gridcell']/following-sibling::div)[3]"));
		String text = Stage1.getText();
		 System.out.println();
		System.out.println("The third Stage in Adminstrative tab is  " + text);
		WebElement Status = driver.findElement(By.xpath("(//div[text()='In Progress'])[1]"));
		String dropdown = Status.getText();
		System.out.println("The third Status in Administrative tab is  " + dropdown);

		Thread.sleep(5000);


		WebElement switchRole = driver.findElement(By.xpath("//div[@class='dropdown']//a[1]"));
		switchRole.click();
		WebElement SS = driver.findElement(By.xpath("//button[text()='Switch Roles']"));
		JavascriptExecutor jr = (JavascriptExecutor) driver;
		jr.executeScript("arguments[0].click();", SS);
		Thread.sleep(5000);

	}
}

class Heatnum extends Login {
	private WebDriver driver;

	public Heatnum(WebDriver driver) {
		this.driver = driver;

	}
	@Test
	public void Heating() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='role-text' and text()='Fabrication']")));
		WebElement n = driver.findElement(By.xpath("//div[@class='role-text' and text()='Fabrication']"));
		n.click();

		Thread.sleep(5000);

		boolean clicked = false;
		int attempts = 0;
		while (!clicked && attempts < 3) {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("(//div[@class='css-bg1rzq-control select-dropdown__control'])[1]")));
				WebElement element = driver
						.findElement(By.xpath("(//div[@class='css-bg1rzq-control select-dropdown__control'])[1]"));
				element.click();
				clicked = true;
			} catch (ElementClickInterceptedException e) {
				// If click is intercepted, retry after waiting a little
				Thread.sleep(500);
				attempts++;
			}
		}

		boolean clicked6 = false;
		int attempts6 = 0;
		while (!clicked6 && attempts6 < 3) {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/p")));
				WebElement div = driver.findElement(By.xpath("//div/p"));
				div.click();
				clicked6 = true;
			} catch (ElementClickInterceptedException e) {
				// If click is intercepted, retry after waiting a little
				Thread.sleep(500);
				attempts6++;
			}
		}

		Thread.sleep(4000);

		boolean clicked1 = false;
		int attempts1 = 0;
		while (!clicked1 && attempts1 < 3) {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("(//div[@class='css-bg1rzq-control select-dropdown__control'])[2]")));
				WebElement element = driver
						.findElement(By.xpath("(//div[@class='css-bg1rzq-control select-dropdown__control'])[2]"));
				element.click();
				clicked1 = true;
			} catch (ElementClickInterceptedException e) {
				// If click is intercepted, retry after waiting a little
				Thread.sleep(500);
				attempts1++;
			}
		}

		WebElement select2 = driver.findElement(By.xpath("//div[2]/div[2]/div/div[2]"));
		select2.click();

		Thread.sleep(3000);

		boolean rr = false;
		int attempts3 = 0;
		while (!rr && attempts3 < 3) {
			try {
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("(//i[@class='packageid-name-arrow'])[1]")));
				WebElement element = driver.findElement(By.xpath("(//i[@class='packageid-name-arrow'])[1]"));
				element.click();
				rr = true;
			} catch (ElementClickInterceptedException e) {
				// If click is intercepted, retry after waiting a little
				Thread.sleep(500);
				attempts3++;
			}
		}

		String randomhValue = RandomGenerator.getRandomh();

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='" + randomhValue + "'])[1]")));
		WebElement wal = driver.findElement(By.xpath("(//span[text()='" + randomhValue + "'])[1]"));
		wal.click();

		Thread.sleep(5000);
		List<WebElement> all = driver.findElements(By.xpath("//div[@role='gridcell']//input[@value='']"));
		System.out.println(all.size());

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(80));

		for (int i = all.size() - 1; i >= 0; i--) {
			int element = 1;
			element = i * 2 + 1;

			if (i == all.size() - 1) {

				int at = 0;
				boolean success = false;
				while (at < 3 && !success) {
					try {
						wait1.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("(//div[@role='gridcell']//input)[" + element + "]")));
						WebElement one = driver
								.findElement(By.xpath("(//div[@role='gridcell']//input)[" + element + "]"));
						one.sendKeys("30");
						success = true;
					} catch (StaleElementReferenceException e) {
						at++;
						System.out.println("found stale element ");

					}
				}
			}

			else if (i == all.size() - 2) {
				int at = 0;
				boolean success = false;
				while (at < 3 && !success) {
					try {
						wait1.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("(//div[@role='gridcell']//input)[" + element + "]")));
						WebElement one = driver
								.findElement(By.xpath("(//div[@role='gridcell']//input)[" + element + "]"));
						success = true;
						one.sendKeys("30");

					} catch (StaleElementReferenceException e) {
						at++;
						System.out.println("found stale element ");

					}
				}

			} else if (i == all.size() - 3) {
				int at = 0;
				boolean success = false;
				while (at < 3 && !success) {
					try {
						wait1.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("(//div[@role='gridcell']//input)[" + element + "]")));
						WebElement one = driver
								.findElement(By.xpath("(//div[@role='gridcell']//input)[" + element + "]"));
						success = true;
						one.sendKeys("30");

					} catch (StaleElementReferenceException e) {
						at++;
						System.out.println("found stale element ");

					}
				}

			} else if (i == all.size() - 4) {
				int at = 0;
				boolean success = false;
				while (at < 3 && !success) {
					try {
						wait1.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("(//div[@role='gridcell']//input)[" + element + "]")));
						WebElement one = driver
								.findElement(By.xpath("(//div[@role='gridcell']//input)[" + element + "]"));
						success = true;
						one.sendKeys("30");
					} catch (StaleElementReferenceException e) {
						at++;
						System.out.println("found stale element ");

					}
				}

			} else if (i == all.size() - 5) {
				int at = 0;
				boolean success = false;
				while (at < 3 && !success) {
					try {
						wait1.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("(//div[@role='gridcell']//input)[" + element + "]")));
						WebElement one = driver
								.findElement(By.xpath("(//div[@role='gridcell']//input)[" + element + "]"));
						success = true;
						one.sendKeys("30");
					} catch (StaleElementReferenceException e) {
						at++;
						System.out.println("found stale element ");

					}
				}

			} else if (i == all.size() - 6) {
				int at = 0;
				boolean success = false;
				while (at < 3 && !success) {
					try {
						wait1.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("(//div[@role='gridcell']//input)[" + element + "]")));
						WebElement one = driver
								.findElement(By.xpath("(//div[@role='gridcell']//input)[" + element + "]"));
						success = true;
						one.sendKeys("30");
					} catch (StaleElementReferenceException e) {
						at++;
						System.out.println("found stale element ");

					}
				}

			} else if (i == all.size() - 7) {
				int at = 0;
				boolean success = false;
				while (at < 3 && !success) {
					try {
						wait1.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("(//div[@role='gridcell']//input)[" + element + "]")));
						WebElement one = driver
								.findElement(By.xpath("(//div[@role='gridcell']//input)[" + element + "]"));
						success = true;
						one.sendKeys("30");
					} catch (StaleElementReferenceException e) {
						at++;
						System.out.println("found stale element ");

					}
				}

			} else if (i == all.size() - 8) {
				int at = 0;
				boolean success = false;
				while (at < 3 && !success) {
					try {
						wait1.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("(//div[@role='gridcell']//input)[" + element + "]")));
						WebElement one = driver
								.findElement(By.xpath("(//div[@role='gridcell']//input)[" + element + "]"));
						success = true;
						one.sendKeys("30");

					} catch (StaleElementReferenceException e) {
						at++;
						System.out.println("found stale element ");

					}
				}

			} else if (i == all.size() - 9) {
				int at = 0;
				boolean success = false;
				while (at < 3 && !success) {
					try {
						wait1.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("(//div[@role='gridcell']//input)[" + element + "]")));
						WebElement one = driver
								.findElement(By.xpath("(//div[@role='gridcell']//input)[" + element + "]"));
						success = true;
						one.sendKeys("30");

					} catch (StaleElementReferenceException e) {
						at++;
						System.out.println("found stale element ");

					}
				}

			} else if (i == all.size() - 10) {

				int at = 0;
				boolean success = false;
				while (at < 3 && !success) {
					try {
						wait1.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("(//div[@role='gridcell']//input)[" + element + "]")));
						WebElement one = driver
								.findElement(By.xpath("(//div[@role='gridcell']//input)[" + element + "]"));
						success = true;
						one.sendKeys("30");

					} catch (StaleElementReferenceException e) {
						at++;
						System.out.println("found stale element ");

					}
				}

			} else if (i == all.size() - 11) {
				int at = 0;
				boolean success = false;
				while (at < 3 && !success) {
					try {
						wait1.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("(//div[@role='gridcell']//input)[" + element + "]")));
						WebElement one = driver
								.findElement(By.xpath("(//div[@role='gridcell']//input)[" + element + "]"));
						success = true;
						one.sendKeys("30");

					} catch (StaleElementReferenceException e) {
						at++;
						System.out.println("found stale element ");

					}
				}

			} else if (i == all.size() - 12) {
				int at = 0;
				boolean success = false;
				while (at < 3 && !success) {
					try {
						wait1.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("(//div[@role='gridcell']//input)[" + element + "]")));
						WebElement one = driver
								.findElement(By.xpath("(//div[@role='gridcell']//input)[" + element + "]"));
						success = true;
						one.sendKeys("30");

					} catch (StaleElementReferenceException e) {
						at++;
						System.out.println("found stale element ");

					}
				}

			} else if (i == all.size() - 13) {
				int at = 0;
				boolean success = false;
				while (at < 3 && !success) {
					try {
						wait1.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("(//div[@role='gridcell']//input)[" + element + "]")));
						WebElement one = driver
								.findElement(By.xpath("(//div[@role='gridcell']//input)[" + element + "]"));
						success = true;
						one.sendKeys("30");

					} catch (StaleElementReferenceException e) {
						at++;
						System.out.println("found stale element ");

					}
				}

			} else if (i == all.size() - 14) {
				int at = 0;
				boolean success = false;
				while (at < 3 && !success) {
					try {
						wait1.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("(//div[@role='gridcell']//input)[" + element + "]")));
						WebElement one = driver
								.findElement(By.xpath("(//div[@role='gridcell']//input)[" + element + "]"));
						success = true;
						one.sendKeys("30");

					} catch (StaleElementReferenceException e) {
						at++;
						System.out.println("found stale element ");

					}
				}

			} else if (i == all.size() - 15) {
				int at = 0;
				boolean success = false;
				while (at < 3 && !success) {
					try {
						wait1.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("(//div[@role='gridcell']//input)[" + element + "]")));
						WebElement one = driver
								.findElement(By.xpath("(//div[@role='gridcell']//input)[" + element + "]"));
						success = true;
						one.sendKeys("30");

					} catch (StaleElementReferenceException e) {
						at++;
						System.out.println("found stale element ");

					}
				}

			} else if (i == all.size() - 16) {
				int at = 0;
				boolean success = false;
				while (at < 3 && !success) {
					try {
						wait1.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("(//div[@role='gridcell']//input)[" + element + "]")));
						WebElement one = driver
								.findElement(By.xpath("(//div[@role='gridcell']//input)[" + element + "]"));
						success = true;
						one.sendKeys("30");

					} catch (StaleElementReferenceException e) {
						at++;
						System.out.println("found stale element ");

					}
				}

			} else if (i == all.size() - 17) {
				int at = 0;
				boolean success = false;
				while (at < 3 && !success) {
					try {
						wait1.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("(//div[@role='gridcell']//input)[" + element + "]")));
						WebElement one = driver
								.findElement(By.xpath("(//div[@role='gridcell']//input)[" + element + "]"));
						success = true;
						one.sendKeys("30");

					} catch (StaleElementReferenceException e) {
						at++;
						System.out.println("found stale element ");

					}
				}

			} else if (i == all.size() - 18) {
				int at = 0;
				boolean success = false;
				while (at < 3 && !success) {
					try {
						wait1.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("(//div[@role='gridcell']//input)[" + element + "]")));
						WebElement one = driver
								.findElement(By.xpath("(//div[@role='gridcell']//input)[" + element + "]"));
						success = true;
						one.sendKeys("30");

					} catch (StaleElementReferenceException e) {
						at++;
						System.out.println("found stale element ");

					}
				}

			} else if (i == all.size() - 19) {
				int at = 0;
				boolean success = false;
				while (at < 3 && !success) {
					try {
						wait1.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("(//div[@role='gridcell']//input)[" + element + "]")));
						WebElement one = driver
								.findElement(By.xpath("(//div[@role='gridcell']//input)[" + element + "]"));
						success = true;
						one.sendKeys("30");

					} catch (StaleElementReferenceException e) {
						at++;
						System.out.println("found stale element ");

					}
				}

			} else if (i == all.size() - 20) {
				int at = 0;
				boolean success = false;
				while (at < 3 && !success) {
					try {
						wait1.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("(//div[@role='gridcell']//input)[" + element + "]")));
						WebElement one = driver
								.findElement(By.xpath("(//div[@role='gridcell']//input)[" + element + "]"));
						success = true;
						one.sendKeys("30");

					} catch (StaleElementReferenceException e) {
						at++;
						System.out.println("found stale element ");

					}
				}

			} else if (i == all.size() - 21) {
				int at = 0;
				boolean success = false;
				while (at < 3 && !success) {
					try {
						wait1.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("(//div[@role='gridcell']//input)[" + element + "]")));
						WebElement one = driver
								.findElement(By.xpath("(//div[@role='gridcell']//input)[" + element + "]"));
						success = true;
						one.sendKeys("30");

					} catch (StaleElementReferenceException e) {
						at++;
						System.out.println("found stale element ");

					}
				}

			} else if (i == all.size() - 22) {
				int at = 0;
				boolean success = false;
				while (at < 3 && !success) {
					try {
						wait1.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("(//div[@role='gridcell']//input)[" + element + "]")));
						WebElement one = driver
								.findElement(By.xpath("(//div[@role='gridcell']//input)[" + element + "]"));
						success = true;
						one.sendKeys("30");

					} catch (StaleElementReferenceException e) {
						at++;
						System.out.println("found stale element ");

					}
				}

			} else if (i == all.size() - 23) {
				int at = 0;
				boolean success = false;
				while (at < 3 && !success) {
					try {
						wait1.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("(//div[@role='gridcell']//input)[" + element + "]")));
						WebElement one = driver
								.findElement(By.xpath("(//div[@role='gridcell']//input)[" + element + "]"));
						success = true;
						one.sendKeys("30");

					} catch (StaleElementReferenceException e) {
						at++;
						System.out.println("found stale element ");

					}
				}

			} else if (i == all.size() - 24) {
				int at = 0;
				boolean success = false;
				while (at < 3 && !success) {
					try {
						wait1.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("(//div[@role='gridcell']//input)[" + element + "]")));
						WebElement one = driver
								.findElement(By.xpath("(//div[@role='gridcell']//input)[" + element + "]"));
						success = true;
						one.sendKeys("30");

					} catch (StaleElementReferenceException e) {
						at++;
						System.out.println("found stale element ");

					}
				}

			} else if (i == all.size() - 25) {
				int at = 0;
				boolean success = false;
				while (at < 3 && !success) {
					try {
						wait1.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("(//div[@role='gridcell']//input)[" + element + "]")));
						WebElement one = driver
								.findElement(By.xpath("(//div[@role='gridcell']//input)[" + element + "]"));
						success = true;
						one.sendKeys("30");

					} catch (StaleElementReferenceException e) {
						at++;
						System.out.println("found stale element ");

					}
				}

			} else {
				System.out.println("saved the heat number");
				System.out.println("Processing index: " + i);

			}

		}

		WebElement save = driver.findElement(By.xpath("//button[@class='btn-to-click btn']"));
		save.click();
		Thread.sleep(8000);

		while (true) {
			// Fetch the current total size
			List<WebElement> total = driver.findElements(By.xpath("(//a[@class='nav-link dropdown-toggle'])[2]"));
			// Break the loop if there are no more elements
			if (total.isEmpty()) {
				System.out.println("No more elements to process. Exiting...");
				break;
			}

			// Process the first element in the list
			try {
				int attempts5 = 0;
				boolean success5 = false;

				while (attempts5 < 3 && !success5) {
					try {

						wait1.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("(//a[@class='nav-link dropdown-toggle'])[2]")));
						WebElement toggle = driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle'])[2]"));

						toggle.click();
						success5 = true;
					} catch (StaleElementReferenceException e) {
						attempts5++;
						System.out.println("Stale Element Reference Exception, retrying...");
					} catch (NoSuchElementException e) {
						// If the element is not found, exit the loop or continue with the next action
						System.out.println("Element not found. Exiting loop or continuing...");
						System.exit(1);
						break;
					} catch (org.openqa.selenium.TimeoutException e) {
						// If the element is not visible within the timeout, exit the loop
						System.out.println("Element not visible within the timeout. Exiting loop...");
						break; // Exit the loop if the element is not visible in time
					}

					if (success5) {
						// Wait and click the 'Complete' button
						wait1.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("(//button[text()='Complete'])[1]")));
						WebElement completeButton = driver.findElement(By.xpath("(//button[text()='Complete'])[1]"));
						completeButton.click();

						WebElement printButton = driver.findElement(By.xpath("//button[text()=' Print']"));
						printButton.click();

						// Optional delay for navigation
						Thread.sleep(8000);
					} else {
						// Element is not present
						System.out.println("Print button not found. Stopping the test.");
						// Stop further execution
						return;
					}

					// Navigate back
					driver.navigate().back();

					// Optional delay after navigation
					Thread.sleep(8000);

					List<WebElement> totalAfterAction = driver
							.findElements(By.xpath("(//a[@class='nav-link dropdown-toggle'])"));
					System.out.println("After action, current total size: " + totalAfterAction.size());

					Thread.sleep(4000);

				}

			} catch (Exception e) {
				System.out.println("Error processing an element: " + e.getMessage());

			}

		}

		WebElement select3 = driver.findElement(By.xpath("(//div[@class='css-1pcexqc-container cut-station'])"));
		select3.click();

		WebElement SH = driver.findElement(By.xpath("//div[2]/div[2]/div/div[3]"));
		SH.click();

		Thread.sleep(5000);
		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(80));

		while (true) {
			// Fetch the current total size
			List<WebElement> sumOf = driver.findElements(By.xpath("//div[@role='gridcell']//input[@value='']"));

			// Break the loop if there are no more elements
			if (sumOf.isEmpty()) {
				System.out.println("No more elements to process.");
				break;
			} else {
				int i = 1;
				wait5.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("(//div[@role='gridcell']//input[@value=''])[" + i + "]")));
				WebElement enter = driver
						.findElement(By.xpath("(//div[@role='gridcell']//input[@value=''])[" + i + "]"));
				enter.sendKeys("40");
				i = i + 1;

			}

		}
		WebElement save1 = driver.findElement(By.xpath("//button[@class='btn-to-click btn']"));
		save1.click();

		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Completed cuts']")));
		WebElement completeCuts = driver.findElement(By.xpath("//span[text()='Completed cuts']"));
		completeCuts.click();
		System.out.println("Program is done , Please check the Stage  ");
		
		Thread.sleep(5000);


		WebElement switchRole = driver.findElement(By.xpath("//div[@class='dropdown']//a[1]"));
		switchRole.click();
		WebElement SS = driver.findElement(By.xpath("//button[text()='Switch Roles']"));
		JavascriptExecutor jr = (JavascriptExecutor) driver;
		jr.executeScript("arguments[0].click();", SS);
		Thread.sleep(5000);

	}
}
