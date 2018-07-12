import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;



public class Camel {
	WebDriver driver;
	
	By username =By.name("username");
	By password = By.name("pwd");
	By loginbtn = By.id("loginButton");
	By gnrlsettings = By.xpath(".//*[@id='topnav']/tbody/tr[1]/td[13]/a/img");
	By topgrplevel =By.name("firstHierarchyLevelCode");
	By middlelevel = By.name("secondHierarchyLevelCode");
	By timeentry = By.name("ThirdHierarchyLevelCode");
	By savebtn = By.xpath(".//*[@id='ButtonPane']/table/tbody/tr[2]/td[2]/input");
	public Camel(WebDriver dr){
		this.driver = dr;
	}
	
	public void max(){
		driver.manage().window().maximize();
	}
	public void waits(){
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	public void Enterusername(){
		driver.findElement(username).sendKeys("admin");
				
	}
	
	public void Enterpwd(){
		driver.findElement(password).sendKeys("MANAGER");
			}
	public void clicklgnbutton(){
		driver.findElement(loginbtn).click();
			}
	public void gnrlsettings (){
		driver.findElement(gnrlsettings).click();
			}
	public void topgrplevel(){
		driver.findElement(topgrplevel).sendKeys("Customer");
			}
	public void middlelevel(){
		driver.findElement(middlelevel).sendKeys("Product");
			}
	public void timeentry(){
		driver.findElement(timeentry).sendKeys("Task");
			}
	public void dropdown(){
		((JavascriptExecutor)driver).executeScript("argument[0],scrollIntoView())",driver);//  = JavascriptExecutor(driver);
		//jse.executeSc
		
		//script("scroll(0,250)");
	}
	public void scroll(){
		((JavascriptExecutor)driver).executeScript("scroll(0,250)");
	}
	

	public void Savebtn(){
		driver.findElement(savebtn).click();
		
	}
	
	
	
}
