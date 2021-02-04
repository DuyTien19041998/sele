package railway.railways;

import org.testng.Assert;
import org.testng.annotations.Test;
import railway.HomePage;
import railway.LoginPage;
import railway.railway_objects.AccountInfo;
import railway.testbase.TestBase;
import java.util.Hashtable;

public class TC08_LoginWithAccountNotActive extends TestBase {

    HomePage homePage = new HomePage();
    AccountInfo accountInfo;

    @Test(dataProvider = "getDataObjects")
    public void TC08(Hashtable<String,String > data) {
        System.out.println("Verify user can't login with an account hasn't been activated");

        System.out.println("1. Navigate to Qa Railway");
        homePage.open();

        System.out.println("2. Click login tab");
        LoginPage loginPage = homePage.goToLoginPage();

        System.out.println("3. Enter valid email and password and click login button");
        accountInfo = new AccountInfo(data.get("username"),data.get("password"));
        loginPage.login(accountInfo);

        System.out.println("4. Check message");
        String actualMsg = loginPage.getWelcomeMessage();
        String expectedMsg = "Welcome " + data.get("username");
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
}
