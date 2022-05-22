package layout;

import element.Footer;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface WithFooter {

    @FindBy("//ul[@data-l='t,actions']")
    Footer footer();
}
