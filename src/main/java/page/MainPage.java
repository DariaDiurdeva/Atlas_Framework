package page;

import element.Button;
import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import layout.WithHeader;
import layout.WithNote;

public interface MainPage extends WebPage, WithHeader, Button, WithNote {

    @Retry(timeout = 10_000L, polling = 1000L)
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

    default void openNotePage(){
        selectButton("t,feed.posting.ui.input").click();
    }
}
