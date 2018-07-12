import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


 public class Calling_keyword_driven extends Common_Functions {
	public static void main(String args[]) throws Exception{
		WebDriver driver = new FirefoxDriver();
		navigatetoUrl(driver,"file:///E://EnquiryForm.html");
		entertext(driver,"id","firstname","Niraj");
		entertext(driver,"id","lastname","chotu");
		click_element(driver, "x-path", "html/body/form/fieldset/input[4]");
		click_element(driver,"x-path","html/body/form/fieldset/input[6]");
		entertext(driver,"id","cars","Audi");
		click_element(driver, "x-path", "html/body/form/fieldset/input[10]");
		Thread.sleep(5000);
		closeapp(driver);
		
	}

}
