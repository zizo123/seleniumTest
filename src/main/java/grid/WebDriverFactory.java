package grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

	static WebDriver create(String type) throws IllegalAccessException {
		WebDriver driver;
		
		switch (type) {
		case "FIREFOX":	
			System.setProperty("webdriver.gecko.driver","C:\\Users\\OZ\\Downloads\\Programs\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "CHROME":	
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\OZ\\Downloads\\Programs\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		default:
			throw new IllegalAccessException();
		}
		
		return null;
	}
}

