package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successfulSearchTest() {

        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Smith");
        $("#userEmail").setValue("alex@gmail.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("2345234523");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select option[value='6']").click();
        $("#dateOfBirth .react-datepicker__year-dropdown-container select option[value='1985']").click();
        $(".react-datepicker__day.react-datepicker__day--014").click();

        $(".subjects-auto-complete__control input").setValue("Math").pressEnter();

        $("label[for='hobbies-checkbox-1']").click(); // Выбирает "Sports"

        $("#uploadPicture").uploadFile(new File("src/test/resources/logo_demo_qa.png"));

        $("#currentAddress").setValue("Unterdenlinden 12");

        Selenide.executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");

        $("#state").click();
        $("#state input").setValue("Uttar Pradesh").pressEnter();
        $("#city input").setValue("Agra").pressEnter();

        $("#submit").click();
    }
}
