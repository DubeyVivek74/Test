import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FinalKeywordDriven extends Common_Functions {

 
	public static void main(String args[]) throws Exception{
		String data[][]=ReadExcelData("C:\\Users\\Vivek\\Desktop\\Data.xls");
		WebDriver driver = new FirefoxDriver();
	navigatetoUrl(driver,data[1][9]);//"file:///E:/Komal_pd_data/EnquiryForm.html");
	entertext(driver,data[2][7],data[2][8],data[2][9]);//"firstname","Niraj");
	Thread.sleep(5000);
	//entertext(driver,"id","lastname","chotu");
	click_element(driver, "x-path", "html/body/form/fieldset/input[4]");
	click_element(driver,"x-path","html/body/form/fieldset/input[6]");
	entertext(driver,"id","cars","Audi");
	click_element(driver, "x-path", "html/body/form/fieldset/input[10]");
	Thread.sleep(5000);
	closeapp(driver);
				
			}

		// TODO Auto-generated method stub

	}


