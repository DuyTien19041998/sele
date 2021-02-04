package railway.railways;

import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import railway.*;
import railway.railway_objects.AccountInfo;
import railway.railway_objects.TicketInfo;
import railway.testbase.TestBase;
import java.util.Hashtable;

public class TC16_CancelTicket extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    RegisterPage registerPage = new RegisterPage();
    TicketInfo ticketInfo;
    AccountInfo accountInfo;

    @Test(dataProvider = "getDataObjects")
    public void TC16(Hashtable<String, String> data) {
        System.out.println("TC16 - Verify user can cancle a ticket");
        System.out.println("1. Navigate to railway website");
        homePage.open();

        System.out.println("2. Click register tab");
        registerPage.goToRegisterTab();

        System.out.println("3. Enter info valid to all fields on form register");
        registerPage.register(data.get("email"), data.get("password"), data.get("confirmPassword"), data.get("pid"));

        System.out.println("4. Click login tab");
        loginPage.goToLoginPage();

        System.out.println("5. Login with username and password created account ");
        accountInfo = new AccountInfo(data.get("email"),data.get("password"));
        loginPage.login(accountInfo);

        System.out.println("6. Click BookTicket tab");
        homePage.goToBookTicketTab();

        System.out.println("7. Book ticket with info valid");
        ticketInfo = new TicketInfo(data.get("departDate"), data.get("departFrom"), data.get("arriveAt"), data.get("seatType"), data.get("ticketAmount1"));
        bookTicketPage.bookTicket(ticketInfo);

        String actualMsg = bookTicketPage.getMsgBookticket().getText();
        String expectedMsg = data.get("expectedMsg");
        Assert.assertEquals(actualMsg, expectedMsg);

        System.out.println("8. Click MyTicket tab");
        homePage.goToMyTicketTab();

        System.out.println("9. Cancel a ticket");
        myTicketPage.clickCanCel(data.get("departFrom"), data.get("arriveAt"));
        Constant.WEBDRIVER.switchTo().alert().accept();

        System.out.println("10. CLick myticket tab");
        myTicketPage.goToMyTicketTab();

        System.out.println(" 11. Check ticket is not exists");
        boolean checkTicketExist = myTicketPage.checkElementExist(myTicketPage.checkBtnCancel(data.get("departFrom"), data.get("arriveAt")));
        Assert.assertTrue(checkTicketExist, "The ticket isn't canceled");
    }
}
