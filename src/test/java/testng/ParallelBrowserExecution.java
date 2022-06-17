package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelBrowserExecution {
	public static WebDriver driver;
	@BeforeSuite
	public void connDb() {
		Reporter.log("connecting to database",true);
	}
	
	@Parameters({"browsername"})
	@BeforeMethod
	public void openAppthree(String browser) {
		//WebDriverManager.chromedriver().setup();
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		
			
		}
		else {
			
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
			
		}
		
		driver.manage().window().maximize();
		driver.get("https://demoapp.skillrary.com/login.php?type=login");
	}
		
		@Test
		public void login() {
			driver.findElement(By.id("email")).sendKeys("admin");
			driver.findElement(By.id("password")).sendKeys("admin");
			driver.findElement(By.name("login")).click();
		}
		
		@Test
		public void sales() {
			driver.findElement(By.xpath("//span[text()='Sales']")).click();
		}
			
			
			@AfterMethod
			public void closeApp() {
				driver.close();
			}
			
			@AfterSuite
			public void disconnDb() {
				Reporter.log("disconnectconnecting to database",true);
			}
			
			
		
		
		
	}


