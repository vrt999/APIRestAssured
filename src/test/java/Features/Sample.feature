Feature:
  Verify different GET operations using Rest Assured

  Scenario: Verify one author of the post
    Given I perform GET operation for "/posts"    
    Then I should see the author name as "typicode"
    
    Scenario: Verify collection of authors in the post
    Given I perform GET operation for "/posts"
    Then I should see the author names
    
    Scenario: Verify the parameter of GET
    Given I perform GET operation for "/posts"
    Then I should see verify GET parameter
    
    



