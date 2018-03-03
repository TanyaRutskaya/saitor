package com.seavus.saitor.checks;

import com.seavus.common.elements.ElementActions;
import com.seavus.saitor.GoogleExcel.CheckRecorder;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ProfDetailsEducationEditable extends ElementActions {

    By edublock = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Education']]");
    By newedu = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Education']]//button[@title='Create new']");
    By mslu = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Education']]//p[text()='MSLU']");
    By msluedit = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Education']]//div[@class='row col-xs-12 padding-left-none read-only-item-component' and .//p[text()='MSLU']]//button[@title='Edit']");
    By editBSUIR = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Education']]//div[@class='row col-xs-12 padding-left-none read-only-item-component' and .//p[text()='BSUIR']]//button[@title='Edit']");
    By eduname = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Education']]//input[@name='cvComposition.inputForms.educationModel.name']");
    By canceledit = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Education']]//span[@class='cancel-icon glyphicon glyphicon-remove']");
    By edustart = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Education']]//div[input[@name='cvComposition.inputForms.educationModel.fromDate']]//input");
    By eduend = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Education']]//div[input[@name='cvComposition.inputForms.educationModel.toDate']]//input");
    By edudegree = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Education']]//div[input[@name='cvComposition.inputForms.educationModel.degree']]//input");
    By harvard = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Education']]//p[text()='Harvard']");
    By school = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Education']]//p[@class='title' and text()='School']");
    By startdatevalidation = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Education']]//span[text() = 'Education start year must be smaller than the end year']");
    By calendarfrombutton = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Education']]//span[@aria-hidden='true']");
    By y1999 = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Education']]//td[@title='1999']");
    By ye1999 = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Education']]//input[@value='1999']");
    By save = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Education']]//span[text()='Save']");
    By remove = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Education']]//span[text()='Remove']");
    By cancelnewedu = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Education']]//button[text()='Cancel']");
    By endDateValidation = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Education']]//span[text() = 'Education to date is required']");
    By edunamerequired = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Education']]//span[text() = 'Education name is required']");
    By edudegreerequired = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Education']]//span[text() = 'Education degree is required']");
    By edurow = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Education']]//div[@class='row col-xs-12 padding-left-none read-only-item-component']");

    //Create a new education
    public boolean addEdu() throws IOException {
        wait.presenceOfElement(newedu);
        WebElement element = driver.findElement(newedu);
        Actions action = new Actions(driver);
        scrolluntilvisibility();
        action.moveToElement(element).build().perform();
        button.click(newedu);
        button.click(eduname);
        input.type(eduname, "MSLU");
        button.click(edustart);
        input.type(edustart, "2007");
        button.click(edudegree);
        input.type(edudegree, "bachelor");
        button.click(eduend);
        input.type(eduend, "2012");
        button.click(save);

        try {
            driver.findElement(mslu);
            CheckRecorder.setValue("build 1!D31", "passed");
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D31", "failed");
        }
        return true;

    }

    //check the "Cancel" at edit mode
    public boolean langEditCancel() throws IOException {

        WebElement element1 = driver.findElement(mslu);
        Actions action1 = new Actions(driver);
        action1.moveToElement(element1).build().perform();
        button.click(msluedit);
        button.click(eduname);
        input.clear(eduname);
        input.type(eduname, "School");
        button.click(canceledit);

        try {
            driver.findElement(school);
            CheckRecorder.setValue("build 1!D32", "failed");
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D32", "passed");
        }
        return true;
    }

//Check  edit "From"/"To" from the "Calendar" button
    public boolean editCalendarPeriod() throws IOException {

        WebElement element2 = driver.findElement(msluedit);
        Actions action = new Actions(driver);
        scrolluntilvisibility();
        action.moveToElement(element2).build().perform();
        button.click(msluedit);
        scroll();
        button.click(calendarfrombutton);
        WebElement element4 = driver.findElement(y1999);
        Actions action2 = new Actions(driver);
        scrolluntilvisibility();
        action2.moveToElement(element4).build().perform();
        button.click(y1999);
        button.click(save);
        WebElement element3 = driver.findElement(msluedit);
        Actions action1 = new Actions(driver);
        scrolluntilvisibility();
        action1.moveToElement(element3).build().perform();
        button.click(msluedit);
        try {
            driver.findElement(ye1999);
            CheckRecorder.setValue("build 1!D37", "passed");
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D37", "failed");
        }
        button.click(canceledit);
        return true;
    }

    //Edit Education name check
    public boolean editEdu() throws IOException {

        WebElement element3 = driver.findElement(msluedit);
        Actions action3 = new Actions(driver);
        scrolluntilvisibility();
        action3.moveToElement(element3).build().perform();
        button.click(msluedit);
        scroll();
        button.click(eduname);
        input.clear(eduname);
        input.type(eduname, "School");
        button.click(save);
        try {
            driver.findElement(school);
            CheckRecorder.setValue("build 1!D34", "passed");
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D34", "failed");
        }
        return true;
    }

//verify if there is an ability to add > 2 educations
    public boolean morethan1block() throws IOException {
        WebElement element6 = driver.findElement(newedu);
        Actions action1 = new Actions(driver);
        EducationItem enteredValue = new EducationItem();
        enteredValue.title = "BSUIR";
        enteredValue.degree = "magistr";
        String startEdu = "1999";
        String endEdu = "2000";
        enteredValue.period = startEdu + " - " + endEdu;
        int repeat = 3;
        for (int i = 0; i < repeat; i++ ) {
            action1.moveToElement(element6).build().perform();
            button.click(newedu);
            button.click(eduname);
            input.type(eduname,  enteredValue.title);
            button.click(edudegree);
            input.type(edudegree, enteredValue.degree);
            button.click(edustart);
            input.type(edustart, startEdu);
            button.click(eduend);
            input.type(eduend, endEdu);
            button.click(save);
            scrolluntilvisibility();
            scroll();

        }
        System.out.print("repeat counted = " + " " +duplicateCount(enteredValue));
        if(repeat==duplicateCount(enteredValue)) {

            CheckRecorder.setValue("build 1!D39", "passed");
        } else  {
            CheckRecorder.setValue("build 1!D39", "failed");
        }
        return true;
    }

//remove education
    public boolean removeEdu() throws IOException {
        WebElement element6 = driver.findElement(newedu);
        EducationItem enteredValue = new EducationItem();
        enteredValue.title = "BSUIR";
        enteredValue.degree = "magistr";
        String startEdu = "1999";
        String endEdu = "2000";
        enteredValue.period = startEdu + " - " + endEdu;
        Actions action4 = new Actions(driver);

        int repeatdelete = 3;

        for (int a = 0; a < repeatdelete; a++ ) {
            WebElement element4 = driver.findElement(editBSUIR);
            action4.moveToElement(element4).build().perform();
            button.click(editBSUIR);
            button.click(remove);
            scrolluntilvisibility();
        }

        if(repeatdelete==duplicateCount(enteredValue)) {

            CheckRecorder.setValue("build 1!D38", "failed");
        } else  {
            CheckRecorder.setValue("build 1!D38", "passed");
        }

        return true;
    }

    //check the "Cancel" at "Create new" mode
    public boolean cancelCreateEdu() throws IOException {
        WebElement element5 = driver.findElement(newedu);
        Actions action = new Actions(driver);
        scrolluntilvisibility();
        action.moveToElement(element5).build().perform();
        button.click(newedu);
        scroll();
        button.click(eduname);
        input.type(eduname, "Harvard");
        button.click(edustart);
        input.type(edustart, "2003");
        button.click(edudegree);
        input.type(edudegree, "magician");
        button.click(eduend);
        input.type(eduend, "2013");
        button.click(cancelnewedu);

        try {
            driver.findElement(harvard);
            CheckRecorder.setValue("build 1!D33", "failed");
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D33", "passed");
        }
        return true;
    }

// check the disability to set the date "To" earlier than "From"
    public boolean dateToEarlier() throws IOException {
        WebElement element5 = driver.findElement(newedu);
        Actions action = new Actions(driver);
        scrolluntilvisibility();
        action.moveToElement(element5).build().perform();
        button.click(newedu);
        scroll();
        button.click(eduname);
        input.type(eduname, "Harvard");
        button.click(edustart);
        input.type(edustart, "2000");
        button.click(edudegree);
        input.type(edudegree, "magician");
        button.click(eduend);
        input.type(eduend, "1999");
        button.click(save);
        try {
            driver.findElement(startdatevalidation);
            CheckRecorder.setValue("build 1!D35", "passed");
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D35", "failed");
        }
        button.click(cancelnewedu);
        return true;
    }

    //check the disabilty to set String values at "From"/"To"
    public boolean dateAlphabetical() throws IOException {
        WebElement element6 = driver.findElement(newedu);
        Actions action = new Actions(driver);
        scrolluntilvisibility();
        action.moveToElement(element6).build().perform();
        button.click(newedu);
        scroll();
        button.click(eduname);
        input.type(eduname, "Harvard");
        button.click(edustart);
        input.type(edustart, "1999");
        button.click(edudegree);
        input.type(edudegree, "magician");
        button.click(eduend);
        input.type(eduend, "two thousand");
        button.click(save);
        try {
            driver.findElement(endDateValidation);
            CheckRecorder.setValue("build 1!D36", "passed");
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D36", "failed");
        }
        return true;
    }

//check the validation for the field EducationName
    public boolean validationeduname() throws IOException, InterruptedException {
        WebElement element6 = driver.findElement(newedu);
        Actions action = new Actions(driver);
        scrolluntilvisibility();
        action.moveToElement(element6).build().perform();
        button.click(newedu);
        scroll();
        button.click(edustart);
        input.type(edustart, "1999");
        button.click(edudegree);
        input.type(edudegree, "magician");
        button.click(eduend);
        input.type(eduend, "2000");
        button.click(save);

        try {
            driver.findElement(edunamerequired);
            CheckRecorder.setValue("build 1!D40", "passed");
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D40", "failed");
        }
        button.click(cancelnewedu);
        return true;
    }

//check the validation for the field EducationDegree
    public boolean validationedudegree() throws IOException, InterruptedException {
        WebElement element6 = driver.findElement(newedu);
        Actions action = new Actions(driver);
        scrolluntilvisibility();
        action.moveToElement(element6).build().perform();
        scroll();
        button.click(newedu);
        button.click(eduname);
        input.type(eduname, "Harvard");
        button.click(edustart);
        input.type(edustart, "1999");
        button.click(eduend);
        input.type(eduend, "2000");
        button.click(save);
        try {

            driver.findElement(edudegreerequired);
            CheckRecorder.setValue("build 1!D41", "passed");
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D41", "failed");
        }
        button.click(cancelnewedu);
        return true;
    }

//check the reaction to the double click
    public boolean doubleclick() throws IOException {
        EducationItem enteredValue = new EducationItem();
        enteredValue.title = "Harvard";
        enteredValue.degree = "wisard";
        String startEdu = "1999";
        String endEdu = "2003";
        enteredValue.period = startEdu + " - " + endEdu;
        WebElement element6 = driver.findElement(newedu);
        Actions action1 = new Actions(driver);
        scrolluntilvisibility();
        action1.moveToElement(element6).build().perform();
        button.click(newedu);
        scroll();
        button.click(eduname);
        input.type(eduname, enteredValue.title);
        button.click(edudegree);
        input.type(edudegree, enteredValue.degree);
        button.click(edustart);
        input.type(edustart, startEdu);
        button.click(eduend);
        input.type(eduend, endEdu);
        Actions action2 = new Actions(driver);
        WebElement element=driver.findElement(save);
        action2.doubleClick(element).perform();
        if(duplicateCount(enteredValue)>=2) {

            CheckRecorder.setValue("build 1!D42", "failed");
        } else  {
            CheckRecorder.setValue("build 1!D42", "passed");
        }
        return true;
    }


    public int duplicateCount(EducationItem item) {
        List<WebElement> elementslist= driver.findElements(edurow);
        List<EducationItem> educationItems = new ArrayList<>();

        for(int n = 0; n < elementslist.size(); n++) {
            WebElement webElement = elementslist.get(n);
            EducationItem educationItem = new EducationItem();
            educationItem.title = webElement.findElement(By.className("title")).getText();
            educationItem.degree = webElement.findElement(By.className("secondary-title")).getText();
            educationItem.period = webElement.findElement(By.className("date")).getText();
            educationItems.add(educationItem);
        }

        int duplicateCount = 0;
        for(int k = 0; k < educationItems.size(); k++){
            if(educationItems.get(k).title.equals(item.title)
                    && educationItems.get(k).degree.equals(item.degree)
                    && educationItems.get(k).period.equals(item.period)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }


    public void scroll() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-125)", "");
    }


    class EducationItem {
        public String title;
        public String degree;
        public String period;
    }


    public void scrolluntilvisibility(){
        WebElement element = driver.findElement(edublock);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.presenceOfElement(edublock);
    }
}