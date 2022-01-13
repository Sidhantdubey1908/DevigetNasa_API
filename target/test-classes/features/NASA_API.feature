Feature: Test Nasa API features

@SmokeTest
Scenario: Launch NASA API and get Mars photos
Given User launches the API "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY" and validates if API is launched
Then Retrieve the first 10 Mars photos made by Curiosity on 1000 Martian sol