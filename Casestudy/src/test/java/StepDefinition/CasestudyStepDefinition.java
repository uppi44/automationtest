package StepDefinition;

import CasestudyBase.CasestudyConfigBrowser;
import CasestudyPages.FormPage;
import CasestudyPages.LoginPage;
import CasestudyPages.ConfirmationPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;

public class CasestudyStepDefinition extends CasestudyConfigBrowser {
	
	LoginPage loginPage;
	FormPage formPage;
	ConfirmationPage confirmationPage;
	
	String heading;
	
	// User name error message variable
	String error_username;
	
	// Password error message variable
	String error_password;
	
	// First Name varaible
	String firstNameAlert;
	
	// Last Name variable
	String lastNameAlert;
	
	// Email ID
	String emailalertmsg;
	 
	// Blank Phone number
	String blankphalert;
	
	// Invalid Phone number
	String invalidphalert;

	// Booked Rooms
	String bookedRooms;
	
	// City Alert
	String cityalertmsg;
	
	// State Alert
	String statealertmsg;
	
	// Card Holder Name Alert
	String cardAlert;
	
	// Debit Card Number Alert
	String debitAlert;
	
	// Card Expiration Month Alert
	String monthAlertmsg;
	
	// Card Expiration Year Alert
	String yearAlertmsg;
	
	// Success Message
	String success_message;
	
	@Given("^User is on login page$")
	public void user_is_on_login_page() throws Throwable {
		CasestudyConfigBrowser.initialize();
	}

	@Given("^Heading of the page is Hotel Booking Application$")
	public void heading_of_the_page_is_Hotel_Booking_Application() throws Throwable {
		loginPage = new LoginPage();
		heading = loginPage.getHeading();
		Assert.assertEquals(loginPage.expectedHeading(), heading);
	}

	@Then("^Print the Heading text$")
	public void print_the_Heading_text() throws Throwable {
		loginPage = new LoginPage();
		System.out.println("Heading:" + heading);
		loginPage.closeBrowser();
	}
	
	// 4th Question
	// Username error

    @Then("^Error message is displayed when username is not entered$")
    public void error_message_is_displayed_when_username_is_not_entered() throws Throwable {
    	loginPage = new LoginPage();
		System.out.println("Error message without username:" + error_username);
		loginPage.closeBrowser();
    }

    @And("^User clicks on login button without entering username$")
    public void user_clicks_on_login_button_without_entering_username() throws Throwable {
    loginPage = new LoginPage();
	error_username = loginPage.usernamelogin();
	Assert.assertEquals(loginPage.expectedUsernameErr(), error_username);
    }
	    
	// Password error

    @And("^User clicks on login button without entering password$")
    public void user_clicks_on_login_button_without_entering_password() throws Throwable {
    loginPage = new LoginPage();
	error_password = loginPage.passwordlogin();
	Assert.assertEquals(loginPage.expectedPwdErr(), error_password);
    }
    
    @Then("^Error message is displayed when password is not entered$")
    public void error_message_is_displayed_when_password_is_not_entered() throws Throwable {
    loginPage = new LoginPage();
	System.out.println("Error message without password:" + error_password);
	loginPage.closeBrowser();
    }

    // 6 & 7

    @And("^User enters the correct login credentials$")
    public void user_enters_the_correct_login_credentials() throws Throwable {
    loginPage = new LoginPage();
	loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }
    
    @Then("^User is redirected to Hotel Booking page and verify the title of that page$")
    public void user_is_redirected_to_hotel_booking_page_and_verify_the_title_of_that_page() throws Throwable {
    	loginPage = new LoginPage();
		formPage = new FormPage();
		Assert.assertEquals(formPage.title(), "Hotel Booking");
		System.out.println("Title of the page:" + formPage.title());
		loginPage.closeBrowser();
    }
	
    // 8 - First Name Alert
    @Given("^User is on Booking Form Page$")
    public void user_is_on_booking_form_page() throws Throwable {
    	CasestudyConfigBrowser.initialize();
    	loginPage = new LoginPage();
		formPage = new FormPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }
    
