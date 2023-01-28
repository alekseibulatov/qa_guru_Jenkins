package demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import demoqa.pages.components.CalendarComponent;
import demoqa.pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Practice Form";

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGender = $("#genterWrapper"),
            userPhoneNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            userSubjectsInput = $("#subjectsInput"),
            userHobbiesWrapper = $("#hobbiesWrapper"),
            userUploadPicture = $("#uploadPicture"),
            userCurrentAddress = $("#currentAddress"),
            userState = $("#state"),
            userStateCityWrapper = $("#stateCity-wrapper"),
            userCity = $("#city"),
            userSubmit = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        userGender.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        userPhoneNumber.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjectsInput(String value) {
        userSubjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        userHobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage loadPicture(String value) {
        userUploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        userCurrentAddress.setValue(value);
        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        userState.click();
        userStateCityWrapper.$(byText(state)).click();
        userCity.click();
        userStateCityWrapper.$(byText(city)).click();
        return this;
    }

    public void clickButtonSubmit() {
        userSubmit.click();
    }

    public RegistrationPage verifyResultModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }
}
