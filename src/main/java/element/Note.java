package element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface Note extends AtlasWebElement {

    @FindBy(".//*[contains(@class, 'media-text_cnt_tx')]")
    AtlasWebElement textNote();


}
