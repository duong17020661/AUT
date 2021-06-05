Feature: Create user test

    Background: Sign in and create user
        Given navigate to web
        When sign in
        Then click add user button

    Scenario Outline: Create user
        When user check user active: <active>
        When user select Group <group> and Language <language>
        When user choose a photo have url <url>
        When user enters Fullname <fullname> Email <email> Password <password> Phone <phone>
        When user click button to add new user
        When check user have name <fullname> and email <email> in table
        Then check user <email> created in database

        Examples:
            | active | group | language | url | fullname | email | password | phone |
            | checked | Client | English | C:\Users\Admin\Downloads\favicon.png | Duong | duogn@abc.com | 1111111 | 1111123 |

    Scenario Outline: Create user
        When user check user active: <active>
        When user select Group <group> and Language <language>
        When user choose a photo have url <url>
        When user enters Fullname <fullname> Email <email> Password <password> Phone <phone>
        When user click button to add new user
        Then check user <email> already exists in database

        Examples:
            | active | group | language | url | fullname | email | password | phone |
            | checked | Client | English | C:\Users\Admin\Downloads\favicon.png | Duong | duogn@abc.com | 1111111 | 1111123 |