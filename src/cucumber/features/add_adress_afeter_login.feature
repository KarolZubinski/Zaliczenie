Feature: MyStore - Add user new address after login

  Scenario Outline: Add user alias, address, city, zip/postal code/country/phone
    Given User is logged in to MyStore Website
    When User goes to user address page
    And User adds his address data alias "<alias>", address "<address>", city "<city>", postal code "<zip>", phone "<phone>", country
    And User saves info
    Then Address successfully added "<alias>", address "<address>", city "<city>", postal code "<zip>", phone "<phone>", country

    Examples:

      | alias     |   address      |   city       |   zip     |   phone   |
      | Kasper    |    Niska       | Warszawa     |  00222    | 506123456 |