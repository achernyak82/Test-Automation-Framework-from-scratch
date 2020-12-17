Feature: Writing Emails

  Background:

    Given I enter in email with login 'testalexnsk' and password 'Uer89fd1982'

  Scenario Outline: Writing an email and placing it in the draft folder

    When I write a letter with parameters:
      | address | subject | body      |
      | <email> | <topic> | <content> |
    And I save the letter in the draft folder
    And I send the letter from the draft folder
    Then The letter to '<email>' should be in the sending folder

    Examples:
      | email               | topic     |  | content   |
      | achernyak82@mail.ru | testemail |  | SOME DATA |
      | testalexnsk@mail.ru | TEST      |  | TEST DATA |

  Scenario: Writing an email and deleting it from the basket

    When I write a letter with parameters:
      | address             | subject   | body      |
      | achernyak82@mail.ru | testEmail | SOME DATA |
    And I save the letter in the draft folder
    And I delete the letter from the draft folder
    And I delete the letter from the basket
    Then The basket should be empty

  Scenario: Creating test folder with filter

    When I add new folder 'testfolder'
    And I add new filter for the test folder with text 'testemail'
    And I write a letter with parameters:
      | address             | subject   | body      |
      | testalexnsk@mail.ru | TESTemail | SOME DATA |
    And I send the letter from the test folder
    Then The letter to 'alexander chernyak' should be in the test folder
    And I delete test folder
    And I delete the letter from the basket