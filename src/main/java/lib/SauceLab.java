package lib;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceLab {
	private WebDriver driver;
	 
    @Test
    public void shouldOpenChrome() throws MalformedURLException {
        /** Here we set environment variables from your local machine, or IntelliJ run configuration,
         *  and store these values in the variables below. Doing this is a best practice in terms of test execution
         *  and security. If you're not sure how to use env variables, refer to this guide -
         * https://wiki.saucelabs.com/display/DOCS/Best+Practice%3A+Use+Environment+Variables+for+Authentication+Credentials
         * or check testng-README.md */
 
        String sauceUserName = System.getenv("SAUCE_USERNAME");
        String sauceAccessKey = System.getenv("SAUCE_ACCESS_KEY");
        String sauceURL = System.getenv("SAUCE_URL");
 
        /**
         * Here we set DesiredCapabilities, in this exercise we set additional capabilities below that align with
         * testing best practices such as timeouts, tags, and build numbers
         */
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("username", "Zizo123Magic");
        capabilities.setCapability("accessKey", "0A6F0A43DCE54D94B4FDEAD0D3CB1BFB");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("version", "59.0");
        capabilities.setCapability("name", "4-best-practices");
 
        /** Tags are an excellent way to control and filter your test automation
         * in Sauce Analytics. Get a better view into your test automation.
         */
        List<String> tags = Arrays.asList("sauceDemo", "demoTest", "module4");
        capabilities.setCapability("tags", tags);
 
        /** Another of the most important things that you can do to get started
         * is to set timeout capabilities for Sauce based on your organizations needs. For example:
         * How long is the whole test allowed to run?*/
        capabilities.setCapability("maxDuration", 3600);
        /** A Selenium crash might cause a session to hang indefinitely.
         * Below is the max time allowed to wait for a Selenium command*/
        capabilities.setCapability("commandTimeout", 600);
        /** How long can the browser wait for a new command */
        capabilities.setCapability("idleTimeout", 1000);
 
        /** Setting a build name is one of the most fundamental pieces of running
         * successful test automation. Builds will gather all of your tests into a single
         * 'test suite' that you can analyze for results.
         * It's a best practice to always group your tests into builds. */
        capabilities.setCapability("build", "SauceDemo");
 
        /** If you're accessing the EU data center, use the following endpoint:.
         * https://ondemand.eu-central-1.saucelabs.com/wd/hub
         * */
        driver = new RemoteWebDriver(new URL(sauceURL), capabilities);
        /** Don't forget to enter in your application's URL in place of 'https://www.saucedemo.com'. */
        driver.navigate().to("https://www.saucedemo.com");
        Assert.assertTrue(true);
 
    }
    /**
     * Below we are performing 2 critical actions. Quitting the driver and passing
     * the test result to Sauce Labs user interface using the Javascript Executor.
     */
    

}
