Feature: Testing the Login functionality

Scenario: Login with valid credentials
Given user has navigated to login page
When user entered valid email address "mohdshoukatali97@gmail.com"
When user entered valid password "Honey@123"
And  user clicks on login button
Then user should logged in successfully

Scenario: Login with invalid credentials
Given user has navigated to login page
When user entered INvalid email address
When user entered INvalid password "Honey@1234"
And  user clicks on login button
Then user should  get Warning message

Scenario: Login with valid Email adress and invalid password
Given user has navigated to login page
When user entered valid email address "mohdshoukatali97@gmail.com"
When user entered INvalid password "Honey@1234"
And  user clicks on login button
Then user should  get Warning message

Scenario: Login with INvalid Email adress and valid password
Given user has navigated to login page
When user entered INvalid email address
When user entered valid password "Honey@123"
And  user clicks on login button
Then user should  get Warning message





