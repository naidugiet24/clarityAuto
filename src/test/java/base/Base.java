package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileReader;
import java.util.Properties;

public class Base {

    WebDriver driver;
    Properties properties;

    public Base() {
        loadProperties();
        initializeDriver(Boolean.parseBoolean(getProperty("useDefaultVersion")));
    }

    private void initializeDriver(boolean useDefault) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        if (useDefault) {
            System.out.println("==================== Using Default Browser ====================");
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            driver = new ChromeDriver(options);
        } else {
            WebDriverManager.chromedriver().setup();
            System.out.println("==================== Browser version ====================");
            System.out.println(getProperty("browser.version"));
            System.out.println("==================== Browser version ====================");
            driver = new ChromeDriver(options);
        }
    }

    private void loadProperties() {
        try {
            FileReader reader = new FileReader("src/test/resources/data.properties");
            properties = new Properties();
            properties.load(reader);
        } catch (Exception e) {
            System.out.println("Exception while reading properties.");
            System.out.println(e);
        }
    }

    public String getProperty(String property) {
        return properties.getProperty(property);
    }

    public WebDriver getDriver() {
        return driver;
    }
}

