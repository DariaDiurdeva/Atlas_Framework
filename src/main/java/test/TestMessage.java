package test;

import org.junit.jupiter.api.Test;
import util.User;
import util.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMessage extends BaseTest {

    @Test
    public void testMessage() {
        driver.get("https://ok.ru");
        String text = Utils.generateLine();

        User user1 = new User.UserBuilder()
                .setLogin("89119877204")
                .setPassword("autotest1")
                .setId("589088855467").build();
        User user2 = new User.UserBuilder()
                .setLogin("89657631124")
                .setPassword("polinasuperstar")
                .setId("589260828331").build();

        onSite().onLoginPage().login(user1);
        onSite().onMainPage().openMessages();
        onSite().onDialogPage().openDialog(user2.getId());
        onSite().onDialogPage().sendMessage(text);

        onSite().onMainPage().exit();

        onSite().onLoginPage().login(user2);
        onSite().onMainPage().openMessages();
        onSite().onDialogPage().openDialog(user1.getId());

        String lastMessage = onSite().onDialogPage().lastMessage().text().getText();
        assertEquals(lastMessage, text);
    }
}
