package docker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SampleTest {

	RemoteWebDriver driver;
	@Parameters("String browserName")
	@Test
	public void sampleTest(String BN) throws MalformedURLException, InterruptedException {
		URL ipAdd = new URL("http://localhost:4444");

		if (BN.equals("Chrome")) {
			ChromeOptions option = new ChromeOptions();
			driver = new RemoteWebDriver(ipAdd, option);
		} else if (BN.equals("Edge")) {
			EdgeOptions option = new EdgeOptions();
			driver = new RemoteWebDriver(ipAdd, option);
		} else if (BN.equals("Firefox")) {
			FirefoxOptions option = new FirefoxOptions();
			driver = new RemoteWebDriver(ipAdd, option);
		}

		Thread.sleep(10000);
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		driver.close();
	}
}