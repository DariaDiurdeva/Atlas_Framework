package element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface Comments extends AtlasWebElement {
    @FindBy("//*[@name = 'st.dM']")
    AtlasWebElement commentField();

    @FindBy("//div[@class='comments_lst_cnt']//div[@class = ' last-comment']//div[@class = 'comments_text textWrap']")
    AtlasWebElement last();
}
