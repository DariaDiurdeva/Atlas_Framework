package test;

import org.junit.jupiter.api.Test;
import util.User;
import util.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

public class TestComments extends BaseTest {

    @Test
    void commentAvatarTest() {
        driver.get("https://ok.ru");
        String id = "569442670075";
        User user1 = new User.UserBuilder().setLogin("89119877204").setPassword("autotest1").build();
        onSite().onLoginPage().login(user1);

        onSite().onMainPage().findHuman(id);
        assertTrue(onSite().onProfilePage().isLoadCheck());
        onSite().onProfilePage().openAvatar();

        String comment = Utils.generateLine();
        onSite().onAvatarPage().writeComment(comment);

        onSite().onAvatarPage().closeImage().should(displayed()).click();
        assertTrue(onSite().onProfilePage().isLoadCheck());

        onSite().onProfilePage().openAvatar();
        String text = onSite().onAvatarPage().getLastComment();
        assertEquals(comment, text);
    }
}
