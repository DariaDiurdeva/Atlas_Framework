package tests;

import org.junit.jupiter.api.Test;
import pages.DialogPage;
import utils.Utils;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMessage extends BaseTest{

    @Test
    public void messageTest() {

        DialogPage dialogPage = new DialogPage();

        open("https://ok.ru/messages/" + user2.getId());
        String message = Utils.generateLine();
        dialogPage.sendMessage(message);
        closeWebDriver();

        open("https://ok.ru");
        loginPage.login(user2.getLogin(), user2.getPassword());
        open("https://ok.ru/messages/" + user1.getId());
        assertEquals(message, dialogPage.getLastMessage());
        closeWebDriver();
    }
}
