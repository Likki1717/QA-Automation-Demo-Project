package kimball;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class fifth {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://staging.bkimechanical.com/login");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("swathi.a+2@westagilelabs.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
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
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div/p")));
				WebElement div = driver
						.findElement(By.xpath("//div/p"));
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

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='pkg7-29apr24'])[1]")));
		WebElement wal = driver.findElement(By.xpath("(//span[text()='pkg7-29apr24'])[1]"));
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
			
			}
			else if (i == all.size() - 22) {
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
				

			}
			else if (i == all.size() - 23) {
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
			

			}
			else if (i == all.size() - 24) {
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
				

			}
			else if (i == all.size() - 25) {
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
			
			}
			else {
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
			 System.out.println("Current total size: " + total.size());
			// Break the loop if there are no more elements
			if (total.isEmpty()) {
		        System.out.println("No more elements to process. Exiting...");
		        break;
		    }

			// Process the first element in the list
			try {
				int attempts5 = 0;
				boolean success5 = false;

				while (attempts5 < 3 && !success5)  {
					try {						    
						 
						wait1.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("(//a[@class='nav-link dropdown-toggle'])[2]")));
						WebElement toggle = driver
									.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle'])[2]"));
						
						
						    
						toggle.click();
						success5 = true;
					} catch (StaleElementReferenceException e) {
						attempts5++;
						 System.out.println("Stale Element Reference Exception, retrying...");
					}catch (NoSuchElementException e) {
					    // If the element is not found, exit the loop or continue with the next action
					    System.out.println("Element not found. Exiting loop or continuing...");
					    System.exit(1); 
					    break; 
				} catch (org.openqa.selenium.TimeoutException e) {
	                // If the element is not visible within the timeout, exit the loop
	                System.out.println("Element not visible within the timeout. Exiting loop...");
	                break;  // Exit the loop if the element is not visible in time
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
				  
					 List<WebElement> totalAfterAction = driver.findElements(By.xpath("(//a[@class='nav-link dropdown-toggle'])"));
					    System.out.println("After action, current total size: " + totalAfterAction.size());
					    
					    Thread.sleep(4000);
					  
				}
				
			}
			 catch (Exception e) {
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
			}
			else {
				int i=1;
				wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='gridcell']//input[@value=''])["+i+"]")));
				WebElement enter = driver.findElement(By.xpath("(//div[@role='gridcell']//input[@value=''])["+i+"]"));
				enter.sendKeys("40");
				i=i+1;
				
			}
			
		
		}
		WebElement save1 = driver.findElement(By.xpath("//button[@class='btn-to-click btn']"));
		save1.click();
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[text()='Completed cuts']")));
		WebElement completeCuts = driver.findElement(By.xpath("//span[text()='Completed cuts']"));
		completeCuts.click();
		System.out.println("program is done , complete cuts are shown here");
		}
	}

