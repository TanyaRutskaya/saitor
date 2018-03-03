package com.seavus.saitor.checks;

import com.seavus.common.elements.ElementActions;
import com.seavus.saitor.googledoc.CheckRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ProfDetailsTrainingEditable extends ElementActions {

    public static final String PASSED = CheckRecorder.PASSED;
    By trainingblock = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]");
    By newtrainingbutton = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//button[@title='Create new']");
    By trainingnameQC = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//p[text()='Web QC']");
    By trainingnameWeb = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//p[text()='Web QA']");
    By editQC = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//div[@class='row col-xs-12 padding-left-none read-only-item-component' and .//p[text()='Web QC']]//button[@title='Edit']");
    By descedit = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//div[@class='row col-xs-12 padding-left-none read-only-item-component' and .//p[text()='Belhard']]//button[@title='Edit']");
    By webedit = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//div[@class='row col-xs-12 padding-left-none read-only-item-component' and .//p[text()='Web QA']]//button[@title='Edit']");
    By trainingnamefield = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//input[@name='cvComposition.inputForms.trainingModel.name']");
    By canceledit = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//span[@class='cancel-icon glyphicon glyphicon-remove']");
    By yearbackfrom = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//div[input[@name='cvComposition.inputForms.trainingModel.fromDate']]//button[@title='navigate back']");
    By yearbackto = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//div[input[@name='cvComposition.inputForms.trainingModel.toDate']]//button[@title='navigate back']");
    By fromdatefield = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//div[input[@name='cvComposition.inputForms.trainingModel.fromDate']]//input[@placeholder='Enter training start date']");
    By todatefield = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//div[input[@name='cvComposition.inputForms.trainingModel.toDate']]//input[@placeholder='Enter training end date']");
    By validmessage = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//span[text()='Training start date cannot be bigger than the current date']");
    By school = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//p[@class='title' and text()='School']");
    By belhard = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//p[text()='Belhard']");
    By calendarfrombutton = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//div[input[@name='cvComposition.inputForms.trainingModel.fromDate']]//button");
    By calendartobutton = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//div[input[@name='cvComposition.inputForms.trainingModel.toDate']]//button");
    By octoberto = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//div[input[@name='cvComposition.inputForms.trainingModel.toDate']]//td/span[text()='Oct']");
    By octoberfrom = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//div[input[@name='cvComposition.inputForms.trainingModel.fromDate']]//td/span[text()='Oct']");
    By save = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//span[@class='ladda-label' and text()='Save']");
    By remove = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//span[text()='Remove']");
    By cancelnew = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//button[text()='Cancel']");
    By trainingrow = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//div[@class='row col-xs-12 padding-left-none read-only-item-component']");
    By namevalidmessage = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//span[text()='Training name is required']");
    By validfrommessage = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//span[text()='Training start date is required']");
    By validtomessage = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//span[text()='Training end date is required']");
    By nov2017 = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//p[@class='date' and contains(text(), '11/2015 -')]");
    By fromdatefieldedit = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Training']]//div[input[@name='cvComposition.inputForms.trainingModel.fromDate']]//input");

    //Create a new training
    public boolean addNew() throws IOException {
        wait.presenceOfElement(newtrainingbutton);
        WebElement element1 = driver.findElement(newtrainingbutton);
        Actions action1 = new Actions(driver);
        scrollUntilVisibility();
        scroll();
        action1.moveToElement(element1).build().perform();
        button.click(newtrainingbutton);
        button.click(trainingnamefield);
        input.type(trainingnamefield, "Web QA");
        button.click(calendarfrombutton);
        WebElement element2 = driver.findElement(yearbackfrom);
        Actions action2 = new Actions(driver);
        action2.moveToElement(element2).build().perform();
        int repeat = 3;

        for (int a = 0; a < repeat; a++) {
            action2.moveToElement(element2).build().perform();
            button.click(yearbackfrom);
            wait.visibilityOfElement(octoberfrom);
        }
        button.click(octoberfrom);
        button.click(calendartobutton);
        WebElement element3 = driver.findElement(yearbackto);
        Actions action3 = new Actions(driver);
        action3.moveToElement(element3).build().perform();
        int repeat1 = 2;
        for (int b = 0; b < repeat1; b++) {
            action3.moveToElement(element3).build().perform();
            button.click(yearbackto);
            wait.visibilityOfElement(octoberto);
        }
        button.click(octoberto);
        button.click(save);

        try {
            driver.findElement(trainingnameWeb);
            CheckRecorder.setValue("build 1!D56", CheckRecorder.PASSED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D56", CheckRecorder.FAILED);
        }
        return true;
    }

    //check the "Cancel" at edit mode
    public boolean EditCancel() throws IOException {

        WebElement element1 = driver.findElement(webedit);
        Actions action = new Actions(driver);
        action.moveToElement(element1).build().perform();
        button.click(webedit);
        button.click(trainingnamefield);
        input.clear(trainingnamefield);
        input.type(trainingnamefield, "School");
        button.click(canceledit);

        try {
            driver.findElement(school);
            CheckRecorder.setValue("build 1!D57", CheckRecorder.FAILED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D57", CheckRecorder.PASSED);
        }
        return true;
    }

    public boolean CreateCancel() throws IOException {

        WebElement element1 = driver.findElement(newtrainingbutton);
        Actions action = new Actions(driver);
        scrollUntilVisibility();
        scroll();
        action.moveToElement(element1).build().perform();
        button.click(newtrainingbutton);
        button.click(trainingnamefield);
        input.type(trainingnamefield, "Web QC");
        button.click(calendarfrombutton);
        WebElement element2 = driver.findElement(yearbackfrom);
        Actions action2 = new Actions(driver);
        action2.moveToElement(element2).build().perform();
        int repeat = 3;

        for (int a = 0; a < repeat; a++) {
            action2.moveToElement(element2).build().perform();
            button.click(yearbackfrom);
            wait.visibilityOfElement(octoberfrom);
        }

        button.click(octoberfrom);
        button.click(calendartobutton);
        WebElement element3 = driver.findElement(yearbackto);
        Actions action3 = new Actions(driver);
        action3.moveToElement(element3).build().perform();
        int repeat1 = 2;

        for (int b = 0; b < repeat1; b++) {
            action3.moveToElement(element3).build().perform();
            button.click(yearbackto);
            wait.visibilityOfElement(octoberto);
        }

        button.click(octoberto);
        button.click(cancelnew);

        try {
            driver.findElement(trainingnameQC);
            CheckRecorder.setValue("build 1!D58", CheckRecorder.FAILED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D58", CheckRecorder.PASSED);
        }
        return true;
    }

    //Edit Training name
    public boolean editTrainingName() throws IOException {

        WebElement element1 = driver.findElement(webedit);
        Actions action = new Actions(driver);
        action.moveToElement(element1).build().perform();
        button.click(webedit);
        button.click(trainingnamefield);
        input.clear(trainingnamefield);
        input.type(trainingnamefield, "Belhard");
        button.click(save);

        try {
            driver.findElement(belhard);//need to add additional "driver.findElement(desctop)"
            CheckRecorder.setValue("build 1!D59", CheckRecorder.PASSED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D59", CheckRecorder.FAILED);
        }
        return true;
    }

    //the ability to add > than 1 block
    public boolean morethan1block() throws IOException {

        WebElement element1 = driver.findElement(newtrainingbutton);
        CertItem enteredValue = new CertItem();
        enteredValue.title = "Web QC";
        String from = "10/2015";
        String to = "10/2016";
        enteredValue.date = from + " - " + to;

        int repeatblock = 3;

        for (int i = 0; i < repeatblock; i++) {
            Actions action1 = new Actions(driver);
            scrollUntilVisibility();
            scroll();
            action1.moveToElement(element1).build().perform();
            button.click(newtrainingbutton);
            button.click(trainingnamefield);
            input.type(trainingnamefield, "Web QC");
            button.click(fromdatefield);
            input.type(fromdatefield, from);
            button.click(todatefield);
            input.type(todatefield, to);
            button.click(save);
        }
        System.out.print("repeat counted = " + " " + duplicateCount(enteredValue));
        if (repeatblock == duplicateCount(enteredValue)) {

            CheckRecorder.setValue("build 1!D60", CheckRecorder.PASSED);
        } else {
            CheckRecorder.setValue("build 1!D60", CheckRecorder.FAILED);
        }
        return true;
    }

    //remove Training
    public boolean removeTraing() throws IOException {

        CertItem enteredValue = new CertItem();
        enteredValue.title = "Web QC";
        String from = "10/2015";
        String to = "10/2016";
        enteredValue.date = from + " - " + to;
        Actions action4 = new Actions(driver);
        int repeatdelete = 3;
        for (int a = 0; a < repeatdelete; a++) {
            WebElement element4 = driver.findElement(editQC);
            action4.moveToElement(element4).build().perform();
            button.click(editQC);
            button.click(remove);
            scrollUntilVisibility();
        }

        if (repeatdelete == duplicateCount(enteredValue)) {

            CheckRecorder.setValue("build 1!D61", CheckRecorder.FAILED);
        } else {
            CheckRecorder.setValue("build 1!D61", CheckRecorder.PASSED);
        }
        return true;
    }

    //check the validation for the field "Training name"
    public boolean validationTrainingname() throws IOException, InterruptedException {

        WebElement element1 = driver.findElement(newtrainingbutton);
        Actions action1 = new Actions(driver);
        scrollUntilVisibility();
        scroll();
        action1.moveToElement(element1).build().perform();
        button.click(newtrainingbutton);
        button.click(calendarfrombutton);
        WebElement element2 = driver.findElement(yearbackfrom);
        Actions action2 = new Actions(driver);
        action2.moveToElement(element2).build().perform();
        int repeat = 3;

        for (int a = 0; a < repeat; a++) {
            action2.moveToElement(element2).build().perform();
            button.click(yearbackfrom);
            wait.visibilityOfElement(octoberfrom);
        }
        button.click(octoberfrom);
        button.click(calendartobutton);
        WebElement element3 = driver.findElement(yearbackto);
        Actions action3 = new Actions(driver);
        action3.moveToElement(element3).build().perform();
        int repeat1 = 2;
        for (int b = 0; b < repeat1; b++) {
            action3.moveToElement(element3).build().perform();
            button.click(yearbackto);
            wait.visibilityOfElement(octoberto);
        }
        button.click(octoberto);
        button.click(save);

        try {
            driver.findElement(namevalidmessage);
            CheckRecorder.setValue("build 1!D62", CheckRecorder.PASSED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D62", CheckRecorder.FAILED);
        }
        button.click(cancelnew);
        return true;
    }

    //check the validation for the field "DATE FROM"
    public boolean validationDatefrom() throws IOException {
        WebElement element1 = driver.findElement(newtrainingbutton);
        Actions action1 = new Actions(driver);
        scrollUntilVisibility();
        scroll();
        action1.moveToElement(element1).build().perform();
        button.click(newtrainingbutton);
        button.click(trainingnamefield);
        input.type(trainingnamefield, "Weber");
        button.click(calendartobutton);
        WebElement element3 = driver.findElement(yearbackto);
        Actions action3 = new Actions(driver);
        action3.moveToElement(element3).build().perform();
        int repeat1 = 2;
        for (int b = 0; b < repeat1; b++) {
            action3.moveToElement(element3).build().perform();
            button.click(yearbackto);
            wait.visibilityOfElement(octoberto);
        }
        button.click(octoberto);
        button.click(save);

        try {
            driver.findElement(validfrommessage);
            CheckRecorder.setValue("build 1!D63", CheckRecorder.PASSED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D63", CheckRecorder.FAILED);
        }
        button.click(cancelnew);
        return true;
    }

    //check the validation for the field "date TO"
    public boolean validationDateTo() throws IOException {
        WebElement element1 = driver.findElement(newtrainingbutton);
        Actions action1 = new Actions(driver);
        scrollUntilVisibility();
        scroll();
        action1.moveToElement(element1).build().perform();
        button.click(newtrainingbutton);
        button.click(trainingnamefield);
        input.type(trainingnamefield, "Weberex");
        button.click(calendarfrombutton);
        WebElement element2 = driver.findElement(yearbackfrom);
        Actions action2 = new Actions(driver);
        action2.moveToElement(element2).build().perform();
        int repeat = 3;

        for (int a = 0; a < repeat; a++) {
            action2.moveToElement(element2).build().perform();
            button.click(yearbackfrom);
            wait.visibilityOfElement(octoberfrom);
        }

        button.click(octoberfrom);
        button.click(save);

        try {
            driver.findElement(validtomessage);
            CheckRecorder.setValue("build 1!D64", CheckRecorder.PASSED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D64", CheckRecorder.FAILED);
        }
        button.click(cancelnew);
        return true;
    }

    //check validation in case "DATE FROM" exceeds "DATE TO"
    public boolean dateFromExceedsTo() throws IOException {
        WebElement element1 = driver.findElement(newtrainingbutton);
        Actions action1 = new Actions(driver);
        scrollUntilVisibility();
        scroll();
        action1.moveToElement(element1).build().perform();
        button.click(newtrainingbutton);
        button.click(trainingnamefield);
        input.type(trainingnamefield, "Weberniy");
        button.click(calendarfrombutton);
        WebElement element2 = driver.findElement(yearbackfrom);
        Actions action2 = new Actions(driver);
        action2.moveToElement(element2).build().perform();
        int repeat = 2;

        for (int a = 0; a < repeat; a++) {
            action2.moveToElement(element2).build().perform();
            button.click(yearbackfrom);
            wait.visibilityOfElement(octoberfrom);
        }

        button.click(octoberfrom);
        button.click(calendartobutton);
        WebElement element3 = driver.findElement(yearbackto);
        Actions action3 = new Actions(driver);
        action3.moveToElement(element3).build().perform();
        int repeat1 = 3;
        for (int b = 0; b < repeat1; b++) {
            action3.moveToElement(element3).build().perform();
            button.click(yearbackto);
            wait.visibilityOfElement(octoberto);
        }
        button.click(octoberto);
        button.click(save);

        try {
            driver.findElement(validmessage);
            CheckRecorder.setValue("build 1!D65", CheckRecorder.PASSED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D65", CheckRecorder.FAILED);
        }
        button.click(cancelnew);
        return true;
    }

    //Check  edit "date" from the "Calendar" button
    public boolean editCalendarPeriod() throws IOException {

        WebElement element2 = driver.findElement(descedit);
        Actions action = new Actions(driver);
        scrollUntilVisibility();
        scroll();
        action.moveToElement(element2).build().perform();
        button.click(descedit);
        button.click(fromdatefieldedit);
        input.clear(fromdatefieldedit);
        input.type(fromdatefieldedit, "11/2015");
        button.click(save);

        try {
            driver.findElement(nov2017);
            CheckRecorder.setValue("build 1!D66", CheckRecorder.PASSED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D66", CheckRecorder.FAILED);
        }
        button.click(canceledit);
        return true;
    }

    //check the disabilty to set alphabetical values at "Certificate date"
    public boolean dateAlphabetical() throws IOException {
        WebElement element6 = driver.findElement(newtrainingbutton);
        Actions action = new Actions(driver);
        scrollUntilVisibility();
        action.moveToElement(element6).build().perform();
        button.click(newtrainingbutton);
        button.click(trainingnamefield);
        input.type(trainingnamefield, "tester");
        button.click(fromdatefield);
        input.type(fromdatefield, "October/2015");
        button.click(todatefield);
        input.type(todatefield, "11/2015");
        button.click(save);
        try {
            driver.findElement(validfrommessage);
            CheckRecorder.setValue("build 1!D67", CheckRecorder.PASSED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D67", CheckRecorder.FAILED);
        }
        button.click(cancelnew);
        return true;

    }

    //check the reaction to the double click
    public boolean doubleclick() throws IOException {
        CertItem enteredValue = new CertItem();
        enteredValue.title = "Web QC";
        String from = "10/2015";
        String to = "11/2016";
        enteredValue.date = from + "-" + to;
        WebElement element6 = driver.findElement(newtrainingbutton);
        Actions action1 = new Actions(driver);
        scrollUntilVisibility();
        scroll();
        action1.moveToElement(element6).build().perform();
        button.click(newtrainingbutton);
        button.click(trainingnamefield);
        input.type(trainingnamefield, enteredValue.title);
        button.click(fromdatefield);
        input.type(fromdatefield, from);
        button.click(todatefield);
        input.type(todatefield, to);

        Actions action3 = new Actions(driver);
        WebElement element = driver.findElement(save);
        action3.doubleClick(element).perform();

        if (duplicateCount(enteredValue) >= 2) {

            CheckRecorder.setValue("build 1!D68", CheckRecorder.FAILED);
        } else {
            CheckRecorder.setValue("build 1!D68", CheckRecorder.PASSED);
        }
        return true;
    }


    public int duplicateCount(CertItem item) {
        List<WebElement> elementsList = driver.findElements(trainingrow);
        List<CertItem> certItems = new ArrayList<>();

        for (int n = 0; n < elementsList.size(); n++) {
            WebElement webElement = elementsList.get(n);
            CertItem certItem = new CertItem();

            certItem.title = webElement.findElement(By.className("title")).getText();
            certItem.date = webElement.findElement(By.className("date")).getText();
            certItems.add(certItem);

        }

        int duplicateCount = 0;

        for (int k = 0; k < certItems.size(); k++) {
            if (certItems.get(k).title.equals(item.title)
                    && certItems.get(k).date.equals(item.date)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }


    public void scroll() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-100)", "");

    }


    public void scrollUntilVisibility() {
        WebElement element = driver.findElement(trainingblock);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.presenceOfElement(newtrainingbutton);

    }


    class CertItem {
        public String title;
        public String subtitle;
        public String date;
    }
}