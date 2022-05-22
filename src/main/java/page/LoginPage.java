package page;

import element.Button;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import util.User;

public interface LoginPage extends WebPage, Button {

    @FindBy("//input[@name = '{{ value }}']")
    AtlasWebElement selectField(@Param("value") String value);

    default void login(User user){
        selectField("st.email").sendKeys(user.getLogin());
        selectField("st.password").sendKeys(user.getPassword());
        selectButton("t,sign_in").click();
    }
}
