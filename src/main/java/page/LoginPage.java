package page;

import element.Button;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;


public interface LoginPage extends WebPage, Button {

    @FindBy("//input[@name = '{{ value }}']")
    AtlasWebElement selectField(@Param("value") String value);

}
