package element;

import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface Header extends AtlasWebElement, Button {

    @FindBy(".//*[@class='ucard-mini toolbar_ucard js-toolbar-menu']")
    AtlasWebElement miniToolbar();

    @FindBy("//input[@name = 'st.query']")
    AtlasWebElement searchInput();

    @Retry(timeout = 20_000L, polling = 2000)
    @FindBy("//div[@class='user-card-wrapper__mpodh']/a")
    AtlasWebElement result();
}
