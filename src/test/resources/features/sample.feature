Feature: orange hrm portal testing

  Background: 
    Given User is on HRMLogin page "https://opensource-demo.orangehrmlive.com"

  @ValidCredentials @smoke @sanity @regression
  Scenario: Login with valid credentials
    When User enters username as "Admin" and password as "admin123"
    Then User should be able to login successfully and new page open

  @InvalidCredentials @sanity @regression
  Scenario Outline: Login with invalid credentials - <Test>
    When User enters username as "<username>" and password as "<password>"
    Then User should be able to see error message "<errorMessage>"
    Examples: 
      | Test           | username | password  | errorMessage        |
      | wrong username | Admin    | admin12$$ | Invalid credentials |
      | wrong password | admin$$  | admin123  | Invalid credentials |
      | both wrong     | abc123   | xyz$$     | Invalid credentials |

  @MissingUsername @smoke @sanity @regression
  Scenario Outline: Login with blank username
    When User enters username as " " and password as "admin123"
    Then User should be able to see a message "Required" below Username

  @FaceBookLink @FailedTest  @sanity @regression
  Scenario: Verify FaceBook Icon on Login Page
    Then User should be able to see FaceBook Icon

  @LinkedInLink @regression
  Scenario: Verify LinkedIn Icon on Login Page
    Then User should be able to see LinkedIn Icon

  @ForgetPasswordLink @smoke @sanity @regression
  Scenario: Verify ForgetPassword link on Login Page
    When User clicks on Forgot your Password Link
    Then User should navigate to a new page
