package Tests;

import Pages.LoginPage;
import Utils.Utils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Utils.ExcelUtils;

import java.time.Duration;
public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup(){
        driver = new FirefoxDriver();
        driver.get(Utils.GetbaseUrl());
        driver.manage().window().maximize();
        ExcelUtils.loadExcelFile("Sheet1");

    }

    @Test
    public void logintoguru(){
        loginPage=new LoginPage(driver);
        String username = ExcelUtils.getdata(1, 0); // row 1, column 0 for username
        String password = ExcelUtils.getdata(1, 1); // row 1, column 1 for password
        loginPage.LoginValidData(username, password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.welcomeMessage));
        String expected = "Manger Id : "+ username;
        String actual = loginPage.getwelcomemessage();
        Assert.assertEquals(expected, actual);
        String actualtitle = driver.getTitle();
        String expectedtitle = "Guru99 Bank Manager HomePage";
        Assert.assertEquals(actualtitle,expectedtitle, "Page title doesn't match after login" );

    }

    @Test
    public void loginwithsinvalidpassword() {
        loginPage = new LoginPage(driver);
        String username = ExcelUtils.getdata(2, 0); // row 1, column 0 for username
        String password = ExcelUtils.getdata(2, 1); // row 1, column 1 for password
        loginPage.LogininValiddata(username, password);
        Alert alert = driver.switchTo().alert();
        String alerttext = alert.getText();
        Assert.assertEquals(alerttext, "User or Password is not valid", "wrong message");
        alert.accept();
    }

    @Test
    public void loginwithinvalidusername() {
        loginPage = new LoginPage(driver);
        String username = ExcelUtils.getdata(3, 0); // row 1, column 0 for username
        String password = ExcelUtils.getdata(3, 1); // row 1, column 1 for password
        loginPage.LogininValiddata(username, password);
        Alert alert = driver.switchTo().alert();
        String alerttext = alert.getText();
        Assert.assertEquals(alerttext, "User or Password is not valid", "wrong message");
        alert.accept();
    }

    @Test
    public void loginwithinvalidusernamePassword() {
        loginPage = new LoginPage(driver);
        String username = ExcelUtils.getdata(4, 0); // row 1, column 0 for username
        String password = ExcelUtils.getdata(4, 1); // row 1, column 1 for password
        loginPage.LogininValiddata(username, password);
        Alert alert = driver.switchTo().alert();
        String alerttext = alert.getText();
        Assert.assertEquals(alerttext, "User or Password is not valid", "wrong message");
        alert.accept();
    }


}
