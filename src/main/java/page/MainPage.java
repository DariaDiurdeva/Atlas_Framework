package page;

import element.Button;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import layout.WithHeader;

public interface MainPage extends WebPage, WithHeader, Button {

    @FindBy("//*[@id=\"hook_Block_Navigation\"]//*[@class = \"tico ellip\"]")
    AtlasWebElement fullName();

    @FindBy("//*[@class='form-actions __center']//*[@data-l='t,logout']")
    AtlasWebElement confirmButton(); // не получилось через кнопку

    default void exit() {
        header().miniToolbar().click();
        header().selectButton("t,logout").click();
        confirmButton().click();
    }

    default void openMessages(){
        header().selectButton("t,messages").click();
    }
}
