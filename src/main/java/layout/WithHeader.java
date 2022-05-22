package layout;

import element.Header;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface WithHeader {

    @FindBy("//div[@data-l = 't,navigationToolbar']")
    Header header();

}
