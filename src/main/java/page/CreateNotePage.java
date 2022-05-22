package page;

import element.Button;
import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface CreateNotePage extends AtlasWebElement, Button {

    @Retry(timeout = 20_000L, polling = 2000L)
    @FindBy("//*[@class = \"posting_itx_ac_menu\"]")
    AtlasWebElement option();

    @FindBy("//*[@data-action = \"add_header\"]")
    AtlasWebElement addHead();

    @FindBy("//*[contains(@class, 'ok-posting-handler')]")
    AtlasWebElement textField();

    @FindBy("//*[@data-id = 'adHeader']")
    AtlasWebElement headField();

    default void creatNote(String head, String text){
        if (head != null) {
            option().click();
            addHead().click();
            headField().sendKeys(head);
        }

        if (text != null) {
            textField().sendKeys(text);
        }

        selectButton("t,button.submit").click();
    }
}
