Feature: Hotel Search automate

@HotelSearch
Scenario Outline: Hotel search dynamically

    Given Open Website With URL 
    Then Click On Signup Window Close in Hotels
    Then Click on Hotels
    And Enter "<From>"
    Then Click on search Hotels
    
    
    Examples:
      | From      | 
      | Chennai   |
