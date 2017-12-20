package svs.autotest;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.seavus.common.Global;
import svs.autotest.pages.LoginPage;

public class RunTest extends Global{
   // ReturnConnection returnConnection = new ReturnConnection();

    LoginPage loginPage = new LoginPage();


    @BeforeClass
    public void setUpClass(){
        loginPage.pageNavigation();
        loginPage.loginForm($("USERNAME"), $("PASSWORD"));
    }

    @BeforeMethod
    public void setUpMethod(){

    }

    @BeforeTest
    public void setUpTest(){

    }

    @Test
    public void popActivationSomething(){
        //Connection conn = returnConnection.connection();
		//popActivationPage.openContractsPage();



        //writer.close();
    }

    @AfterClass
    public void tearDownClass(){
        loginPage.navigate.closeDriver();
    }

//	public void writeResults() throws IOException {
//		System.out.println("After class... ");
//		ExcelWriter writer = FileRecord.getWriter();
//		writer.writeCell(0, FileRecord.ASSIGNMENT_1_COLUMN_INDEX, FileRecord.ASSIGNMENT_1_COLUMN_NAME);
//		writer.writeCell(1, FileRecord.ASSIGNMENT_1_COLUMN_INDEX, linkColor);
    //writer.writeCell(2, FileRecord.ASSIGNMENT_1_COLUMN_INDEX, linkColor);
    //writer.writeCell(3, FileRecord.ASSIGNMENT_1_COLUMN_INDEX, linkColor);
//		writer.close();
//	}
}
