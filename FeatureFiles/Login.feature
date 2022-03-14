Feature: Login Functionality Feature
@singledata
Scenario: Login Functionality
Given user launches orange url
When user enter username And user enter password
When user clicks login button
Then user validate url
Then user close browser
@Multipledata
Scenario Outline: Login Functionality with multiple data
Given user navigates to orangeHrm "<Browser>"
When users enter "<Username>" in username
When users enter "<Password>" in password
When users click login 
Then user should validate url
Then i close browser
Examples:
|Browser|Username|Password|
|chrome|Admin|Qedge123!@#|
|firefox|Admin|Qedge123|
|chrome|Admin2|Qedge123!@#|
|firefox|Admin|Qedge123!@#|
|Chrome|Admin|Qedge123!@#|

