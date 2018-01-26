package svs.autotest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.seavus.common.Global;
//import svs.autotest.GoogleExcel.FileRecord;
import svs.autotest.checks.*;

import java.io.IOException;

public class RunTestCases extends Global {
    Login_ValidCredentials loginValidCredentials = new Login_ValidCredentials();
    Login_InvalidCredentials loginInvalidCredentials= new Login_InvalidCredentials();
    Login_EditInputValues loginEditInputValues = new Login_EditInputValues();
    ProfDetails_JobNotEditable profDetailsJobNotEditable =new ProfDetails_JobNotEditable();
    ProfDetails_LangEditable profDetailsLangEditable =new ProfDetails_LangEditable();
    ProfDetails_EducationEditable profDetails_educationEditable = new ProfDetails_EducationEditable();
    ProfDetails_CertificationEditable profDetailsCertificationEditable=new ProfDetails_CertificationEditable();

    @BeforeClass
    public void setUpClass() throws IOException {
      //  loginValidCredentials.pageNavigation();
        // loginValidCredentials.loginForm($("USERNAME"), $("PASSWORD"));
    }

    @BeforeMethod
    public void setUpMethod() {

    }

    @BeforeTest
    public void setUpTest() {

    }

    @Test
   public void RunCases() throws IOException, InterruptedException {
        loginValidCredentials.pageNavigation();
        loginInvalidCredentials.IncorrectLogin();
        loginEditInputValues.AbilityEdit();

        profDetailsJobNotEditable.jobIneditable();
        profDetailsLangEditable.newlang();
        profDetailsLangEditable.cancelEditProf();
        profDetailsLangEditable.langEdit();
        profDetailsLangEditable.langprofEdit();
        profDetailsLangEditable.cancelCreateLang();
        profDetailsLangEditable.removelang();
        profDetailsLangEditable.doubleclick();
       profDetailsLangEditable.validationLangfield();
        profDetailsLangEditable.validationProffield();

       profDetails_educationEditable.addEdu();
        profDetails_educationEditable.langEditCancel();
        profDetails_educationEditable.editCalendarPeriod();
        profDetails_educationEditable.editEdu();
        profDetails_educationEditable.removeEdu();
        profDetails_educationEditable.cancelCreateEdu();
        profDetails_educationEditable.dateToEarlier();
        profDetails_educationEditable.dateAlphabetical();
        profDetails_educationEditable.validationeduname();
        profDetails_educationEditable.validationedudegree();
        profDetails_educationEditable.doubleclick();
        profDetails_educationEditable.morethan1block();


       profDetailsCertificationEditable.addNew();


    }

    @AfterClass
    public void tearDownClass() {
        loginValidCredentials.navigate.closeDriver();
        loginInvalidCredentials.navigate.closeDriver();
        profDetailsJobNotEditable.navigate.closeDriver();
        profDetailsLangEditable.navigate.closeDriver();
        profDetailsCertificationEditable.navigate.closeDriver();

    }

}