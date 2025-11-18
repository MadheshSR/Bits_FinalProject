Feature: Oneway car automate

@OneWayCar
Scenario Outline: Book Onewaycar dynamically
    Given Open website with URL 
    Then Click on Signup window close in cabs
    Then Click on Cabs
    And Enter Fromplace "<From>"
    Then Select departure datee
    Then Click on Search Cabs
    
    
    
    
    Examples:
      | From      | Date            | Km    |
      | Chennai   | Sat Nov 29 2025 | 3     |
    

