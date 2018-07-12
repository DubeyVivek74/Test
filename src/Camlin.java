import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class Camlin {

	@Test
	public void verifyflow(){
		WebDriver dr = new FirefoxDriver();
		dr.navigate().to("http://vivek-pc/login.do");
		Camel cc = new Camel(dr);
		cc.max();
		cc.waits();
		cc.Enterusername();
		cc.Enterpwd();
		cc.clicklgnbutton();
		cc.waits();
		cc.gnrlsettings();
		cc.waits();
		cc.topgrplevel();
		cc.waits();
		cc.middlelevel();
		cc.waits();
		cc.timeentry();
		cc.waits();
		cc.dropdown();
		dr.close();
		
	}

}
