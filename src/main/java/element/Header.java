package element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;


public interface Header extends AtlasWebElement,Button {

    /*@FindBy(".//*[@data-l = '{{ value }}']")
    AtlasWebElement buttonOnHeader(@Param("value") String value);*/

    @FindBy(".//*[@class='ucard-mini toolbar_ucard js-toolbar-menu']")
    AtlasWebElement miniToolbar();

}
