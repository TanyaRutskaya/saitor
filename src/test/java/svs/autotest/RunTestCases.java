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
    Login_InvalidCredentials loginInvalidCredentials = new Login_InvalidCredentials();
    Login_EditInputValues loginEditInputValues = new Login_EditInputValues();
    ProfDetails_JobNotEditable profDetailsJobNotEditable = new ProfDetails_JobNotEditable();
    ProfDetails_LangEditable profDetailsLangEditable = new ProfDetails_LangEditable();
    ProfDetails_EducationEditable profDetails_educationEditable = new ProfDetails_EducationEditable();
    ProfDetails_CertificationEditable profDetailsCertificationEditable = new ProfDetails_CertificationEditable();
    ProfDetails_TrainingEditable profDetailsTrainingEditable = new ProfDetails_TrainingEditable();

    @BeforeMethod
    public void setUpMethod() {

    }

    @BeforeTest
    public void setUpTest() throws IOException {
        loginValidCredentials.pageNavigation();
        loginValidCredentials.loginSuccessfully();
    }

    @Test
    public void LoginTest() throws IOException, InterruptedException {

        loginValidCredentials.logout();
        loginInvalidCredentials.invalidusername();
        loginInvalidCredentials.invalidpass();
        loginInvalidCredentials.nousername();
        loginInvalidCredentials.nopass();
        loginEditInputValues.abilityEdit();

    }

        @Test
   public void Job() throws IOException, InterruptedException {

        profDetailsJobNotEditable.jobIneditable();
    }
    @Test
    public void Language() throws IOException, InterruptedException {
        profDetailsLangEditable.newlang();
        profDetailsLangEditable.cancelEditProf();
        profDetailsLangEditable.langEdit();
        profDetailsLangEditable.langprofEdit();
        profDetailsLangEditable.cancelCreateLang();
        profDetailsLangEditable.removelang();
        profDetailsLangEditable.doubleclick();
        profDetailsLangEditable.validationLangfield();
        profDetailsLangEditable.validationProffield();
    }

    @Test
    public void Education() throws IOException, InterruptedException {
        profDetails_educationEditable.addEdu();
        profDetails_educationEditable.langEditCancel();
        profDetails_educationEditable.editCalendarPeriod();
        profDetails_educationEditable.editEdu();
        profDetails_educationEditable.cancelCreateEdu();
        profDetails_educationEditable.dateToEarlier();
        profDetails_educationEditable.dateAlphabetical();
        profDetails_educationEditable.validationeduname();
        profDetails_educationEditable.validationedudegree();
        profDetails_educationEditable.doubleclick();
        profDetails_educationEditable.morethan1block();
        profDetails_educationEditable.removeEdu();
}
    @Test
public void Certification() throws IOException, InterruptedException {

        profDetailsCertificationEditable.addNew();
        profDetailsCertificationEditable.certEditCancel();
        profDetailsCertificationEditable.certCreateCancel();
        profDetailsCertificationEditable.editCalendarPeriod();
        profDetailsCertificationEditable.editCertnameIssuer();
        profDetailsCertificationEditable.morethan1block();
        profDetailsCertificationEditable.removeCert();
        profDetailsCertificationEditable.validationcertname();
        profDetailsCertificationEditable.validationcertissuer();
        profDetailsCertificationEditable.validationcertdate();
        profDetailsCertificationEditable.dateAlphabetical();
        profDetailsCertificationEditable.dateExceeds();
        profDetailsCertificationEditable.doubleclick();
   }
    @Test
    public void Training() throws IOException, InterruptedException {
        profDetailsTrainingEditable.addNew();
        profDetailsTrainingEditable.EditCancel();
        profDetailsTrainingEditable.CreateCancel();
        profDetailsTrainingEditable.editTrainingName();
        profDetailsTrainingEditable.morethan1block();
        profDetailsTrainingEditable.removeTraing();
        profDetailsTrainingEditable.validationTrainingname();
        profDetailsTrainingEditable.validationDatefrom();
        profDetailsTrainingEditable.validationDateTo();
        profDetailsTrainingEditable.dateFromExceedsTo();
        profDetailsTrainingEditable.editCalendarPeriod();
        profDetailsTrainingEditable.dateAlphabetical();
        profDetailsTrainingEditable.doubleclick();
    }

    @AfterClass
    public void tearDownClass() {
        loginValidCredentials.navigate.closeDriver();
        loginInvalidCredentials.navigate.closeDriver();
        profDetailsJobNotEditable.navigate.closeDriver();
        profDetailsLangEditable.navigate.closeDriver();
        profDetailsCertificationEditable.navigate.closeDriver();
        profDetailsTrainingEditable.navigate.closeDriver();

    }

}