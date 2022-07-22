import com.github.javafaker.Faker;
import org.example.pages.ContactsPage;
import org.example.pages.LoginPage;
import org.example.pages.NewAccountModal;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactsTest extends BaseTest {

    @Test
    public void createContactsTest() {
        new LoginPage(driver).open()
                             .fillInUserName("lunekv-t0yh@force.com")
                             .fillInPassword("2435lvv1")
                             .submitForm();
        Assert.assertEquals(homePage.getQuarterlyPerformance(), "Quarterly Performance", "the user is not logged in");
        new ContactsPage(driver).open()
                .clickNewButton();

        Faker faker = new Faker();
        new NewAccountModal(driver).fillInNewContactModal("Ms.", faker.company().name(),"fgdhdgh",
                faker.leagueOfLegends().summonerSpell()).saveContact();
        Assert.assertTrue(accountsPage.conformationRegistration(),"the user did not create a contact");
    }
}
