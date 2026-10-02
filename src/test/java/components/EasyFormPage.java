package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class EasyFormPage {

    private final SelenideElement userNameInput = $("#userName");
    private final SelenideElement userMailInput = $("#userEmail");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement permanentAddressInput = $("#permanentAddress");

    private final SelenideElement resultsOutput = $("#output");
    private final SelenideElement nameOutput = $("#output #name");
    private final SelenideElement mailOutput = $("#output #email");
    private final SelenideElement currentAddressOutput = $("#output #currentAddress");
    private final SelenideElement permanentAddressOutput =  $("#output #permanentAddress");
    private final SelenideElement submit = $("#submit");

    public EasyFormPage typeUserName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public EasyFormPage typeUserMail(String value) {
        userMailInput.setValue(value);
        return this;
    }

    public EasyFormPage typeUserAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public EasyFormPage typePermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;

    }
    public EasyFormPage submit() {
        submit.pressEnter();
        return this;
    }

    public EasyFormPage checkOutputVisible() {
        resultsOutput.shouldBe(visible);
        return this;
    }

    public EasyFormPage checkOutputHidden() {
        resultsOutput.shouldNotBe(visible);
        return this;
    }

    public EasyFormPage outputName(String name, String lastName) {
        nameOutput.shouldHave(text(name + " " + lastName));
        return this;
    }

    public EasyFormPage outputEmail(String value) {
        mailOutput.shouldHave(text(value));
        return this;
    }

    public EasyFormPage outputCurrentAddress(String value) {
        currentAddressOutput.shouldHave(text(value));
        return this;
    }

    public EasyFormPage outputPermanentAddress(String value) {
        permanentAddressOutput.shouldHave(text(value));
        return this;
    }
}



