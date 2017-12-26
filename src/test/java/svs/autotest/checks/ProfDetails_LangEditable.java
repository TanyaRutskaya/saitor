package svs.autotest.checks;

import com.seavus.common.elements.ElementActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import svs.autotest.GoogleExcel.CheckRecorder;

import java.io.IOException;


public class ProfDetails_LangEditable extends ElementActions {

    By username = By.id("user_name");
    By loginButton = By.id("login_button");
    By welcomeLink = By.id("welcome_link");
    By edit = By.className("Edit");

    public void langEdit() throws IOException {
        navigate.openBrowser();
        navigate.maximizeBrowser();
        navigate.to($("URL1"));
        Alert alert = driver.switchTo().alert();
        alert.accept();
        navigate.to($("URL2"));


        if ( driver.findElement(By.className("edit-button hide")).isDisplayed()) {
            wait.presenceOfElement(edit, 15000);
            if(driver.findElement(edit) != null) {
                CheckRecorder.setValue("build 1!D22", "passed");
            } else {
                CheckRecorder.setValue("build 1!D22", "failed");
            }

        } else {
            CheckRecorder.setValue("build 1!D22", "failed");
        }
    }



}

