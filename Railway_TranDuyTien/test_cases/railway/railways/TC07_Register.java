package railway.railways;

import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import railway.HomePage;
import railway.RegisterPage;
import railway.testbase.TestBase;
import java.util.Hashtable;

public class TC07_Register extends TestBase {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    String email = homePage.randomEmail();

    @Test(dataProvider = "getDataObjects")
    public void TC07(Hashtable<String, String> data) {
        System.out.println("TC03 Verify that user can register with info valid");
        System.out.println("1. Navigate to Railway website");
        homePage.open();

        System.out.println("2. Click login tab ");
        homePage.goToRegisterTab();

        System.out.println("3. Enter valid info into all fields");
        registerPage.register(email, data.get("password"), data.get("confirmPassword"), Constant.PID);

        System.out.println("4. Check message");
        String actualMsg = registerPage.getMsgRegister().getText();
        Assert.assertEquals(actualMsg, data.get("expectedMsg"));

    }
}
