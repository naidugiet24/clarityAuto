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
        initializeDriver(Boolean.parseBoolean(getProperty("useConfiguredVersion")));
    }

    private void initializeDriver(boolean useConfiguredVersion) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        if (useConfiguredVersion) {
            System.out.println("==================== Using configured version for browser ====================");
            System.out.println(getProperty("browser.version"));
            WebDriverManager.chromedriver().browserVersion(getProperty("browser.version")).setup();
            driver = new ChromeDriver(options);
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            System.out.println("==================== Using default browser version ====================");
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

