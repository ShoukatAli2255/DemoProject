Feature: Testing the Register functionality

Scenario: user creates the new account with mandatory fields

Given User navigated to register account page
When User enters the details with below fileds
| First name |Shoukat |
|Last name   | Ali   |
|Telephone|123456789 |
|Password|Honey@123  |
And User selects privacy policy
And User clicks on continue button
Then user account should be get created successsfully

Scenario: user creates the new account with all fields

Given User navigated to register account page
When User enters the details with below fileds
| First name |Shoukat |
|Last name   | Ali   |
|Telephone|123456789 |
|Password|Honey@123  |
And User selects No for newsletter
And User selects privacy policy
And User clicks on continue button
Then user account should be get created successsfully


Scenario: user creates the duplicate account

Given User navigated to register account page
When User enters the details with below fileds
| First name |Shoukat |
|Last name   | Ali   |
|Email | shoukatali.md97@gmail.com|
|Telephone|123456789 |
|Password|Honey@123  |
And User selects privacy policy
And User clicks on continue button
Then user should gets warning message

Scenario: user crates the account with out the details

Given User navigated to register account page
When User dont enter the details in th fields
And User clicks on continue button 
Then user get proper warning messages for each and every field
 
 
 