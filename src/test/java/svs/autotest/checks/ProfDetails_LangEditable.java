package svs.autotest.checks;

import com.seavus.common.elements.ElementActions;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.Select;
import svs.autotest.GoogleExcel.CheckRecorder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ProfDetails_LangEditable extends ElementActions {


    By newlan = By.xpath("//div[@class='col-xs-12 child-component' and //*[text()='Language']]//button[@title='Create new']");
    By editeng = By.xpath(".//div[@class='col-xs-12 child-component' and //*[text()='Language']]//div[@class='col-xs-12 padding-left-none' and .//p[text()='English']]//button[@title='Edit']");
    By editgerman = By.xpath(".//div[@class='col-xs-12 child-component' and //*[text()='Language']]//div[@class='col-xs-12 padding-left-none' and .//p[text()='Deutch']]//button[@title='Edit']");
    By language = By.xpath(".//div[@class='col-xs-12 child-component' and //*[text()='Language']]//input[@name ='cvComposition.inputForms.languageModel.name']");
    By langprofEn = By.xpath("//div[@class='col-xs-12 child-component' and //*[text()='Language']]//select");
    By langprofDe = By.xpath("//div[@class='col-xs-12 child-component' and //*[text()='Language']]//p[@class='subtitle' and text()='Elementary']");
    By create = By.xpath(".//div[@class='col-xs-12 child-component' and //*[text()='Language']]//button[@class='btn btn-flat btn-success margin-r-5' and text()='Create']");
    By saveEdition= By.xpath(".//div[@class='col-xs-12 child-component' and //*[text()='Language']]//button[@class='btn btn-flat btn-success margin-r-5' and text()='Save']");
    By german = By.xpath("//div[@class='col-xs-12 child-component' and //*[text()='Language']]//p[@class='title' and text()='Deutch']");
    By english = By.xpath("//div[@class='col-xs-12 child-component' and //*[text()='Language']]//p[@class='title' and text()='English']");
    By englishinfield=By.xpath(".//div[@class='col-xs-12 child-component' and //*[text()='Language']]//input[@value='English']");
    By remove= By.xpath("//div[@class='col-xs-12 child-component' and //*[text()='Language']]//a[text()='Remove']");
    By cancel = By.xpath("/html/body/div/div/div[2]/div/div/div[3]/div[3]/div[2]/form/div/div[2]/button[2]");
    By cancelEdition = By.xpath(".//div[@class='col-xs-12 child-component' and //*[text()='Language']]//span[@class='cancel-button glyphicon glyphicon-remove']");
    By langrow = By.xpath(".//div[@class='col-xs-12 child-component' and .//h5[text()='Language']]//div[@class='col-xs-12 padding-left-none']");
    By langvalidation = By.xpath(".//div[@class='col-xs-12 child-component' and .//h5[text()='Language']]//span[text()='Language is required']");
    By profvalidation = By.xpath(".//div[@class='col-xs-12 child-component' and .//h5[text()='Language']]//span[text()='Proficiency is required']");

    public boolean newlang() throws IOException {
        navigate.openBrowser();
        navigate.maximizeBrowser();
        navigate.to($("URL1"));
        Alert alert = driver.switchTo().alert();
        alert.accept();
        navigate.to($("URL2"));
        wait.presenceOfElement(newlan);
        WebElement element = driver.findElement(newlan);
        Actions action = new Actions(driver);


        try {
            action.moveToElement(element).build().perform();
        } catch (MoveTargetOutOfBoundsException ex) {

        scroll();
            action.moveToElement(element).build().perform();

        }
            button.click(newlan);
            button.click(language);
            input.type(language, "English");
            Select level = new Select(driver.findElement(langprofEn));
            level.selectByValue("NATIVE");
            button.click(create);

        try {

            driver.findElement(editeng);
            CheckRecorder.setValue("build 1!D22", "passed");
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D22", "failed");
        }
        return true;

    }

        public boolean langEdit() throws IOException {

            WebElement element2 = driver.findElement(editeng);
            Actions action= new Actions(driver);
            scroll();
            action.moveToElement(element2).build().perform();
            button.click(editeng);
            input.clear(englishinfield);
            input.type(language, "Deutch");
            button.click(saveEdition);

            try {

                driver.findElement(german);
                CheckRecorder.setValue("build 1!D23", "passed");
            } catch (NoSuchElementException ex) {
                CheckRecorder.setValue("build 1!D23", "failed");
            }

            return true;
        }


//checking the adjustment of the  language level

    public boolean langprofEdit() throws IOException {

        WebElement element3 = driver.findElement(editgerman);
        Actions action= new Actions(driver);
        action.moveToElement(element3).build().perform();
        button.click(editgerman);


        Select level2 = new Select(driver.findElement(langprofEn));
        level2.selectByValue("ELEMENTARY");
        button.click(saveEdition);


        if (driver.findElement(langprofDe) != null) {
            if (driver.findElement(langprofDe) != null) {
                CheckRecorder.setValue("build 1!D24", "passed");
            } else {
                CheckRecorder.setValue("build 1!D24", "failed");
            }
        }

        return true;
    }

//Cancel check in Edit mode

    public boolean cancelEditProf() throws IOException {

        WebElement element6 = driver.findElement(editeng);
        Actions action= new Actions(driver);
        action.moveToElement(element6).build().perform();
        button.click(editeng);
        Select level3 = new Select(driver.findElement(langprofEn));
        level3.selectByValue("PROFESSIONAL_WORKING");
        button.click(langprofEn);
        input.clear(englishinfield);
        input.type(language, "Deutch");
        button.click(cancelEdition);

        try {
            driver.findElement(langprofDe);
            CheckRecorder.setValue("build 1!D27", "failed");
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D27", "passed");
        }
        return true;
    }



    public boolean removelang() throws IOException {

        WebElement element4 = driver.findElement(editgerman);
        Actions action= new Actions(driver);
        action.moveToElement(element4).build().perform();
        button.click(editgerman);
        button.click(remove);


        try {
            driver.findElement(german);
            CheckRecorder.setValue("build 1!D25", "failed");
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D25", "passed");
        }
        return true;
    }
    public boolean cancelCreateLang() throws IOException {

       // wait.presenceOfElement(newlan);
        WebElement element5 = driver.findElement(newlan);
        Actions action= new Actions(driver);
        action.moveToElement(element5).build().perform();
        button.click(newlan);
        button.click(language);
        input.type(language, "English");
        Select level = new Select(driver.findElement(langprofEn));
        level.selectByValue("NATIVE");
        button.click(cancel);

        try {
            driver.findElement(english);
            CheckRecorder.setValue("build 1!D26", "failed");
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D26", "passed");
        }

        return true;
    }
    public boolean doubleclick() throws IOException {
        LangItem enteredValue = new LangItem();
        enteredValue.enterlang = "Italian";
        enteredValue.enterprof= "Elementary";

        WebElement element5 = driver.findElement(newlan);
        Actions action= new Actions(driver);
        scroll();
        action.moveToElement(element5).build().perform();
        button.click(newlan);
        button.click(language);
        input.type(language, enteredValue.enterlang);
        Select level = new Select(driver.findElement(langprofEn));
        level.selectByValue("ELEMENTARY");
        Actions action2 = new Actions(driver);
        WebElement element=driver.findElement(create);
        action2.doubleClick(element).perform();
        //button.click(create);


        if(duplicateCount(enteredValue)>=2) {

            CheckRecorder.setValue("build 1!D28", "failed");
        } else  {
            CheckRecorder.setValue("build 1!D28", "passed");
        }
        return true;
    }

    //Language field validation check

    public boolean validationLangfield() throws IOException {

        // wait.presenceOfElement(newlan);
        WebElement element5 = driver.findElement(newlan);
        Actions action= new Actions(driver);
        action.moveToElement(element5).build().perform();
        button.click(newlan);
        Select level = new Select(driver.findElement(langprofEn));
        level.selectByValue("NATIVE");
        button.click(create);
        button.click(create);//need to be removed after the bug 152 is fixed

        try {
            driver.findElement(langvalidation);
            CheckRecorder.setValue("build 1!D29", "passed");
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D29", "failed");
        }

        return true;
    }

    //Level filed validation check

    public boolean validationProffield() throws IOException {

        // wait.presenceOfElement(newlan);
        WebElement element5 = driver.findElement(newlan);
        Actions action= new Actions(driver);
        action.moveToElement(element5).build().perform();
        button.click(newlan);
        button.click(language);
        input.type(language, "English");
        button.click(create);
        button.click(create);//need to be removed after the bug 152 is fixed

        try {
            driver.findElement(profvalidation);
            CheckRecorder.setValue("build 1!D30", "passed");
        } catch (NoSuchElementException ex) {
            CheckRecorder.setValue("build 1!D30", "failed");
        }

        return true;
    }

public void scroll(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
}

 public int duplicateCount(LangItem item) {
List<WebElement> elementslist= driver.findElements(langrow);
  List <LangItem> langItems = new ArrayList<>();

        for(int n = 0; n < elementslist.size(); n++) {
        WebElement webElement = elementslist.get(n);
        LangItem langItem = new LangItem();

        langItem.enterlang = webElement.findElement(By.className("title")).getText();
        langItem.enterprof = webElement.findElement(By.className("subtitle")).getText();


        langItems.add(langItem);

    }

    int duplicateCount = 0;

        for(int k = 0; k < langItems.size(); k++){
        if(langItems.get(k).enterlang.equals(item.enterlang)
                && langItems.get(k).enterprof.equals(item.enterprof))
            {
            duplicateCount++;
        }
    }
        return duplicateCount;
}

class LangItem {
    public String enterlang;
    public String enterprof;

}
}