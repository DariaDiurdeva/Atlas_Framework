package element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface Button extends AtlasWebElement {

    @FindBy("//input[@data-l = '{{ value }}']")
    AtlasWebElement selectButton(@Param("value") String value);

}
