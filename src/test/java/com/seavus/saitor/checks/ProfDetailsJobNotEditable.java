package com.seavus.saitor.checks;

import com.seavus.common.elements.ElementActions;
import com.seavus.saitor.GoogleExcel.CheckRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.io.IOException;


public class ProfDetailsJobNotEditable extends ElementActions {

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