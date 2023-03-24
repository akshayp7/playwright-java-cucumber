Feature: Verify Widgets Page

  @smoke
  Scenario: Verify User is interact with Widgets
    Given user navigates to "url"
    When user clicks on "Widgets" icon in main page
    And user clicks "Auto Complete" navbar option in Widgets page
    And user enters "Bl" in Single color name edit box in Auto Complete section in Widgets page
    Then verify Blue color is selected in Single color name in Auto Complete section in Widgets page
    When user clicks "Tool Tips" navbar option in Widgets page
    And user hovers over button in Tool Tips section in Widgets page
    Then verify "You hovered over the Button" tooltip is displayed in Tool Tips section in Widgets page
    When user clicks "Select Menu" navbar option in Widgets page
    And user selects "Aqua" in Old Style Select Menu in Select Menu section in Widgets page