package railway.railways;

import org.testng.Assert;
import org.testng.annotations.Test;
import railway.HomePage;
import railway.LoginPage;
import railway.railway_objects.AccountInfo;
import railway.testbase.TestBase;

import java.util.Hashtable;

public class TC02_LoginWithBlankUsername extends TestBase {

    HomePage homePage = new HomePage();
    AccountInfo accountInfo;

    @Test(dataProvider = "getDataObjects")
    public void TC02(Hashtable<String, String> data) {
        System.out.println("TC02 - Verify that user can't login with blank username");

        System.out.println("1 : Navigate to QA Railway website");
        homePage.open();

        System.out.println("2 : Click login tab ");
        LoginPage loginPage = homePage.goToLoginPage();

        System.out.println("3 : Enter blank username , valid password and click login button");
        accountInfo = new AccountInfo(data.get("username"), data.get("password"));
        loginPage.login(accountInfo);

        System.out.println("4. Check message");
        String actualMsg = loginPage.getLbLoginErrorMsg().getText();
        Assert.assertEquals(actualMsg, data.get("expectedMsg"), "Welcome message is not displayed as expected");
    }
}
