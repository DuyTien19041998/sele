package railway.railways;

import org.testng.Assert;
import org.testng.annotations.Test;
import railway.HomePage;
import railway.LoginPage;
import railway.railway_objects.AccountInfo;
import railway.testbase.TestBase;

import java.util.Hashtable;

public class TC03_LoginWithPasswordInvalid extends TestBase {

    HomePage homePage = new HomePage();
    AccountInfo accountInfo;

    @Test(dataProvider = "getDataObjects")
    public void TC03(Hashtable<String, String> data) {
        System.out.println("TC03 - Verify user can't not login with invalid password");

        System.out.println(" 1. Navigate to Qa Railway");
        homePage.open();

        System.out.println("2. Click login tab");
        LoginPage loginPage = homePage.goToLoginPage();

        System.out.println("3. Enter valid email and invalid password");
        accountInfo = new AccountInfo(data.get("username"), data.get("password"));
        loginPage.login(accountInfo);

        System.out.println("4. Check message");
        String actualMsg = loginPage.getLbLoginErrorMsg().getText();
        String expectedMsg = data.get("expectedMsg");
        Assert.assertEquals(actualMsg, expectedMsg);
    }
}
