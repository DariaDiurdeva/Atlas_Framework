package test;

import org.junit.jupiter.api.Test;
import util.User;
import util.Utils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLike extends BaseTest {

    @Test
    public void likeTest() {
        driver.get("https://ok.ru");
        User user1 = new User.UserBuilder().setLogin("89119877204").setPassword("autotest1").build();
        onSite().onLoginPage().login(user1);

        User user2 = Utils.getRandomUserWithAvatar();
        onSite().onMainPage().header().searchInput().sendKeys(user2.getId());
        onSite().onMainPage().header().result().click();

        //ждем загрузки
        assertTrue(onSite().onProfilePage().isLoadCheck());
        onSite().onProfilePage().openAvatar();

        //если был лайк - убираем
        if (onSite().onAvatarPage().isLike()) {
            onSite().onAvatarPage().clickUnLike();
        }

        onSite().onAvatarPage().clickLike();
        assertTrue(onSite().onAvatarPage().isLike());

        //убираем лайк
        onSite().onAvatarPage().clickUnLike();
        assertFalse(onSite().onAvatarPage().isLike());
    }
}
