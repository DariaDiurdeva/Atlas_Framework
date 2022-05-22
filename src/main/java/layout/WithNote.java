package layout;

import element.Note;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface WithNote {

    @FindBy("//div[1][@class= 'feed']")
    Note lastNote();
}
