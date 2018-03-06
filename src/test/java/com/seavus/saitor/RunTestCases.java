package com.seavus.saitor;

import com.seavus.saitor.checks.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.seavus.common.Global;

import java.io.IOException;


public class RunTestCases extends Global {
    LoginValidCredentials loginValidCredentials = new LoginValidCredentials();
    LoginInvalidCredentials loginInvalidCredentials = new LoginInvalidCredentials();
    LoginEditInputValues loginEditInputValues = new LoginEditInputValues();
    ProfDetailsJobNotEditable profDetailsJobNotEditable = new ProfDetailsJobNotEditable();
    ProfDetailsLangEditable profDetailsLangEditable = new ProfDetailsLangEditable();
    ProfDetailsEducationEditable profDetailsEducationEditable = new ProfDetailsEducationEditable();
    ProfDetailsCertificationEditable profDetailsCertificationEditable = new ProfDetailsCertificationEditable();
    ProfDetailsTrainingEditable profDetailsTrainingEditable = new ProfDetailsTrainingEditable();


    @BeforeTest
    public void setUpTest() throws IOException {
        loginValidCredentials.pageNavigation();
        loginValidCredentials.login();
    }

    @Test
    public void testLoginSuccessful() throws Exception {
        loginValidCredentials.loginSuccessful();
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
        profDetailsEducationEditable.addEdu();
        profDetailsEducationEditable.langEditCancel();
        profDetailsEducationEditable.editCalendarPeriod();
        profDetailsEducationEditable.editEdu();
        profDetailsEducationEditable.cancelCreateEdu();
        profDetailsEducationEditable.dateToEarlier();
        profDetailsEducationEditable.dateAlphabetical();
        profDetailsEducationEditable.validationeduname();
        profDetailsEducationEditable.validationedudegree();
        profDetailsEducationEditable.doubleclick();
        profDetailsEducationEditable.morethan1block();
        profDetailsEducationEditable.removeEdu();
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