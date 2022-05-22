package layout;

import element.Message;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface WithMessage {

    @FindBy("//*[@class=\"group\"][last()]//msg-message[not(@mine)][last()]")
    Message lastMessage();
}
