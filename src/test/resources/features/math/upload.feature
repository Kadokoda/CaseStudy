Feature: Uploading feature

  Scenario: User uploads a file successfully
    Given the user is on the file upload page
    And the information box of file size showing "Select file to send(max 196.45 MB)"
    When the user select a file to upload
    And checks the I accept terms of service checkbox
    And user clicks on the Submit File button
    And the message "1 file has been successfully uploaded." should be shown

  Scenario: User tries to submit without accepting terms of service (This test is intentionally designed to fail.)
    Given the user is on the file upload page
    And the information box of file size showing "Select file to send(max 196.45 MB)"
    When the user select a file to upload
    When user clicks on the Submit File button
    And the message "User should accept term before submit." should be shown

  Scenario: User tries to submit without selecting a file (This test is intentionally designed to fail.)
    Given the user is on the file upload page
    And checks the I accept terms of service checkbox
    When user clicks on the Submit File button
    And the message "No file has been selected for uploading." should be shown


  Scenario: User uploads a large file (this test is failed)
    Given the user is on the file upload page
    When the user selects a large file which is larger than 196.45 MB upload
    And checks the I accept terms of service checkbox
    And user clicks on the Submit File button
    Then the message "Selected file exceeds the maximum allowed size." should be shown

  Scenario: User uploads a file with a long filename (This test is intentionally designed to fail.)
    Given the user is on the file upload page
    When the user selects a long file name to upload
    And checks the I accept terms of service checkbox
    And user clicks on the Submit File button
    Then the message "Selected file name is too long." should be shown

  Scenario: User uploads a file with a special character in the filename (This test is intentionally designed to fail.)
    Given the user is on the file upload page
    When the user selects a file with special character in name to upload
    And checks the I accept terms of service checkbox
    And user clicks on the Submit File button
    Then the message "Selected file name is not allowed." should be shown