Feature: Verify STCTV Subscription functionality

  @sanity
  Scenario: Verify user landed on Sctv page
    Given User redirects to the sctv page
    Then Verify the title of the sctv page
    And Verify URL of sctv Website


    @sanity
  Scenario: Validate the subscription packages for stctv
      Given User redirects to the sctv page
      Then Verify the title of the sctv page
      And Verify URL of sctv Website
      When User verify the plan heading on the page
      Then User validate all the subscription packages




	



