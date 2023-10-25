import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GmailPage;
import pages.LoginGmailPage;

public class GmailTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        start(config.url());
    }

    @Test()
    public void testSuccessesSend() {
        new LoginGmailPage()
                .login(config.email(), config.password());

        new GmailPage()
                .sendMessage("Hello world!", "Demo message", config.email())
                .checkSuccessSend();
    }

    @Test()
    public void testUnsuccessfullySend() {
        new LoginGmailPage()
                .login(config.email(), config.password());

        new GmailPage()
                .sendMessage("Hello world!", "Demo message", config.wrongEmail())
                .checkUnsuccessfullySend();
    }

    @AfterMethod
    public void close() {
        stop();
    }
}