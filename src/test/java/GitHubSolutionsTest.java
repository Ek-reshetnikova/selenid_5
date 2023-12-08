import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class GitHubSolutionsTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void searchSolutions () {
        open("https://github.com/");
        $( "ul.d-lg-flex.list-style-none")
                .$(byText("Solutions")).hover();
        $("a[href='/enterprise']").click();
        $("div.enterprise-hero-background.overflow-hidden")
                .shouldHave(text("To build, scale, and deliver secure software."));
    }
}