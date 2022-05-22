package element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface Message extends AtlasWebElement {

    @FindBy(".//msg-parsed-text")
    AtlasWebElement text();
}
