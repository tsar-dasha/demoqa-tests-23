package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

    public class TextBoxTest {

        @BeforeAll
        static void beforeAll() {
            Configuration.browserSize = "1920x1080";
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.pageLoadStrategy = "eager";
            Configuration.holdBrowserOpen = true;
            Configuration.timeout = 5000;
        }

        @Test
        void fillFormTest() {
            open("/text-box");
            $("#userName").setValue("Dasha");
            $("#userEmail").setValue("dasha55@mail.ru");
            $("#currentAddress").setValue("Street 45");
            $("#permanentAddress").setValue("Street 47");
            $("#submit").click();

            $("#output #name").shouldHave(text("Dasha"));
            $("#output #email").shouldHave(text("dasha55@mail.ru"));
            $("#output #currentAddress").shouldHave(text("Street 45"));
            $("#output #permanentAddress").shouldHave(text("Street 47"));
        }
    }

