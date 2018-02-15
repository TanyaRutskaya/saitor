package svs.autotest.checks;

import com.seavus.common.elements.ElementActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import svs.autotest.GoogleExcel.CheckRecorder;

import java.io.IOException;


public class Login_EditInputValues extends ElementActions {

    By login = By.name("authentication.inputForms.loginModel.username");
    By pass = By.name("authentication.inputForms.loginModel.password");
    By loginButton = By.xpath(".//div[@class='box-body']//span[text()='Login']");
    By loggedinPerson = By.xpath("//div[@class='navbar-custom-menu']//li[@class = 'person-profile dropdown user user-menu false']");


    public void abilityEdit () throws IOException {

        wait.presenceOfElement(login);
        button.click(login);
        input.type(login,"Person.11");
        button.click(pass);
        input.type(pass, "123");
        button.click(loginButton);
        input.type(login, "\u0008");
        button.click(loginButton);

        try {
            driver.findElement(loggedinPerson);
            CheckRecorder.setValue("build 1!D7", "passed");
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D7", "failed");
        }
    }




//    public void loginForm(final String user, final String pass) {
//
//        $I->executeJS('return $("#element").is(":focus")');
//    }

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

