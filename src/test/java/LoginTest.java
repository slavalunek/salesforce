import com.github.javafaker.Faker;
import org.example.dto.Account;
import org.example.pages.*;
import org.example.steps.AccountsSteps;
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
        account.setWebsite(faker.internet().url());
        account.setPhone(faker.phoneNumber().phoneNumber());
        account.setType1("Competitor");
        account.setType2("Apparel");
        account.setEmployees(faker.lebowski().actor());

        new AccountsSteps(driver).createNewAccount(account);

//        new NewAccountModal(driver).fillInNewAccountModal(account)
//                                   .saveAccount();
//        Assert.assertTrue(accountsPage.conformationRegistration(), "The account for user was not created");



//        new NewAccountModal(driver).fillInNewAccountModal("dd", faker.internet().url(),
//                                           faker.phoneNumber().phoneNumber(), "Competitor", "Apparel", faker.lebowski().actor(),
//                                           faker.address().city(), faker.address().zipCode(), faker.address().country(),
//                                           faker.address().country(), faker.address().cityName(), faker.address().zipCode(),
//                                           faker.address().country(), faker.address().country(), faker.rickAndMorty().quote(),
//                                           faker.hobbit().location(), faker.lordOfTheRings().location())
//                                   .saveAccount();

    }
}