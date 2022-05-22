package test;

import org.junit.jupiter.api.Test;
import util.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLogin extends BaseTest{

    @Test
    public void testLogin() {
        driver.get("https://ok.ru");
        User user = new User.UserBuilder()
                .setFullName("Дарья Дюрдева")
                .setLogin("89119877204")
                .setPassword("autotest1")
                .build();
        onSite().onLoginPage().login(user);
        assertEquals(onSite().onMainPage().getFullName(),user.getFullName());
    }
}
