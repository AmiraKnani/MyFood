*** Settings ***
Library    RequestsLibrary

*** Variables ***
${BASE_URL}    http://localhost:8028

*** Test Cases ***
Quick Get Adresses Request Test
    [Documentation]    Test GET request to /orders
    ${response}=    GET     ${BASE_URL}/adresses/Ville A
    Should Be Equal As Strings    ${response.status_code}    200
    Log     Response Body: ${response.text}

Quick Get Menus Request Test
    [Documentation]    Test GET request to /orders
    ${response}=    GET     ${BASE_URL}/menus/Menu three
    Should Be Equal As Strings    ${response.status_code}    200
    Log     Response Body: ${response.text}
