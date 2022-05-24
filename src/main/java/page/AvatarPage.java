package page;

import element.Button;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import layout.WithComment;
import layout.WithFooter;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

public interface AvatarPage extends WebPage, WithFooter, WithComment, Button {

    default void clickLike() {
        footer().likeType("t,.l").should(displayed()).click();
        footer().likeType("t,unlike").waitUntil(displayed());
    }

    default void clickUnLike() {
        footer().likeType("t,unlike").should(displayed()).click();
        footer().likeType("t,.l").waitUntil(displayed());
    }

    @FindBy("//button[@class = 'control__4rmea']")
    AtlasWebElement closeImage();

    default boolean isLike() {
        return footer().likeButton().getAttribute("class").contains("active");
    }

    default void writeComment(String comment) {
        comments().commentField().sendKeys(comment);
        selectButton("t,submit").click();
    }

    default String getLastComment() {
        return comments().last().getText();
    }
}
