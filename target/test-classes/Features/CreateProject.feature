Feature: Creating Project


  Scenario Outline: Create project called Testing Project
    Given navigate to wamly login page
    When user logged in using email as "<username>"
    Then User's enter password as "<password>"


    And click projects , Add New and From Scratch
    Then fill Settings form "<ProjectName>" , "<Department>" , "<ProjectDescription>" ,"<IntroVideos>" click open project "<StartDate>"
    Then click next
    And Select Available raters "<rater1>" and "<rater2>"
    And click next To Create New Project
    And Select "<projectQuestion>"
    And click next to project








    Examples:
      | username                    | password   |ProjectName|Department|ProjectDescription|IntroVideos|StartDate|rater1|rater2|projectQuestion|
      | andani@commandquality.co.za | Map9@gmail |Testing Projectss|AndaniDevelopment|Testing Wamly with Selenium|Interview video|06/06/2022|Andani Maluwa|Mthobisi M|Create own|