package page;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;


public interface MainPage extends WebPage {

    @FindBy("//*[@id=\"hook_Block_Navigation\"]//*[@class = \"tico ellip\"]")
    AtlasWebElement fullName();
}
