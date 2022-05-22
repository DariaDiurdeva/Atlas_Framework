package element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface Header extends AtlasWebElement,Button {

    @FindBy(".//*[@class='ucard-mini toolbar_ucard js-toolbar-menu']")
    AtlasWebElement miniToolbar();

}
