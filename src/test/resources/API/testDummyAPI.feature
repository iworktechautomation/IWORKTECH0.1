@api

Feature:  To check Dummy API


  Background:  Background: This steps will be executed for the features mentioned below

    Given User is on the Base URL


  Scenario Outline: Check if the applications are getting returned for the given internal vehicle reference & product type

    When user sends a request with the given internal entity reference "<internal_entity_reference>" product type ref "<product_type_ref>" and index refe "<index_ref>"
    #Then I should get json response with status code 200 and response should match with "VehicleLookupRequestDetails.json"
    Then success code 200 should be displayed for the application controller
    Examples:

      | internal_entity_reference | product_type_ref | index_ref |
      | 12345                     | 200              | 233       |
