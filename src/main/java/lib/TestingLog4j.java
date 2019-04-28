package lib;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestingLog4j {

	Logger logger;

	@Test
	public void testLogs() {

		logger = Logger.getLogger("devLogger");

		logger.debug("Staring od Selenium tests");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\OZ\\Downloads\\Programs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		logger.debug("Chrome browser opens");
		driver.get("http:\\google.com");
		logger.debug("Navigate to Google");

	}
}
