import com.github.javafaker.Faker;
import org.example.dto.Account;
import org.example.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void createAccountTest() {
        new LoginPage(driver).open()
                             .fillInUserName("lunekv-t0yh@force.com")
                             .fillInPassword("2435lvv1")
                             .submitForm();
        Assert.assertEquals(homePage.getQuarterlyPerformance(), "Quarterly Performance", "the user is not logged in");

        new AccountsPage(driver).open()
                                .clickNewButton();

        Faker faker = new Faker();
        String accountName = faker.company().name();
        Account account = new Account(accountName);
        account.setParentAccount("Oberbrunner-Keeling");
        account.setWebsite(faker.internet().url());
        account.setType1("Competitor");
        account.setType2("Apparel");
        account.setEmployees(faker.number().digit());

        // new AccountsSteps(driver).createNewAccount(account);

        new NewAccountModal(driver).fillInNewAccountModal(account)
                                   .saveAccount();
        Assert.assertTrue(accountsPage.isConfirmationMessageDisplayed(), "The account for user was not created");
        Account actualAccount =  new AccountsDetailsPage(driver).open().getAccountDetails();
        Assert.assertEquals(actualAccount, account);
    }
}