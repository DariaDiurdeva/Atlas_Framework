package page;

import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import layout.WithHeader;

import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

public interface ProfilePage extends WebPage, WithHeader {
    @FindBy("//div[@class='card_wrp']//a[contains(@href,'/profile')]")
    AtlasWebElement avatarHref();

    @Retry(timeout = 20_000L, polling = 2000)
    @FindBy("//h1[@class='__user-profile-name-decorator']")
    AtlasWebElement xPathUniqueElem();

    default void openAvatar() {
        avatarHref().click();
    }

    default boolean isLoadCheck() {
        try {
            xPathUniqueElem().waitUntil(displayed());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
