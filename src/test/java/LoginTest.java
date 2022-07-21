import com.github.javafaker.Faker;
import org.example.AccountsPage;
import org.example.LoginPage;
import org.example.NewAccountModal;
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
        new NewAccountModal(driver).fillInNewAccountModal("dd", faker.internet().url(),
                                           faker.phoneNumber().phoneNumber(), "Competitor", "Apparel", faker.lebowski().actor(),
                                           faker.address().city(), faker.address().zipCode(), faker.address().country(),
                                           faker.address().country(), faker.address().cityName(), faker.address().zipCode(),
                                           faker.address().country(), faker.address().country(), faker.rickAndMorty().quote(),
                                           faker.hobbit().location(), faker.lordOfTheRings().location())
                                   .saveAccount();
        Assert.assertTrue(accountsPage.conformationRegistration(),"the user did not create an account");
    }
}