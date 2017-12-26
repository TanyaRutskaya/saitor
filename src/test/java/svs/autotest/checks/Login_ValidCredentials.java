package svs.autotest.checks;

import com.seavus.common.elements.ElementActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import svs.autotest.GoogleExcel.CheckRecorder;

import java.io.IOException;


    public class Login_ValidCredentials extends ElementActions {

        By username = By.id("user_name");
        By loginButton = By.id("login_button");
        By welcomeLink = By.id("welcome_link");
        By element = By.id("root");

        public void pageNavigation() throws IOException {
            navigate.openBrowser();
            navigate.maximizeBrowser();
            navigate.to($("URL1"));
            Alert alert = driver.switchTo().alert();
            alert.accept();
            navigate.to($("URL2"));


            if (!isAlertPresent()) {
                wait.presenceOfElement(element, 15000);
                if(driver.findElement(element) != null) {
                    CheckRecorder.setValue("build 1!D4", "passed");
                } else {
                    CheckRecorder.setValue("build 1!D4", "failed");
                }

            } else {
                CheckRecorder.setValue("build 1!D4", "failed");
            }
        }




        //public void loginForm(final String user, final String pass) {

            //input.type(username, user);
            //input.type(password, pass);
           // button.click(loginButton);
            //TODO Validation that logged in
            //validate.textContains(welcomeLink, "LoggedIn");
       // }

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

