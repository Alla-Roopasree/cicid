#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file
Background: 
Given landed on ecomerce page
 
  @tag1
  Scenario Outline: Positive test of purchasing order
    Given enter username <username> and password <password>
    When add the product <productname> to cart
    And check out <productname> and submit the product
    Then "Thankyou for the order" verify the message is displayed

    Examples: 
      |username           |password     |productname|
      |roopasree@gmail.com|Roopasree@00 |ZARA COAT 3|
      
      
      
      