Feature: User Adding New Pet
@pet
  Scenario Outline: User adds new pet to store
  When User adds new pet to the store with custom <id>
  Then Check if the response code is 200
  When User get pet by <id>
  Then Check if the code of response is 200
  And User checks if the pet's name is equal to declared one
  And User removes pet from the store with <id>
  Examples:
  |id       |
  |123456789|
  |987654321|






