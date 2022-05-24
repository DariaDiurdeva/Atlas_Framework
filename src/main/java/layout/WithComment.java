package layout;

import element.Comments;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface WithComment {
    @FindBy("//div[@id = 'hook_Block_InlineCommentPLB']")
    Comments comments();
}
