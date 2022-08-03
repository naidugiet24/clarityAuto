import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    By usernameTxtBox = By.id("username");
    By passwordTxtBox = By.id("password");
    By loginBnt = By.name("op");
    By logOutBtn = By.xpath("//a[@class='home-user-header__logout cui-link']");


    public void enterUsername(String user) {
        webDriver.findElement(usernameTxtBox).click();
        webDriver.findElement(usernameTxtBox).clear();
        webDriver.findElement(usernameTxtBox).sendKeys(user);
    }


    public void enterPassword(String pass) {
        webDriver.findElement(passwordTxtBox).click();
        webDriver.findElement(passwordTxtBox).clear();
        webDriver.findElement(passwordTxtBox).sendKeys(pass);
    }


    public void clickLogin() {
        webDriver.findElement(loginBnt).click();
    }

    public void verify() {
        Assert.assertTrue(webDriver.findElement(logOutBtn).isDisplayed());
        Assert.assertEquals(webDriver.findElement(logOutBtn).getText(), "Logout");

    }
}
