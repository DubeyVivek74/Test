import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Normal_Test {
	public static void main(String args[]){
		WebDriver dr = new FirefoxDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		dr.get("file:///E:/Komal_pd_data/EnquiryForm.html");
		dr.findElement(By.id("firstname")).sendKeys("Niraj");
		dr.findElement(By.id("lastname")).sendKeys("chotu");
		dr.findElement(By.xpath("html/body/form/fieldset/input[4]")).click();
		dr.findElement(By.xpath("html/body/form/fieldset/input[6]")).click();
		dr.findElement(By.xpath(".//*[@id='cars']")).sendKeys("Audi");
		dr.findElement(By.xpath("html/body/form/fieldset/input[10]")).click();
		dr.quit();
	}
 
}
