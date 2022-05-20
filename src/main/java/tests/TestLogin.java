package tests;

import pages.MainPage;

public class TestLogin {

    @Test
    public void testLogin() {
        MainPage mainPage = new MainPage();
        assertTrue(mainPage.isLoadCheck(user1.getFullName()));
    }
}
