package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$x;

public class GmailPage {
    private final SelenideElement emailInout = $x("//input[@type='email']");
    private final SelenideElement passwordInput = $x("//input[@type='password']");
    private final SelenideElement nextButton = $x("//span[text()='Далее']/..");
    private final SelenideElement startMessageButton = $x("//div[text()='Написать']");
    private final SelenideElement whoInput = $x("//div[@aria-label='Кому']//input");
    private final SelenideElement topicInput = $x("//input[@aria-label='Тема']");
    private final SelenideElement messageDiv = $x("//div[@aria-label='Текст письма']");
    private final SelenideElement sendMessageButton = $x("//div[text()='Отправить']");
    private final SelenideElement successMessage = $x("//span[contains(text(), 'Сообщение отправлено.')]");
    private final SelenideElement errorMessage = $x("//span[text()='Ошибка']");

    public GmailPage login(String email, String password) {
        emailInout.setValue(email);
        nextButton.click();
        passwordInput.setValue(password);
        nextButton.click();
        return this;
    }

    public GmailPage sendMessage(String message, String topic, String who) {
        startMessageButton.click();
        whoInput.setValue(who);
        topicInput.setValue(topic);
        messageDiv.setValue(message);
        sendMessageButton.click();
        return this;
    }

    public void checkSuccessSend() {
        successMessage.should(appear);
    }

    public void checkUnsuccessfullySend() {
        errorMessage.should(appear);
    }
}