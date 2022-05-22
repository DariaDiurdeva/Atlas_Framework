package test;

import org.junit.jupiter.api.Test;
import util.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSendNote  extends BaseTest{


    @Test
    public void testSendNote() {
        driver.get("https://ok.ru");
        User user = new User.UserBuilder().setFullName("Дарья Дюрдева")
                .setLogin("89119877204").setPassword("autotest1")
                .setId("589088855467").build();
        onSite().onLoginPage().login(user);

        String text = "This is test";
        String head = "Hello";
        String checkText = head + "\n" + text;

        onSite().onMainPage().openNotePage();
        onSite().onCreateNotesPage().creatNote(head,text);

        String lastNote = onSite().onMainPage().lastNote().textNote().getText();
        assertEquals( lastNote, checkText);
    }
}
