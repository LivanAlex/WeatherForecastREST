# Weather Forecast
## https://aston-weather.herokuapp.com/weather?number=+79681635788
### This is main module of REST application based on a microservice architecture.

---
### Modules:
the application consists of several modules:
- [main module](https://github.com/LivanAlex/WeatherForecastREST)
- [module for determining the city by phone number](https://github.com/Mark9115/CityResolverService)
- [module for getting weather forecast for the city](https://github.com/MihailNn/weater_rest_client)
- [sms sending module](https://github.com/hotmexican/SmsService)
---
### Description:
the app checks the weather and sends sms according to the rule:
```
weather <= 15 degrees - low temperature
weather > 15 degrees - high temperature
```
the phone number is passed in the request parameters:
```
/weather?number=+79992292345
```
in good case, you will receive json:
```json
{
  "number": "+79681635788",
  "city": "Москва",
  "temperature": "9.85",
  "message": "low temperature"
}
```
in bad case:
```json
{
  "info": "Number you entered isn't valid"
}
```
---
### Tags:
Spring, REST, heroku, lombok, mockito, libphonenumber
