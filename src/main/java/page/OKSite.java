package page;

import io.qameta.atlas.webdriver.WebSite;
import io.qameta.atlas.webdriver.extension.Page;
import page.LoginPage;
import page.MainPage;

public interface OKSite extends WebSite {

    @Page
    MainPage onMainPage();

    @Page
    LoginPage onLoginPage();

}
