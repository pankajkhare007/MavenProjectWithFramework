package core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverHelper  {
	
	static WebDriver driver;
	
	public static void invokeBrowser() {
		String browser = ReadPropertiesFile.getPropertiesValue("browser");
		String url = ReadPropertiesFile.getPropertiesValue("url");
		int defaul_timeout = Integer.parseInt(ReadPropertiesFile.getPropertiesValue("default_timeout"));
		switch(browser) {
		case "chrome" :
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox" :
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(defaul_timeout));
		
	}
	
	public static void closeBrowser() {
		driver.close();
	}

}
