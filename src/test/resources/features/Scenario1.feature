Feature: Wikipedia Language Verification

  Scenario: User selects different languages and verify UI rendering for the selected language
    Given User is on the Wikipedia Page
    When User clicks on language Bosanski
    Then User should see Wikipedia logo title as Posjeti početnu stranicu
    
    When User clicks on language Suomi
    Then User should see Wikipedia logo title as Etusivu

    When User clicks on language Italiano
    Then User should see Wikipedia logo title as Visita la pagina principale

    When User clicks on language Română
    Then User should see Wikipedia logo title as Pagina principală

    When User clicks on language Polski
    Then User should see Wikipedia logo title as Strona główna

    When User clicks on language Deutsch
    Then User should see Wikipedia logo title as Hauptseite

    When User clicks on language Magyar
    Then User should see Wikipedia logo title as Kezdőlap megtekintése

    When User clicks on language Lietuvių
    Then User should see Wikipedia logo title as Eiti į pradinį puslapį

    When User clicks on language 日本語
    Then User should see Wikipedia logo title as メインページに移動する

    When User clicks on language Slovenčina
    Then User should see Wikipedia logo title as Navštíviť Hlavnú stránku

    When User clicks on language English
    Then User should see Wikipedia logo title as Visit the main page



