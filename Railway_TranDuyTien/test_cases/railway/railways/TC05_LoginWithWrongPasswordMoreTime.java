package railway.railways;

import org.testng.Assert;
import org.testng.annotations.Test;
import railway.HomePage;
import railway.LoginPage;
import railway.railway_objects.AccountInfo;
import railway.testbase.TestBase;
import java.util.Hashtable;

public class TC05_LoginWithWrongPasswordMoreTime extends TestBase {

    HomePage homePage = new HomePage();
    AccountInfo accountInfo;
    @Test(dataProvider = "getDataObjects")
    public void TC05(Hashtable<String, String> data) {
        System.out.println("TC05 - Verify system shows message when user enter wrong password several time");

        System.out.println("1. Navigate to Qa Railway website");
        homePage.open();

        System.out.println("2. Click login tab ");
        LoginPage loginPage = homePage.goToLoginPage();

        System.out.println("3. Enter valid username and invalid password with three times");
        accountInfo = new AccountInfo(data.get("username"),data.get("password"));
        loginPage.login(accountInfo);
        loginPage.login(accountInfo);
        loginPage.login(accountInfo);

        System.out.println("4. Check message ");
        String actualMsg = loginPage.getLbLoginErrorMsg().getText();
        Assert.assertEquals(actualMsg, data.get("expectedMsg"), "Welcome message is not displayed as expected");

    }
}
