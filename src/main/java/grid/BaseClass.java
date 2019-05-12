package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {

	private static final String nodeURL = "http://localhost:4444/wd/hub";
	static WebDriver driver;
	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();

	@BeforeMethod
	@Parameters("myBrowser")
	public void beforeMethod(String myBrowser) throws IllegalAccessException, MalformedURLException {
		RemoteWebDriver driver = null;
		if (myBrowser.equals("chrome")) {
			/*
			 * DesiredCapabilities capability = new DesiredCapabilities().chrome();
			 * capability.setBrowserName("chrome"); capability.setPlatform(Platform.WIN10);
			 * driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
			 * capability);
			 */
			ChromeOptions options = new ChromeOptions();
			options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
			options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
			driver.manage().window().maximize();
		}
		if (myBrowser.equals("firefox")) {
			DesiredCapabilities capability = new DesiredCapabilities().firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.WIN10);
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		}
		if (myBrowser.equals("edge")) {

			EdgeOptions options = new EdgeOptions();
			options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);

			/*
			 * DesiredCapabilities capability = new DesiredCapabilities().edge();
			 * capability.setBrowserName("edge"); capability.setPlatform(Platform.WIN10);
			 * driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
			 * capability);
			 */
		}
	}

	private void setDriver() {
		dr.set(driver);
	}

	@AfterClass
	public void afterClass() {
		getDriver().quit();
		dr.set(null);
	}

	public WebDriver getDriver() {
		return dr.get();
	}

}
