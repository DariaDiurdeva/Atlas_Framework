package tests;

public class TestLogin {
    @Test
    public void loginTest() {
        MainPage mainPage = new MainPage();
        assertTrue(mainPage.isLoadCheck(user1.getFullName()));
    }
}
