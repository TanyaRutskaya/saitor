package com.seavus.saitor.checks;

import com.seavus.common.elements.ElementActions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import com.seavus.saitor.googledoc.CheckRecorder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ProfDetailsCertificationEditable extends ElementActions {

    By certificateblock = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Certification']]");
    By newcertificatebutton = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Certification']]//button[@title='Create new']");
    By certnameQC = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Certification']]//p[text()='Web QC']");
    By certnameWeb = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Certification']]//p[text()='Web QA']");
    By editQC = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Certification']]//div[@class='row col-xs-12 padding-left-none read-only-item-component' and .//p[text()='Web QC']]//button[@title='Edit']");
    By webedit = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Certification']]//div[@class='row col-xs-12 padding-left-none read-only-item-component' and .//p[text()='Web QA']]//button[@title='Edit']");
    By certnamefield = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Certification']]//input[@name='cvComposition.inputForms.certificationModel.name']");
    By canceledit = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Certification']]//span[@class='cancel-icon glyphicon glyphicon-remove']");
    By certyearback = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Certification']]//button[@aria-label='navigate back']");
    By certdatefield = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Certification']]//input[@name='cvComposition.inputForms.certificationModel.validFrom']");
    By certissuer = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Certification']]//input[@placeholder='Enter certification issuer']");
    By editcertissuer = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Certification']]//input[@name='cvComposition.inputForms.certificationModel.issuer']");
    By oct2017 = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Certification']]//p[@class='subtitle'and text()='10/2017']");
    By school = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Certification']]//p[@class='title' and text()='School']");
    By belhard = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Certification']]//p[text()='Belhard']");
    By calendarbutton = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Certification']]//div[input[@name='cvComposition.inputForms.certificationModel.validFrom']]//button");
    By certyearforward = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Certification']]//div[input[@name='cvComposition.inputForms.certificationModel.validFrom']]//button[@aria-label='navigate forward']");
    By october = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Certification']]//td/span[text()='Oct']");
    By save = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Certification']]//span[@class='ladda-label' and text()='Save']");
    By remove = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Certification']]//span[text()='Remove']");
    By cancelnewcert = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Certification']]//button[text()='Cancel']");
    By certrow = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Certification']]//div[@class='row col-xs-12 padding-left-none read-only-item-component']");
    By namevalidmessage = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Certification']]//span[text()='Certification name is required']");
    By issuervalidmessage = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Certification']]//span[text()='Certification issuer is required']");
    By datevalidmessage = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Certification']]//span[text()='Certification valid from is required']");

    //Create a new certification
    public boolean addNew() throws IOException {
        wait.presenceOfElement(newcertificatebutton);

        WebElement element1 = driver.findElement(newcertificatebutton);
        Actions action1 = new Actions(driver);
        scrolluntilvisibility();
        scroll();
        action1.moveToElement(element1).build().perform();
        button.click(newcertificatebutton);
        scroll();
        button.click(certnamefield);

        input.type(certnamefield, "Web QA");
        button.click(certissuer);
        input.type(certissuer, "basic");
        button.click(calendarbutton);
        WebElement element2 = driver.findElement(certyearback);
        Actions action2 = new Actions(driver);
        action2.moveToElement(element2).build().perform();
        int repeat = 3;

        for (int a = 0; a < repeat; a++) {
            action2.moveToElement(element2).build().perform();
            button.click(certyearback);
            wait.visibilityOfElement(october);
        }

        button.click(october);
        button.click(save);

        try {
            driver.findElement(certnameWeb);
            CheckRecorder.setValue("build 1!D43", CheckRecorder.PASSED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D43", CheckRecorder.FAILED);
        }
        return true;
    }

    //check the "Cancel" at edit mode
    public boolean certEditCancel() throws IOException {

        WebElement element1 = driver.findElement(webedit);
        Actions action = new Actions(driver);
        scrolluntilvisibility();
        scroll();
        action.moveToElement(element1).build().perform();
        button.click(webedit);
        button.click(certnamefield);
        input.clear(certnamefield);
        input.type(certnamefield, "School");
        button.click(canceledit);

        try {
            driver.findElement(school);
            CheckRecorder.setValue("build 1!D44", CheckRecorder.FAILED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D44", CheckRecorder.PASSED);
        }
        return true;
    }

    public boolean certCreateCancel() throws IOException {

        WebElement element1 = driver.findElement(newcertificatebutton);
        Actions action = new Actions(driver);
        action.moveToElement(element1).build().perform();
        button.click(newcertificatebutton);
        button.click(certnamefield);
        input.type(certnamefield, "Web QC");
        button.click(certissuer);
        input.type(certissuer, "basic");
        button.click(calendarbutton);
        WebElement element2 = driver.findElement(certyearback);
        Actions action2 = new Actions(driver);
        action2.moveToElement(element2).build().perform();
        int repeat = 3;

        for (int a = 0; a < repeat; a++) {
            action2.moveToElement(element2).build().perform();
            button.click(certyearback);
            wait.visibilityOfElement(october);
        }

        button.click(october);
        button.click(cancelnewcert);

        try {
            driver.findElement(certnameQC);
            CheckRecorder.setValue("build 1!D45", CheckRecorder.FAILED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D45", CheckRecorder.PASSED);
        }
        return true;
    }

    //Check  edit "date" from the "Calendar" button
    public boolean editCalendarPeriod() throws IOException {

        WebElement element2 = driver.findElement(webedit);
        Actions action = new Actions(driver);
        action.moveToElement(element2).build().perform();
        button.click(webedit);
        button.click(calendarbutton);

        WebElement element3 = driver.findElement(certyearforward);
        Actions action3 = new Actions(driver);
        action3.moveToElement(element3).build().perform();
        int repeat = 2;

        for (int a = 0; a < repeat; a++) {
            action3.moveToElement(element3).build().perform();
            button.click(certyearforward);
            wait.visibilityOfElement(october);
        }

        button.click(october);
        button.click(save);

        try {
            driver.findElement(oct2017);
            CheckRecorder.setValue("build 1!D46", CheckRecorder.PASSED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D46", CheckRecorder.FAILED);
        }

        return true;
    }

    //Edit Cetrification name and issuer check
    public boolean editCertnameIssuer() throws IOException {

        WebElement element4 = driver.findElement(webedit);
        Actions action4 = new Actions(driver);
        action4.moveToElement(element4).build().perform();
        button.click(webedit);
        button.click(certnamefield);
        input.clear(certnamefield);
        input.type(certnamefield, "Desctop QA");
        button.click(editcertissuer);
        input.clear(editcertissuer);
        input.type(editcertissuer, "Belhard");
        button.click(save);

        try {
            driver.findElement(belhard);//need to add additional "driver.findElement(desctop)"
            CheckRecorder.setValue("build 1!D47", CheckRecorder.PASSED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D47", CheckRecorder.FAILED);
        }
        return true;
    }

    //the ability to add > than 1 block
    public boolean morethan1block() throws IOException {
        WebElement element1 = driver.findElement(newcertificatebutton);
        Actions action1 = new Actions(driver);
        action1.moveToElement(element1).build().perform();
        CertItem enteredValue = new CertItem();
        enteredValue.title = "Web QC";
        String month = "10";
        String year = "2015";
        enteredValue.subtitle = month + "/" + year;

        int repeat = 3;

        for (int i = 0; i < repeat; i++) {
            action1.moveToElement(element1).build().perform();
            scrolluntilvisibility();
            scroll();
            button.click(newcertificatebutton);
            scroll();
            button.click(certnamefield);
            input.type(certnamefield, enteredValue.title);
            button.click(certissuer);
            input.type(certissuer, "basic");
            button.click(certdatefield);
            input.type(certdatefield, enteredValue.subtitle);
            button.click(save);
        }
        System.out.print("repeat counted = " + " " + duplicateCount(enteredValue));
        if (repeat == duplicateCount(enteredValue)) {

            CheckRecorder.setValue("build 1!D49", CheckRecorder.PASSED);
        } else {
            CheckRecorder.setValue("build 1!D49", CheckRecorder.FAILED);
        }
        return true;
    }

    //remove Certification
    public boolean removeCert() throws IOException {

        CertItem enteredValue = new CertItem();
        enteredValue.title = "Web QC";
        String month = "10";
        String year = "2015";
        enteredValue.subtitle = month + "/" + year;
        Actions action4 = new Actions(driver);

        int repeatdelete = 3;

        for (int a = 0; a < repeatdelete; a++) {
            WebElement element4 = driver.findElement(editQC);
            action4.moveToElement(element4).build().perform();
            button.click(editQC);
            button.click(remove);
            scrolluntilvisibility();
        }

        if (repeatdelete == duplicateCount(enteredValue)) {

            CheckRecorder.setValue("build 1!D48", CheckRecorder.FAILED);
        } else {
            CheckRecorder.setValue("build 1!D48", CheckRecorder.PASSED);
        }

        return true;
    }

    //check the validation for the field "Certification name"
    public boolean validationcertname() throws IOException, InterruptedException {
        WebElement element6 = driver.findElement(newcertificatebutton);
        Actions action = new Actions(driver);
        scrolluntilvisibility();
        action.moveToElement(element6).build().perform();
        button.click(newcertificatebutton);
        button.click(certissuer);
        scroll();
        input.type(certissuer, "basic");
        button.click(certdatefield);
        input.type(certdatefield, "10/2015");
        button.click(save);
        try {
            driver.findElement(namevalidmessage);
            CheckRecorder.setValue("build 1!D50", CheckRecorder.PASSED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D50", CheckRecorder.FAILED);
        }
        button.click(cancelnewcert);
        return true;
    }

    //check the validation for the field "Certification issuer"
    public boolean validationcertissuer() throws IOException, InterruptedException {
        WebElement element6 = driver.findElement(newcertificatebutton);
        Actions action = new Actions(driver);
        action.moveToElement(element6).build().perform();
        button.click(newcertificatebutton);
        scroll();
        button.click(certnamefield);
        input.type(certnamefield, "Designer");
        button.click(certdatefield);
        input.type(certdatefield, "10/2015");
        button.click(save);

        try {
            driver.findElement(issuervalidmessage);
            CheckRecorder.setValue("build 1!D51", CheckRecorder.PASSED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D51", CheckRecorder.FAILED);
        }

        button.click(cancelnewcert);
        return true;
    }

    //check the validation for the field "Certification issuer"
    public boolean validationcertdate() throws IOException, InterruptedException {
        WebElement element6 = driver.findElement(newcertificatebutton);
        Actions action = new Actions(driver);
        action.moveToElement(element6).build().perform();
        button.click(newcertificatebutton);
        scroll();
        button.click(certnamefield);
        input.type(certnamefield, "Designer");
        button.click(certissuer);
        input.type(certissuer, "basic");
        button.click(save);

        try {
            driver.findElement(datevalidmessage);
            CheckRecorder.setValue("build 1!D52", CheckRecorder.PASSED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D52", CheckRecorder.FAILED);
        }

        button.click(cancelnewcert);
        return true;
    }


    //check the disabilty to set alphabetical values at "Certificate date"
    public boolean dateAlphabetical() throws IOException {
        WebElement element6 = driver.findElement(newcertificatebutton);
        Actions action = new Actions(driver);
        scrolluntilvisibility();
        action.moveToElement(element6).build().perform();
        button.click(newcertificatebutton);
        button.click(certnamefield);
        input.type(certnamefield, "tester");
        button.click(certissuer);
        input.type(certissuer, "Harvard");
        button.click(certdatefield);
        input.type(certdatefield, "October/2015");
        button.click(save);

        try {
            driver.findElement(datevalidmessage);
            CheckRecorder.setValue("build 1!D53", CheckRecorder.PASSED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D53", CheckRecorder.FAILED);
        }

        button.click(cancelnewcert);
        return true;

    }

    // check the disability to set the Certification date later than current date
    public boolean dateExceeds() throws IOException {
        WebElement element5 = driver.findElement(newcertificatebutton);
        Actions action = new Actions(driver);
        scrolluntilvisibility();
        action.moveToElement(element5).build().perform();
        button.click(newcertificatebutton);
        scroll();
        button.click(certnamefield);
        input.type(certnamefield, "Harvard");
        button.click(certissuer);
        input.type(certissuer, "magician");
        button.click(calendarbutton);
        WebElement element2 = driver.findElement(certyearforward);
        Actions action2 = new Actions(driver);
        action2.moveToElement(element2).build().perform();
        int repeat = 1;

        for (int a = 0; a < repeat; a++) {
            action2.moveToElement(element2).build().perform();
            button.click(certyearforward);
            wait.visibilityOfElement(october);
        }

        button.click(save);

        try {
            driver.findElement(datevalidmessage);
            CheckRecorder.setValue("build 1!D54", CheckRecorder.PASSED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D54", CheckRecorder.FAILED);
        }

        return true;
    }

    //check the reaction to the double click
    public boolean doubleclick() throws IOException {
        CertItem enteredValue = new CertItem();
        enteredValue.title = "Web QC";
        String month = "10";
        String year = "2015";
        enteredValue.subtitle = month + "/" + year;

        WebElement element6 = driver.findElement(newcertificatebutton);
        Actions action1 = new Actions(driver);
        action1.moveToElement(element6).build().perform();
        button.click(newcertificatebutton);
        scroll();
        button.click(certnamefield);
        input.type(certnamefield, enteredValue.title);
        button.click(certissuer);
        input.type(certissuer, "basic");
        button.click(certdatefield);
        input.type(certdatefield, enteredValue.subtitle);

        Actions action3 = new Actions(driver);
        WebElement element = driver.findElement(save);
        action3.doubleClick(element).perform();

        if (duplicateCount(enteredValue) >= 2) {

            CheckRecorder.setValue("build 1!D55", CheckRecorder.FAILED);
        } else {
            CheckRecorder.setValue("build 1!D55", CheckRecorder.PASSED);
        }

        return true;
    }


    public int duplicateCount(CertItem item) {
        List<WebElement> elementslist = driver.findElements(certrow);
        List<CertItem> certItems = new ArrayList<>();

        for (int n = 0; n < elementslist.size(); n++) {
            WebElement webElement = elementslist.get(n);
            CertItem certItem = new CertItem();

            certItem.title = webElement.findElement(By.className("title")).getText();
            certItem.subtitle = webElement.findElement(By.className("subtitle")).getText();
            certItems.add(certItem);
        }

        int duplicateCount = 0;

        for (int k = 0; k < certItems.size(); k++) {
            if (certItems.get(k).title.equals(item.title)
                    && certItems.get(k).subtitle.equals(item.subtitle)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }


    public void scroll() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-100)", "");
    }


    public void scrolluntilvisibility() {
        WebElement element = driver.findElement(certificateblock);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.presenceOfElement(newcertificatebutton);
    }


    class CertItem {
        public String title;
        public String subtitle;
    }
}