Feature: Wikipedia Search Verification

  Scenario Outline: User searches for celebrities and log their birth and spouse details
    Given User is on the Wikipedia Page
    When User searches for the celebrity <celebrityName>
    Then User should see celebrity name <celebrityName> on the page
    And User logs birth and spouse details in a log file

    Examples:
    | celebrityName   |
    | Gigi Hadid      |
    | Dilip Kumar     |
    | Aaron of Aleth  |
    | Britney Spears  |
    | Oprah Winfrey   |
    | Maisie Williams |
    | Abba Jofir       |
    | Jessica Alba    |
    |Jennifer Lawrence|
    | Rebecca Lim     |



