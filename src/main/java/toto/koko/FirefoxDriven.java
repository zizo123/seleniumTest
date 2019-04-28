package toto.koko;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriven {

	public static void main(String ...str ) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\OZ\\Downloads\\Programs\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
	
		driver.manage().window().maximize();
	}
}
