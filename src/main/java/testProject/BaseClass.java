package testProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public WebDriver driver;
	private String browserName;
	private String appUrl;
	public Properties prop;

	public BaseClass() {

	}

	public void init_properties() {

	}

	public void initializeDriver() {

		try {
			prop = new Properties();
			System.out.println(System.getProperty("user.dir") + "\\src\\main\\java\\testProject\\config.properties");
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\testProject\\config.properties");

			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(prop.get("browserName"));
		System.out.println(prop.get("appUrl"));
		String browserName = prop.getProperty("browserName");
		String appUrl = prop.getProperty("appUrl");
		if (browserName.equals("chrome")) {
			this.initChromeDriver(appUrl);
		} else if (browserName.equals("firefox")) {
			this.initFirefoxDriver(appUrl);
		} else {
			this.initInternetExplorerDriver(appUrl);
		}
	}

	private void initChromeDriver(String appUrl) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		System.out.println("page loading starts");
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get(appUrl);
		System.out.println("opening chrome browser");
	}

	private WebDriver initFirefoxDriver(String appUrl) {
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability(FirefoxDriver.MARIONETTE, true);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.addArguments("--incognito");
		this.driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.get(appUrl);
		this.driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		return this.driver;

	}

	private WebDriver initInternetExplorerDriver(String appUrl) {
		System.setProperty("webdriver.ie.driver", ".\\drivers\\ie-driver-3.1.1\\IEDriverServer.exe");
		InternetExplorerOptions options = new InternetExplorerOptions();
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, false);
		options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
		this.driver = new InternetExplorerDriver(options);
		driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		this.driver.navigate().to(appUrl);
		return driver;
	}

	public void closeDriver() {
		driver.close();
	}

	public void quitDriver(WebDriver driver) {
		driver.quit();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public WebDriver getCurrentDriver() {
		return driver;
	}

	public WebElement clickElementWhenVisible(WebElement element) {	
		WebElement ele =  new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
		return ele;
	}

//	public WebElement elementNotTractableWait(WebElement webElement, int wait) {
//		return new WebDriverWait(this.driver, wait).until(ExpectedConditions.visibilityOf(learnMoreBtn));
//	}

}
