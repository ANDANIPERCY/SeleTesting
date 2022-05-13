Feature: Login Feature File


  Scenario Outline: Login scenario test for wamly
    Given navigate to wamly page
    When user logged in using username as "<username>"
    Then User enter password as "<password>"




    Examples:
      | username                    | password   |
      | andani@commandquality.co.za | Map9@gmail |
