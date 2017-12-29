package svs.autotest.checks;

import com.seavus.common.elements.ElementActions;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import svs.autotest.GoogleExcel.CheckRecorder;

import java.io.IOException;


public class ProfDetails_LangEditable extends ElementActions {

    By username = By.id("user_name");
    By loginButton = By.id("login_button");
    By welcomeLink = By.id("welcome_link");
    By newlan = By.xpath("//div[@class='col-xs-12 child-component' and //*[text()='Language']]//button[@title='Create new']");
    By edit = By.xpath("//div[@class='col-xs-12 child-component' and //*[text()='Language']]//button[@title='Edit']");
    By language = By.xpath("/html/body/div/div/div[2]/div/div/div[3]/div[3]/div[2]/form/div/div[1]/div[1]/input");
    By langprofEn = By.xpath("//div[@class='col-xs-12 child-component' and //*[text()='Language']]//select");
    By langprofDe = By.xpath("//div[@class='col-xs-12 child-component' and //*[text()='Language']]//p[@class='subtitle' and text()='Elementary']");
    By create = By.xpath("/html/body/div/div/div[2]/div/div/div[3]/div[3]/div[2]/form/div/div[2]/button[1]");
    By save= By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[3]/div[3]/div[2]/div/div[1]/div/form/div/div[2]/button");
    By german = By.xpath("//div[@class='col-xs-12 child-component' and //*[text()='Language']]//p[@class='title' and text()='Deutch']");
    By english=By.xpath("html/body/div/div/div[2]/div/div/div[3]/div[3]/div[2]/div/div[1]/div/form/div/div[1]/div[1]/input");
    By remove= By.xpath("//div[@class='col-xs-12 child-component' and //*[text()='Language']]//a[text()='Remove']");
    By cancel = By.xpath("/html/body/div/div/div[2]/div/div/div[3]/div[3]/div[2]/form/div/div[2]/button[2]");
    By cancelEdition = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[3]/div[3]/div[2]/div/div/div/div[1]/span");

    public boolean newlang() throws IOException {
        navigate.openBrowser();
        navigate.maximizeBrowser();
        navigate.to($("URL1"));
        Alert alert = driver.switchTo().alert();
        alert.accept();
        navigate.to($("URL2"));
        wait.presenceOfElement(newlan);
        WebElement element = driver.findElement(newlan);
        Actions action= new Actions(driver);
        action.moveToElement(element).build().perform();
        button.click(newlan);
        button.click(language);
        input.type(language, "English");
        Select level = new Select(driver.findElement(langprofEn));
        level.selectByValue("NATIVE");
        button.click(create);

        if (driver.findElement(edit) != null) {

            if (driver.findElement(edit) != null) {
                CheckRecorder.setValue("build 1!D22", "passed");
            } else {
                CheckRecorder.setValue("build 1!D22", "failed");
            }
        }
        return true;

    }

        public boolean langEdit() throws IOException {

            WebElement element2 = driver.findElement(edit);
            Actions action= new Actions(driver);
            action.moveToElement(element2).build().perform();
            button.click(edit);
            input.clear(english);
            input.type(english, "Deutch");
            button.click(save);
            wait.presenceOfElement(german, 15000);

        if (driver.findElement(german) != null) {

            if (driver.findElement(german) != null) {
                CheckRecorder.setValue("build 1!D23", "passed");
            } else {
                CheckRecorder.setValue("build 1!D23", "failed");
            }
        }
            return true;
        }



    public boolean langprofEdit() throws IOException {

        WebElement element3 = driver.findElement(edit);
        Actions action= new Actions(driver);
        action.moveToElement(element3).build().perform();
        button.click(edit);


        Select level2 = new Select(driver.findElement(langprofEn));
        level2.selectByValue("ELEMENTARY");
        button.click(save);


        if (driver.findElement(langprofDe) != null) {
            if (driver.findElement(langprofDe) != null) {
                CheckRecorder.setValue("build 1!D24", "passed");
            } else {
                CheckRecorder.setValue("build 1!D24", "failed");
            }
        }

        return true;
    }

    public boolean cancelEditLang() throws IOException {

        WebElement element6 = driver.findElement(edit);
        Actions action= new Actions(driver);
        action.moveToElement(element6).build().perform();
        button.click(edit);


        Select level3 = new Select(driver.findElement(langprofEn));
        level3.selectByValue("PROFESSIONAL_WORKING");
        button.click(edit);
        input.clear(english);
        input.type(english, "Deutch");
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

        WebElement element4 = driver.findElement(edit);
        Actions action= new Actions(driver);
        action.moveToElement(element4).build().perform();
        button.click(edit);
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

        wait.presenceOfElement(newlan);
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

//public void rbselected(WebDriver driver, By newlan){
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("window.scrollBy(0,350)","");
//
//}
}