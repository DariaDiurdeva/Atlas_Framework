package test;

import org.openqa.selenium.support.ui.WebDriverWait;
import util.DefaultMethodExtension;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.core.context.RetryerContext;
import io.qameta.atlas.core.internal.DefaultRetryer;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import io.qameta.atlas.webdriver.extension.ShouldMethodExtension;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.OKSite;

import java.util.Collections;

public class BaseTest {
    public static WebDriver driver;
    private static Atlas atlas;

    @BeforeAll
    static void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
       atlas = new Atlas(new WebDriverConfiguration(driver,"https://ok.ru")).
               extension(new DefaultMethodExtension()).
               extension(new ShouldMethodExtension()).
               context(new RetryerContext(new DefaultRetryer(10000L, 1000L,
                       Collections.singletonList(Throwable.class))));;
    }

    @AfterAll
    static void close(){
        driver.close();
    }

    public OKSite onSite() {
        return atlas.create(driver, OKSite.class);
    }
}
