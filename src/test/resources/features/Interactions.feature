Feature: Verify Interactions Page

  @smoke
  Scenario: Verify User is able perform Drag and Drop
    Given user navigates to "url"
    When user clicks on "Interactions" icon in main page
    And user clicks "Droppable" navbar option in Interactions page
    And user performs drag and drop in Droppable section in Interactions page
    Then verify "Dropped" text is displayed after successful drag and drop in Droppable section in Interactions page