Feature: Bus Book automate

@BusBook
Scenario Outline: BusBook dynamically
    Given open website with URL 
    Then click on Signup window close in cabs
    Then Click on Bus   
    And Enter FromStop "<From>"
    And Enter ToStop "<To>"
    Then Click on Search Bus  
    
    
    Examples:
      | From      | To              |
      | Chennai  | Bangalore       | 

    

