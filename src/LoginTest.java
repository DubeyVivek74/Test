
import java.io.File;
import java.io.IOException;
import java.util.Set;

//import junit.framework.Assert;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver driver;
	String mainWindowHandle;
	Actions act ;
	Reading_Excel reader;
	
	@BeforeTest
	public void setup(){
		driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "D:/Komal/Softwares/chromedriver.exe");
		driver = new ChromeDriver();//driver = new Chromedriver(); } else{ driver = new FirefoxDriver();}
		reader = new Reading_Excel("Data.xls");
		//if(reader.getData("BROWSER_NAME")).equalsIgnoreCase("cHROME")){
		driver.get(reader.getData("WEBSITE_URL"));
		driver.manage().window().maximize();
		mainWindowHandle = driver.getWindowHandle();
		act = new Actions(driver);
	}
	
	@Test
	public void whenValidCredentials_NaukriShouldLogin() throws IOException{
		try {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for(String handle : allWindowHandles){
			if(!handle.equals(mainWindowHandle)){
				driver.switchTo().window(handle);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindowHandle);
		
		String loginLinkXpath = reader.getData("LOGIN_LINK_XPATH");
		WebElement loginLink = driver.findElement(By.xpath(loginLinkXpath));
		loginLink.click();
	
		String emailIdXpath = reader.getData("USERNAME_XPATH");
		WebElement emailId = driver.findElement(By.xpath(emailIdXpath));
		emailId.sendKeys(reader.getData("USERNAME"));
		
		String passwordXpath = reader.getData("PASSWORD_XPATH");
		WebElement password = driver.findElement(By.xpath(passwordXpath));
		password.sendKeys(reader.getData("PASSWORD"));
		
		String loginButtonXpath = reader.getData("LOGIN_BUTTON_XPATH");
		WebElement loginButton = driver.findElement(By.xpath(loginButtonXpath));
		loginButton.click();
	
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		String nameSpanXpath = reader.getData("NAME_DISPLAY_SPAN_XPATH");
		WebElement nameSpan = wait.until
				(ExpectedConditions.presenceOfElementLocated(By.xpath(nameSpanXpath)));
		String expectedName = reader.getData("ASSERT_TEXT");
				
		String actualName = nameSpan.getText();
		
		Assert.assertEquals(expectedName, actualName);
		
		WebElement jobs = driver.findElement(By.xpath(reader.getData("MY_JOBS_XPATH")));
		act.moveToElement(jobs).perform();
		
		driver.findElement(By.xpath(reader.getData("BROWSE_ALL_JOBS_XPATH"))).click();
		allWindowHandles = driver.getWindowHandles();
		for(String handle : allWindowHandles){
			if(!handle.equals(mainWindowHandle)){
				driver.switchTo().window(handle);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindowHandle);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("D:/screenshot.png"));
		} catch (Exception e) {
			e.printStackTrace();
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("D:/screenshot.png"));
		}
		
	}
	
	
	@AfterTest
	public void tearDown(){
		WebElement myNaukriDropDown = driver.findElement(
				By.xpath(reader.getData("MY_NAUKRI_XPATH")));
		act.moveToElement(myNaukriDropDown).perform();;
		
		WebElement logoutLink = driver.findElement(By.xpath(
				reader.getData("LOGOUT_LINK_XPATH")));
		logoutLink.click();
		driver.quit();
	}
	

}