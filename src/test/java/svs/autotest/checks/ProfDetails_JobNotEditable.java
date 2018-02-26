package svs.autotest.checks;

import com.seavus.common.elements.ElementActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import svs.autotest.GoogleExcel.CheckRecorder;

import java.io.IOException;




public class ProfDetails_JobNotEditable extends ElementActions {

    By username = By.id("user_name");
    By loginButton = By.id("login_button");
    By welcomeLink = By.id("welcome_link");
    By edit = By.xpath("//div[@class='col-xs-12 child-component' and .//h5[text()='Job Position:']]//button[@title='Edit']");

    public boolean jobIneditable() throws IOException {
        try {
            driver.findElement(edit);
            CheckRecorder.setValue("build 1!D21", "failed");
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D21", "passed");
        }
        return true;




    }


    }

