#Author: florian.michaud11@gmail.com
Feature: Submit ISTQB foundation quizz
  Technical test to automate the submission of a valid form on the hightest.nc site

  Scenario: Submit ISTQB foundation quizz on hightest.com
    Given I navigate to "https://www.mohmal.com/fr"
    And I get an email
    And I navigate to "https://hightest.nc"
    And I navigate to "Toolbox" section
    And I run "Quiz ISTQB niveau Foundation" in french
    When I complete the quiz
    And I enter my mail
    And I navigate to "https://www.mohmal.com/fr"
    And I login to my email
    Then I can check my results
    And I got "100"% correct answers
