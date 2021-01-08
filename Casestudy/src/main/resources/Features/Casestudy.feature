# 1. Launch the application browser
# 2. Open the web page “login.html “ in the browser.
# 3. Verify login page heading as “Hotel Booking Application” using xpath.
Feature: Verify hotel booking web page
Scenario: Verify login page
Given User is on login page
And Heading of the page is Hotel Booking Application
Then Print the Heading text

# 4. Enter UserName. Ensure that displays the error message “Please enter UserName” 
# upon clicking on the “Login” button without entering any data in the text box. 
# Enter Password. Ensure that displays the error message “Please enter Password” upon clicking 
# on the “Login” button without entering any data in the text box.

# For username
Scenario: Verify the error message for username
Given User is on login page
And User clicks on login button without entering username
Then Error message is displayed when username is not entered

# For passwords
Scenario: Verify the error message for password
Given User is on login page
And User clicks on login button without entering password
Then Error message is displayed when password is not entered

# 6. Enter “admin” as username and “admin” as password for valid login. 
# For this authorized user it will move to next page called “Hotel booking”. 
# 7. Verify the title “Hotel Booking” of the page.
Scenario: Login with credentials and verify the Title
Given User is on login page
And User enters the correct login credentials
Then User is redirected to Hotel Booking page and verify the title of that page

#8. Ensure that the alert box displays the message “Please fill the First Name” 
# upon clicking on the button “Confirm Booking” 
# without entering any data in the text box.
Scenario: Verify the alert message for first name
Given User is on Booking Form Page
And User clicks on confirm booking button without entering first name
Then Error will be thrown for not entering the first name

# 9. Ensure that the alert box displays the message “Please fill the Last Name” 
# upon clicking on the button “Confirm Booking” 
# without entering any data in the text box.
Scenario: Verify the alert message for last name
Given User is on Booking Form Page
And User clicks on confirm booking button without entering last name
Then Error will be thrown for not entering the last name

# 10. Ensure that the alert box displays the message 
# “Please fill the Email” upon wrong email format entered in the text box. 
Scenario: Verify the email ID format
Given User is on Booking Form Page
And User enters email id which is of incorrect format
Then Throw the alert message for incorrect email ID


# 11. Ensure that the alert box displays the message “Please fill the Mobile No.” 
# upon clicking on the button “Confirm Booking” without entering any data in the text box.
Scenario: Verify that the mobile number is entered
Given User is on Booking Form Page
And User clicks on confirm booking button without entering phone number
Then Throw the alert message to enter the mobile number

# 12. Ensure that the alert box displays the message “Please enter valid Contact no.” 
# upon clicking on the button “Confirm Booking” on entering wrong data that doesn’t 
# start with either 7,8 or 9 and doesn’t have 10 digits in the text box.
Scenario: Verify that valid phone number is entered
Given User is on Booking Form Page
And User clicks on confirm booking button after entering invalid phone number
Then Throw the alert message to enter the valid phone number


# 13. Ensure that the alert box displays the message “Number of people attending.” 
# upon clicking on the button “Confirm Booking” without entering any data in the box.
# 14. Enter address details, validation for address.
Scenario: Enter the details upto address and select the number of people
Given User is on Booking Form Page
And User enters the details till address and selects the number of people from the dropdown
Then The number of rooms booked will be printed

# 15. Select City. Ensure that alert box display the message
# “Please select city” upon clicking on the button “Confirm Booking” without selecting any city.
Scenario: Verify alert message is shown if city is not selected
Given User is on Booking Form Page
And User clicks on confirm booking button without selecting city from the dropdown
Then Throw the alert message to select the city from the dropdown


# 16. Select State. Ensure that alert box display the message “Please select state” 
# upon clicking on the button “Confirm Booking” without selecting any state.
Scenario: Verify alert message is shown if state is not selected
Given User is on Booking Form Page
And User clicks on confirm booking button without selecting state from the dropdown
Then Throw the alert message to select the state from the dropdown

# 17. Ensure that the alert box displays the message “Please fill the Card holder name” 
# upon clicking on the button “Confirm Booking” without entering any data in the text box.
Scenario: Verify alert message for card holder name
Given User is on Booking Form Page
And User clicks on confirm booking  button without entering card holder name
Then Throw the alert message to enter the card holder name

# 18. Ensure that the alert box displays the message“Please fill the Debit card Number” 
# upon clicking on the button “Confirm Booking” without entering any data in the text box.
Scenario: Verify alert message for entering debit card number
Given User is on Booking Form Page
And User clicks on confirm booking  button without entering debit card number
Then Throw the alert message to enter the debit card number

#19.Ensure that the alert box displays the message “Please fill expiration month” 
# upon clicking on the button “Confirm Booking” without entering any data in the text box.
Scenario: Verify alert message for entering card expiration month
Given User is on Booking Form Page
And User clicks on confirm booking  button without entering card expiration month
Then Throw the alert message to enter the card expiration month

# 20.Ensure that the alert box displays the message “Please fill expiration year” 
# upon clicking on the button “Confirm Booking” without entering any data in the text box.
Scenario: Verify alert message for entering card expiration year
Given User is on Booking Form Page
And User clicks on confirm booking  button without entering card expiration year
Then Throw the alert message to enter the card expiration year

#21. Click on “Confirm Booking” button. 
# Ensure that it navigates to success page which displays the message “Booking Completed!!!”.
Scenario: Verify confirmation of Hotel Booking
Given User is on Booking Form Page
And User fills the booking form by providing all the required details correctly
Then Navigates to confirmation page with the success message
