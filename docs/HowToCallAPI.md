# How to call API v2

### Original Tech Requirement API

```apl
api.openweathermap.org/data/2.5/forecast/hourly?lat={lat}&lon={lon}&appid={API key}
```

### Changed Tech Requirement API
```apl
api.openweathermap.org/data/2.5/forecast?lat={lat}&lon={lon}&appid={API key}
```


| Parameters   |          |                                                              |
| :----------- | -------- | ------------------------------------------------------------ |
| `lat`, `lon` | required | Geographical coordinates (latitude, longitude). If you need the geocoder to automatic convert city names and zip-codes to geo coordinates and the other way around, please use our [Geocoding API](https://openweathermap.org/api/geocoding-api). |
| `appid`      | required | Your unique API key (you can always find it on your account page under the ["API key" tab](https://home.openweathermap.org/api_keys)) |
| `units`      | optional | Units of measurement. `standard`, `metric` and `imperial` units are available. If you do not use the `units` parameter, `standard` units will be applied by default. [Learn more](https://openweathermap.org/forecast5#data) |
| `mode`       | optional | Response format. JSON format is used by default. To get data in XML format use `mode=xml`. [Learn more](https://openweathermap.org/forecast5#format) |
| `cnt`        | optional | A number of timestamps, which will be returned in the API response. [Learn more](https://openweathermap.org/forecast5#limit) |
| `units`      | optional | Units of measurement. `standard`, `metric` and `imperial` units are available. If you do not use the `units` parameter, `standard` units will be applied by default. [Learn more](https://openweathermap.org/forecast5#data) |
| `lang`       | optional | You can use the `lang` parameter to get the output in your language. [Learn more](https://openweathermap.org/multi) |

# Weather parameters in API response



### JSON

* API response example

```json
{
  "cod": "200",
  "message": 0,
  "cnt": 40,
  "list": [
    {
      "dt": 1596564000,
      "main": {
        "temp": 293.55,
        "feels_like": 293.13,
        "temp_min": 293.55,
        "temp_max": 294.05,
        "pressure": 1013,
        "sea_level": 1013,
        "grnd_level": 976,
        "humidity": 84,
        "temp_kf": -0.5
      },
      "weather": [
        {
          "id": 500,
          "main": "Rain",
          "description": "light rain",
          "icon": "10d"
        }
      ],
      "clouds": {
        "all": 38
      },
      "wind": {
        "speed": 4.35,
        "deg": 309,
        "gust": 7.87
      },
      "visibility": 10000,
      "pop": 0.49,
      "rain": {
        "3h": 0.53
      },
      "sys": {
        "pod": "d"
      },
      "dt_txt": "2020-08-04 18:00:00"
    },

    ...

"city": {
    "id": 2643743,
    "name": "London",
    "coord": {
      "lat": 51.5073,
      "lon": -0.1277
    },
    "country": "GB",
    "timezone": 0,
    "sunrise": 1578384285,
    "sunset": 1578413272
  }
}             
                  
```
# Fields in API response
- .

    - `cod` Internal parameter

    - `message` Internal parameter

    - `cnt`A number of timestamps returned in the API response
  
    - ```
      list
      ```
  
      - `list.dt `Time of data forecasted, unix, UTC
  
      - ```
        list.main
        ```
  
        - `list.main.temp` Temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
        - `list.main.feels_like` This temperature parameter accounts for the human perception of weather. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
        - `list.main.temp_min` Minimum temperature at the moment of calculation. This is minimal forecasted temperature (within large megalopolises and urban areas), use this parameter optionally. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
        - `list.main.temp_max` Maximum temperature at the moment of calculation. This is maximal forecasted temperature (within large megalopolises and urban areas), use this parameter optionally. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit.
        - `list.main.pressure` Atmospheric pressure on the sea level by default, hPa
        - `list.main.sea_level` Atmospheric pressure on the sea level, hPa
        - `list.main.grnd_level` Atmospheric pressure on the ground level, hPa
        - `list.main.humidity` Humidity, %
        - `list.main.temp_kf` Internal parameter
  
      - ```
        list.weather
        ```
  
        - `list.weather.id` Weather condition id
        - `list.weather.main` Group of weather parameters (Rain, Snow, Extreme etc.)
        - `list.weather.description` Weather condition within the group. You can get the output in your language. [Learn more](https://openweathermap.org/forecast5#multi).
        - `list.weather.icon` Weather icon id
  
      - ```
        list.clouds
        ```
  
        - `list.clouds.all` Cloudiness, %

      - ```
        list.wind
        ```

        - `list.wind.speed` Wind speed. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour.
        - `list.wind.deg` Wind direction, degrees (meteorological)
        - `list.wind.gust` Wind gust. Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour
  
      - `list.visibility` Average visibility, metres

      - `list.pop` Probability of precipitation

      - ```
        list.rain
        ```

        - `list.rain.3h` Rain volume for last 3 hours, mm
  
      - ```
        list.snow
        ```

        - `list.snow.3h` Snow volume for last 3 hours

      - `list.sys`
  
      - - `list.sys.pod` Part of the day (n - night, d - day)

      - `list.dt_txt` Time of data forecasted, ISO, UTC

    - ```
      city
      ```
  
      - `city.id` City ID

      - `city.name` City name
  
      - ```
        city.coord
        ```
  
        - `city.coord.lat `City geo location, latitude
        - `city.coord.lon` City geo location, longitude

      - `city.country` Country code (GB, JP etc.)
  
      - `city.timezone` Shift in seconds from UTC