package element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface Footer extends AtlasWebElement {

    @FindBy("//span[contains(@data-l, '{{ value }}')]")
    AtlasWebElement likeType(@Param("value") String value);

    @FindBy("//span[contains(@data-l, 't,')]//parent::div")
    AtlasWebElement likeButton();

    @FindBy("//span[text() = 'Комментарии']")
    AtlasWebElement comments();

}
