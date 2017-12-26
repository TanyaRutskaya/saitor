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
    public void RunCases() throws IOException {
        loginValidCredentials.pageNavigation();
        loginInvalidCredentials.IncorrectLogin();
        loginEditInputValues.AbilityEdit();
        profDetailsJobNotEditable.jobIneditable();
        profDetailsLangEditable.langEdit();


    }

    @AfterClass
    public void tearDownClass() {
        loginValidCredentials.navigate.closeDriver();
        loginInvalidCredentials.navigate.closeDriver();

    }

}
