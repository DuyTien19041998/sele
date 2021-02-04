package railway.railways;

import org.testng.Assert;
import org.testng.annotations.Test;
import railway.ContactPage;
import railway.HomePage;
import railway.testbase.TestBase;

import java.util.Hashtable;

public class TC04_ContactTest extends TestBase {

    HomePage homePage = new HomePage();
    ContactPage contactPage = new ContactPage();

    @Test(dataProvider = "getDataObjects")
    public void TC04(Hashtable<String, String> data) {
        System.out.println("TC03 - Verify user can't not login with invalid password");

        System.out.println("1. Navigate to Qa Railway website");
        homePage.open();

        System.out.println("2. Click contact tab");
        homePage.goToContactTab();

        System.out.println("3. Check address email ");
        String actualTextLink = contactPage.getLinkTextEmail().getAttribute("href");
        Assert.assertEquals(actualTextLink, data.get("expectedTextLink"));
    }
}
