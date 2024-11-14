package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class LoginPage {
        WebDriver driver;

        public LoginPage(WebDriver driver) {
            this.driver = driver;
        }
        private By username= By.name("uid");
        private By password = By.name("password");
        private By loginbutton = By.name("btnLogin");
        public By welcomeMessage = By.xpath("//td[@style='color: green' and contains(text(), 'Manger Id :')]");

        public void LoginValidData(String user, String Pass){
            driver.findElement(username).sendKeys(user);
            driver.findElement(password).sendKeys(Pass);
            driver.findElement(loginbutton).click();
        }
        public String getwelcomemessage(){

            return driver.findElement(welcomeMessage).getText();
        }

        public void LogininValiddata(String user, String Pass){
            driver.findElement(username).sendKeys(user);
            driver.findElement(password).sendKeys(Pass);
            driver.findElement(loginbutton).click();
        }



    }










