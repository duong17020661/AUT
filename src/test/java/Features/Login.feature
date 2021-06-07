
Feature: Test login functionality

  Scenario Outline: Create user
    Given click add user button
    When user check user act  ive: <active>
    When user select Group <group> and Language <language>
    When user choose a photo have url <url>
    When user enters Fullname <fullname> Email <email> Password <password> Phone <phone>
    Then user click button to add new user

    Examples:
      | active | group | language | url | fullname | email | password | phone |
      | checked | Client | English | C:\Users\Admin\Downloads\favicon.png | Duong | duogn@abc.com | 1111111 | 1111123 |