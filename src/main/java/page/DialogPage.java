package page;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import layout.WithHeader;
import layout.WithMessage;

public interface DialogPage extends WebPage, WithMessage, WithHeader {

    @FindBy("//msg-input")
    AtlasWebElement lineInputMessage();

    @FindBy("//msg-button[@data-tsid='button_send']")
    AtlasWebElement sendButton();

    @FindBy("//msg-chats-list-item//*[@id= '{{ value }}']")
    AtlasWebElement dialog(@Param("value") String value);

    default void sendMessage(String text){
        lineInputMessage().sendKeys(text);
        sendButton().click();
    }

     default void openDialog(String id){
        dialog(id).click();
     }
}