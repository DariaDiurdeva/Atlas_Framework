package page;

import io.qameta.atlas.webdriver.WebPage;
import layout.WithFooter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

public interface AvatarPage extends WebPage, WithFooter {
//    By nameComment = By.name("st.dM");
//    By xPathAddComment = By.xpath("//button[@data-l='t,submit']");
//    By xPathLastComment = By.xpath("(//div[@class='comments_text textWrap'])[last()]");
//    By xPathControlComments = By.xpath("//div[@class='comments_controls-t']");

    default void clickLike() {
        footer().likeType("t,.l").should(displayed()).click();
        footer().likeType("t,unlike").waitUntil(displayed());
    }

    default void clickUnLike() {
        footer().likeType("t,unlike").should(displayed()).click();
        footer().likeType("t,.l").waitUntil(displayed());
    }

    default boolean isLike() {
           return(footer().likeButton().getAttribute("class").contains("active"));
    }


//    public void writeComment(String comment) {
//        $(nameComment).setValue(comment);
//        $(xPathAddComment).click();
//    }
//
//    public String getLastComment() {
//        return $(xPathLastComment).getText();
//    }
//
//    public void deleteLastComment() {
//        $(xPathControlComments).shouldBe(Condition.visible);
//        $(xPathAddComment).click();
//    }
}
