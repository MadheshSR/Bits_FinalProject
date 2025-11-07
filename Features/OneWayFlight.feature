Feature: Oneway Flight Automate

  @OneWayFlight
  Scenario Outline: Book OneWay flight dynamically
    Given Open Website with URL
    Then Click on Signup window close
    And Enter From "<From>"
    And Enter To "<To>"
    Then Select departure date "<Date>"
    And Select travellers <Adults> adults and <Children> children
    And Select TravelClass "<TravelClass>"
    Then Click on Search Flights
    Then Enter Booking Details "<Mobileno>","<Email>","<BillingAddress>","<PinCode>"
    And If Flight page is displayed close it

    Examples:
      | From      | To        | Date            | Adults | Children | TravelClass | Mobileno  | Email                     | BillingAddress         | PinCode |
      | Chennai   | Mumbai    | Tue Dec 02 2025 | 2      | 1        | Economy     | 8489127046 | madheshmaddy080@gmail.com | 2,vaigai st,thiruvallur | 602002  |
