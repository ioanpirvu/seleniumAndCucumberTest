Feature: Products sorting

  Scenario Outline: Sort products by price
    Given I open the homepage
    And I search products by ”<keyword>”
    When I select the option ”<sort criteria>” in the Sort By list
    And I sort the products in <sort direction> direction
    Then the  products are ordered by price in <sort direction> order

    Examples:
      | keyword      | sort criteria | sort direction |
      | new arrivals | Price         | descending     |
      | shirt        | Name          | ascending      |