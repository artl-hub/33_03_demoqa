package tests;

import com.codeborne.selenide.Configuration;
import net.bytebuddy.build.Plugin;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; //defolt 4000

    }

    @Test
    void successfulSearchTest() {

        open("/text-box");
        $("#userName").setValue("Alex");
        $("#userEmail").setValue("alex@gmail.com");
        $("#currentAddress").setValue("Tbiilis str.");
        $("#permanentAddress").setValue("Doman str.");
        $("#submit").scrollTo().click();
//        $("#submit").click();
        $("#output #name").shouldHave(text("Alex"));
        $("#output #email").shouldHave(text("alex@gmail.com"));
        $(" #output #currentAddress").shouldHave(text("Tbiilis str."));
        $("#output #permanentAddress").shouldHave(text("Doman str."));


    }

}
