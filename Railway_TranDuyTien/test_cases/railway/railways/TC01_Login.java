package railway.railways;

import org.testng.Assert;
import org.testng.annotations.Test;
import railway.HomePage;
import railway.LoginPage;
import railway.railway_objects.AccountInfo;
import railway.testbase.TestBase;

import java.util.Hashtable;


public class TC01_Login extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    AccountInfo accountInfo;

    @Test(dataProvider = "getDataObjects")
    public void TC01(Hashtable<String, String> data) {
        System.out.println("TC01 - User can log into Railway with valid username and password");

        System.out.println("1. Navigate to Qa Railway");
        homePage.open();

        System.out.println("2. Click login tab");
        homePage.goToLoginPage();

        System.out.println("3. Enter valid email and password and click login button");
        accountInfo = new AccountInfo(data.get("username"), data.get("password"));
        loginPage.login(accountInfo);

        System.out.println("4. Check message");
        String actualMsg = loginPage.getWelcomeMessage();
        String expectedMsg = "Welcome " + data.get("username");
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
}