        @And("^User clicks on confirm booking button without entering first name$")
        public void user_clicks_on_confirm_booking_button_without_entering_first_name() throws Throwable {
        	formPage = new FormPage();
    		firstNameAlert = formPage.alertfname();
    		Assert.assertEquals(firstNameAlert, "Please fill the First Name");
        }
   

    @Then("^Error will be thrown for not entering the first name$")
    public void error_will_be_thrown_for_not_entering_the_first_name() throws Throwable {
    	System.out.println("First Name Alert:" + firstNameAlert);
		loginPage = new LoginPage();
		loginPage.closeBrowser();
    }

  // 9 - Last Name Alert
 
    @And("^User clicks on confirm booking button without entering last name$")
    public void user_clicks_on_confirm_booking_button_without_entering_last_name() throws Throwable {
    formPage = new FormPage();
	lastNameAlert = formPage.alertlname();
	Assert.assertEquals(lastNameAlert, "Please fill the Last Name");
    }
     
    @Then("^Error will be thrown for not entering the last name$")
     public void error_will_be_thrown_for_not_entering_the_last_name() throws Throwable {
    	System.out.println("Last Name Alert:" + lastNameAlert);
		loginPage = new LoginPage();
		loginPage.closeBrowser();     
     }
    

// 10 - Email ID Format Error

@And("^User enters email id which is of incorrect format$")
public void user_enters_email_id_which_is_of_incorrect_format() throws Throwable {
	formPage = new FormPage();
	emailalertmsg = formPage.alertemail();
	Assert.assertEquals(emailalertmsg, "Please enter valid Email Id.");
}


@Then("^Throw the alert message for incorrect email ID$")
public void throw_the_alert_message_for_incorrect_email_id() throws Throwable {
	System.out.println("Email Alert:" + emailalertmsg);
	loginPage = new LoginPage();
	loginPage.closeBrowser();
}	

// 11. Ensure that the alert box displays the message “Please fill the Mobile No.” when mobile number is not entered

@And("^User clicks on confirm booking button without entering phone number$")
public void user_clicks_on_confirm_booking_button_without_entering_phone_number() throws Throwable {
	formPage = new FormPage();
	blankphalert = formPage.blankalertphone();
	Assert.assertEquals(blankphalert, "Please fill the Mobile No.");  
}

@Then("^Throw the alert message to enter the mobile number$")
public void throw_the_alert_message_to_enter_the_mobile_number() throws Throwable {
	System.out.println("Blank Phone Number Alert:" + blankphalert);
	loginPage = new LoginPage();
	loginPage.closeBrowser();    
}

//12. that the alert box displays the message “Please enter valid Contact no.”  when mobile number is invalid

@And("^User clicks on confirm booking button after entering invalid phone number$")
public void user_clicks_on_confirm_booking_button_after_entering_invalid_phone_number() throws Throwable {
	formPage = new FormPage();
	invalidphalert = formPage.alertphone();
	Assert.assertEquals(invalidphalert, "Please enter valid Contact no.");
}

@Then("^Throw the alert message to enter the valid phone number$")
public void throw_the_alert_message_to_enter_the_valid_phone_number() throws Throwable {
	System.out.println("Invalid Phone Number Alert:" + invalidphalert);
	loginPage = new LoginPage();
	loginPage.closeBrowser();
}

// 13 & 14 - Number of rooms booked & address vaidation

@And("^User enters the details till address and selects the number of people from the dropdown$")
public void user_enters_the_details_till_address_and_selects_the_number_of_people_from_the_dropdown() throws Throwable {
	formPage = new FormPage();
	bookedRooms = formPage.roomsBooked();
}

@Then("^The number of rooms booked will be printed$")
public void the_number_of_rooms_booked_will_be_printed() throws Throwable {
	System.out.println("No.of rooms booked:" + bookedRooms);
	loginPage = new LoginPage();
	loginPage.closeBrowser();
}

// 15 - City Alert

@And("^User clicks on confirm booking button without selecting city from the dropdown$")
public void user_clicks_on_confirm_booking_button_without_selecting_city_from_the_dropdown() throws Throwable {
	formPage = new FormPage();
	cityalertmsg = formPage.cityAlert();
	Assert.assertEquals(cityalertmsg, "Please select city");
}

@Then("^Throw the alert message to select the city from the dropdown$")
public void throw_the_alert_message_to_select_the_city_from_the_dropdown() throws Throwable {
	System.out.println("City Alert:" + cityalertmsg);
	loginPage = new LoginPage();
	loginPage.closeBrowser();
}

// 16 - State Alert
@And("^User clicks on confirm booking button without selecting state from the dropdown$")
public void user_clicks_on_confirm_booking_button_without_selecting_state_from_the_dropdown() throws Throwable {
	formPage = new FormPage();
	statealertmsg = formPage.stateAlert();
	Assert.assertEquals(statealertmsg, "Please select state");
}

@Then("^Throw the alert message to select the state from the dropdown$")
public void throw_the_alert_message_to_select_the_state_from_the_dropdown() throws Throwable {
	System.out.println("State Alert:" + statealertmsg);
	loginPage = new LoginPage();
	loginPage.closeBrowser();
}

// 17 - Card Holder Name

@And("^User clicks on confirm booking  button without entering card holder name$")
public void user_clicks_on_confirm_booking_button_without_entering_card_holder_name() throws Throwable {
	formPage = new FormPage();
	cardAlert = formPage.cardHolderAlert();
	Assert.assertEquals(cardAlert, "Please fill the Card holder name");
}

@Then("^Throw the alert message to enter the card holder name$")
public void throw_the_alert_message_to_enter_the_card_holder_name() throws Throwable {
	System.out.println("Card Holder Name Alert:" + cardAlert);
	loginPage = new LoginPage();
	loginPage.closeBrowser();
}

// 18 - Debit Card details
@And("^User clicks on confirm booking  button without entering debit card number$")
public void user_clicks_on_confirm_booking_button_without_entering_debit_card_number() throws Throwable {
	formPage = new FormPage();
	debitAlert = formPage.debitCardAlert();
	Assert.assertEquals(debitAlert, "Please fill the Debit card Number");
}

@Then("^Throw the alert message to enter the debit card number$")
public void throw_the_alert_message_to_enter_the_debit_card_number() throws Throwable {
	System.out.println("Debit Card Alert:" + debitAlert);
	loginPage = new LoginPage();
	loginPage.closeBrowser();
}

// 19 - Card Expiration Month
@And("^User clicks on confirm booking  button without entering card expiration month$")
public void user_clicks_on_confirm_booking_button_without_entering_card_expiration_month() throws Throwable {
	formPage = new FormPage();
	monthAlertmsg = formPage.expirationMonthAlert();
	Assert.assertEquals(monthAlertmsg, "Please fill expiration month");
}

@Then("^Throw the alert message to enter the card expiration month$")
public void throw_the_alert_message_to_enter_the_card_expiration_month() throws Throwable {
	System.out.println("Expiration Month Alert:" + monthAlertmsg);
	loginPage = new LoginPage();
	loginPage.closeBrowser();
}

// 20 - Card Expiration year
@And("^User clicks on confirm booking  button without entering card expiration year$")
public void user_clicks_on_confirm_booking_button_without_entering_card_expiration_year() throws Throwable {
	formPage = new FormPage();
	yearAlertmsg = formPage.expirationYearAlert();
	Assert.assertEquals(yearAlertmsg, "Please fill the expiration year");
}

@Then("^Throw the alert message to enter the card expiration year$")
public void throw_the_alert_message_to_enter_the_card_expiration_year() throws Throwable {
	System.out.println("Expiration Year Alert:" + yearAlertmsg);
	loginPage = new LoginPage();
	loginPage.closeBrowser();
}

// 21 - Confirmation page after Hotel Booking
@And("^User fills the booking form by providing all the required details correctly$")
public void user_fills_the_booking_form_by_providing_all_the_required_details_correctly() throws Throwable {
	formPage = new FormPage();
	formPage.confirmation();
}

@Then("^Navigates to confirmation page with the success message$")
public void navigates_to_confirmation_page_with_the_success_message() throws Throwable {
	confirmationPage = new ConfirmationPage();
	success_message = confirmationPage.bookingConfirmation();
	Assert.assertEquals(success_message, "Booking Completed!");
	System.out.println("Success message:" +success_message);
	loginPage = new LoginPage();
	loginPage.closeBrowser();
}


}





