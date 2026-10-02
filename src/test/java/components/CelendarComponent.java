package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CelendarComponent {

    private final SelenideElement dateInput = $("#dateOfBirthInput");
    private final SelenideElement yearSelect = $(".react-datepicker__year-select");
    private final SelenideElement monthSelect = $(".react-datepicker__month-select");

    public CelendarComponent setDate (String day,String month, String year) {
        dateInput.click();
        yearSelect.selectOption(year);
        monthSelect.selectOption(month);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
        return this;
    }
}