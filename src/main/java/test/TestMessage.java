package test;

import org.junit.jupiter.api.Test;
import util.User;
import util.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMessage extends BaseTest{

    @Test
    public void testMessage() {
        String text = Utils.generateLine();

        User user1 = new User.UserBuilder().setLogin("89119877204").setPassword("autotest1").build();
        User user2 = new User.UserBuilder().setLogin("89657631124").setPassword("polinasuperstar").build();

        driver.get("https://ok.ru");
        onSite().onLoginPage().login(user1);
        onSite().onMainPage().openMessages();
        onSite().onDialogPage().openDialog(user2.getId());
        onSite().onDialogPage().sendMessage(text);

        onSite().onMainPage().exit();

        onSite().onLoginPage().login(user2);
        onSite().onMainPage().openMessages();
        onSite().onDialogPage().openDialog(user1.getId());

        assertEquals(onSite().onDialogPage().lastMessage().text().getText(),text);
    }
}