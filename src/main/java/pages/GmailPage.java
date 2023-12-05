package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class GmailPage {
    private final SelenideElement startMessageButton = $x("//div[text()='Написать']");
    private final SelenideElement whoInput = $x("//div[@aria-label='Кому']//input");
    private final SelenideElement topicInput = $x("//input[@aria-label='Тема']");
    private final SelenideElement messageDiv = $x("//div[@aria-label='Текст письма']");
    private final SelenideElement sendMessageButton = $x("//div[text()='Отправить']");
    private final SelenideElement successMessage = $x("//span[contains(text(), 'Сообщение отправлено.')]");
    private final SelenideElement errorMessage = $x("//div[@aria-modal='true']");

    public GmailPage sendMessage(String message, String topic, String who) {
        startMessageButton.click();
        whoInput.setValue(who);
        topicInput.setValue(topic);
        messageDiv.setValue(message);
        sendMessageButton.click();
        return this;
    }

    public void checkSuccessSend() {
        successMessage.shouldBe(visible);
    }

    public void checkUnsuccessfullySend(String error) {
        errorMessage.shouldHave(text(error));
    }
}