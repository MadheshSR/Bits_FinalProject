Feature: Oneway train automate

@OneWayTrain
Scenario Outline:Book OnewayTrain dynamically

    Given Open website with url 
    Then Click on Signup window close in trains
    Then Click on Trains 
    And Enter FromStation "<From>"
    And Enter ToStation "<To>"
    Then select Departure "<date>"
    Then Click on Search Trains
    
    Examples:
      | From      | To              | date            | Km    |
      | Chennai Central | Bangalore | 18             | 3     |
    


