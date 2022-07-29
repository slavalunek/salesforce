import com.github.javafaker.Faker;
import org.example.dto.Account;
import org.example.pages.AccountsDetailsPage;
import org.example.pages.AccountsPage;
import org.example.pages.NewAccountModal;
import org.example.steps.AccountsSteps;
import org.example.steps.LoginSteps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AccountTest extends BaseTest{

    @BeforeMethod
    public void login(){
        new LoginSteps(driver).loginStandardUser();
        new AccountsSteps(driver).createParentAccount();

    }

    @Test
    public void createAccount(){

        new AccountsPage(driver).open()
                                .clickNewButton();

        Faker faker = new Faker();
        String accountName = faker.company().name();
        Account account = Account.builder()
                                 .accountName(accountName)
                                 .parentAccount("Oberbrunner-Keeling")
                                 .website(faker.internet().url())
                                 .type1("Competitor")
                                 .type2("Apparel")
                                 .employees(faker.number().digit())
                                 .build();

        new NewAccountModal(driver).fillInNewAccountModal(account)
                                   .saveAccount();
        Assert.assertTrue(accountsPage.isConfirmationMessageDisplayed(), "The account for user was not created");
        Account actualAccount = new AccountsDetailsPage(driver).open().getAccountDetails();
        Assert.assertEquals(actualAccount, account);
    }

    @AfterMethod
    public void deleteAccounts(){
       new  AccountsSteps(driver).deleteAccount();
    }
}
