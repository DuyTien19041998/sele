package railway.railways;

import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import railway.Generalpage;
import railway.HomePage;
import railway.LoginPage;
import railway.railway_objects.AccountInfo;
import railway.testbase.TestBase;
import java.util.Hashtable;

public class TC06_LoginAndVerifyTabName extends TestBase {

    HomePage homePage = new HomePage();
    Generalpage generalpage = new Generalpage();
    AccountInfo accountInfo;

    @Test(dataProvider = "getDataObjects")
    public void TC06(Hashtable<String,String> data) {
        System.out.println("TC06 - Verify additional pages display once user logged in");

        System.out.println("1. Navigate to Qa Railway website ");
        homePage.open();

        System.out.println("2. Click login tab ");
        LoginPage loginPage = homePage.goToLoginPage();

        System.out.println(" Login with username and password valid");
        accountInfo = new AccountInfo(data.get("username"),data.get("password"));
        loginPage.login(accountInfo);

        System.out.println("3. Check message ");
        String actualMsg = loginPage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");

        System.out.println("4. Check change password tab");
        Assert.assertTrue(generalpage.checkElementExist(homePage.tabChangePassword),"Tab ChangePassword is not exists");

        System.out.println("5. Check logout tab ");
        Assert.assertTrue(generalpage.checkElementExist(homePage.tabLogout),"Tab Logout is not exists");

        System.out.println("6. Check myticket tab ");
        Assert.assertTrue(generalpage.checkElementExist(homePage.tabMyTicket),"Tab Myticket is not exists");

    }
}
