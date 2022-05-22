package test;

import org.junit.jupiter.api.Test;
import util.User;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMessage extends BaseTest{

    @Test
    public void testMessage() {
        String text = "How are you?";
        User user1 = new User.UserBuilder().setFullName("Дарья Дюрдева")
                .setLogin("89119877204").setPassword("autotest1")
                .setId("589088855467").build();
        User user2 = new User.UserBuilder().setFullName("Lol Kek")
                .setLogin("89657631124").setPassword("polinasuperstar")
                .setId("589260828331").build();
        driver.get("https://ok.ru");
        onSite().onLoginPage().login(user1);
        onSite().onMainPage().openMessages();
        onSite().onDialogPage().openDialog(user2.getId());
        onSite().onDialogPage().sendMessage(text);

        onSite().onMainPage().exit();

        onSite().onLoginPage().login(user2);
        onSite().onMainPage().openMessages();
        onSite().onDialogPage().openDialog(user1.getId());

        String lastMessage = onSite().onDialogPage().lastMessage().text().getText();
        assertEquals(lastMessage,text);
    }
}
