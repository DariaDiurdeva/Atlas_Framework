package page;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import layout.WithHeader;

public interface MainPage extends WebPage, WithHeader {

    @FindBy("//*[@id=\"hook_Block_Navigation\"]//*[@class = \"tico ellip\"]")
    AtlasWebElement fullName();

    @FindBy("//*[@class='form-actions __center']//*[@data-l='t,logout']")
    AtlasWebElement confirmButton();

    default void exit(){
        header().miniToolbar().click();
        header().buttonOnHeader("t,logout").click();
        confirmButton().click();
    }

    default void openMessages(){
        header().buttonOnHeader("t,messages").click();
    }
}
