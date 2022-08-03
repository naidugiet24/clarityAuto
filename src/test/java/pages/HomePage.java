package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HomePage {

    WebDriver webDriver;
    String baseUrl = "https://clarity.dexcom.com/";

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    By dexcomClarityForHomeUsers = By.linkText("Dexcom Clarity for Home Users");

    public void getHomeUsersPage() {
        webDriver.get(baseUrl);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void clickHomeUser()
    {
        webDriver.findElement(dexcomClarityForHomeUsers).click();
    }


}
