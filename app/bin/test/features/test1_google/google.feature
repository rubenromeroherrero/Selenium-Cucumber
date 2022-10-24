# BDD => se desarrolla de acuerdo al comportamiento que se está esperando en la aplicación
# Cucumber no es sólo para automatizar => es para cubrir los aspectos más críticos de la app documentados
@Test
Feature: Test Google search functionality
    Scenario: As a user I enter a search criteria in Google
        Given I am on the Google search page
        When I enter a search criteria
        And click on the search button
        Then the results match the criteria
        Then I can validate that the value is correct
