package exercise;
/* Author: truonganhdung
 * Created Date: 11/09/2018
 * Modified Date: ../../2018
 * https://www.guru99.com/execute-javascript-selenium-webdriver.html
 * */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class IV_V_JS_execute_AsyncScript {
	@Test
	public void Login() {
		WebDriver driver = new FirefoxDriver();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.get("http://demo.guru99.com/V4/");
		driver.manage().window().maximize();
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);

		long start_time = System.currentTimeMillis();

		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");

		System.out.println("Passed time: " + (System.currentTimeMillis() - start_time));
		
		driver.close();
	}
}