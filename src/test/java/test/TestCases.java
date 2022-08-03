package test;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;


public class TestCases {
    private WebDriver driver;
    private Base base;

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        base = new Base();
        driver = base.getDriver();
    }


    @Test
    public void loginTest() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.getHomeUsersPage();
        homePage.clickHomeUser();

        loginPage.enterUsername(base.getProperty("username"));
        loginPage.enterPassword(base.getProperty("password"));
        loginPage.clickLogin();
        loginPage.verify();

    }


    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
