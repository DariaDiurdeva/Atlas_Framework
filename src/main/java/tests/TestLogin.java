package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLogin extends BaseTest{

    @Test
    public void testLogin() {
        MainPage mainPage = new MainPage();
        assertTrue(mainPage.isLoadCheck(user1.getFullName()));
    }
}
