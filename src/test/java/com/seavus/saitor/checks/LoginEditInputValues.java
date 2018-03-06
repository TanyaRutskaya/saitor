package com.seavus.saitor.checks;

import com.seavus.common.elements.ElementActions;
import com.seavus.saitor.googledoc.CheckRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.io.IOException;


public class LoginEditInputValues extends ElementActions {
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
            CheckRecorder.setValue("build 1!D7", CheckRecorder.PASSED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D7", CheckRecorder.FAILED);
        }
    }
}