import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HardFormTest {

    @BeforeEach
    public void setUp() {
        open("https://demoqa.com/automation-practice-form");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @DisplayName("Заполнение всех полей")
    @Test
    public void AllFields() {
        $("#firstName").setValue("Pavel");
        $("#lastName").setValue("Maltsev");
        $("#userEmail").setValue("mail@mail.com");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("5553535111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1976");
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__day--026").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbies-checkbox-1").parent().click();
        $("#hobbies-checkbox-3").parent().click();
        $("#uploadPicture").uploadFromClasspath("photo_2024-06-26_21-07-42.jpg");
        $("#currentAddress").setValue("Moscow");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $(".modal-dialog.modal-lg").shouldBe(visible);
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Pavel Maltsev"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("mail@mail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("5553535111"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("26 July,1976"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports, Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("photo_2024-06-26_21-07-42.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Moscow"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
    }

    @DisplayName("Заполнение только обязательных полей")
    @Test
    public void OnlyRequiredFields() {
        $("#firstName").setValue("Pavel");
        $("#lastName").setValue("Maltsev");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("5553535111");
        $("#submit").click();

        $(".modal-dialog.modal-lg").shouldBe(visible);
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Pavel Maltsev"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("5553535111"));
    }

    @DisplayName("Невозможность появления формы без заполнения пола")
    @Test
    public void WithoutGender() {
        $("#firstName").setValue("Pavel");
        $("#lastName").setValue("Maltsev");
        $("#userNumber").setValue("5553535111");
        $("#submit").click();
        $(".modal-dialog.modal-lg").shouldNotBe(visible);
    }
    @DisplayName("Невозможность появления формы, если в номере меньше десяти цифр")
    @Test
    public void NumberValidation() {
        $("#firstName").setValue("Pavel");
        $("#lastName").setValue("Maltsev");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("123456789");
        $("#submit").click();
        $(".modal-dialog.modal-lg").shouldNotBe(visible);
    }
    @DisplayName("Невозможность появления формы, если указан неправильный мэйл")
    @Test
    public void MailValidation() {
        $("#firstName").setValue("Pavel");
        $("#lastName").setValue("Maltsev");
        $("#userEmail").setValue("mail");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("5553535111");
        $("#submit").click();
        $(".modal-dialog.modal-lg").shouldNotBe(visible);
    }
}




