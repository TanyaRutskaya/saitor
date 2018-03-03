package com.seavus.saitor.checks;

import com.seavus.common.elements.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import com.seavus.saitor.googledoc.CheckRecorder;

import java.io.IOException;


public class LoginInvalidCredentials extends ElementActions {

    By login = By.name("authentication.inputForms.loginModel.username");
    By pass = By.name("authentication.inputForms.loginModel.password");
    By loginButton = By.xpath(".//div[@class='box-body']//span[text()='Login']");
    By validation = By.xpath("//div[@class='notification-message' and text()='Login failed. Invalid username or password.']");
    By noPassValidation = By.xpath(".//div[@class='box-body']//span[text()='Password is required']");
    By noUsernameValidation = By.xpath(".//div[@class='box-body']//span[text()='Username is required']");


    public boolean invalidusername() throws IOException {

        wait.presenceOfElement(login);
        button.click(login);
        input.type(login, "Person.2");
        button.click(pass);
        input.type(pass, "123");
        button.click(loginButton);

        try {
            driver.findElement(validation);
            CheckRecorder.setValue("build 1!D5", CheckRecorder.PASSED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D5", CheckRecorder.FAILED);
        }

        input.clear(pass);
        input.clear(login);
        return true;
    }


    public boolean invalidpass() throws IOException {
        button.click(login);
        input.type(login, "Person.1");
        button.click(pass);
        input.type(pass, "");
        button.click(loginButton);

        try {
            driver.findElement(validation);
            CheckRecorder.setValue("build 1!D6", CheckRecorder.PASSED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D6", CheckRecorder.FAILED);
        }

        input.clear(login);
        input.clear(pass);
        return true;
    }

    //no username validation check
    public boolean nousername() throws IOException {

        button.click(pass);
        input.type(pass, "123");
        button.click(loginButton);

        try {
            driver.findElement(noUsernameValidation);
            CheckRecorder.setValue("build 1!D8", CheckRecorder.PASSED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D8", CheckRecorder.FAILED);
        }

        input.clear(pass);
        input.clear(login);
        return true;
    }

    // no password validation check
    public boolean nopass() throws IOException {
        button.click(login);
        input.type(login, "Person.2");
        input.clear(pass);
        button.click(loginButton);

        try {
            driver.findElement(noPassValidation);
            CheckRecorder.setValue("build 1!D9", CheckRecorder.PASSED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D9", CheckRecorder.FAILED);
        }

        input.clear(pass);
        input.clear(login);
        return true;
    }
}