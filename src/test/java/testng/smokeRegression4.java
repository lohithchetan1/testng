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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class smokeRegression4 {
	public static WebDriver driver;
	@BeforeSuite(groups="regression")
	public void connDb() {
		Reporter.log("connecting to database",true);
	}
	
	@BeforeTest(groups="regression")
	public void openAppthree() {
		WebDriverManager.firefoxdriver().setup();		
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapp.skillrary.com/login.php?type=login");
	}
		
		@Test(groups="regression")
		public void login() {
			driver.findElement(By.id("email")).sendKeys("admin");
			driver.findElement(By.id("password")).sendKeys("admin");
			driver.findElement(By.name("login")).click();
		}
		
		@Test(groups="regression")
		public void sales() {
			driver.findElement(By.xpath("//span[text()='Sales']")).click();
		}
			
			
			@AfterTest(groups="regression")
			public void closeApp() {
				driver.close();
			}
			
			@AfterSuite(groups="regression")
			public void disconnDb() {
				Reporter.log("disconnectconnecting to database",true);
			}
			
			
		
		
		
	}


