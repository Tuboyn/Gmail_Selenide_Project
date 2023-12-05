import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.GmailPage;
import pages.LoginGmailPage;

public class GmailTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        start(config.url());
        new LoginGmailPage()
                .login(config.email(), config.password());
    }

    @Test
    public void testSuccessesSend() {
        new GmailPage()
                .sendMessage("Hello world!", "Demo message", config.email())
                .checkSuccessSend();
    }

    @Test(dataProvider = "wrongMessageData")
    public void testUnsuccessfullySend(String email, String errorMessage) {
        new GmailPage()
                .sendMessage("Hello world!", "Demo message", email)
                .checkUnsuccessfullySend(errorMessage);
    }

    @DataProvider(name = "wrongMessageData")
    public Object[][] wrongMessageData() {
        return new Object[][]{
                {"usertets203", "Проверьте правильность ввода всех адресов."},
                {null, "Укажите как минимум одного получателя."}
        };
    }

    @AfterMethod
    public void close() {
        stop();
    }
}