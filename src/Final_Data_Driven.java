import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;

/**
 * 
 */

/**
 * @author Vivek
 *
 */
public class Final_Data_Driven {

	 static WebDriver driver;
	static Reading_Excel reader;
	public static void main(String[] args) throws InterruptedException {
		driver = new FirefoxDriver();
		reader = new Reading_Excel("C://Users//Vivek//Desktop//DataDriven.xls");
       driver.get(reader.getData("Website_URL"));
       String Fname=  reader.getData("First_Name_Xpath");
       WebElement FirstName = driver.findElement(By.xpath(Fname));
       FirstName.sendKeys(reader.getData("First_Name"));
       String Lname = reader.getData("Last_Name_Xpath");
       WebElement l_name = driver.findElement(By.xpath(Lname));
       l_name.sendKeys(reader.getData("Last_Name"));
       String Geder = reader.getData("Gender_Xpath");
       WebElement gender = driver.findElement(By.xpath(Geder));
       gender.click();
       String Chkbox = reader.getData("Language_Xpath");
       WebElement vheckbox  = driver.findElement(By.xpath(Chkbox));
       vheckbox.click();
    		   Thread.sleep(3000);

	}

}
