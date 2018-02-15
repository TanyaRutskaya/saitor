package svs.autotest.checks;

import com.seavus.common.elements.ElementActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import svs.autotest.GoogleExcel.CheckRecorder;

import java.io.IOException;


    public class Login_ValidCredentials extends ElementActions {

        By login = By.name("authentication.inputForms.loginModel.username");
        By pass = By.name("authentication.inputForms.loginModel.password");
        By loginButton = By.xpath(".//div[@class='box-body']//span[text()='Login']");
        By logout = By.id("logout-btn");
        By loggedinPerson = By.xpath("//div[@class='navbar-custom-menu']//li[@class = 'person-profile dropdown user user-menu false']");

        public void pageNavigation() throws IOException {
            navigate.openBrowser();
            navigate.maximizeBrowser();
            navigate.to($("URL1"));
            wait.presenceOfElement(login);
        }

        public boolean loginSuccessfully() throws IOException {
            button.click(login);
            input.type(login,"Person.1");
            button.click(pass);
            input.type(pass, "123");
            button.click(loginButton);

            try {
                driver.findElement(loggedinPerson);
                CheckRecorder.setValue("build 1!D4", "passed");
            } catch (NoSuchElementException ex) {
                CheckRecorder.setValue("build 1!D4", "failed");
            }

            return true;
        }
        public boolean logout() throws IOException {
            button.click(loggedinPerson);
            button.click(logout);

            try {
                driver.findElement(loggedinPerson);
                CheckRecorder.setValue("build 1!D10", "false");
            } catch (NoSuchElementException ex) {
                CheckRecorder.setValue("build 1!D10", "passed");
            }
            input.clear(login);
            input.clear(pass);
            return true;

        }
    }





