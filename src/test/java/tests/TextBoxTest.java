package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

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
            open("/automation-practice-form");
            $("#firstName").setValue("Dasha");
            $("#lastName").setValue("Tsareva");
            $("#userEmail").setValue("dasha55@mail.ru");
            $(byText("Female")).parent().click();
            $("#userNumber").setValue("89991234567");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__year-select").selectOption("2022");
            $(".react-datepicker__month-select").selectOption("July");
            $(".react-datepicker__day--009").click();
            $(".subjectsInput").setValue("M");
            $x("//div[contains(text(),'Maths')]").click();
            $(byText("Sports")).parent().click();
            $(byText("Music")).parent().click();
            $("#uploadPicture").uploadFile(new File("student.jpg"));
            $("#currentAddress").setValue("City");
            $x("//div[@id='state']").click();
            $x("//div[contains(text(),'NCR')]").click();
            $x("//div[@id='city']").click();
            $x("//div[contains(text(),'Delhi')]").click();



            // проверки
            $(".modal-body").shouldHave(text("Dasha Tsareva"));
            $(".modal-body").shouldHave(text("dasha55@mail.ru"));
            $(".modal-body").shouldHave(text("Female"));
            $(".modal-body").shouldHave(text("89991234567"));
            $(".modal-body").shouldHave(text("9 July,2022"));
           // $(".modal-body").shouldHave(text("Maths"));
            $(".modal-body").shouldHave(text("Sports, Music"));
            $("#uploadPicture").parent().shouldHave(text("student.jpg"));
            $(".modal-body").shouldHave(text("Dasha Tsareva"));




        }
    }

