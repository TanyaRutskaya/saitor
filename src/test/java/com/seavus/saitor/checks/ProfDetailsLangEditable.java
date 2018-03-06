package com.seavus.saitor.checks;

import com.seavus.common.elements.ElementActions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.seavus.saitor.googledoc.CheckRecorder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ProfDetailsLangEditable extends ElementActions {
    By languageblock = By.xpath("//div[@class='col-xs-12 child-component list-component' and //*[text()='Language']]");
    By newlan = By.xpath("//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Language']]//button[@title='Create new']");
    By editeng = By.xpath(".//div[@class='col-xs-12 child-component list-component' and //*[text()='Language']]//div[@class='row col-xs-12 padding-left-none read-only-item-component' and .//p[text()='English']]//button[@title='Edit']");
    By editgerman = By.xpath(".//div[@class='col-xs-12 child-component list-component' and //*[text()='Language']]//div[@class='row col-xs-12 padding-left-none read-only-item-component' and .//p[text()='Deutch']]//button[@title='Edit']");
    By language = By.xpath(".//div[@class='col-xs-12 child-component list-component' and //*[text()='Language']]//input[@name ='cvComposition.inputForms.languageModel.name']");
    By langprofEn = By.xpath("//div[@class='col-xs-12 child-component list-component' and //*[text()='Language']]//select");
    By langprofDe = By.xpath("//div[@class='col-xs-12 child-component list-component' and //*[text()='Language']]//p[@class='subtitle' and text()='Limited Working']");
    By save = By.xpath(".//div[@class='col-xs-12 child-component list-component' and //*[text()='Language']]//span[text()='Save']");
    By german = By.xpath("//div[@class='col-xs-12 child-component list-component' and //*[text()='Language']]//p[@class='title' and text()='Deutch']");
    By chinese = By.xpath("//div[@class='col-xs-12 child-component list-component' and //*[text()='Language']]//p[@class='title' and text()='Chinese']");
    By englishinfield = By.xpath(".//div[@class='col-xs-12 child-component list-component' and //*[text()='Language']]//input[@value='English']");
    By remove = By.xpath("//div[@class='col-xs-12 child-component list-component' and //*[text()='Language']]//span[text()='Remove']");
    By cancel = By.xpath(".//div[@class='col-xs-12 child-component list-component' and //*[text()='Language']]//button[@class='btn btn-flat btn-default' and text()='Cancel']");
    By cancelEdition = By.xpath(".//div[@class='col-xs-12 child-component list-component' and //*[text()='Language']]//span[@class='cancel-icon glyphicon glyphicon-remove']");
    By langrow = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Language']]//div[@class='row col-xs-12 padding-left-none read-only-item-component']");
    By langvalidation = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Language']]//span[text()='Language is required']");
    By profvalidation = By.xpath(".//div[@class='col-xs-12 child-component list-component' and .//h5[text()='Language']]//span[text()='Proficiency is required']");


    public boolean newlang() throws IOException {
        wait.presenceOfElement(newlan);
        WebElement element = driver.findElement(newlan);
        Actions action = new Actions(driver);
        scrolluntilvisibility();
        scroll();
        action.moveToElement(element).build().perform();
        button.click(newlan);
        button.click(language);
        input.type(language, "English");
        Select level = new Select(driver.findElement(langprofEn));
        level.selectByValue("NATIVE");
        button.click(save);
        try {
            driver.findElement(editeng);
            CheckRecorder.setValue("build 1!D22", CheckRecorder.PASSED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D22", CheckRecorder.FAILED);
        }
        button.click(cancel);
        return true;
    }

    //Cancel check in Edit mode
    public boolean cancelEditProf() throws IOException {
        WebElement element6 = driver.findElement(editeng);
        Actions action = new Actions(driver);
        scrolluntilvisibility();
        scroll();
        action.moveToElement(element6).build().perform();
        button.click(editeng);
        Select level3 = new Select(driver.findElement(langprofEn));
        level3.selectByValue("LIMITED_WORKING");
        button.click(langprofEn);
        input.clear(englishinfield);
        input.type(language, "Deutch");
        button.click(cancelEdition);
        try {
            driver.findElement(langprofDe);
            CheckRecorder.setValue("build 1!D27", CheckRecorder.FAILED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D27", CheckRecorder.PASSED);
        }
        return true;
    }

    // check the adjustment of the language
    public boolean langEdit() throws IOException {
        WebElement element2 = driver.findElement(editeng);
        Actions action2 = new Actions(driver);
        scrolluntilvisibility();
        scroll();
        action2.moveToElement(element2).build().perform();
        button.click(editeng);
        input.clear(englishinfield);
        input.type(language, "Deutch");
        button.click(save);
        try {
            driver.findElement(german);
            CheckRecorder.setValue("build 1!D23", CheckRecorder.PASSED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D23", CheckRecorder.FAILED);
        }
        return true;
    }

    //checking the adjustment of the  language level
    public boolean langprofEdit() throws IOException {
        WebElement element3 = driver.findElement(editgerman);
        Actions action = new Actions(driver);
        action.moveToElement(element3).build().perform();
        button.click(editgerman);
        Select level2 = new Select(driver.findElement(langprofEn));
        level2.selectByValue("LIMITED_WORKING");
        button.click(save);
        try {
            driver.findElement(langprofDe);
            CheckRecorder.setValue("build 1!D24", CheckRecorder.PASSED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D24", CheckRecorder.FAILED);
        }
        return true;
    }


    public boolean removelang() throws IOException {
        WebElement element4 = driver.findElement(editgerman);
        Actions action = new Actions(driver);
        action.moveToElement(element4).build().perform();
        button.click(editgerman);
        button.click(remove);
        try {
            driver.findElement(german);
            CheckRecorder.setValue("build 1!D25", CheckRecorder.FAILED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D25", CheckRecorder.PASSED);
        }
        return true;
    }


    public boolean cancelCreateLang() throws IOException {
        WebElement element5 = driver.findElement(newlan);
        Actions action = new Actions(driver);
        scrolluntilvisibility();
        scroll();
        action.moveToElement(element5).build().perform();
        button.click(newlan);
        button.click(language);
        input.type(language, "Chinese");
        Select level = new Select(driver.findElement(langprofEn));
        level.selectByValue("NATIVE");
        button.click(cancel);
        try {
            driver.findElement(chinese);
            CheckRecorder.setValue("build 1!D26", CheckRecorder.FAILED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D26", CheckRecorder.PASSED);
        }
        return true;
    }


    public boolean doubleclick() throws IOException {
        LangItem enteredValue = new LangItem();
        enteredValue.enterlang = "Italian";
        enteredValue.enterprof = "Elementary";
        WebElement element5 = driver.findElement(newlan);
        Actions action = new Actions(driver);
        scrolluntilvisibility();
        scroll();
        action.moveToElement(element5).build().perform();
        button.click(newlan);
        button.click(language);
        input.type(language, enteredValue.enterlang);
        Select level = new Select(driver.findElement(langprofEn));
        level.selectByValue("ELEMENTARY");
        Actions action2 = new Actions(driver);
        WebElement element6 = driver.findElement(save);
        action2.doubleClick(element6).perform();
        if (duplicateCount(enteredValue) >= 2) {
            CheckRecorder.setValue("build 1!D28", CheckRecorder.FAILED);
        } else {
            CheckRecorder.setValue("build 1!D28", CheckRecorder.PASSED);
        }
        return true;
    }

    //Language field validation check
    public boolean validationLangfield() throws IOException {
        WebElement element5 = driver.findElement(newlan);
        Actions action = new Actions(driver);
        scrolluntilvisibility();
        scroll();
        action.moveToElement(element5).build().perform();
        button.click(newlan);
        Select level = new Select(driver.findElement(langprofEn));
        level.selectByValue("NATIVE");
        button.click(save);
        try {
            driver.findElement(langvalidation);
            CheckRecorder.setValue("build 1!D29", CheckRecorder.PASSED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D29", CheckRecorder.FAILED);
        }
        button.click(cancel);
        return true;
    }

    //Level filed validation check
    public boolean validationProffield() throws IOException {
        WebElement element5 = driver.findElement(newlan);
        Actions action = new Actions(driver);
        scrolluntilvisibility();
        scroll();
        action.moveToElement(element5).build().perform();
        button.click(newlan);
        button.click(language);
        input.type(language, "English");
        button.click(save);
        try {
            driver.findElement(profvalidation);
            CheckRecorder.setValue("build 1!D30", CheckRecorder.PASSED);
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D30", CheckRecorder.FAILED);
        }
        button.click(cancel);
        return true;
    }


    public void scroll() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-150)", "");
    }


    public int duplicateCount(LangItem item) {
        List<WebElement> elementslist = driver.findElements(langrow);
        List<LangItem> langItems = new ArrayList<>();
        for (int n = 0; n < elementslist.size(); n++) {
            WebElement webElement = elementslist.get(n);
            LangItem langItem = new LangItem();
            langItem.enterlang = webElement.findElement(By.className("title")).getText();
            langItem.enterprof = webElement.findElement(By.className("subtitle")).getText();
            langItems.add(langItem);
        }

        int duplicateCount = 0;
        for (int k = 0; k < langItems.size(); k++) {
            if (langItems.get(k).enterlang.equals(item.enterlang)
                    && langItems.get(k).enterprof.equals(item.enterprof)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }


    public void scrolluntilvisibility() {
        WebElement element = driver.findElement(languageblock);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.presenceOfElement(newlan);
    }


    class LangItem {
        public String enterlang;
        public String enterprof;
    }
}