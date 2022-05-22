package page;

import io.qameta.atlas.webdriver.WebSite;
import io.qameta.atlas.webdriver.extension.Page;

public interface OKSite extends WebSite {

    @Page
    MainPage onMainPage();

    @Page
    LoginPage onLoginPage();

    @Page
    DialogPage onDialogPage();

}
