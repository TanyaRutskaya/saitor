package svs.autotest.pages;

import com.seavus.common.elements.ElementActions;
import org.openqa.selenium.By;

/**
 * Created by tanya on 20.12.17.
 */


    public class LoginPage extends ElementActions {


        By username = By.id("user_name");
        By loginButton = By.id("login_button");
        By welcomeLink = By.id("welcome_link");

        public void pageNavigation(){
            navigate.openBrowser();
            navigate.maximizeBrowser();
            navigate.to($("URL"));
        }

        public void loginForm(final String user, final String pass) {
            input.type(username, user);
            //input.type(password, pass);
            button.click(loginButton);
            //TODO Validation that logged in
            //validate.textContains(welcomeLink, "LoggedIn");
        }
    }

