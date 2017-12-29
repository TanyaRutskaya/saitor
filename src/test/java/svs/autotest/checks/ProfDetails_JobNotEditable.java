package svs.autotest.checks;

import com.seavus.common.elements.ElementActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import svs.autotest.GoogleExcel.CheckRecorder;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;




public class ProfDetails_JobNotEditable extends ElementActions {

    By username = By.id("user_name");
    By loginButton = By.id("login_button");
    By welcomeLink = By.id("welcome_link");
    By edit = By.className("edit-button");

    public void jobIneditable() throws IOException {
        navigate.openBrowser();
        navigate.maximizeBrowser();


        navigate.to($("URL1"));
        Alert alert = driver.switchTo().alert();
        alert.accept();
        navigate.to($("URL2"));


        wait.presenceOfElement(edit, 15000);
        if (driver.findElement(edit) != null) {

            if (driver.findElement(edit) != null) {
                CheckRecorder.setValue("build 1!D22", "passed");
            } else {
                CheckRecorder.setValue("build 1!D22", "failed");
            }
        }




    }


    }

