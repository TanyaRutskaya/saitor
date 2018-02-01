package svs.autotest.checks;

import com.seavus.common.elements.ElementActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import svs.autotest.GoogleExcel.CheckRecorder;

import java.io.IOException;


public class Login_InvalidCredentials extends ElementActions {

    By login = By.name("authentication.inputForms.loginModel.username");
    By pass = By.name("authentication.inputForms.loginModel.password");
    By loginButton = By.xpath(".//div[@class='box-body']//span[text()='Login']");
    By validation = By.xpath("//div[@class='notification-message' and text()='Username and password is not valid.']");
    By noPassValidation = By.xpath(".//div[@class='box-body']//span[text()='Password is required']");
    By noUsernameValidation = By.xpath(".//div[@class='box-body']//span[text()='Username is required']");

    public void pageNavigation() throws IOException {
        navigate.openBrowser();
        navigate.maximizeBrowser();
        navigate.to($("URL1"));
        wait.presenceOfElement(login);
    }

    public boolean invalidusername() throws IOException {
        button.click(login);
        input.type(login,"Person.2");
        button.click(pass);
        input.type(pass, "123");
        button.click(loginButton);

        try {
            driver.findElement(validation);
            CheckRecorder.setValue("build 1!D5", "passed");
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D5", "failed");
        }

        return true;
    }
    public boolean invalidpass() throws IOException {
        button.click(login);
        input.type(login,"Person.1");
        button.click(pass);
        input.type(pass, " ");
        button.click(loginButton);

        try {
            driver.findElement(validation);
            CheckRecorder.setValue("build 1!D6", "passed");
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D6", "failed");
        }

        return true;
    }

    //no username validation check
    public boolean nousername() throws IOException {

        button.click(pass);
        input.type(pass, "123");
        button.click(loginButton);

        try {
            driver.findElement(noUsernameValidation);
            CheckRecorder.setValue("build 1!D8", "passed");
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D8", "failed");
        }

        return true;
    }
// no passwords validation check

    public boolean nopass() throws IOException {
        button.click(login);
        input.type(login,"Person.2");
        input.clear(pass);
        button.click(loginButton);

        try {
            driver.findElement(noPassValidation);
            CheckRecorder.setValue("build 1!D9", "passed");
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D9", "failed");
        }

        return true;
    }

    private boolean isAlertPresent()
    {
        try
        {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException Ex)
        {
            return false;
        }
    }
}
