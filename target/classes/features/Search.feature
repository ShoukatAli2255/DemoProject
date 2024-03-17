Feature: Testing the Search functionality

Scenario: User searches for valid product
Given  User opens the application
When User enters valid product "HP" into search box field
And clicks on search button
Then User should get valid product on the displayed in the search details

Scenario: User searches for invalid product
Given User opens the application
When user enter invalid product "Honda" into search box
And clicks on search button
Then user should get a proper message  about no products found


Scenario: User click on search button with out entering anything in the search field
Given User opens the application
When user dont enter any product name into searcbox field
And clicks on search button
Then user should get a proper message  about no products found
 

