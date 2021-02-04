package railway.railways;

import org.testng.Assert;
import org.testng.annotations.Test;
import railway.HomePage;
import railway.LoginPage;
import railway.testbase.TestBase;
import java.util.Hashtable;

public class TC10_UserCannotResetPassword extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(dataProvider = "getDataObjects")
    public void TC10(Hashtable<String, String> data) {
        System.out.println("TC10 - Verify that User can't reset password if enter incorrect email address");

        System.out.println("1. Navigate to Railway website");
        homePage.open();

        System.out.println("2. CLick login tab");
        loginPage.goToLoginPage();

        System.out.println("3. CLick on ForgotPassword link");
        loginPage.getTextLinkChangePassword().click();

        System.out.println("4. Enter an un-existing email address");
        loginPage.getTxtEmailReset().sendKeys("tiene@gmail.com");

        System.out.println("5. CLick on SendInstruction button");
        loginPage.getBtnSendInstructions().click();

        System.out.println("6. Check message");
        String actualMsg = loginPage.getMsgResetEmail().getText();
        Assert.assertEquals(actualMsg, data.get("expectedMsg"));
    }
}
