package railway.railways;

import org.testng.Assert;
import org.testng.annotations.Test;
import railway.Generalpage;
import railway.HomePage;
import railway.RegisterPage;
import railway.testbase.TestBase;
import java.util.Hashtable;

public class TC11_CannotCreateWithPasswordAndPidEmpty extends TestBase {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    Generalpage generalpage = new Generalpage();

    @Test(dataProvider = "getDataObjects")
    public void TC11(Hashtable<String, String> data) {
        System.out.println("TC11 - Verify user can't create account while password and PID fields are empty");

        System.out.println("1. Navigate to Railway website");
        homePage.open();

        System.out.println("2. Click register tab");
        generalpage.goToRegisterTab();

        System.out.println("3. Enter valid email and leave other fields empty");
        System.out.println("4. CLick register button");
        registerPage.register(data.get("email"), "", "", "");

        System.out.println("5. Check message");
        String actualMsgCommon = registerPage.msgCommon();

        String expectedMsgCommon = data.get("expectedMsgError");
        Assert.assertEquals(actualMsgCommon, expectedMsgCommon);

        System.out.println("6. Check message password");
        actualMsgCommon = registerPage.getMsgPassword().getText();
        expectedMsgCommon = data.get("expectedMsgPassword");
        Assert.assertEquals(actualMsgCommon, expectedMsgCommon);

        System.out.println("7. Check message pid");
        actualMsgCommon = registerPage.getMsgPid().getText();
        expectedMsgCommon = data.get("expectedMsgPid");
        Assert.assertEquals(actualMsgCommon, expectedMsgCommon);
    }
}
