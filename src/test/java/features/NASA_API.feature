Feature: Test Nasa API features

@Test1
Scenario: Launch NASA API and get Mars photos
Given User launches the API "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY" and validates if API is launched
Then Retrieve the first 10 Mars photos made by Curiosity on 1000 Martian sol

@Test2
Scenario: Get mars photos where Earth date is equal to 1000 sol
Given User is on the API page and converts 1000 sol to earth date
Then Retrieve the first 10 Mars photos made by Curiosity with Earth date equals 1000 sol

