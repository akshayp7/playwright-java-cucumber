Feature: Verify the functionalities of Elements page

  @smoke
  Scenario: Verify User is able to perform actions on Web Elements in Elements page
    Given user navigates to "url"
    When user clicks on "Elements" icon in main page
    And user clicks "Text Box" navbar option in Elements page
    And user enters "AutoTest" in Full Name Edit box in Elements page
    And user clicks Submit in Text Box section in Elements page
    Then verify submitted text is displayed in Text Box section in Elements page
    When user clicks "Check Box" navbar option in Elements page
    And user clicks on Home checkbox in Check Box section in Elements page
    Then verify that "home" checkbox selected text is displayed in Check Box section in Elements page
    When user clicks "Radio Button" navbar option in Elements page
    Then verify that No radio button is disabled in Radio Button section in Elements page
    When user clicks "Web Tables" navbar option in Elements page
    Then verify that "First Name" is first column header in Web Tables section in Elements page
    When user edits Cierra entry in Web Tables section in Elements page
    Then user verifies Registration Form is displayed in Web Tables section in Elements page
    When user clicks on Close button in Registration Form in Web Tables section in Elements page
    And user clicks "Buttons" navbar option in Elements page
    And user performs "double" click in Buttons section in Elements page
    Then user verifies "double" click success message in Buttons section in Elements page
    When user performs "right" click in Buttons section in Elements page
    Then user verifies "right" click success message in Buttons section in Elements page
    And user clicks "Upload and Download" navbar option in Elements page
    Then verify user is able to download file in Upload and Download section in Elements page
    When user uploads "sampleFile.jpeg" file in Upload and Download section in Elements page
    Then verify "sampleFile.jpeg" is uploaded successfully in Upload and Download section in Elements page